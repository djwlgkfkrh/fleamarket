package org.flea.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.flea.domain.BoardVO;
import org.flea.domain.PageMaker;
import org.flea.domain.SearchCriteria;
import org.flea.service.BoardService;
import org.flea.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private BoardService service;
	@Inject
	private UserService uservice;

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("popularBoard", service.popular());

		Map<String, String> fleaMarket = new HashMap<String, String>();
		fleaMarket.put("usercount", "" + uservice.countuser());
		fleaMarket.put("boardcount", "" + service.countboard());
		
		model.addAttribute("fleaMarket", fleaMarket);

		return "home";
	}

	// Main Search
	@RequestMapping(value = "/home", method = { RequestMethod.POST, RequestMethod.GET })
	public String mainlist(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("home search list post ...........");

		List<BoardVO> searchlist = service.listSearchCriteria(cri);
		model.addAttribute("searchlist", searchlist);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.salelistSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		return "sboard/searchlist";

	}

}
