package test.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Getter;
import test.domain.Member;

/* DTO : 데이터전송객체(Data Transfer Object) 계층 간 데이터 전송을 위한 도메인 모델 대신 사용되는 객체
 * DTO는 어떠한 비즈니스 로직을 가져서는 안되며, 저장, 검색, 직렬화, 역직렬화 로직만을..
 */
@Getter
public class MemberDto {

	private final Long id;
	
	private String name;
	
	private String pw;
	
	private String age;
	
	private String sex;
	
	private String birth;
	
	/*
	 * DTO > Entity
	 */
	@Builder
	public MemberDto(Long id, String name, String pw, String age, String sex, String birth) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.age = age;
		this.sex = sex;
		this.birth = birth;
	}

	/* Entity to Dto */
    public MemberDto(Member m) {
    	this.id = m.getId();
		this.name = m.getName();
		this.pw = m.getPw();
		this.age = m.getAge();
		this.sex = m.getSex();
		this.birth = m.getBirth();
	}

	public Member toEntity() {
        return Member.builder()
                .name(name)
                .pw(pw)
                .age(age)
                .sex(sex)
                .build();
    }
}
