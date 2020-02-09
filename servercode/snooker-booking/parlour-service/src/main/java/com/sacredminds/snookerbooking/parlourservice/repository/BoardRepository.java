package com.sacredminds.snookerbooking.parlourservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sacredminds.snookerbooking.datamodel.Board;
import com.sacredminds.snookerbooking.parlourservice.vo.BoardResponse;

public interface BoardRepository extends JpaRepository<Board, Long> {

	@Query("SELECT count(*) FROM Board b GROUP BY b.parlour.location.city.cityId")
	List<Long> countByCity();

	@Query("SELECT new com.sacredminds.snookerbooking.parlourservice.vo.BoardResponse(count(*), b.parlour.location.city.cityId) FROM Board b GROUP BY b.parlour.location.city.cityId")
	List<BoardResponse> getListByCity();
}
