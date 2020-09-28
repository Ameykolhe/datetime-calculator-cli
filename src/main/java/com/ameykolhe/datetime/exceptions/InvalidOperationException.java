package com.ameykolhe.datetime.exceptions;

import com.ameykolhe.datetime.entities.Operation;

public class InvalidOperationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8591339797135943221L;

	public InvalidOperationException(Operation operation) {
		super("Invalid Operation : " + operation.name());
	}

}
