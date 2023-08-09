package test.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.domain.Member;
import test.repository.MemberRepository;

@RestController
@RequestMapping(value="/test.do")
public class MemberController {

  @Autowired
  MemberRepository memberRepository;

   @Autowired
   Member member;

    @RequestMapping(method = RequestMethod.POST,path = "/save")
    public String savtest() {
        member.setAge("30");
        member.setBirth("19900101");        
        member.setName("홍길동");
        member.setPw("test");
        member.setSex("남성");
        Date today = new Date();
        member.setDate(today);

        try {
            memberRepository.save(member);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "okok";
    }
}
