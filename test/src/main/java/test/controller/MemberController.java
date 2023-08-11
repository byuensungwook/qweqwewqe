package test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import test.dto.MemberDto;
import test.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memeberService;

	/**
	 * 글을 수정한다.
	 * @param sampleVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/list.do", method = RequestMethod.POST) 
	public String list(@ModelAttribute("dto") MemberDto dto, Model model, SessionStatus status) throws Exception {
		
		List list = memeberService.list(dto);
				
//		List<?> list = memeberService.list(dto);
		model.addAttribute("list", list);
		
		return "index";
	}
		
	/**
	 * 글을 수정한다.
	 * @param sampleVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute("dto") MemberDto dto, Model model, SessionStatus status) throws Exception {
		
		memeberService.update(dto);
				
//		List<?> list = memeberService.list(dto);
//		model.addAttribute("list", list);
		
		return "index";
	}
}
