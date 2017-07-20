package org.flea.controller;

import java.util.Locale;

import javax.inject.Inject;
import org.flea.domain.UserVO;
import org.flea.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Handles requests for the application home page.
 */

@Controller

public class MypageController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/*@Inject
	private UserService service;

	*//**
	 * Simply selects the home view to render by returning its name.
	 *//*
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modify(Locale locale, Model model) {
		logger.info("Welcome Modify! The client locale is {}.", locale);

	}

	@RequestMapping(value = "/complete", method = RequestMethod.POST)
	public String Complete(UserVO user, Model model) throws Exception {
		logger.info("Mypage modify complete");
		service.update(user);
		return "redirect:/mypage";
	}*/

}
