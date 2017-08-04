package org.flea.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.flea.domain.CartVO;
import org.flea.domain.PageMaker;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;
import org.flea.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 * Handles requests for the application home page.
 */
@SessionAttributes("userinfo")
@Controller
@RequestMapping("/mypage/*")
public class MypageController {
	@Inject
	private BoardService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	  /**
	   * Simply selects the home view to render by returning its name.
	   */
	  @RequestMapping(value = "/modify", method = RequestMethod.GET)
	  public void modify(Locale locale, Model model) {
		    logger.info("Welcome Modify! The client locale is {}.", locale);

		  }
	  @RequestMapping(value = "/mycart",  method = { RequestMethod.POST, RequestMethod.GET })
	  public void mycart(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpSession session) throws Exception {
		 
			logger.info("salelist post ...........");
			UserVO vo=(UserVO) session.getAttribute("userinfo");
			model.addAttribute("cart_list",service.listCart(vo.getUserkey()));
			model.addAttribute("list", service.listAll());

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);

			pageMaker.setTotalCount(service.listSearchCount(cri));

			model.addAttribute("pageMaker", pageMaker);
		  }
	 
	
}
