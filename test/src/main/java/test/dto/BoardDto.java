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
	
	private String searchScCd;
	
	private Integer replyLc; //답글
	
	private String expiredYn; //만료
	
	private String delYn; //사용여부
	
	private Date postBgng; //게시시작일자
	
	private Date postEnd; //게시종료일자
	
	private Integer searchCnt; //조회건수
	
	private LocalDateTime modDate;
	
	private LocalDateTime regDate;
	
	/* 생성자에 @Builder 적용
	 * 객체를 정의하고 그 객체를 생성할 때 보통 생성자를 통해 생성
	 * 데이터 일관성을 위해 정보들을 다 받은 후에 객체를 생성
	 */
    @Builder
	public BoardDto(Long id, String title, String writer, String content, String searchScCd, Integer replyLc,
			String expiredYn, String delYn, Date postBgng, Date postEnd, Integer searchCnt) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.searchScCd = searchScCd;
		this.replyLc = replyLc;
		this.expiredYn = expiredYn;
		this.delYn = delYn;
		this.postBgng = postBgng;
		this.postEnd = postEnd;
		this.searchCnt = searchCnt;
	}    
	
	/* Entity to Dto */
    public BoardDto(Board board) {
		this.id = board.getId();
		this.title = board.getTitle();
		this.writer = board.getWriter();
		this.content = board.getContent();
		this.replyLc = board.getReplyLc();
		this.expiredYn = board.getExpiredYn();
		this.delYn = board.getDelYn();
		this.postBgng = board.getPostBgng();
		this.postEnd = board.getPostEnd();
		this.searchCnt = board.getSearchCnt();
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
                .replyLc(replyLc)
                .expiredYn(expiredYn)
                .delYn(delYn)
                .postBgng(postBgng)
                .postEnd(postEnd)
                .searchCnt(searchCnt)
                .build();
    }	   
}
