package com.sacredminds.snookerbooking.parlourservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacredminds.snookerbooking.parlourservice.exceptionhandling.ResourceNotFoundException;
import com.sacredminds.snookerbooking.parlourservice.repository.CityRepository;
import com.sacredminds.snookerbooking.parlourservice.repository.ParlourRepository;
import com.sacredminds.snookerbooking.parlourservice.service.ParlourService;
import com.sacredminds.snookerbooking.parlourservice.vo.ParlourRequestVO;
import com.sacredminds.snookerbooking.parlourservice.vo.ParlourResponseVO;

@Service
public class ParlourServiceImpl implements ParlourService {

	@Autowired
	ParlourRepository parlourRepository;

	@Autowired
	CityRepository cityRepository;

	private static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public ParlourResponseVO addParlour(@Valid ParlourRequestVO body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParlourResponseVO> findParlourByCity(@NotNull @Valid Long cityId) {
		// TODO Auto-generated method stub

		List<ParlourResponseVO> parlourResponseVO = new ArrayList<>();
		cityRepository.findById(cityId).ifPresentOrElse(city -> {
			parlourRepository.findByCity(city).forEach(parlour -> {
				parlourResponseVO.add(modelMapper.map(parlour, ParlourResponseVO.class));
			});

		}, () -> {
			throw new ResourceNotFoundException(" No Cities found with provided CityID ");
		});

		return parlourResponseVO;
	}

}
