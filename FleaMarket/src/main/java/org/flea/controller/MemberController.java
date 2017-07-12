package org.flea.controller;

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
	  public void join(MemberVO member, Model model) throws Exception {

	    logger.info("join post ...........");
	    service.join(member);
	  }
}
