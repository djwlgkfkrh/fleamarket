package org.flea.controller;

import javax.inject.Inject;

import org.flea.domain.ZipcodeVO;
import org.flea.service.ZipcodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private ZipcodeService service;

	// 거래화면
	@RequestMapping(value = "/deal", method = RequestMethod.GET)
	public void dealView(Model model) throws Exception {

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
	public void dealing(Model model) throws Exception {

	}
}
