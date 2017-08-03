package org.flea.controller;

import java.util.List;

import javax.inject.Inject;

import org.flea.domain.CommentVO;
import org.flea.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/reply/*")
public class CommentController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private CommentService service;

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<CommentVO> listReply(@RequestParam("boardkey") int boardkey, Model model) throws Exception {
		logger.info("listReply post ...........");
		List<CommentVO> entity = null;
		entity = service.commentRead(boardkey);
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

	@RequestMapping(value = "/delete/{commentkey}", method = RequestMethod.POST)
	public ResponseEntity<String> delete(@PathVariable("commentkey") Integer commentkey) throws Exception {
		logger.info("reply delete ...........");

		ResponseEntity<String> entity = null;
		service.deleteReply(commentkey);
		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		return entity;
	}

	@RequestMapping(value = "/modify/{commentkey}", method =  RequestMethod.POST )
	public ResponseEntity<String> modify( @PathVariable("commentkey") Integer commentkey, CommentVO vo) throws Exception {
		logger.info("reply modify  ...........");
		logger.info("dd"+vo.getContext());
		vo.setCommentkey(commentkey);
		ResponseEntity<String> entity = null;
		service.modifyReply(vo);
		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;

	}
	@RequestMapping(value = "/replySub/{commentkey}", method = { RequestMethod.POST })
	public ResponseEntity<String> replySub( @PathVariable("commentkey") Integer commentkey, CommentVO vo) throws Exception {
		logger.info("replySub  ...........");
		vo.setParent_key(commentkey);
		ResponseEntity<String> entity = null;
		service.replySub(vo);
		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;

	}

}
