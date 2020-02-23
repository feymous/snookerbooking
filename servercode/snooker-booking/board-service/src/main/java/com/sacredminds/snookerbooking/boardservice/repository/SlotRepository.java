package com.sacredminds.snookerbooking.boardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sacredminds.snookerbooking.datamodel.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long> {

}
