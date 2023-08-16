package test.dto;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.domain.Board;

/* DTO : 데이터전송객체(Data Transfer Object) 계층 간 데이터 전송을 위한 도메인 모델 대신 사용되는 객체
 * DTO는 어떠한 비즈니스 로직을 가져서는 안되며, 저장, 검색, 직렬화, 역직렬화 로직만을..
 */
@Getter
@NoArgsConstructor  // 인자 없이 객체 생성 가능
public class BoardDto {
	
	private Long id;
	
	private String title;
	
	private String writer;
	
	private String content;
	
	private LocalDateTime modDate;
	
	private LocalDateTime regDate;
	
	/*
	 * 빌더패턴을 사용하요 
	 */
	@Builder
	public BoardDto(Long id, String title, String writer, String content, LocalDateTime modDate, LocalDateTime regDate) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.modDate = modDate;
		this.regDate = regDate;
	}
	
	/* Entity to Dto */
    public BoardDto(Board board) {
    	this.id = board.getId();
		this.title = board.getTitle();
		this.writer = board.getWriter();
		this.content = board.getContent();
		this.modDate = board.getModDate();
		this.regDate = board.getRegDate();
	}

    /* dto to entity */
	public Board toEntity() {
        return Board.builder()
        		.id(id)
        		.title(title)
        		.writer(writer)
                .content(content)
                .build();
    }
}
