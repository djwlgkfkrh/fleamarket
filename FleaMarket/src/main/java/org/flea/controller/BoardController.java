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
	@Inject
	private FileService fileservice;

	UploadFile FileUP = new UploadFile();
	PostFile filepost = new PostFile();

	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	public void salelist(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("salelist post ...........");
	
		model.addAttribute("list", service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("boardkey") int boardkey, Model model, HttpSession session,
			HttpServletRequest request, HttpServletResponse res, FileVO filevo) throws Exception {
		
		BoardVO boardinfo = service.read(boardkey);
		model.addAttribute("boardinfo", boardinfo);
		UserVO boarduser = service.find(boardinfo.getUserkey());
		model.addAttribute("boarduser", boarduser);

		session = request.getSession(true);
		UserVO userinfo = (UserVO) session.getAttribute("userinfo");

		model.addAttribute("reply", cservice.commentRead(boardkey));

		
		// file : 다중파일로 바꾸기 
		// 여기서 file이 있을때와 없을때로 또 나눠야함 

		FileVO fileinfo = fileservice.postFile(filevo);
		logger.info("FileVO 상태 : ======= service.postFile(vo) 완료 =========");

		byte[] bytes = filepost.readFile(fileinfo.getFname());
		filepost.write(res, fileinfo.getFileData());

	}

	// from jsp to DB // Posting Page
	@RequestMapping(value = "/post", method = { RequestMethod.GET}) 
	public void createGET() throws Exception {
	}
	
	
	@RequestMapping(value = "/post", method = {RequestMethod.POST }) // POST
	public String createPOST(BoardVO bvo, @RequestParam("file") MultipartFile multipartFile) throws Exception {
	
		logger.info(" =======   createPOST 진입    ========");
		
		service.createPost(bvo); // post.jsp랑  controller랑 연결
				
		// file : 다중파일로 바꾸기
		if (multipartFile.isEmpty()) {

			logger.info("FileVO 상태 : ====   파일없음    =====");

		} else {

			logger.info("FileVO  상태 : ====   파일있음    =====");
			FileVO filevo = FileUP.GetFile(multipartFile);
			filevo.setBoardkey(service.getboardKey(bvo)); // set FileVO - Boardkey 이게 아직 null값임 
			fileservice.saveFile(filevo); // service로 전달

			logger.info("=======File service.saveFile(vo) 실행 완료 =====");

		}
	return "redirect:/sboard/list";
	}
	



	@RequestMapping(value = "/beforeread", method = { RequestMethod.GET, RequestMethod.POST })
	public String beforeGET(@RequestParam("boardkey") int boardkey) throws Exception {
		try{
		int b = service.before(boardkey);
		return "redirect:/sboard/read?boardkey=" + b;
		}catch(Exception e){
			e.printStackTrace();
			return "error/nullPage_error";
		}
	}

	@RequestMapping(value = "/afterread", method = { RequestMethod.GET, RequestMethod.POST })
	public String afterGET(@RequestParam("boardkey") int boardkey) throws Exception {
		try{
		int b = service.after(boardkey);
		return "redirect:/sboard/read?boardkey=" + b;
		}catch(Exception e){
			e.printStackTrace();
			return "error/nullPage_error";
		}
		
	}

}
