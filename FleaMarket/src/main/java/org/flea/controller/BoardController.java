package org.flea.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.flea.domain.BoardVO;
import org.flea.domain.FileVO;
import org.flea.domain.PageMaker;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;
import org.flea.service.BoardService;
import org.flea.service.CommentService;
import org.flea.service.FileService;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

	// Board List
	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	public void salelist(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("salelist post ...........");

		model.addAttribute("list", service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);

	}

	// Board Read
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("boardkey") int boardkey, Model model, HttpSession session,
			HttpServletRequest request) throws Exception {

		BoardVO boardinfo = service.read(boardkey);
		model.addAttribute("boardinfo", boardinfo);
		UserVO boarduser = service.find(boardinfo.getUserkey());
		model.addAttribute("boarduser", boarduser);

		session = request.getSession(true);
		UserVO userinfo = (UserVO) session.getAttribute("userinfo");
		model.addAttribute("reply", cservice.commentRead(boardkey));

		logger.info("read 상태 : ======= comment Read 완료 =========");

		logger.info("FileVO  : ======= file read 시작 =========");

		List<FileVO> fileinfo = fileservice.postFile(boardkey);
		model.addAttribute("fileinfo", fileinfo);

		logger.info("FileVO 상태 : ======= file read 완료 =========");

	}

	// Create Board (from jsp to DB)
	@RequestMapping(value = "/post", method = { RequestMethod.GET })
	public void createGET() throws Exception {

		logger.info(" =======   createGET  ========");

	}

	// Create Board (from jsp to DB) : Post Board
	@RequestMapping(value = "/post", method = { RequestMethod.POST }) // POST
	public String createPOST(BoardVO bvo, MultipartHttpServletRequest mfile, HttpServletRequest request)
			throws IllegalStateException, Exception {

		logger.info(" =======   createPOST 진입    ========");

		service.createPost(bvo); // post.jsp랑 controller랑 연결

		logger.info("FileVO  ====   진입  =====");

		List<MultipartFile> mf = mfile.getFiles("file");

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("file")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {

				logger.info("FileVO  상태 : ====   파일있음    =====");

				String fileName = mf.get(i).getOriginalFilename();
				logger.info("FileVO  " + fileName);

				String rootpath = request.getSession().getServletContext().getRealPath("/");
				String attachpath = "resources/upload";
				String saveDir = (rootpath + attachpath);

				System.out.println(saveDir);

				System.out.println(mf.get(i).getOriginalFilename());

				FileVO filevo = FileUP.GetFile(saveDir, mf.get(i));
				filevo.setFileid(i + 1);
				filevo.setBoardkey(service.getboardKey(bvo));
				fileservice.saveFile(filevo);

				logger.info("=======createPOST 완료 =====");

			}

		}
		return "redirect:/sboard/list";
	}

	// Delete Board
	@RequestMapping(value = "/delete", method = { RequestMethod.POST })
	public String DeletePOST(@RequestParam("boardkey") int boardkey, HttpSession session, HttpServletRequest request)
			throws Exception {

		logger.info(" =======   DeletePOST ========");
		logger.info(" ======= ========   boardkey : " + boardkey);
		service.deleteBoard(boardkey);

		return "redirect:/sboard/list";

	}

	// Modify Board GET
	@RequestMapping(value = "/boardmodify", method = RequestMethod.GET)
	public void ModifyGET(@RequestParam("boardkey") int boardkey, Model model, HttpSession session,
			HttpServletRequest request) throws IllegalStateException, Exception {

		logger.info(" =======   ModifyGET  ========");

		read(boardkey, model, session, request);

		logger.info(" =======  ModifyGET read 완료   ========");

	}

	// Modify Board POST
	@RequestMapping(value = "/boardmodify", method = RequestMethod.POST)
	public String ModifyPOST(BoardVO bvo, MultipartHttpServletRequest mfile, HttpServletRequest request)
			throws IllegalStateException, Exception {

		logger.info(" =======   ModifyPOST ========");

		int boardkey = service.getboardKey(bvo);

		logger.info(" ======= ========   boardkey : " + boardkey);

		bvo.setBoardkey(boardkey);
		service.modifyBoard(bvo);

		logger.info(" =======   ModifyPOST END========");

	
		return "redirect:/sboard/list";

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

}
