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
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/salelist", method = {RequestMethod.POST,RequestMethod.GET})
	public void salelist( Model model) throws Exception {
		logger.info("salelist post ...........");
		model.addAttribute("list", service.show());
		//service.join(user);
		//return "redirect:/";
	}
	
	
	
	/* �� �д� �κ�  => ���� / �˴ϴ� / ��ϴ�  ���� ======================================= 

	
	
	
	// readSale : �˴ϴ� ���� ���б� 
	@RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
	public String readSale(Model model, UserVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); // ���� �����ϰ� �������� �κ�
		UserVO usersession = (UserVO) session.getAttribute("userinfo"); // session���� ""�� �ش��ϴ� ������ ������
		
		System.out.println("id check : " + usersession.getId()); // �������� ���� User�� Id Ȯ��
		
		logger.info("main post ...........");
		//model.addAttribute("list", service.read(useridx.getUserkey())); // �𵨷� �ϸ� ���ΰ�ħ�ϸ� ����� 

		return "main";
	}
	
	// readBuy : ��ϴ� ���� ���б� 
	@RequestMapping(value = "/salelist", method = { RequestMethod.GET, RequestMethod.POST })
	public void salelist(Model model, UserVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); // ���� �����ϰ� �������� �κ�
		UserVO usersession = (UserVO) session.getAttribute("userinfo"); // session���� ""�� �ش��ϴ� ������ ������
		
		System.out.println("id check : " + usersession.getId()); // �������� ���� User�� Id Ȯ��
		
		logger.info("salelist post ...........");
		//model.addAttribute("list", service.read(useridx.getUserkey())); // �𵨷� �ϸ� ���ΰ�ħ�ϸ� ����� 

		
	}
	
	/* �� �д� �κ�  => ���� / �˴ϴ� / ��ϴ�  �� ======================================= */
	
	
	
		
	
	/* �� ���� �κ� => �˴ϴ� / ��ϴ�   ����  ==========================================  
	
	
	// createGET : ���������� �� �ۼ� ����GET
	@RequestMapping(value = "/post", method = { RequestMethod.GET }) // �������� �� �ۼ� ����GET
	public String createGET(BoardVO vo, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(); // ���� �����ϰ� �������� �κ�
		UserVO usersession = (UserVO) session.getAttribute("userinfo");
		vo.setUserkey(usersession.getUserkey());

		logger.info("postGET ...........");

		return "post";
	}
	

	// createPOST : ���������� �� �ۼ� ���� POST
	@RequestMapping(value = "/post", method = { RequestMethod.POST }) // ������ �������� �� �ۼ� POST
	public String createPOST(HttpServletRequest request,BoardVO vo) throws Exception {
		
		HttpSession session = request.getSession(); // ���� �����ϰ� �������� �κ�
		UserVO usersession = (UserVO) session.getAttribute("userinfo");
		vo.setUserkey(usersession.getUserkey());
		
		// ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");

		logger.info(vo.toString());
		
		service.create(vo);

		logger.info("postPOST ...........");

		return "redirect:/main";
	}
	
	
	
	/* �� ���� �κ� => �˴ϴ� / ��ϴ�   ��  ==========================================  */
	
	
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
