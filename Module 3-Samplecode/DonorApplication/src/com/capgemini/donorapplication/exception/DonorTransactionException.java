package com.capgemini.donorapplication.exception;

/**
 * Author 		: CAPGEMINI 
 * Class Name 	: DonorTransactionException 
 * Package 		: com.capgemini.donorapplication.exception
 * Date 		: Nov 21, 2016
 */

@SuppressWarnings("serial")
public class DonorTransactionException extends Exception{
	public DonorTransactionException(String message)
	{
		super(message);
	}
}
