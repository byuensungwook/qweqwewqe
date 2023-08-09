package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository	<Member, Long> {	// JpaRepository를 상속하여 사용. <객체, ID>

}
