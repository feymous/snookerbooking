package com.sacredminds.snookerbooking.parlourservice.vo;

import lombok.Data;

@Data
public class BoardResponse {

	long count;

	long cityId;

	public BoardResponse(long count, long cityId) {
		super();
		this.count = count;
		this.cityId = cityId;
	}

}
