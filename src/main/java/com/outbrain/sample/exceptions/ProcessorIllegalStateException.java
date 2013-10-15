package com.outbrain.sample.exceptions;

import java.io.FileNotFoundException;

public class ProcessorIllegalStateException extends Exception{

	public ProcessorIllegalStateException(String msg, FileNotFoundException e) {
		super(msg,e);
	}

}
