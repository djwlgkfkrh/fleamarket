package org.flea.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.flea.domain.BoardVO;
import org.flea.domain.CartVO;
import org.flea.domain.DealVO;
import org.flea.domain.FileVO;
import org.flea.domain.PageMaker;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;
import org.flea.service.BoardService;
import org.flea.service.CommentService;
import org.flea.service.DealService;
import org.flea.service.FileService;
import org.flea.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes("userinfo") // MemberVO ????
@Controller
@RequestMapping("")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService service;
	@Inject
	private BoardService bservice;
	@Inject
	private CommentService cservice;
	@Inject
	private DealService dservice;
	@Inject
	private FileService fileservice;

	// 아이디 중복확인 창
	@RequestMapping(value = "/IdCheck", method = RequestMethod.GET)
	public void IdCheck(Model model) throws Exception {

	}

	@ResponseBody
	@RequestMapping(value = "/userIdCheck/{checkid}", method = RequestMethod.GET)
	public ResponseEntity<String> userIdCheck(@PathVariable String checkid, Model model) throws Exception {
		logger.info("중복되는 아이디 있음" + checkid);
		ResponseEntity<String> entity = null;
		try {
			boolean result = service.checkId(checkid);
			if (result) {
				logger.info("중복되는 아이디 있음");
				entity = new ResponseEntity<String>("NO", HttpStatus.OK);
			} else {
				logger.info("중복되는 아이디 없음");
				entity = new ResponseEntity<String>("YES", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 닉네임 
	@RequestMapping(value = "/nicknameCheck", method = RequestMethod.GET)
	public void nicknameCheck(Model model) throws Exception {

	}

	@ResponseBody
	@RequestMapping(value = "/userNickCheck/{checknick}", method = RequestMethod.GET)
	public ResponseEntity<String> userNickCheck(@PathVariable String checknick, Model model) throws Exception {
		logger.info("닉네임" + checknick);
		ResponseEntity<String> entity = null;
		try {
			boolean result = service.checkNick(checknick);
			if (result) {
				logger.info("닉네임");
				entity = new ResponseEntity<String>("NO", HttpStatus.OK);
			} else {
				logger.info("닉네임");
				entity = new ResponseEntity<String>("YES", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO user, Model model) throws Exception {

		logger.info("join post ...........");
		service.join(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVO user, HttpServletResponse response, Model model) throws Exception {

		logger.info("login post ...........");
		String url;
		UserVO userinfo = service.login(user);
		if (userinfo == null)
			url = "error/login_error";
		else {
			model.addAttribute("userinfo", userinfo);
			url = "redirect:/";
		}
		return url;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(UserVO user, Model model, SessionStatus sessionStatus) throws Exception {

		logger.info("logout post ...........");

		// model.addAttribute("user",service.login(user));
		sessionStatus.setComplete();
		return "redirect:/";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(UserVO user, Model model, HttpSession session) throws Exception {
		logger.info("MyPage................" + user.getUserkey());
		user = (UserVO) session.getAttribute("userinfo");
		if (user == null) {
			return "error/login_error";
		} else {
			model.addAttribute("deal_list", dservice.getDeal(user.getUserkey()));
			model.addAttribute("b_list", bservice.listMy(user.getUserkey()));
			model.addAttribute("c_list", cservice.listMy(user.getUserkey()));
			model.addAttribute("b_mycount", bservice.listCount(user.getUserkey()));
			model.addAttribute("c_mycount", cservice.commentCount(user.getUserkey()));
			return "mypage/mypage";
		}
	}

	// my order
	@RequestMapping(value = "/deallist", method = RequestMethod.GET)
	public String deallist(UserVO user, Model model, HttpSession session) throws Exception {
		logger.info("deallist................" + user.getUserkey());
		user = (UserVO) session.getAttribute("userinfo");
		if (user == null) {
			return "error/login_error";
		} else {
			model.addAttribute("deal_list", dservice.getDeal(user.getUserkey()));
			return "mypage/deallist";
		}
	}

	@RequestMapping(value = "/mypage/modify", method = RequestMethod.GET)
	public void modify(UserVO user, Model model, HttpSession session) throws Exception {
		logger.info("MyPage modify................");
		user = (UserVO) session.getAttribute("userinfo");
		model.addAttribute("b_list", bservice.listMy(user.getUserkey()));
		model.addAttribute("c_list", cservice.listMy(user.getUserkey()));
		model.addAttribute("b_mycount", bservice.listCount(user.getUserkey()));
		model.addAttribute("c_mycount", cservice.commentCount(user.getUserkey()));

	}

	// 더럽게 짜증나네
	@RequestMapping(value = "/mypage/complete", method = RequestMethod.POST)
	public String Complete(@ModelAttribute UserVO user, Model model) throws Exception {
		logger.info("Mypage modify complete");
		service.update(user);

		model.addAttribute("userinfo", user);
		// session.setAttribute("userinfo", user);

		/*
		 * //요거 있으면 반응을 안해 user=(UserVO) session.getAttribute("userinfo");
		 * model.addAttribute("userinfo",user);
		 */
		return "redirect:/mypage";
	}

	@RequestMapping(value = "/mypage/changePw", method = RequestMethod.POST)
	public String changePw(@RequestParam String mid, @RequestParam String mpw, UserVO userinfo, RedirectAttributes rttr)
			throws Exception {
		logger.info("Mypage modify complete");
		// 비밀번호 체크

		boolean result = service.checkPw(mid, mpw);
		if (result) { // 비밀번호가 일치하면 수정 처리후, 마이페이지로
			service.updatePw(userinfo);
			logger.info("비밀번호 변경");
			rttr.addFlashAttribute("msg", "비밀번호가 변경되었습니다.");
			return "redirect:/mypage";
		} else
			logger.info("현재 비밀번호가 틀렸어" + result);
		return "error/pw_error";

	}

	@RequestMapping(value = "/mypage/deleteUser", method = RequestMethod.POST)
	public String deleteUser(@RequestParam String did, @RequestParam String dpw, Model model,
			SessionStatus sessionStatus) throws Exception {
		logger.info("회원탈퇴 비밀번호 체크");
		// 비밀번호 체크

		boolean result = service.checkPw(did, dpw);
		if (result) { // 비밀번호가 일치하면 수정 처리후, 마이페이지로
			service.delete(did);
			logger.info("회원탈퇴");
			sessionStatus.setComplete();
			return "redirect:/";
		} else
			logger.info("현재 비밀번호가 틀렸어" + result);
		return "error/pw_error";

	}

	@RequestMapping(value = "/dealinfo/{dealkey}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, String>> dealinfo(@PathVariable("dealkey") Integer dealkey) throws Exception {
		logger.info("dealinfo  ...........");

		DealVO dvo = dservice.read(dealkey);
		UserVO uvo = service.find(dvo.getBuyuserkey());
		BoardVO bvo = bservice.read(dvo.getBoardkey());
		Map<String, String> entity = new HashMap<String, String>();
		entity.put("dealkey", "" + dealkey);

		entity.put("seller", bvo.getNickname());

		entity.put("buyer", uvo.getNickname());
		entity.put("boardtitle", bvo.getTitle());
		SimpleDateFormat newformat = new SimpleDateFormat("yyyy년 M월 d일");
		String new_date = newformat.format(dvo.getRegdate());
		entity.put("regdate", new_date);
		entity.put("money", "" + dvo.getMoney());
		entity.put("deliverykey", "" + dvo.getDeliverykey());
		entity.put("salestate", "" + dvo.getSalestate());

		entity.put("address", uvo.getAddress());
		entity.put("number", "" + uvo.getPhone());
		String salestate = "";
		switch (dvo.getSalestate()) {
		case 0:
			salestate = "입금대기";
			break;
		case 1:
			salestate = "배송대기";
			break;
		case 2:
			salestate = "배송중";
			break;
		case 3:
			salestate = "거래완료";
			break;
		case 4:
			salestate = "반품";
			break;
		case 5:
			salestate = "반품완료";
			break;
		}
		entity.put("salestate", salestate);
		entity.put("salestateNum", "" + dvo.getSalestate());
		return new ResponseEntity<>(entity, HttpStatus.OK);

	}

	@RequestMapping(value = "/mypage/mycart", method = { RequestMethod.POST, RequestMethod.GET })
	public String mycart(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("userinfo");
		if (user == null) {
			return "error/login_error";
		} else {
			logger.info("salelist post ...........");
			UserVO vo = (UserVO) session.getAttribute("userinfo");
			model.addAttribute("cart_list", bservice.listCart(vo.getUserkey()));
			model.addAttribute("list", bservice.listAll());

			List<CartVO> cartlist = bservice.listCart(vo.getUserkey());

			List<FileVO> filelist = new ArrayList<>();
			FileVO fileinfo = new FileVO();

			for (int i = 0; i < cartlist.size(); i++) {

				int boardkey = cartlist.get(i).getBoardkey();
				fileinfo = fileservice.getOneFile(boardkey);

				filelist.add(i, fileinfo);
			}

			model.addAttribute("filelist", filelist);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);

			pageMaker.setTotalCount(bservice.listSearchCount(cri));

			model.addAttribute("pageMaker", pageMaker);
			return "mypage/mycart";
		}
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public void admin(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info("admin");

		model.addAttribute("reportlist", bservice.reportSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(bservice.reportSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);

		// 비밀번호 체크

	}

	@RequestMapping(value = "/admin/return", method = RequestMethod.GET)
	public String adminReturn(@RequestParam("boardkey") int boardkey, Model model) throws Exception {

		bservice.adminreturn(boardkey);
		// 비밀번호 체크
		return "redirect:/admin";
	}

	@RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	public String adminDelete(@RequestParam("boardkey") int boardkey, Model model) throws Exception {
		if (bservice.getBuyState(boardkey) == 0) {
			bservice.deleteSale(boardkey);
			return "redirect:/admin";
		} else {
			bservice.deleteBuy(boardkey);
			return "redirect:/admin";
		}
		// 비밀번호 체크

	}
}
