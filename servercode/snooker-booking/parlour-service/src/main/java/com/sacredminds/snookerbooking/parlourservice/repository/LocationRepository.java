package com.sacredminds.snookerbooking.parlourservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sacredminds.snookerbooking.datamodel.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
