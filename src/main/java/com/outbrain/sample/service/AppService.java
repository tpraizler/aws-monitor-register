package com.outbrain.sample.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * This service will can give information about apps and agents.
 * 
 * @author tomer
 *
 */
@Component
public class AppService {
	private Map<String,List<String>> appsToAgents;

	public Map<String,List<String>> getAppsToAgents() {
		return appsToAgents;
	}

	public void setAppsToAgents(Map<String,List<String>> appsToAgents) {
		this.appsToAgents = appsToAgents;
	}
	
	public void addAppToAgents(String app, List<String> agents){
		appsToAgents.put(app, agents);
	}
	
	public List<String> getAgents(String app){
		return appsToAgents.get(app);
	}
}
