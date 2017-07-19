package org.flea.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.flea.domain.BoardVO;
import org.flea.domain.UserVO;
import org.flea.service.BoardService;

@Controller
//@RequestMapping("/main")
public class BoardController {
	

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);


	@Inject
	private BoardService service;
	
	
	
	/* read Main / Sale / Buy start ============= */
	
	// readMain : 
	@RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
	public String readMain(Model model, UserVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); 
		UserVO usersession = (UserVO) session.getAttribute("userinfo"); 
		
		System.out.println("id check : " + usersession.getId());

		
		logger.info("main post ...........");
		//model.addAttribute(service.read(vo);

		return "main";
	}
	
	// readSale 
	@RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
	public String readSale(Model model, UserVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); 
		UserVO usersession = (UserVO) session.getAttribute("userinfo");
		
		System.out.println("id check : " + usersession.getId()); 
		
		logger.info("main post ...........");
		//model.addAttribute("list", service.read(useridx.getUserkey())); 

		return "main";
	}
	
	// readBuy 
	@RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
	public String readMBuy(Model model, UserVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); 
		UserVO usersession = (UserVO) session.getAttribute("userinfo"); 
		
		System.out.println("id check : " + usersession.getId()); 
		
		logger.info("main post ...........");
		//model.addAttribute("list", service.read(useridx.getUserkey()));
		
		return "main";
	}
	

	// read Main / Sale / Buy end ======================================= 
	

	
	
	// Write => Sale / Buy Start ==========================================  
	// createGET 
	@RequestMapping(value = "/post", method = { RequestMethod.GET }) 
	public String createGET(BoardVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); 
		UserVO usersession = (UserVO) session.getAttribute("userinfo");
		vo.setUserkey(usersession.getUserkey());

		logger.info("postGET ...........");

		return "post";
	}
	

	// createPOST 
	@RequestMapping(value = "/post", method = { RequestMethod.POST })
	public String createPOST(HttpServletRequest request,BoardVO vo) throws Exception {
		
		HttpSession session = request.getSession(); 
		UserVO usersession = (UserVO) session.getAttribute("userinfo");
		vo.setUserkey(usersession.getUserkey());
		
		// ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");

		logger.info(vo.toString());
		
		service.create(vo);

		logger.info("postPOST ...........");

		return "redirect:/main";
	}
	
	
	/*
	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public String settingGET(MemberVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); 
		MemberVO useridx = (MemberVO) session.getAttribute("userinfo");
		vo.setUserid(useridx.getUserid());  

		logger.info("userinfo GET ...........");

		return "setting";
	}
	
	
	
	
	/// delete
	@RequestMapping(value = "/deletePage", method = RequestMethod.POST) 
	  public String delete(@RequestParam("boardkey") int boardkey, BoardVO vo, RedirectAttributes rttr) throws Exception {

	    service.delete(vo);
	    
	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/main";
	  }
	
*/
}
