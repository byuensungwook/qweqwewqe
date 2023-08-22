package test.dto;

import lombok.Builder;
import lombok.Getter;
import test.domain.User;

/* DTO : 데이터전송객체(Data Transfer Object) 계층 간 데이터 전송을 위한 도메인 모델 대신 사용되는 객체
 * DTO는 어떠한 비즈니스 로직을 가져서는 안되며, 저장, 검색, 직렬화, 역직렬화 로직만을..
 */
@Getter
public class UserDto {

	private final Long id;
	
	private String userId;
	
	private String userPw;
	
	private String userNm;
	
	private String userRrno;
	
	private String userSex;
	
	private String userBirth;
	
	/*
	 * DTO > Entity
	 */
	@Builder
	public UserDto(Long id, String userId, String userPw, String userNm, String userRrno, String userSex, String userBirth) {
		this.id = id;
		this.userId = userId;
		this.userPw = userPw;
		this.userNm = userNm;
		this.userRrno = userRrno;
		this.userSex = userSex;
		this.userBirth = userBirth;
	}

	/* Entity to Dto */
    public UserDto(User m) {
    	this.id = m.getId();
    	this.userId = m.getUserId();
		this.userPw = m.getUserPw();
		this.userNm = m.getUserNm();
		this.userRrno = m.getUserRrno();
		this.userSex = m.getUserSex();
		this.userBirth = m.getUserBirth();
	}

	public User toEntity() {
        return User.builder()
        		.id(id)
        		.userId(userId)
        		.userPw(userPw)
                .userNm(userNm)
                .userRrno(userRrno)
                .userSex(userSex)
                .userBirth(userBirth)
                .build();
    }
}
