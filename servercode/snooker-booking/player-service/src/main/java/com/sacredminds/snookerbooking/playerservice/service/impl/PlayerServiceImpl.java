package com.sacredminds.snookerbooking.playerservice.service.impl;

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
import com.sacredminds.snookerbooking.datamodel.Player;
import com.sacredminds.snookerbooking.playerservice.exceptionhandling.ResourceNotFoundException;
import com.sacredminds.snookerbooking.playerservice.repository.BoardRepository;
import com.sacredminds.snookerbooking.playerservice.repository.BoardTypeRepository;
import com.sacredminds.snookerbooking.playerservice.repository.CityRepository;
import com.sacredminds.snookerbooking.playerservice.repository.LocationRepository;
import com.sacredminds.snookerbooking.playerservice.repository.ParlourOwnerRepository;
import com.sacredminds.snookerbooking.playerservice.repository.ParlourRepository;
import com.sacredminds.snookerbooking.playerservice.repository.PlayerRepository;
import com.sacredminds.snookerbooking.playerservice.service.PlayerService;
import com.sacredminds.snookerbooking.playerservice.vo.BoardVO;
import com.sacredminds.snookerbooking.playerservice.vo.LocationRequestVO;
import com.sacredminds.snookerbooking.playerservice.vo.OwnerVO;
import com.sacredminds.snookerbooking.playerservice.vo.ParlourRequestVO;
import com.sacredminds.snookerbooking.playerservice.vo.ParlourResponseVO;
import com.sacredminds.snookerbooking.playerservice.vo.PlayerRequestVO;
import com.sacredminds.snookerbooking.playerservice.vo.PlayerResponseVO;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepo;

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
	public PlayerResponseVO addPlayer(@Valid PlayerRequestVO request) {
		// TODO Auto-generated method stub
		
		Player player = new Player();
		
		player.setFirstName(request.getFirstName());
		player.setLastName(request.getLastName());
		player.setPhoneNo(request.getPhoneNo());
		player.setMailId(request.getMailId());
		player.
		
		Player playerResponse = playerRepo.save(player);
		return modelMapper.map(playerResponse, PlayerResponse.class);
	}

	private List<Players> addPlayers(@Valid List<PlayerRequestVO> playersVO) {

		List<Players> playerList = new ArrayList<>();
		playersVO.forEach(playerVO -> {
			Player player = new Player();
			player.setFirstName(request.getFirstName());
			player.setLastName(request.getLastName());
			player.setPhoneNo(request.getPhoneNo());
			player.setMailId(request.getMailId());
			playerList.add(player);
		});
		return playerRepo.saveAll(playerList);
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

}
