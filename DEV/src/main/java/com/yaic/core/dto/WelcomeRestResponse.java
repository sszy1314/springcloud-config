package com.yaic.core.dto;

/**
 *
 */
public class WelcomeRestResponse
{

	private final String message;

	/**
	 * @param message
	 */
	public WelcomeRestResponse(final String message)
	{
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return this.message;
	}

}
