package test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*Entity : 실제 Db와 매핑되는 클래스, DB의 컬럼들을 필드로 가짐(1:1매핑), Entity를 기준으로 동작함에따라 변경을 지양
 * 			또한 Setter를 지양하며 대신 Constructor(생성자) 또는 Builder 사용
 * 
 */
@Entity													// DB테이블
@Getter													// getter 사용o/settetr 사용x
@Table(name = "userInfo", uniqueConstraints = {
		@UniqueConstraint(
				name="USER_INFO_UNIQUE",
				columnNames= {"userId", "userPw"}
				)})										// 테이블관련 세팅(명, 유니크
@NoArgsConstructor(access = AccessLevel.PROTECTED)		// 접근제어로 의미없는 객체 생성 방지
public class User extends BaseTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userId;
	
	private String userPw;
	
	private String userNm;
	
	private String userRrno;
	
	private String userSex;
	
	private String userBirth;
	
	/* 생성자에 @Builder 적용
	 * 객체를 정의하고 그 객체를 생성할 때 보통 생성자를 통해 생성
	 * 데이터 일관성을 위해 정보들을 다 받은 후에 객체를 생성
	 */
    @Builder
	public User(Long id, String userId, String userPw, String userNm, String userRrno, String userSex, String userBirth) {
    	this.id = id;
    	this.userId = userId;
    	this.userPw = userPw;
		this.userNm = userNm;
		this.userRrno = userRrno;
		this.userSex = userSex;
		this.userBirth = userBirth;
	}
}
