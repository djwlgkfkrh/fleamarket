package org.flea.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.flea.domain.PageMaker;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;
import org.flea.service.BoardService;
import org.flea.service.DealService;
import org.flea.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("userinfo") // MemberVO 세션
@Controller
@RequestMapping("")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService service;
	@Inject
	private BoardService bservice;
	@Inject
	private DealService dservice;

	// 아이디 중복확인 창
	@RequestMapping(value = "/IdCheck", method = RequestMethod.GET)
	public void IdCheck(Model model) throws Exception {

	}

	@ResponseBody
	@RequestMapping(value = "/userIdCheck/{checkid}", method = RequestMethod.GET)
	public ResponseEntity<String> userIdCheck(@PathVariable String checkid, Model model) throws Exception {
		logger.info("중복되는 아이디 있음" + checkid);
		ResponseEntity<String> entity = null;
		try {
			boolean result = service.checkId(checkid);
			if (result) {
				logger.info("중복되는 아이디 있음");
				entity = new ResponseEntity<String>("NO", HttpStatus.OK);
			} else {
				logger.info("중복되는 아이디 없음");
				entity = new ResponseEntity<String>("YES", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 닉네임 중복확인 창
	@RequestMapping(value = "/nicknameCheck", method = RequestMethod.GET)
	public void nicknameCheck(Model model) throws Exception {

	}

	@ResponseBody
	@RequestMapping(value = "/userNickCheck/{checknick}", method = RequestMethod.GET)
	public ResponseEntity<String> userNickCheck(@PathVariable String checknick, Model model) throws Exception {
		logger.info("중복되는 닉네임 있음" + checknick);
		ResponseEntity<String> entity = null;
		try {
			boolean result = service.checkNick(checknick);
			if (result) {
				logger.info("중복되는 닉네임 있음");
				entity = new ResponseEntity<String>("NO", HttpStatus.OK);
			} else {
				logger.info("중복되는 닉네임 없음");
				entity = new ResponseEntity<String>("YES", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO user, Model model) throws Exception {

		logger.info("join post ...........");
		service.join(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVO user, HttpServletResponse response, Model model) throws Exception {

		logger.info("login post ...........");
		String url;
		UserVO userinfo = service.login(user);
		if (userinfo == null)
			url = "error/login_error";
		else {
			model.addAttribute("userinfo", userinfo);
			url = "redirect:/";
		}
		return url;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(UserVO user, Model model, SessionStatus sessionStatus) throws Exception {

		logger.info("logout post ...........");

		// model.addAttribute("user",service.login(user));
		sessionStatus.setComplete();
		return "redirect:/";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Model model) {
		logger.info("MyPage................");
		return "mypage/mypage";
	}

	@RequestMapping(value = "/mypage/deallist", method = RequestMethod.GET)
	public String deallist(UserVO user, Model model, HttpSession session) throws Exception {
		logger.info("deallist................" + user.getUserkey());
		user = (UserVO) session.getAttribute("userinfo");
		if (user == null) {
			return "error/login_error";
		} else {
			model.addAttribute("deal_list", dservice.getDeal(user.getUserkey()));
			return "mypage/deallist";
		}

	}

	@RequestMapping(value = "/mypage/mycart", method = { RequestMethod.POST, RequestMethod.GET })
	public void mycart(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpSession session) throws Exception {

		logger.info("salelist post ...........");
		UserVO vo = (UserVO) session.getAttribute("userinfo");
		model.addAttribute("cart_list", bservice.listCart(vo.getUserkey()));
		model.addAttribute("list", bservice.listAll());

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(bservice.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}
}
