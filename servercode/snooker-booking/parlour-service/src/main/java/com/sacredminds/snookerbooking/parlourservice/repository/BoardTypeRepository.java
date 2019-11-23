package com.sacredminds.snookerbooking.parlourservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sacredminds.snookerbooking.datamodel.BoardType;

@Repository
public interface BoardTypeRepository extends JpaRepository<BoardType, Long> {

}
