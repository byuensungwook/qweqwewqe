package test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import test.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository	<Board, Long>, JpaSpecificationExecutor<Board> {	// JpaRepository를 상속하여 사용. <객체, ID>
//    public List<Board> findBoardBy(); //selectList
}
