package org.flea.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.flea.domain.BoardVO;
import org.flea.domain.CartVO;
import org.flea.domain.CommentVO;
import org.flea.domain.PageMaker;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;
import org.flea.service.BoardService;
import org.flea.service.CommentService;
import org.flea.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("userinfo") // MemberVO ����
@Controller
@RequestMapping("/sboard/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private BoardService service;
	@Inject
	private CommentService cservice;
	@Inject
	private UserService uservice;

	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	public void salelist(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("salelist post ...........");
		// model.addAttribute("list", service.show());
		// HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분
		// UserVO usersession = (UserVO) session.getAttribute("userinfo");
		// vo.setUserkey(usersession.getUserkey());
		model.addAttribute("list", service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);

	}

	/*
	 * 글 읽는 부분 => 메인 / 팝니다 / 삽니다 시작 ======================================= - -
	 * - - - // readSale : 팝니다 에서 글읽기 - @RequestMapping(value = "", method = {
	 * RequestMethod.GET, RequestMethod.POST }) - public String readSale(Model
	 * model, UserVO vo, HttpServletRequest request) throws Exception { - -
	 * HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분 - UserVO
	 * usersession = (UserVO) session.getAttribute("userinfo"); // session에서 ""에
	 * 해당하는 세션을 가져옴 - - System.out.println("id check : " + usersession.getId());
	 * // 세션으로 현재 User의 Id 확인 - - logger.info("main post ..........."); -
	 * //model.addAttribute("list", service.read(useridx.getUserkey())); // 모델로
	 * 하면 새로고침하면 사라짐 - - return "main"; - } - - // readBuy : 삽니다 에서 글읽기
	 * - @RequestMapping(value = "/salelist", method = { RequestMethod.GET,
	 * RequestMethod.POST }) - public void salelist(Model model, UserVO vo,
	 * HttpServletRequest request) throws Exception { - - HttpSession session =
	 * request.getSession(); // 세션 선언하고 가져오는 부분 - UserVO usersession = (UserVO)
	 * session.getAttribute("userinfo"); // session에서 ""에 해당하는 세션을 가져옴 - -
	 * System.out.println("id check : " + usersession.getId()); // 세션으로 현재 User의
	 * Id 확인 - - logger.info("salelist post ..........."); -
	 * //model.addAttribute("list", service.read(useridx.getUserkey())); // 모델로
	 * 하면 새로고침하면 사라짐
	 * 
	 */

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("boardkey") int boardkey, Model model, HttpSession session,
			HttpServletRequest request) throws Exception {
		BoardVO boardinfo = service.read(boardkey);
		model.addAttribute("boardinfo", boardinfo);
		UserVO boarduser = service.find(boardinfo.getUserkey());
		model.addAttribute("boarduser", boarduser);
		session = request.getSession(true);
		UserVO userinfo = (UserVO) session.getAttribute("userinfo");

		int cart = 0;
		if (userinfo != null) {
			cart = service.getcart(boardkey, userinfo.getUserkey());
		}
		model.addAttribute("cart", cart);
	}

	@RequestMapping(value = "/post", method = { RequestMethod.GET })
	public void createGET(BoardVO vo) throws Exception {
		logger.info("postGET ...........");
	}

	@RequestMapping(value = "/beforeread", method = { RequestMethod.GET, RequestMethod.POST })
	public String beforeGET(@RequestParam("boardkey") int boardkey) throws Exception {
		try {
			int b = service.before(boardkey);
			return "redirect:/sboard/read?boardkey=" + b;
		} catch (Exception e) {
			e.printStackTrace();
			return "error/nullPage_error";
		}
	}

	@RequestMapping(value = "/afterread", method = { RequestMethod.GET, RequestMethod.POST })
	public String afterGET(@RequestParam("boardkey") int boardkey) throws Exception {
		try {
			int b = service.after(boardkey);
			return "redirect:/sboard/read?boardkey=" + b;
		} catch (Exception e) {
			e.printStackTrace();
			return "error/nullPage_error";
		}

	}

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public ResponseEntity<String> cart(CartVO vo) throws Exception {
		logger.info("cart ...........");
		ResponseEntity<String> entity = null;
		service.putcart(vo);
		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@RequestMapping(value = "/dealcart", method = RequestMethod.POST)
	public ResponseEntity<String> dealcart(@RequestParam("boardkey") int boardkey, @RequestParam("userkey") int userkey,
			CartVO vo) throws Exception {
		logger.info("dealcart ...........");
		ResponseEntity<String> entity = null;
		service.dealcart(boardkey, userkey);
		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@RequestMapping(value = "/information", method = { RequestMethod.GET, RequestMethod.POST })
	public void information(@RequestParam int commentkey, Model model) throws Exception {
		CommentVO cvo = cservice.find(commentkey);
		UserVO uvo = uservice.find(cvo.getUserkey());
		model.addAttribute("cuserinfo", uvo);
	}

	@RequestMapping(value = "/deallist", method = { RequestMethod.GET, RequestMethod.POST })
	public void deallist(@RequestParam int commentkey, Model model) throws Exception {
		CommentVO cvo = cservice.find(commentkey);
		UserVO uvo = uservice.find(cvo.getUserkey());
		model.addAttribute("cuserinfo", uvo);

	}
}
