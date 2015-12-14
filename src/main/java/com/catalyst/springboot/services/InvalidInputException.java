package com.catalyst.springboot.services;

/**
 * This exception should be thrown when the user enters incorrect input. The message should contain any status codes/messages
 * needed to explain to the user what was invalid and why.
 * @author Ernest
 *
 */
public class InvalidInputException extends Exception {

	public InvalidInputException(String message) {
		super(message);
	}
 
}
