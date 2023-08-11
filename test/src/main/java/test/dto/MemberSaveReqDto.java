package test.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.domain.Member;

//요청Dto
@Getter
@NoArgsConstructor
public class MemberSaveReqDto {

	private String name;	
	private String pw;	
	private String age;	
	private String sex;
	private Date date;

	@Builder
	public MemberSaveReqDto(String name, String pw, String age, String sex, Date date) {
        this.name = name;
        this.pw = pw;
        this.age = age;
        this.sex = sex;
        this.date = date;
	}
	
	//Req 요청을 dto 로 받은 Member 객체를 Entity 화하여 저장하는 용도
    public Member toEntity() {
        return Member.builder()
        		.name(name)
        		.pw(pw)
        		.age(age)
        		.sex(sex)
        		.date(date)
        		.build();
    }
}
