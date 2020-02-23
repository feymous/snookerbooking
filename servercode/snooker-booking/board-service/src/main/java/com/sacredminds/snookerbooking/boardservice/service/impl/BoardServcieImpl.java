package com.sacredminds.snookerbooking.boardservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacredminds.snookerbooking.boardservice.exceptionhandler.BoardServiceException;
import com.sacredminds.snookerbooking.boardservice.repository.BoardRepository;
import com.sacredminds.snookerbooking.boardservice.repository.BoardTypeRepository;
import com.sacredminds.snookerbooking.boardservice.repository.ParlourRepository;
import com.sacredminds.snookerbooking.boardservice.service.BoardService;
import com.sacredminds.snookerbooking.boardservice.vo.BoardRequestVO;
import com.sacredminds.snookerbooking.boardservice.vo.BoardResponseVO;
import com.sacredminds.snookerbooking.datamodel.Board;

@Service
public class BoardServcieImpl implements BoardService {

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	BoardTypeRepository boardTypeRepository;

	@Autowired
	ParlourRepository parlourRepository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<BoardResponseVO> findBoardsByParlourId(@NotNull @Valid Long parlourId) {

		List<BoardResponseVO> boards = new ArrayList<>();

		boardRepository.findByParlour(parlourId).forEach(board -> {
			boards.add(modelMapper.map(board, BoardResponseVO.class));
		});

		return boards;
	}

	@Override
	public List<BoardResponseVO> findBoardsByBoardType(@NotNull @Valid Long boardTypeId) {
		List<BoardResponseVO> boards = new ArrayList<>();

		boardRepository.findByBoardType(boardTypeId).forEach(board -> {
			boards.add(modelMapper.map(board, BoardResponseVO.class));
		});

		return boards;
	}

	@Override
	public List<BoardResponseVO> addBoard(@Valid List<BoardRequestVO> boardRequests) {

		List<Board> boards = new ArrayList<>();
		for (BoardRequestVO boardRequest : boardRequests) {
			Board board = modelMapper.map(boardRequest, Board.class);
			board.setBoardType(boardTypeRepository.findById(boardRequest.getBoardTypeId()).orElseThrow());
			board.setParlour(parlourRepository.findById(boardRequest.getParlourId()).orElseThrow());
			boards.add(board);
		}
		List<BoardResponseVO> boardsResponse = new ArrayList<>();

		boards = boardRepository.saveAll(boards);
		boards.forEach(board -> {
			boardsResponse.add(modelMapper.map(board, BoardResponseVO.class));
		});
		return boardsResponse;
	}

	@Override
	public Board findByBoardId(long boardId) throws BoardServiceException {

		return boardRepository.findById(boardId)
				.orElseThrow(() -> new BoardServiceException(123, "Board not fould with boardID: " + boardId));
	}

}
