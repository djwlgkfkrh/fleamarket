package org.flea.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.flea.domain.UserVO;
import org.flea.service.BoardService;
import org.flea.service.CommentService;
import org.flea.service.DealService;
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
	
	// 아이디 중복확인 창
	@RequestMapping(value = "/IdCheck", method = RequestMethod.GET)
	public void IdCheck(Model model) throws Exception {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/userIdCheck/{checkid}", method = RequestMethod.GET)
	public ResponseEntity<String> userIdCheck(@PathVariable String checkid, Model model) throws Exception {
		  logger.info("중복되는 아이디 있음"+checkid);
		ResponseEntity<String> entity = null;
		    try {
		      boolean result = service.checkId(checkid);
		      if(result){
		      logger.info("중복되는 아이디 있음");
		    	  entity = new ResponseEntity<String>("NO", HttpStatus.OK);}
		      else{
		      logger.info("중복되는 아이디 없음");
		    	  entity = new ResponseEntity<String>("YES", HttpStatus.OK);}
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
	public String mypage(UserVO user,Model model,HttpSession session) throws Exception {
		logger.info("MyPage................"+user.getUserkey());
		user=(UserVO) session.getAttribute("userinfo");
		if(user==null){
			return "error/login_error";
		}else{
		model.addAttribute("deal_list",dservice.getDeal(user.getUserkey()));
		model.addAttribute("b_list",bservice.listMy(user.getUserkey()));
		model.addAttribute("c_list",cservice.listMy(user.getUserkey()));
		model.addAttribute("b_mycount",bservice.listCount(user.getUserkey()));
		model.addAttribute("c_mycount",cservice.commentCount(user.getUserkey()));
		return "mypage/mypage";
		}
	}
	
	@RequestMapping(value = "/deallist", method = RequestMethod.GET)
	public String deallist(UserVO user,Model model,HttpSession session) throws Exception {
		logger.info("deallist................"+user.getUserkey());
		user=(UserVO) session.getAttribute("userinfo");
		if(user==null){
			return "error/login_error";
		}else{
		model.addAttribute("deal_list",dservice.getDeal(user.getUserkey()));
		return "mypage/deallist";
		}
	}
	@RequestMapping(value = "/mypage/modify", method = RequestMethod.GET)
	public void modify(UserVO user, Model model,HttpSession session)  throws Exception{
		logger.info("MyPage modify................");
		user=(UserVO) session.getAttribute("userinfo");
		model.addAttribute("b_list",bservice.listMy(user.getUserkey()));
		model.addAttribute("c_list",cservice.listMy(user.getUserkey()));
		model.addAttribute("b_mycount",bservice.listCount(user.getUserkey()));
		model.addAttribute("c_mycount",cservice.commentCount(user.getUserkey()));

	}
	//더럽게 짜증나네
	@RequestMapping(value = "/mypage/complete", method = RequestMethod.POST)
		public String Complete(@ModelAttribute UserVO user, Model model) throws Exception {
			logger.info("Mypage modify complete");
			service.update(user);
			
			model.addAttribute("userinfo", user);
			//session.setAttribute("userinfo", user);
			
			
			/*//요거 있으면 반응을 안해
			user=(UserVO) session.getAttribute("userinfo");
			model.addAttribute("userinfo",user);*/
			return "redirect:/mypage";
	}

	@RequestMapping(value = "/mypage/changePw", method = RequestMethod.POST)
	public String changePw(@RequestParam String mid, @RequestParam String mpw,UserVO userinfo, RedirectAttributes rttr) throws Exception {
		logger.info("Mypage modify complete");
		// 비밀번호 체크
        boolean result = service.checkPw(mid, mpw);
        if(result){ // 비밀번호가 일치하면 수정 처리후, 마이페이지로
            service.updatePw(userinfo);
            logger.info("비밀번호 변경");
            rttr.addFlashAttribute("msg", "비밀번호가 변경되었습니다.");
            return "redirect:/mypage";
        }else
        	logger.info("현재 비밀번호가 틀렸어"+result);
        	return "error/pw_error";
	}
	
	@RequestMapping(value = "/mypage/deleteUser", method = RequestMethod.POST)
	public String deleteUser(@RequestParam String did, @RequestParam String dpw, Model model,SessionStatus sessionStatus) throws Exception {
		logger.info("회원탈퇴 비밀번호 체크");
		// 비밀번호 체크
        boolean result = service.checkPw(did, dpw);
        if(result){ // 비밀번호가 일치하면 수정 처리후, 마이페이지로
            service.delete(did);
            logger.info("회원탈퇴");
            sessionStatus.setComplete();
            return "redirect:/";
        }else
        	logger.info("현재 비밀번호가 틀렸어"+result);
        	return "error/pw_error";
	}
}
