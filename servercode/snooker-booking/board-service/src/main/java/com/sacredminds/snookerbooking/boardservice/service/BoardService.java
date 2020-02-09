package com.sacredminds.snookerbooking.boardservice.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.sacredminds.snookerbooking.boardservice.vo.BoardRequestVO;
import com.sacredminds.snookerbooking.boardservice.vo.BoardResponseVO;

public interface BoardService {

	List<BoardResponseVO> findBoardsByParlourId(@NotNull @Valid Long parlourId);
	
	List<BoardResponseVO> findBoardsByBoardType(@NotNull @Valid Long boardTypeId);

	List<BoardResponseVO> addBoard(@Valid List<BoardRequestVO> boardRequests);

}
