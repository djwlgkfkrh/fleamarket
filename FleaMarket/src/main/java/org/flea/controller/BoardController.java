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
	
	
	
	
	/* read Main / Sale / Buy start ======================================= */

	
	
	// readMain : 메인에서 글읽기 
	@RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
	public String readMain(Model model, UserVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분
		UserVO usersession = (UserVO) session.getAttribute("userinfo"); // session에서 ""에 해당하는 세션을 가져옴
		
		System.out.println("id check : " + usersession.getId()); // 세션으로 현재 User의 Id 확인

		
		logger.info("main post ...........");
		//model.addAttribute(service.read(vo); // 모델로 하면 새로고침하면 사라짐 

		return "main";
	}
	
	// readSale : 팝니다 에서 글읽기 
	@RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
	public String readSale(Model model, UserVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분
		UserVO usersession = (UserVO) session.getAttribute("userinfo"); // session에서 ""에 해당하는 세션을 가져옴
		
		System.out.println("id check : " + usersession.getId()); // 세션으로 현재 User의 Id 확인
		
		logger.info("main post ...........");
		//model.addAttribute("list", service.read(useridx.getUserkey())); // 모델로 하면 새로고침하면 사라짐 

		return "main";
	}
	
	// readBuy : 삽니다 에서 글읽기 
	@RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
	public String readMBuy(Model model, UserVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분
		UserVO usersession = (UserVO) session.getAttribute("userinfo"); // session에서 ""에 해당하는 세션을 가져옴
		
		System.out.println("id check : " + usersession.getId()); // 세션으로 현재 User의 Id 확인
		
		logger.info("main post ...........");
		//model.addAttribute("list", service.read(useridx.getUserkey())); // 모델로 하면 새로고침하면 사라짐 

		return "main";
	}
	
	/* read Main / Sale / Buy end ======================================= */
	
	
	
		
	
	/* 글 쓰는 부분 => 팝니다 / 삽니다   시작  ==========================================  */
	
	
	// createGET : 세션정보로 글 작성 세션GET
	@RequestMapping(value = "/post", method = { RequestMethod.GET }) // 세션으로 글 작성 세션GET
	public String createGET(BoardVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분
		UserVO usersession = (UserVO) session.getAttribute("userinfo");
		vo.setUserkey(usersession.getUserkey());

		logger.info("postGET ...........");

		return "post";
	}
	

	// createPOST : 세션정보로 글 작성 세션 POST
	@RequestMapping(value = "/post", method = { RequestMethod.POST }) // 가져온 세션으로 글 작성 POST
	public String createPOST(HttpServletRequest request,BoardVO vo) throws Exception {
		
		HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분
		UserVO usersession = (UserVO) session.getAttribute("userinfo");
		vo.setUserkey(usersession.getUserkey());
		
		// ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");

		logger.info(vo.toString());
		
		service.create(vo);

		logger.info("postPOST ...........");

		return "redirect:/main";
	}
	
	
	
	/* 글 쓰는 부분 => 팝니다 / 삽니다   끝  ==========================================  */
	
	
/*	@RequestMapping(value = "/setting", method = RequestMethod.GET) // 세팅버튼 누르면 세션화면으로 가는부분
	public String settingGET(MemberVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분
		MemberVO useridx = (MemberVO) session.getAttribute("userinfo");
		vo.setUserid(useridx.getUserid()); // 여기는 userkey대신 id로.. 

		logger.info("userinfo GET ...........");

		return "setting";
	}*/
	
	
	
	
	/// delete 미완 
/*	
		delete 버튼도 없이... 
	@RequestMapping(value = "/deletePage", method = RequestMethod.POST) // 
	  public String delete(@RequestParam("boardkey") int boardkey, BoardVO vo, RedirectAttributes rttr) throws Exception {

	    service.delete(vo);
	    
	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/main";
	  }
	*/

}
