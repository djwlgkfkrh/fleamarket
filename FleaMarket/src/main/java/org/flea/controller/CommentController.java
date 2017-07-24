package org.flea.controller;

import javax.inject.Inject;

import org.flea.domain.SearchCriteria;
import org.flea.service.BoardService;
import org.flea.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.flea.domain.CommentVO;

@Controller
@RequestMapping("/reply")
public class CommentController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private CommentService service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String salelist(@RequestParam("boardkey") int boardkey,Model model, CommentVO vo) throws Exception {

		logger.info("reply post ...........");
		service.addReply(vo);
		return "redirect:/sboard/read?boardkey="+boardkey;

	}

}
