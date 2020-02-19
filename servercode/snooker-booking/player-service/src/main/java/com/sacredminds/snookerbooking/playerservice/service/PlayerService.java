package com.sacredminds.snookerbooking.playerservice.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;

import com.sacredminds.snookerbooking.playerservice.vo.PlayerRequestVO;
import com.sacredminds.snookerbooking.playerservice.vo.PlayerResponseVO;

public interface PlayerService {

	PlayerResponseVO addPlayer(@Valid PlayerRequestVO body);

	PlayerResponseVO findByUsrAndPwd(@NotNull @Valid String playerName,@NotNull @Valid String password);

}
