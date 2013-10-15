package com.outbrain.sample.prossesor;

import com.outbrain.sample.exceptions.ProcessorIllegalStateException;


public interface IProcessor {
	/**
	 * process a database
	 * 
	 * @throws ProcessorIllegalStateException
	 */
	public void process() throws ProcessorIllegalStateException;
	
	/**
	 * return the name of the processor
	 * 
	 * @throws ProcessorIllegalStateException
	 */
	public String getName();
}
