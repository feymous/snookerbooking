package com.sacredminds.snookerbooking.listofvalues.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacredminds.snookerbooking.datamodel.BoardType;
import com.sacredminds.snookerbooking.listofvalues.repository.BoardTypeRepository;
import com.sacredminds.snookerbooking.listofvalues.repository.CityRepository;
import com.sacredminds.snookerbooking.listofvalues.service.ListOfValuesService;
import com.sacredminds.snookerbooking.listofvalues.vo.Cities;
import com.sacredminds.snookerbooking.listofvalues.vo.CityVO;

@Service
public class ListOfValuesImpl implements ListOfValuesService {

	@Autowired
	CityRepository cityRepository;

	@Autowired
	BoardTypeRepository boardTypeRepository;

	private static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public Cities getCities() {

		Cities cities = new Cities();

		cityRepository.findAll().forEach(city -> {
			cities.add(modelMapper.map(city, CityVO.class));
		});
		return cities;
	}

	@Override
	public List<BoardType> getBoardTypes() {
		return boardTypeRepository.findAll();
	}

}
