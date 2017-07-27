package org.flea.controller;

import java.util.List;

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
@RequestMapping("/reply/*")
public class CommentController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private CommentService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<CommentVO>> listReply(@RequestParam("boardkey") int boardkey, Model model)
			throws Exception {
		logger.info("listReply post ...........");
		ResponseEntity<List<CommentVO>> entity = null;
		entity = new ResponseEntity<>(service.commentRead(boardkey), HttpStatus.OK);
		return entity;

	}

	@RequestMapping(value = "/addReply", method = RequestMethod.POST)
	public ResponseEntity<String> addReply(CommentVO vo) throws Exception {
		logger.info("addReply post ...........");

		ResponseEntity<String> entity = null;
		service.addReply(vo);
		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<String> delete(int commentkey) throws Exception {
		logger.info("reply delete ...........");

		ResponseEntity<String> entity = null;

		service.deleteReply(commentkey);
		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		return entity;
	}
	/*
	 * @RequestMapping(value = "/modify", method = { RequestMethod.POST,
	 * RequestMethod.GET }) public String modify(@RequestParam("boardkey") int
	 * boardkey, Model model, CommentVO vo) throws Exception {
	 * logger.info("modify delete ..........."); service.modifyReply(vo); return
	 * "redirect:/sboard/read?boardkey=" + boardkey;
	 * 
	 * }
	 */

}
