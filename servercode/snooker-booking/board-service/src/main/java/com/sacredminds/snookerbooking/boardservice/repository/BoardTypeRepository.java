package com.sacredminds.snookerbooking.boardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sacredminds.snookerbooking.datamodel.BoardType;

public interface BoardTypeRepository extends JpaRepository<BoardType, Long> {

}
