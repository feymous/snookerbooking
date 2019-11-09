package com.sacredminds.snookerbooking.parlourservice.service.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.sacredminds.snookerbooking.parlourservice.service.ParlourService;
import com.sacredminds.snookerbooking.parlourservice.vo.ParlourRequestVO;
import com.sacredminds.snookerbooking.parlourservice.vo.ParlourResponseVO;

@Service
public class ParlourServiceImpl implements ParlourService{

	@Override
	public ParlourResponseVO addParlour(@Valid ParlourRequestVO body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParlourResponseVO> findParlourByCity(@NotNull @Valid Long cityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
