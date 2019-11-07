package com.sacredminds.snookerbooking.parlourservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sacredminds.snookerbooking.datamodel.Parlour;

@Repository
public interface ParlourRepository extends JpaRepository<Parlour, Long>{

}
