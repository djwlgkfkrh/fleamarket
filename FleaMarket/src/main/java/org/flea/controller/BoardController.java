package org.flea.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.flea.domain.BoardVO;
import org.flea.domain.PageMaker;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;
import org.flea.service.BoardService;
import org.flea.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import org.flea.controller.PostFile;
import org.flea.controller.UploadFile;
import org.flea.domain.FileVO;
import org.flea.service.FileService;


@SessionAttributes("userinfo") // MemberVO
@Controller
@RequestMapping("/sboard/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private BoardService service;
	@Inject
	private CommentService cservice;

	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	public void salelist(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("salelist post ...........");
		// model.addAttribute("list", service.show());
		// HttpSession session = request.getSession(); // �꽭�뀡 �꽑�뼵�븯怨� 媛��졇�삤�뒗 遺�遺�
		// UserVO usersession = (UserVO) session.getAttribute("userinfo");
		// vo.setUserkey(usersession.getUserkey());
		model.addAttribute("list", service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);

	}


	
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("boardkey") int boardkey, Model model,HttpSession session,HttpServletRequest request) throws Exception {
		BoardVO boardinfo = service.read(boardkey);
		model.addAttribute("boardinfo", boardinfo);
		UserVO boarduser = service.find(boardinfo.getUserkey());
		model.addAttribute("boarduser", boarduser);
		
		session=request.getSession(true);
		UserVO userinfo = (UserVO) session.getAttribute("userinfo");
		
		
		 model.addAttribute("reply",cservice.commentRead(boardkey));

	}

	
	
	
	@RequestMapping(value = "/post", method = { RequestMethod.GET })
	public void createGET(BoardVO vo) throws Exception {
		logger.info("postGET ...........");
	}
	
	
	


	@RequestMapping(value = "/beforeread", method = { RequestMethod.GET, RequestMethod.POST })
	public String beforeGET(@RequestParam("boardkey") int boardkey) throws Exception {

		int b = service.before(boardkey);
		return "redirect:/sboard/read?boardkey=" + b;
	}

	@RequestMapping(value = "/afterread", method = { RequestMethod.GET, RequestMethod.POST })
	public String afterGET(@RequestParam("boardkey") int boardkey) throws Exception {

		int b = service.after(boardkey);
		return "redirect:/sboard/read?boardkey=" + b;
	}
	
	
	// File start
	@Inject
	FileService fileservice;

	
	UploadFile FileUP = new UploadFile();
	PostFile filepost = new PostFile();

	@RequestMapping("/uploadPage")
	private String uploadView() {

		logger.info(" =========FileVO 시작 =========");
		return "upload";
	}


	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	private String upload(@RequestParam("File") MultipartFile multipartFile) throws Exception {

		if (multipartFile.isEmpty()) {

			logger.info("FileVO 상태 : ====   파일없음    =====");
			return " ";

		} else {

			logger.info("FileVO  상태 : ====   파일있음    =====");
			FileVO vo  = FileUP.GetFile(multipartFile);		
			fileservice.saveFile(vo); // service로 전달

			logger.info("=======File service.saveFile(vo) 실행 완료 =====");

			return "redirect:/uploadComplete";
		}
	}


	@RequestMapping("/uploadComplete")
	private void PostImage(FileVO vo, HttpServletResponse res, Model model) throws Exception {


		FileVO vo2 = fileservice.postFile(vo);
		logger.info("FileVO 상태 : ======= service.postFile(vo) 완료 =========");
		
		byte[] bytes = filepost.readFile(vo2.getFname());
		filepost.write(res, vo2.getFileData());
		
	}
	
	// File end
	
	
	
	

}

