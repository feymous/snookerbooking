package com.sacredminds.snookerbooking.listofvalues.service;

import java.util.List;

import com.sacredminds.snookerbooking.datamodel.BoardType;
import com.sacredminds.snookerbooking.listofvalues.vo.Cities;

public interface ListOfValuesService {

	Cities getCities();

	List<BoardType> getBoardTypes();

}
