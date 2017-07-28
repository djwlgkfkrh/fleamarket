package org.flea.controller;

import javax.inject.Inject;

import org.flea.domain.BoardVO;
import org.flea.domain.UserVO;
import org.flea.domain.ZipcodeVO;
import org.flea.service.BoardService;
import org.flea.service.DealService;
import org.flea.service.UserService;
import org.flea.service.ZipcodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/site/*")
public class SiteController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Inject
	private UserService uservice;
	@Inject
	private BoardService bservice;
	@Inject
	private ZipcodeService service;
	@Inject
	private DealService dservice;

	// 거래화면
	@RequestMapping(value = "/deal", method = RequestMethod.GET)
	public void dealView(@RequestParam("boardkey") int boardkey, Model model) throws Exception {
		BoardVO boardinfo = bservice.read(boardkey);
		model.addAttribute("boardinfo", boardinfo);
		UserVO boarduser = bservice.find(boardinfo.getUserkey());
		model.addAttribute("boarduser", boarduser);
	}

	// 우편번호검색
	@RequestMapping(value = "/zipcode", method = RequestMethod.GET)
	public void zipcode(Model model) throws Exception {

	}

	// 우편번호검색
	@RequestMapping(value = "/zipcodeList", method = RequestMethod.GET)
	public void zipcodeListGET(ZipcodeVO vo, Model model) throws Exception {

	}

	// 우편번호검색
	@RequestMapping(value = "/zipcodeList", method = RequestMethod.POST)
	public void zipcodeListPOST(@RequestParam String dong, Model model) throws Exception {
		model.addAttribute("zipcode", service.readZip(dong));
	}

	// 거래화면
	@RequestMapping(value = "/dealing", method = RequestMethod.POST)
	public ResponseEntity<String> dealing(UserVO user) throws Exception {
		logger.info("dealing................");
		
		ResponseEntity<String> entity = null;
		uservice.addInfo(user);
		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
}
