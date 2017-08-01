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
	public String list(@ModelAttribute("cri") SearchCriteria cri, Model model, @RequestParam("boardkey") int boardkey)
			throws Exception {

		/*
		 * logger.info("salelist post ...........");
		 * 
		 * model.addAttribute("list", service.listSearchCriteria(cri));
		 * PageMaker pageMaker = new PageMaker(); pageMaker.setCri(cri);
		 * 
		 * pageMaker.setTotalCount(service.listSearchCount(cri));
		 * model.addAttribute("pageMaker", pageMaker);
		 */

		if (service.getBuyState(boardkey) == 0) {
			return "redirect:/sboard/salelist";
		} else {
			return "redirect:/sboard/buylist";
		}

	}

	// Sale List
	@RequestMapping(value = "/salelist", method = { RequestMethod.POST, RequestMethod.GET })
	public void salelist(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("salelist post ...........");

		model.addAttribute("salelist", service.salelistSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.salelistSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);

	}

	// Buy List
	@RequestMapping(value = "/buylist", method = { RequestMethod.POST, RequestMethod.GET })
	public void buylist(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("buylist post ...........");

		model.addAttribute("buylist", service.buylistSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.buylistSearchCount(cri));
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

		// null일 경우도 생각하기 
		
		List<FileVO> fileinfo = fileservice.postFile(boardkey);
		model.addAttribute("fileinfo", fileinfo);

		logger.info("FileVO 상태 : ======= file read 완료 =========");

	}

	// Create Post /* @@@@@@ file handling */
	public void createPOST(BoardVO bvo, MultipartHttpServletRequest mfile, HttpServletRequest request)
			throws IllegalStateException, Exception {

		logger.info(" =======   createPOST 진입    ========");

		service.createPost(bvo);

		logger.info("FileVO  ====   진입  =====");

		/* file 없어도 출력할 수 있도록 만들기 */

		if (!mfile.getFiles("file").isEmpty()) {

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
		}
	}

	// Sale Post /* 생성된 테이블이 없는 상태라서 sale/buy 판별 불가. 그래서 따로 페이지 만들어줌 */
	@RequestMapping(value = "/salepost", method = { RequestMethod.GET })
	public void saleGET() throws Exception {

	}

	@RequestMapping(value = "/salepost", method = { RequestMethod.POST }) // POST
	public String salePOST(BoardVO bvo, MultipartHttpServletRequest mfile, HttpServletRequest request)
			throws Exception {

		createPOST(bvo, mfile, request);
		service.createSale(service.getboardKey(bvo)); // board 키만 있으면 됨

		logger.info(" =======   salePOST 완료    ========");

		return "redirect:/sboard/salelist";
	}

	// Buy Post /* 생성된 테이블이 없는 상태라서 sale/buy 판별 불가. 그래서 따로 페이지 만들어줌 */
	@RequestMapping(value = "/buypost", method = { RequestMethod.GET })
	public void buyGET() throws Exception {

	}

	@RequestMapping(value = "/buypost", method = { RequestMethod.POST }) // POST
	public String buyPOST(BoardVO bvo, MultipartHttpServletRequest mfile, HttpServletRequest request) throws Exception {

		createPOST(bvo, mfile, request);
		service.createBuy(service.getboardKey(bvo)); // board 키만 있으면 됨

		logger.info(" =======   buyPOST 완료    ========");

		return "redirect:/sboard/buylist";
	}

	// Delete Board
	@RequestMapping(value = "/delete", method = { RequestMethod.POST })
	public String DeletePOST(@RequestParam("boardkey") int boardkey, HttpSession session, HttpServletRequest request)
			throws Exception {

		logger.info(" =======  DeletePOST ======== boardkey : " + boardkey);

		if (service.getBuyState(boardkey) == 0) {
			service.deleteSale(boardkey);
			return "redirect:/sboard/salelist";
		} else {
			service.deleteBuy(boardkey);
			return "redirect:/sboard/buylist";
		}

	}

	// Modify Board GET
	@RequestMapping(value = "/boardmodify", method = RequestMethod.GET)
	public void ModifyGET(@RequestParam("boardkey") int boardkey, Model model, HttpSession session,
			HttpServletRequest request) throws IllegalStateException, Exception {

		logger.info(" =======   Modify Start =====");
		read(boardkey, model, session, request);
	}

	// Modify Board POST
	@RequestMapping(value = "/boardmodify", method = RequestMethod.POST)
	public String ModifyPOST(BoardVO bvo, MultipartHttpServletRequest mfile, HttpServletRequest request)
			throws IllegalStateException, Exception {

		int boardkey = service.getboardKey(bvo);
		bvo.setBoardkey(boardkey);
		service.modifyBoard(bvo);
		
		logger.info(" =======   Modify END========");

		if (service.getBuyState(boardkey) == 0) {
			return "redirect:/sboard/salelist";
		} else {
			return "redirect:/sboard/buylist";
		}
		
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
