package org.flea.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.flea.domain.BoardVO;
import org.flea.domain.CommentVO;
import org.flea.domain.PageMaker;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;
import org.flea.service.BoardService;
import org.flea.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@SessionAttributes("userinfo") // MemberVO ¼¼¼Ç
@Controller
@RequestMapping("/sboard/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private BoardService service;
	@Inject
	private CommentService cservice;

	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	public void salelist(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("salelist post ...........");

		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("boardkey") int boardkey, Model model,HttpSession session,HttpServletRequest request) throws Exception {
		BoardVO boardinfo = service.read(boardkey);
		model.addAttribute("boardinfo", boardinfo);

		UserVO boarduser = service.find(boardinfo.getUserkey());
		model.addAttribute("boarduser", boarduser);
		
		session=request.getSession(true);
		UserVO userinfo = (UserVO) session.getAttribute("userinfo");
		
		
		

	}

	@RequestMapping(value = "/post", method = { RequestMethod.GET })
	public void createGET(BoardVO vo) throws Exception {
		logger.info("postGET ...........");

	}

	@RequestMapping(value = "/beforeread", method = { RequestMethod.GET, RequestMethod.POST })
	public String beforeGET(@RequestParam("boardkey") int boardkey) throws Exception {

		int b = service.before(boardkey);
		return "redirect:/sboard/read?boardkey=" + b;
	}

	@RequestMapping(value = "/afterread", method = { RequestMethod.GET, RequestMethod.POST })
	public String afterGET(@RequestParam("boardkey") int boardkey) throws Exception {

		int b = service.after(boardkey);
		return "redirect:/sboard/read?boardkey=" + b;
	}

}
