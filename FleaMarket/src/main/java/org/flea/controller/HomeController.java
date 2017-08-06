package org.flea.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.flea.domain.BoardVO;
import org.flea.domain.PageMaker;
import org.flea.domain.SearchCriteria;
import org.flea.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private BoardService service;

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

		return "home";
	}

	// Main Search
	@RequestMapping(value = "/home", method = { RequestMethod.POST, RequestMethod.GET })
	public ResponseEntity<List<BoardVO>> mainlist(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("home search list post ...........");
		ResponseEntity<List<BoardVO>> entity = null;
		List<BoardVO> searchlist = service.listSearchCriteria(cri);
				
		model.addAttribute("list", service.read(119));
		
		
		/*model.addAttribute("list", searchlist);
		PageMaker pageMaker = new PageMaker(); 
		pageMaker.setCri(cri); 
		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);*/
		
		entity = new ResponseEntity<List<BoardVO>>(searchlist ,HttpStatus.OK);
				 
		logger.info(" home search => group1 : "+cri.getGroup1()+" group1 : "+cri.getGroup2()+" keyword : "+cri.getKeyword());
		
		return entity;
	}

}
