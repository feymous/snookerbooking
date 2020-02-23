package com.sacredminds.snookerbooking.boardservice.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sacredminds.snookerbooking.boardservice.exceptionhandler.BoardServiceException;
import com.sacredminds.snookerbooking.boardservice.repository.SlotRepository;
import com.sacredminds.snookerbooking.boardservice.service.BoardService;
import com.sacredminds.snookerbooking.boardservice.service.SlotsService;
import com.sacredminds.snookerbooking.boardservice.util.LocalDatePersistenceConverter;
import com.sacredminds.snookerbooking.boardservice.util.LocalTimePersistenceConverter;
import com.sacredminds.snookerbooking.boardservice.vo.BoardSlotsResponseVO;
import com.sacredminds.snookerbooking.boardservice.vo.BoardSlotsVO;
import com.sacredminds.snookerbooking.boardservice.vo.SlotRequestVO;
import com.sacredminds.snookerbooking.datamodel.Board;
import com.sacredminds.snookerbooking.datamodel.Slot;
import com.sacredminds.snookerbooking.datamodel.SlotStatus;


@Service
public class SlotServiceImpl implements SlotsService {

	@Autowired
	SlotRepository slotRepositiory;

	@Autowired
	BoardService boardService;
	
	@Value("${date_format}")
	String dateFormat;

	@Value("${time_format}")
	String timeFormat;

	@Value("${tz_id}")
	String zoneId;
	
	ModelMapper modelMapper = new ModelMapper();

	private LocalDatePersistenceConverter dc = new LocalDatePersistenceConverter();
	private LocalTimePersistenceConverter tc = new LocalTimePersistenceConverter();

	@Override
	public BoardSlotsResponseVO createSlots(@Valid SlotRequestVO slotRequestVO) throws BoardServiceException {

		Board board = boardService.findByBoardId(slotRequestVO.getBoardId());
		List<Slot> slotList = createSlots(
				dc.convertToLocalDate(slotRequestVO.getStartDate()), dc.convertToLocalDate(slotRequestVO.getEndDate()),
				board);
		
		BoardSlotsResponseVO boardSlotsResponseVO = modelMapper.map(board, BoardSlotsResponseVO.class);
		List<BoardSlotsVO> boardSlotsVO = new ArrayList<>();
		SimpleDateFormat dateFormatter = new SimpleDateFormat(this.dateFormat);
		SimpleDateFormat timeFormatter = new SimpleDateFormat(this.timeFormat);
		String dateValue = "";
		String startTime = "";
		String endTime = "";
		String endTimeValue;
		
		for (Slot slot : slotList) {
			BoardSlotsVO slotvo = new BoardSlotsVO();
			slotvo.setSlotId(slot.getSlotId());
			// Formating date
			if (slot.getDate() != null) {
				dateValue  = String.valueOf(dateFormatter.format(slot.getDate()));
			}
			// Formating startTime
			if (slot.getStartTime() != null) {
				startTime = String.valueOf(timeFormatter.format(slot.getStartTime()));
			}
			String startTimeValue = dateValue + "T" + startTime + "Z";

			if (slot.getEndTime() != null) {
				endTime = String.valueOf(timeFormatter.format(slot.getEndTime()));
			}
			// Date increment to next date when end time is 00:00:00
			if (startTime.contains("23")) {
				SimpleDateFormat sdf = new SimpleDateFormat(this.dateFormat);
				java.util.Calendar c = java.util.Calendar.getInstance();
				try {
					c.setTime(sdf.parse(dateValue));
				} catch (ParseException e) {
					throw new BoardServiceException(124, "Invalid DateFormat");
				}
				c.add(java.util.Calendar.DATE, 1);
				dateValue = sdf.format(c.getTime());
			}

			endTimeValue = dateValue + "T" + endTime + "Z";

			slotvo.setStart(startTimeValue);
			slotvo.setEnd(endTimeValue);

			boardSlotsVO.add(slotvo);
		}
		boardSlotsResponseVO.setBoardSlots(boardSlotsVO);
		return boardSlotsResponseVO;
	}

	public List<Slot> createSlots(LocalDate startDate, LocalDate endDate, Board board) {

		List<Slot> slots = new ArrayList<>();
		LocalDate currDate = startDate;
		while (currDate.isBefore(endDate)) {
			for (int i = 0; i <= 23; i++) {
				Slot slot = new Slot();
				if (i == 23) {
					slot.setStartTime(tc.convertToDatabaseColumn(LocalTime.of(i, 00)));
					slot.setEndTime(tc.convertToDatabaseColumn(LocalTime.of(00, 00)));
				} else {
					slot.setStartTime(tc.convertToDatabaseColumn(LocalTime.of(i, 00)));
					slot.setEndTime(tc.convertToDatabaseColumn(LocalTime.of(i + 1, 00)));
				}
				slot.setDate(dc.convertToDatabaseColumn(currDate));
				slot.setBoard(board);
				slot.setSlotStatus(SlotStatus.OPEN);
				slots.add(slot);
			}
			currDate = currDate.plusDays(1);
		}
		return slotRepositiory.saveAll(slots);
	}

}
