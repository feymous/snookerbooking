package com.sacredminds.snookerbooking.boardservice.repository;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sacredminds.snookerbooking.datamodel.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

	@Query("SELECT b FROM Board b where b.parlour.parlourId = ?1")
	List<Board> findByParlour(long parlourId);

	@Query("SELECT b FROM Board b where b.boardType.boardTypeId = ?1")
	List<Board> findByBoardType(@NotNull @Valid Long boardTypeId);
	
}
