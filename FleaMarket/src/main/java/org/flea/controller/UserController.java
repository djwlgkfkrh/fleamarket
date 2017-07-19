package org.flea.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

@SessionAttributes("userinfo") //  MemberVO 세션
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
	  public String login(@ModelAttribute UserVO user, Model model) throws Exception {

	    logger.info("login post ...........");
	    UserVO userinfo=service.login(user);
	    model.addAttribute("userinfo", userinfo);
	    return "redirect:/";
	  }
	  
	  @RequestMapping(value = "/logout", method = RequestMethod.POST)
	  public String logout(UserVO user, Model model,SessionStatus sessionStatus ) throws Exception {

	    logger.info("logout post ...........");
	 
	   // model.addAttribute("user",service.login(user));
	    sessionStatus.setComplete();
	    return "redirect:/";
	  }
	  
	  
	  //UI 검사용 임시방편 controller
	  @RequestMapping(value = "/salelist", method = RequestMethod.GET)
	  public void salelist(Model model) throws Exception {

	    logger.info("sale boardlist ...........");
	  }
	  
}
