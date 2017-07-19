package org.flea.controller;

import javax.inject.Inject;

import org.flea.domain.UserVO;
import org.flea.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
	  public String login(UserVO user, Model model) throws Exception {

	    logger.info("login post ...........");
	 
	    model.addAttribute("user",service.login(user));
	    return "login1";
	  }
}
