package test.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.domain.Board;
import test.domain.Member;
import test.dto.BoardDto;
import test.dto.MemberDto;
import test.repository.BoardRepository;
import test.repository.MemberRepository;

@Service
public class MemberService {
	
	private final Logger log = (Logger) LoggerFactory.getLogger(getClass());	
	
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BoardRepository boardRepository;

	public List list(MemberDto dto) throws Exception {
		List<Member> list = memberRepository.findMemberBy();
		
		List<MemberDto> rtnlist = list.stream().map(m -> new MemberDto(m)).collect(Collectors.toList());
		
		return rtnlist;
	}
	
	
	public List selectBoard() throws Exception {
		List<Board> list = boardRepository.findBoardBy();
		
		List<BoardDto> rtnlist = list.stream().map(m -> new BoardDto(m)).collect(Collectors.toList());
		
		return rtnlist;
	}
	
	
	public void update(MemberDto dto) throws Exception {				
	}
}
