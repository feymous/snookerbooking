package com.sacredminds.snookerbooking.parlourservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacredminds.snookerbooking.datamodel.Board;
import com.sacredminds.snookerbooking.datamodel.Location;
import com.sacredminds.snookerbooking.datamodel.Parlour;
import com.sacredminds.snookerbooking.datamodel.ParlourOwner;
import com.sacredminds.snookerbooking.parlourservice.exceptionhandling.ResourceNotFoundException;
import com.sacredminds.snookerbooking.parlourservice.repository.BoardRepository;
import com.sacredminds.snookerbooking.parlourservice.repository.BoardTypeRepository;
import com.sacredminds.snookerbooking.parlourservice.repository.CityRepository;
import com.sacredminds.snookerbooking.parlourservice.repository.LocationRepository;
import com.sacredminds.snookerbooking.parlourservice.repository.ParlourOwnerRepository;
import com.sacredminds.snookerbooking.parlourservice.repository.ParlourRepository;
import com.sacredminds.snookerbooking.parlourservice.service.ParlourService;
import com.sacredminds.snookerbooking.parlourservice.vo.BoardVO;
import com.sacredminds.snookerbooking.parlourservice.vo.LocationRequestVO;
import com.sacredminds.snookerbooking.parlourservice.vo.OwnerVO;
import com.sacredminds.snookerbooking.parlourservice.vo.ParlourRequestVO;
import com.sacredminds.snookerbooking.parlourservice.vo.ParlourResponseVO;

@Service
public class ParlourServiceImpl implements ParlourService {

	@Autowired
	ParlourRepository parlourRepo;

	@Autowired
	LocationRepository locationRepo;

	@Autowired
	BoardRepository boardRepo;

	@Autowired
	ParlourOwnerRepository parlourOwnerRepo;

	@Autowired
	BoardTypeRepository boardTypeRepo;

	@Autowired
	CityRepository cityRepo;

	private static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public ParlourResponseVO addParlour(@Valid ParlourRequestVO request) {
		// TODO Auto-generated method stub

		Parlour parlour = new Parlour();

		parlour.setDescription(request.getDescription());
		parlour.setParlourName(request.getParlourName());
		parlour.setPhoneNo(request.getPhoneNo());
		parlour.setEmail(request.getMailId());
		parlour.setOwner(addOwner(request.getOwner()));
		parlour.setLocation(addLocation(request.getLocationRequestVO()));
		parlour.setTags(request.getTags().toString());

		Parlour parlourResponse = parlourRepo.save(parlour);
		parlourResponse.setBoards(addBoards(request.getBoards(), parlour));
		return modelMapper.map(parlourResponse, ParlourResponseVO.class);
	}

	private ParlourOwner addOwner(@Valid OwnerVO ownerRequest) {
		return parlourOwnerRepo.save(modelMapper.map(ownerRequest, ParlourOwner.class));
	}

	private Location addLocation(@Valid LocationRequestVO locationRequest) {
		Location location = modelMapper.map(locationRequest, Location.class);

		cityRepo.findById(locationRequest.getCity()).ifPresentOrElse(city -> {
			location.setCity(city);
		}, () -> {
			throw new ResourceNotFoundException(" No Cities found with provided CityID: " + locationRequest.getCity());
		});
		return locationRepo.save(location);

	}

	private List<Board> addBoards(@Valid List<BoardVO> boardsVO, Parlour parlour) {

		List<Board> boards = new ArrayList<>();
		boardsVO.forEach(boardVO -> {
			Board board = new Board();
			board.setBoardType(boardTypeRepo.findById(boardVO.getBoardTypeId()).get());
			board.setDescription(boardVO.getDescription());
			board.setName(boardVO.getName());
			board.setParlour(parlour);
			board.setPricePerHour(boardVO.getPricePerHour());
			boards.add(board);
		});
		return boardRepo.saveAll(boards);
	}

	@Override
	public List<ParlourResponseVO> findParlourByCity(@NotNull @Valid Long cityId) {

		List<ParlourResponseVO> parlourResponseVO = new ArrayList<>();

		cityRepo.findById(cityId).ifPresentOrElse(city -> {
			parlourRepo.findByCity(city).forEach(parlour -> {
				parlourResponseVO.add(modelMapper.map(parlour, ParlourResponseVO.class));
			});

		}, () -> {
			throw new ResourceNotFoundException(" No Cities found with provided CityID " + cityId);
		});
		return parlourResponseVO;
	}

	@Override
	public List<Long> findParlourCountByCity() {
		return boardRepo.countByCity();
	}

}
