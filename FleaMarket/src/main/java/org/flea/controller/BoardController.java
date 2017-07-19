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

	
	@RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
	
	public String read(Model model, UserVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분
		UserVO useridx = (UserVO) session.getAttribute("userinfo"); // session에서 ""에 해당하는 세션을 가져옴

		System.out.println("id check : " + useridx.getId()); // 옼 ! 나와따 ㅎㅎ

		logger.info("main post ...........");

		//model.addAttribute("list", service.read(useridx.getUserkey()));

		return "main";
	}
	
	

	@RequestMapping(value = "/post", method = { RequestMethod.GET }) // 세션으로 글 작성 세션GET
	public String createGET(BoardVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분
		UserVO useridx = (UserVO) session.getAttribute("userinfo");
		vo.setUserkey(useridx.getUserkey());

		logger.info("postGET ...........");

		return "post";
	}
	
	
	

	@RequestMapping(value = "/post", method = { RequestMethod.POST }) // 가져온 세션으로 글 작성 POST
	public String createPOST(HttpServletRequest request,BoardVO vo) throws Exception {
		
		HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분
		UserVO useridx = (UserVO) session.getAttribute("userinfo");
		vo.setUserkey(useridx.getUserkey());
		
		// ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");

		logger.info(vo.toString());
		
		service.create(vo);

		logger.info("postPOST ...........");

		return "redirect:/main";
	}
	
	
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
