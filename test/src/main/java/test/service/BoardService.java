package test.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.domain.Board;
import test.dto.BoardDto;
import test.repository.BoardRepository;
import test.repository.JpaSpecification;

@Service
public class BoardService {
	
	private final Logger log = (Logger) LoggerFactory.getLogger(getClass());	
	
	@Autowired
	private BoardRepository boardRepository;

	/* select board */
	public List<BoardDto> selectBoard(BoardDto dto) throws Exception {
		
		List<Board> list = boardRepository.findAll(JpaSpecification.likeTitle(dto));
		
		//List<Board> list = (List<Board>) JpaSpecification.likeTitle(dto.getTitle());
		
		/* entity > dto */
		List<BoardDto> rtnDto = list.stream().map(BoardDto::new).collect(Collectors.toList());			
		
		return rtnDto;
	}
	
	/* select Board Detail */
	public BoardDto selectBoardDetail(BoardDto dto) {
		
		Long id = dto.getId();
		
		Optional<Board> board = boardRepository.findById(dto.getId());
		
		BoardDto rntDto = new BoardDto(board.get());
					
		return rntDto;
	}
	
	/* insert board */
	public void update(BoardDto dto) throws Exception {				
		Board boardEntity = dto.toEntity();
		boardRepository.save(boardEntity);
	}
}
