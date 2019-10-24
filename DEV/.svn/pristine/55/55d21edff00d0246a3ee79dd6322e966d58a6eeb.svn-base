package com.yaic.app.common.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yaic.servicelayer.util.IOUtil;

public class HttpUtil {
	private static final Logger LOG = LoggerFactory.getLogger(HttpUtil.class);
	
	public static String getRequestBody(final HttpServletRequest request) {
		final StringBuilder buffer = new StringBuilder();
		
		try {
			final List<String> lines = IOUtil.readLines(request.getInputStream(), "UTF-8");
			for (String line : lines) {
				buffer.append(line);
			}
		} catch (IOException e) {
			LOG.error("IOException occured when process request: {}", request.getRequestURL() , e);
		}
		
		return buffer.toString();
	}
}