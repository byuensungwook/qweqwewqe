package test.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.domain.Board;

/* DTO : 데이터전송객체(Data Transfer Object) 계층 간 데이터 전송을 위한 도메인 모델 대신 사용되는 객체
 * DTO는 어떠한 비즈니스 로직을 가져서는 안되며, 저장, 검색, 직렬화, 역직렬화 로직만을..
 */
@Getter
public class BoardDto {
	
	private final Long id;
	
	private String title;
	
	private String content;
	
	private Date date;
	
	/*
	 * DTO > Entity
	 */
	@Builder
	public BoardDto(Long id, String title, String content, Date date) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	/* Entity to Dto */
    public BoardDto(Board m) {
    	this.id = m.getId();
		this.title = m.getTitle();
		this.content = m.getContent();		
		this.date = m.getDate();
	}

	public Board toEntity() {
        return Board.builder()
        		.title(title)
                .content(content)
                .build();
    }
}
