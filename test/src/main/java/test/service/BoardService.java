package test.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.domain.Board;
import test.dto.BoardDto;
import test.repository.BoardRepository;
import test.repository.BoardSpecification;

@Service
public class BoardService {
	
	private final Logger log = (Logger) LoggerFactory.getLogger(getClass());	
	
	@Autowired
	private BoardRepository boardRepository;

	/* select board */
	public List selectBoard(BoardDto dto) throws Exception {
		
		List<Board> list = boardRepository.findAll(BoardSpecification.likeTitle(dto.getTitle()));
		
		//List<Board> list = (List<Board>) JpaSpecification.likeTitle(dto.getTitle());
		
		/* entity > dto */
		List<BoardDto> rtnlist = list.stream().map(BoardDto::new).collect(Collectors.toList());			
		
		return rtnlist;
	}
	
	/* insert board */
	public void update(BoardDto dto) throws Exception {				
		Board boardEntity = dto.toEntity();
		boardRepository.save(boardEntity);
	}
}
