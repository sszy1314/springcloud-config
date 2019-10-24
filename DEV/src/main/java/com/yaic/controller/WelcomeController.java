package com.yaic.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yaic.core.dto.WelcomeRestResponse;
import com.yaic.exception.WelcomeException;


/**
 * 启动测试类
 */
@Controller
public class WelcomeController
{
	@Value("Hello World")
	private String message;

	/**
	 * @return the welcome page
	 */
	@GetMapping(value = "/", produces = { "application/json; charset=UTF-8" })
	@ResponseBody
	public String index()
	{
		return this.message;
	}

	/**
	 * @param model
	 * @return the welcome page
	 */
	@GetMapping( { "/welcome" } )
	public String welcome(final Map<String, Object> model)
	{
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}

	/**
	 * @return the error page
	 */
	@RequestMapping("/fail")
	public String fail()
	{
		throw new WelcomeException("Oh dear!");
	}

	/**
	 * @return the error page
	 */
	@RequestMapping("/fail2")
	public String fail2()
	{
		throw new IllegalStateException();
	}

	/**
	 * @param exception
	 * @return the error page
	 */
	@ExceptionHandler(WelcomeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody WelcomeRestResponse handleMyRuntimeException(final WelcomeException exception)
	{
		return new WelcomeRestResponse("Some data I want to send back to the client.");
	}

}
