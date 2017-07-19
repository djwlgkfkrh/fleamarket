package org.flea.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/mypage/*")
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	  /**
	   * Simply selects the home view to render by returning its name.
	   */
	  @RequestMapping(value = "/modify", method = RequestMethod.GET)
	  public void modify(Locale locale, Model model) {
		    logger.info("Welcome Modify! The client locale is {}.", locale);

		  }
	  
	  
	
}
