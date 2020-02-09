package com.sacredminds.snookerbooking.parlourservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sacredminds.snookerbooking.datamodel.City;
import com.sacredminds.snookerbooking.datamodel.Parlour;

@Repository
public interface ParlourRepository extends JpaRepository<Parlour, Long> {

	@Query("SELECT p FROM Parlour p INNER JOIN p.location l WHERE l.city= :city")
	List<Parlour> findByCity(@Param("city") City city);
	
	@Query("SELECT count(*) FROM Parlour p GROUP BY p.location.city.cityId")
	List<Long> countByCity();

}
