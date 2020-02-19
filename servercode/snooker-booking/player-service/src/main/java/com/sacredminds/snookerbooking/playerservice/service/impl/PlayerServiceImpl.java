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
import com.sacredminds.snookerbooking.playerservice.repository.PlayerRepository;
import com.sacredminds.snookerbooking.playerservice.service.PlayerService;
import com.sacredminds.snookerbooking.playerservice.vo.PlayerRequestVO;
import com.sacredminds.snookerbooking.playerservice.vo.PlayerResponseVO;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepo;

	private static final ModelMapper modelMapper = new ModelMapper();
	
	/**
	 *  adding a single player
	 */
	@Override
	public PlayerResponseVO addPlayer(@Valid PlayerRequestVO request) {
		Player player = new Player();
		
		player.setFirstName(request.getFirstName());
		player.setLastName(request.getLastName());
		player.setPhone(request.getPhoneNo());
		player.setEmail(request.getEmail());
		player.setPassword(request.getPassword());
		Player playerResponse = playerRepo.save(player);
		return modelMapper.map(playerResponse, PlayerResponseVO.class);
	}

	/** 
	 * Adding multiple players
	 * 
	 * @param playersVO
	 * @return
	 */
	private List<Player> addPlayers(@Valid List<PlayerRequestVO> playersVO) {

		List<Player> playerList = new ArrayList<>();
		playersVO.forEach(playerVO -> {
			Player player = new Player();
			player.setFirstName(playerVO.getFirstName());
			player.setLastName(playerVO.getLastName());
			player.setPhone(playerVO.getPhoneNo());
			player.setEmail(playerVO.getEmail());
			player.setPassword(playerVO.getPassword());
			playerList.add(player);
		});
		return playerRepo.saveAll(playerList);
	}


	@Override
	public PlayerResponseVO findByUsrAndPwd(@NotNull @Valid String playerName, @NotNull @Valid String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
