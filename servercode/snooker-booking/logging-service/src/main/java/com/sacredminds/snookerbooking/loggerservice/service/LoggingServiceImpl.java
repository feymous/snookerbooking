package com.sacredminds.snookerbooking.loggerservice.service;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;

@Component
@Log
public class LoggingServiceImpl implements LoggingService {

	public static final Logger logger = LoggerFactory.getLogger(LoggingServiceImpl.class);

	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public void logRequest(HttpServletRequest httpServletRequest, Object body) {
		StringBuilder stringBuilder = new StringBuilder();
		Map<String, String> parameters = buildParametersMap(httpServletRequest);

		stringBuilder.append("REQUEST ");
		stringBuilder.append("method=[").append(httpServletRequest.getMethod()).append("] ");
		stringBuilder.append(", path=[").append(httpServletRequest.getRequestURI()).append("] ");
		stringBuilder.append(", headers=[").append(buildHeadersMap(httpServletRequest)).append("] ");

		if (!parameters.isEmpty()) {
			stringBuilder.append("parameters=[").append(parameters).append("] ");
		}

		if (body != null) {
			stringBuilder.append("body=[" + mapper(body) + "]");
		}

		log.info(stringBuilder.toString());
	}

	@Override
	public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object body) {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("RESPONSE ");
		stringBuilder.append("method=[").append(httpServletRequest.getMethod()).append("] ");
		stringBuilder.append(", path=[").append(httpServletRequest.getRequestURI()).append("] ");
		stringBuilder.append(", responseHeaders=[").append(buildHeadersMap(httpServletResponse)).append("] ");
		stringBuilder.append(", statusCode=[").append(httpServletResponse.getStatus()).append("] ");
		stringBuilder.append(", responseBody=[").append(mapper(body)).append("] ");

		log.info(stringBuilder.toString());

	}

	private Map<String, String> buildParametersMap(HttpServletRequest httpServletRequest) {
		Map<String, String> resultMap = new HashMap<>();
		Enumeration<String> parameterNames = httpServletRequest.getParameterNames();

		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			String value = httpServletRequest.getParameter(key);
			resultMap.put(key, value);
		}

		return resultMap;
	}

	private String mapper(Object object) {

		try {
			return mapper.writeValueAsString(null != object ? object : "");
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage(), e);
			return "couldnt parse the body object";
		}

	}

	private Map<String, String> buildHeadersMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();

		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}

		return map;
	}

	private Map<String, String> buildHeadersMap(HttpServletResponse response) {
		Map<String, String> map = new HashMap<>();

		Collection<String> headerNames = response.getHeaderNames();
		for (String header : headerNames) {
			map.put(header, response.getHeader(header));
		}

		return map;
	}
}
