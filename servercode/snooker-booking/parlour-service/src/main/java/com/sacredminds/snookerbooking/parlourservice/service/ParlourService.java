package com.sacredminds.snookerbooking.parlourservice.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.sacredminds.snookerbooking.parlourservice.vo.ParlourRequestVO;
import com.sacredminds.snookerbooking.parlourservice.vo.ParlourResponseVO;

public interface ParlourService {

	ParlourResponseVO addParlour(@Valid ParlourRequestVO body);

	List<ParlourResponseVO> findParlourByCity(@NotNull @Valid Long cityId);

	List<Long> findParlourCountByCity();

}
