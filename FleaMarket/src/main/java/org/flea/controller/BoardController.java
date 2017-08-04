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
import org.flea.service.DealService;
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

@SessionAttributes("userinfo") // MemberVO ¼¼¼Ç
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
	@Inject
	private DealService dservice;

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

		int b = service.before(boardkey);
		return "redirect:/sboard/read?boardkey=" + b;
	}

	@RequestMapping(value = "/afterread", method = { RequestMethod.GET, RequestMethod.POST })
	public String afterGET(@RequestParam("boardkey") int boardkey) throws Exception {
		int b = service.after(boardkey);
		return "redirect:/sboard/read?boardkey=" + b;
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
	public ResponseEntity<String> dealcart(@RequestParam("boardkey") int boardkey,@RequestParam("userkey") int userkey,CartVO vo) throws Exception {
		logger.info("dealcart ...........");
		ResponseEntity<String> entity = null;
		service.dealcart(boardkey,userkey);
		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	@RequestMapping(value = "/information", method = { RequestMethod.GET, RequestMethod.POST })
	public void information(@RequestParam int commentkey, Model model) throws Exception {
		CommentVO cvo=cservice.find(commentkey);
		UserVO uvo=uservice.find(cvo.getUserkey());
		model.addAttribute("cuserinfo",uvo);	
		model.addAttribute("deal_list", dservice.getDeal(cvo.getUserkey()));
	}
	@RequestMapping(value = "/requestDeal", method = { RequestMethod.GET, RequestMethod.POST })
	public void deallist(@RequestParam int commentkey, Model model) throws Exception {
		CommentVO cvo=cservice.find(commentkey);
		UserVO uvo=uservice.find(cvo.getUserkey());
		model.addAttribute("cuserinfo",uvo);
		model.addAttribute("board",service.read(cvo.getBoardkey()));
		
		
	}
}
