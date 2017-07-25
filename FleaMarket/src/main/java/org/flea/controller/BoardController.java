package org.flea.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.flea.domain.BoardVO;
import org.flea.domain.PageMaker;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;
import org.flea.service.BoardService;
import org.flea.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@SessionAttributes("userinfo") // MemberVO ����
@Controller
@RequestMapping("/sboard/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private BoardService service;
	@Inject
	private CommentService cservice;

	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	public void salelist(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("salelist post ...........");
		// model.addAttribute("list", service.show());
		// HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분
		// UserVO usersession = (UserVO) session.getAttribute("userinfo");
		// vo.setUserkey(usersession.getUserkey());
		model.addAttribute("list", service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);

	}

	/*
	 * 글 읽는 부분 => 메인 / 팝니다 / 삽니다 시작 ======================================= - -
	 * - - - // readSale : 팝니다 에서 글읽기 - @RequestMapping(value = "", method = {
	 * RequestMethod.GET, RequestMethod.POST }) - public String readSale(Model
	 * model, UserVO vo, HttpServletRequest request) throws Exception { - -
	 * HttpSession session = request.getSession(); // 세션 선언하고 가져오는 부분 - UserVO
	 * usersession = (UserVO) session.getAttribute("userinfo"); // session에서 ""에
	 * 해당하는 세션을 가져옴 - - System.out.println("id check : " + usersession.getId());
	 * // 세션으로 현재 User의 Id 확인 - - logger.info("main post ..........."); -
	 * //model.addAttribute("list", service.read(useridx.getUserkey())); // 모델로
	 * 하면 새로고침하면 사라짐 - - return "main"; - } - - // readBuy : 삽니다 에서 글읽기
	 * - @RequestMapping(value = "/salelist", method = { RequestMethod.GET,
	 * RequestMethod.POST }) - public void salelist(Model model, UserVO vo,
	 * HttpServletRequest request) throws Exception { - - HttpSession session =
	 * request.getSession(); // 세션 선언하고 가져오는 부분 - UserVO usersession = (UserVO)
	 * session.getAttribute("userinfo"); // session에서 ""에 해당하는 세션을 가져옴 - -
	 * System.out.println("id check : " + usersession.getId()); // 세션으로 현재 User의
	 * Id 확인 - - logger.info("salelist post ..........."); -
	 * //model.addAttribute("list", service.read(useridx.getUserkey())); // 모델로
	 * 하면 새로고침하면 사라짐
	 * 
	 */

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("boardkey") int boardkey, Model model,HttpSession session,HttpServletRequest request) throws Exception {
		BoardVO boardinfo = service.read(boardkey);
		model.addAttribute("boardinfo", boardinfo);
		UserVO boarduser = service.find(boardinfo.getUserkey());
		model.addAttribute("boarduser", boarduser);
		
		session=request.getSession(true);
		UserVO userinfo = (UserVO) session.getAttribute("userinfo");
		
		
		 model.addAttribute("reply",cservice.commentRead(boardkey));

	}

	/*
	 * 글 읽는 부분 => 메인 / 팝니다 / 삽니다 끝 =======================================
	 */
	/*
	 * 글 쓰는 부분 => 팝니다 / 삽니다 시작 ========================================== - - -
	 * // createGET : 세션정보로 글 작성 세션GET - - - - // createPOST : 세션정보로 글 작성 세션
	 * POST - @RequestMapping(value = "/post", method = { RequestMethod.POST })
	 * // 가져온 세션으로 글 작성 POST - public String createPOST(HttpServletRequest
	 * request,BoardVO vo) throws Exception { - - HttpSession session =
	 * request.getSession(); // 세션 선언하고 가져오는 부분 - UserVO usersession = (UserVO)
	 * session.getAttribute("userinfo"); -
	 * vo.setUserkey(usersession.getUserkey()); - - // ModelAndView mv = new
	 * ModelAndView("redirect:/sample/openBoardList.do"); - -
	 * logger.info(vo.toString()); - - service.create(vo); - -
	 * logger.info("postPOST ..........."); - - return "redirect:/main"; +
	 */
	@RequestMapping(value = "/post", method = { RequestMethod.GET })
	public void createGET(BoardVO vo) throws Exception {
		logger.info("postGET ...........");
	}
	/*
	 * 글 쓰는 부분 => 팝니다 / 삽니다 끝 ==========================================
	 */
	/*
	 * @RequestMapping(value = "/setting", method = RequestMethod.GET) // 세팅버튼
	 * 누르면 세션화면으로 가는부분 - public String settingGET(MemberVO vo,
	 * HttpServletRequest request) throws Exception { - - HttpSession session =
	 * request.getSession(); // 세션 선언하고 가져오는 부분 - MemberVO useridx = (MemberVO)
	 * session.getAttribute("userinfo"); - vo.setUserid(useridx.getUserid()); //
	 * 여기는 userkey대신 id로.. - - logger.info("userinfo GET ..........."); - -
	 * return "setting"; - }
	 */
	/// delete 미완
	/*
	 * - delete 버튼도 없이... - @RequestMapping(value = "/deletePage", method =
	 * RequestMethod.POST) // - public String delete(@RequestParam("boardkey")
	 * int boardkey, BoardVO vo, RedirectAttributes rttr) throws Exception { - -
	 * service.delete(vo); - - rttr.addFlashAttribute("msg", "SUCCESS"); - -
	 * return "redirect:/main"; - } -
	 */


	@RequestMapping(value = "/beforeread", method = { RequestMethod.GET, RequestMethod.POST })
	public String beforeGET(@RequestParam("boardkey") int boardkey) throws Exception {

		int b = service.before(boardkey);
		return "redirect:/sboard/read?boardkey=" + b;
	}

	@RequestMapping(value = "/afterread", method = { RequestMethod.GET, RequestMethod.POST })
	public String afterGET(@RequestParam("boardkey") int boardkey) throws Exception {

		int b = service.after(boardkey);
		return "redirect:/sboard/read?boardkey=" + b;
	}

}

