package test.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
@Table(name = "member")									// 테이블명칭 세팅
@NoArgsConstructor(access = AccessLevel.PROTECTED)		// 접근제어로 의미없는 객체 생성 방지
public class Member extends BaseTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String pw;
	
	private String age;
	
	private String sex;
	
	private String birth;
	
	/* 생성자에 @Builder 적용
	 * 객체를 정의하고 그 객체를 생성할 때 보통 생성자를 통해 생성
	 * 데이터 일관성을 위해 정보들을 다 받은 후에 객체를 생성
	 */
    @Builder
	public Member(String name, String pw, String age, String sex, String birth) {
		this.name = name;
		this.pw = pw;
		this.age = age;
		this.sex = sex;
		this.birth = birth;
	}
}
