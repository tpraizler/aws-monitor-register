package com.outbrain.sample.prossesor;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.outbrain.sample.exceptions.ProcessorIllegalStateException;

/**
 * 
 * Will be loaded at startup, and will processes all databases available.
 * 
 * @author tomer
 *
 */
@Component
public class ProccessDB {

	@Resource(name = "initProcessors")
	private List<IProcessor> processors;
	private static Logger logger = LoggerFactory.getLogger(ProccessDB.class);
	
	@PostConstruct
	public void init(){
		for (IProcessor processor : processors){
			try {
				logger.info("Start processor: " + processor.getName());
				processor.process();
			} catch (ProcessorIllegalStateException e) {
				logger.error("Failed to process : "+processor.getName(),e);
			}
		}
	}
}
