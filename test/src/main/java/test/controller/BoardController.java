package test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import test.dto.BoardDto;
import test.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	
	/**
	 * 조회
	 * @param sampleVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@PostMapping(value="/selectBoardPost", consumes = "application/x-www-form-urlencoded")
//	@ResponseBody
	//@RequestMapping(value = "/selectBoard.do", method = RequestMethod.POST) 
	public String selectBoardPost(@RequestParam Map map, Model model, SessionStatus status) throws Exception {
		
		//조회구분에 따라 조호조건 빌더 수정
		BoardDto dto = BoardDto.builder()
				.title((String) map.get("title"))
				.content((String) map.get("content"))
				.build();
		
		System.out.println(dto.toString());
		System.out.println("##############selectBoardPost.do#############");
		
		List<BoardDto> list = boardService.selectBoard(dto);
				
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
//		System.out.println("json String =============================================" + json);
//		
//		return json;
//		
		model.addAttribute("boardList", list);
		
		return "/selectBoardList";
	}
	
	/**
	 * 조회
	 * @param sampleVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@GetMapping(value="/selectBoardGet")
//	@ResponseBody
	//@RequestMapping(value = "/selectBoard.do", method = RequestMethod.POST) 
	public String selectBoardGet(RedirectAttributes attributes, Model model, SessionStatus status) throws Exception {
		
		System.out.println("##############title#############" + attributes.getAttribute("title"));
		System.out.println("##############content#############" + attributes.getAttribute("content"));
		
		BoardDto dto = BoardDto.builder()
			    .title((String) attributes.getAttribute("title"))
			    .content((String) attributes.getAttribute("content"))		    
			    .build();
		  
		
		List<BoardDto> list = boardService.selectBoard(dto);
				
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
//		System.out.println("json String =============================================" + json);
//		
//		return json;
//		
		model.addAttribute("boardList", list);
		
		return "/selectBoardList";
	}
	
//	/**
//	 * 조화회 ajax
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
//		List list = boardService.selectBoard();
//				
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
//		System.out.println("json String =============================================" + json);
//		
//		return json;
//		
//		
////		List<?> list = boardService.list(dto);
////		model.addAttribute("boardList", list);
////		
////		return "index";
//	}
	
	
	/**
	 * 상세조회.
	 * @param sampleVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@PostMapping("/detailBoard")
//	@ResponseBody
	//@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String updateBoard(@RequestParam Map map, Model model, SessionStatus status) throws Exception {
		
		System.out.println("##############detailBoard.do#############");
		
		//toString(), String.valueOf -> 전자는 null인 경우 이셉션, 후자는 어떠한 값이 오더라도 변환
		BoardDto dto = BoardDto.builder()			
				.id(Long.parseLong(String.valueOf(map.get("id"))))
				.build();
		
		
//		boardService.update(dto);
				
		BoardDto boardDetail = boardService.selectBoardDetail(dto);
		model.addAttribute("board", boardDetail);
		
		return "/detailBoard";
	}
	
	/**
	 * 글을 수정한다. redirect 
	 * @param sampleVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@PostMapping("/regBoard")
//	@ResponseBody
	//@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String regBoard(@RequestParam Map map, SessionStatus status, RedirectAttributes attributes) throws Exception {
		
		
		BoardDto dto = BoardDto.builder()			
				.title(String.valueOf(map.get("title")))
				.writer(String.valueOf(map.get("writer")))
				.content(String.valueOf(map.get("content")))
				.build();
		
		System.out.println(dto.toString());
		System.out.println("##############regBoard.do#############");
		
		boardService.update(dto);
				
//		List<?> list = boardService.list(dto);
//		model.addAttribute("list", list);
		
		attributes.addAttribute("title", dto.getTitle());
		attributes.addAttribute("content", dto.getContent());
		
		return "redirect:selectBoardGet";
	}
}
