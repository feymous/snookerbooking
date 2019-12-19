package com.sacredminds.snookerbooking.playerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sacredminds.snookerbooking.datamodel.City;
import com.sacredminds.snookerbooking.datamodel.Parlour;
import com.sacredminds.snookerbooking.datamodel.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Query("SELECT p FROM Player p where p.playerName= :playerName and p.password= :password")
	Player findByUserNameAndPassword(@Param("playerName") String playerName,@Param("password") String password);

}
