package test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

import test.dto.MemberDto;
import test.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memeberService;
	
	
	/**
	 * 글을 수정한다. ajax
	 * @param sampleVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@PostMapping(value="/selectBoard", consumes = "application/x-www-form-urlencoded")
	@ResponseBody
	//@RequestMapping(value = "/selectBoard.do", method = RequestMethod.POST) 
	public Model selectBoard(Model model, SessionStatus status) throws Exception {
		
		
		System.out.println("##############ist.do#############");
		
		List list = memeberService.selectBoard();
				
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
//		System.out.println("json String =============================================" + json);
//		
//		return json;
//		
		model.addAttribute("boardList", list);
		
		return model;
	}
	
//	/**
//	 * 글을 수정한다. ajax
//	 * @param sampleVO - 수정할 정보가 담긴 VO
//	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
//	 * @param status
//	 * @return "forward:/egovSampleList.do"
//	 * @exception Exception
//	 */
//	@PostMapping("/selectBoard")
//	@ResponseBody
//	//@RequestMapping(value = "/selectBoard.do", method = RequestMethod.POST) 
//	public String selectBoard(@RequestBody MemberDto memberDto, Model model, SessionStatus status) throws Exception {
//		
//		
//		System.out.println("##############ist.do#############");
//		
//		List list = memeberService.selectBoard();
//				
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
//		System.out.println("json String =============================================" + json);
//		
//		return json;
//		
//		
////		List<?> list = memeberService.list(dto);
////		model.addAttribute("boardList", list);
////		
////		return "index";
//	}
	
	/**
	 * 글을 수정한다.
	 * @param sampleVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@PostMapping("/updatePage")
	@ResponseBody
	//@RequestMapping(value = "/updatePage.do", method = RequestMethod.POST) 
	public String updatePage(@RequestBody MemberDto dto, Model model, SessionStatus status) throws Exception {
			
		return "redirect:test";
	}
		
	/**
	 * 글을 수정한다.
	 * @param sampleVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@PostMapping("/update")
	@ResponseBody
	//@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(@RequestBody MemberDto dto, Model model, SessionStatus status) throws Exception {
		
		memeberService.update(dto);
				
//		List<?> list = memeberService.list(dto);
//		model.addAttribute("list", list);
		
		return "redirect:list.do";
	}
}
