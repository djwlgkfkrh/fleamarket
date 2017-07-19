package org.flea.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.flea.domain.MemberVO;
import org.flea.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("")
public class MemberController {

	  private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	  @Inject
	  private MemberService service;

	  @RequestMapping(value = "/join", method = RequestMethod.POST)
	  public String join(MemberVO member, Model model) throws Exception {

	    logger.info("join post ...........");
	    service.join(member);
	    return "redirect:/";
	  }
	  
	  @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public String login(MemberVO member, Model model) throws Exception {

	    logger.info("login post ...........");
	 
	    model.addAttribute("member",service.login(member));
	    return "login1";
	  }
	  
	  @RequestMapping(value = "/mypage", method = RequestMethod.GET)
	  public void mypage( Model model) {
		  logger.info("my ...........");


		     }

}
