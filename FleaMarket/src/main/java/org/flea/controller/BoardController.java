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

		HttpSession session = request.getSession(); // ���� �����ϰ� �������� �κ�
		UserVO useridx = (UserVO) session.getAttribute("userinfo"); // session���� ""�� �ش��ϴ� ������ ������

		System.out.println("id check : " + useridx.getId()); // �� ! ���͵� ����

		logger.info("main post ...........");

		//model.addAttribute("list", service.read(useridx.getUserkey()));

		return "main";
	}
	
	

	@RequestMapping(value = "/post", method = { RequestMethod.GET }) // �������� �� �ۼ� ����GET
	public String createGET(BoardVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); // ���� �����ϰ� �������� �κ�
		UserVO useridx = (UserVO) session.getAttribute("userinfo");
		vo.setUserkey(useridx.getUserkey());

		logger.info("postGET ...........");

		return "post";
	}
	
	
	

	@RequestMapping(value = "/post", method = { RequestMethod.POST }) // ������ �������� �� �ۼ� POST
	public String createPOST(HttpServletRequest request,BoardVO vo) throws Exception {
		
		HttpSession session = request.getSession(); // ���� �����ϰ� �������� �κ�
		UserVO useridx = (UserVO) session.getAttribute("userinfo");
		vo.setUserkey(useridx.getUserkey());
		
		// ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");

		logger.info(vo.toString());
		
		service.create(vo);

		logger.info("postPOST ...........");

		return "redirect:/main";
	}
	
	
/*	@RequestMapping(value = "/setting", method = RequestMethod.GET) // ���ù�ư ������ ����ȭ������ ���ºκ�
	public String settingGET(MemberVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); // ���� �����ϰ� �������� �κ�
		MemberVO useridx = (MemberVO) session.getAttribute("userinfo");
		vo.setUserid(useridx.getUserid()); // ����� userkey��� id��.. 

		logger.info("userinfo GET ...........");

		return "setting";
	}*/
	
	
	
	
	/// delete �̿� 
/*	
		delete ��ư�� ����... 
	@RequestMapping(value = "/deletePage", method = RequestMethod.POST) // 
	  public String delete(@RequestParam("boardkey") int boardkey, BoardVO vo, RedirectAttributes rttr) throws Exception {

	    service.delete(vo);
	    
	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/main";
	  }
	*/

}
