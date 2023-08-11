package test.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.domain.Member;
import test.dto.MemberDto;
import test.repository.MemberRepository;

@Service
public class MemberService {
	
	private final Logger log = (Logger) LoggerFactory.getLogger(getClass());	
	
	@Autowired
	MemberRepository memberRepository;

	@Autowired
	Member member;
	
	public List list(MemberDto dto) throws Exception {
		List<Member> list = memberRepository.findAll();
		
		List<MemberDto> rtnlist = list.stream().map(m -> new MemberDto(m)).collect(Collectors.toList());
		
		return rtnlist;
	}
	
	public void update(MemberDto dto) throws Exception {		
		
		log.debug("###########DTO############");
		log.debug("id : {} ", dto.getId());
		log.debug("name : {} ", dto.getName());
		log.debug("pw : {} ", dto.getPw());
		log.debug("age : {} ", dto.getAge());
		log.debug("sex : {} ", dto.getSex());
		log.debug("birth : {} ", dto.getBirth());
		log.debug("date : {} ", dto.getDate());
		
		/* dto -> entity */
		Member Member = dto.toEntity();		
		
		log.debug("###########Member############");
		log.debug("id : {} ", Member.getId());
		log.debug("name : {} ", Member.getName());
		log.debug("pw : {} ", Member.getPw());
		log.debug("age : {} ", Member.getAge());
		log.debug("sex : {} ", Member.getSex());
		log.debug("birth : {} ", Member.getBirth());
		log.debug("date : {} ", Member.getDate());
		
	}
}
