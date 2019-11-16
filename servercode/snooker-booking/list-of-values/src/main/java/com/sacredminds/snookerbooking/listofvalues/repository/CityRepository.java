package com.sacredminds.snookerbooking.listofvalues.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sacredminds.snookerbooking.datamodel.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
