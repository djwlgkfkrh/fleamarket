package org.flea.controller;

import java.io.PrintWriter;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.flea.domain.UserVO;
import org.flea.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("userinfo") // MemberVO ����
@Controller
@RequestMapping("")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService service;

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

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Locale locale, Model model) {
		logger.info("Welcome Modify! The client locale is {}.", locale);
		return "mypage/mypage";
	}
}
