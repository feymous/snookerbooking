package com.sacredminds.snookerbooking.parlourservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sacredminds.snookerbooking.datamodel.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
