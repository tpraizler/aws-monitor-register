package com.outbrain.sample.prossesor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.outbrain.sample.exceptions.ProcessorIllegalStateException;
import com.outbrain.sample.model.Entries;
import com.outbrain.sample.model.Entry;
import com.outbrain.sample.service.AppService;

/**
 * Will process a json file given in the app.prop.
 * 
 * @author tomer
 *
 */
@Component("jsonProc")
public class JsonProssesor implements IProcessor{

	@Autowired
	private AppService service;
	
	@Value("${path}")
	private String pathToJsonFile;
	
	@Override
	public String getName() {
		return "jsonProcessor";
	}
	
	public void process() throws ProcessorIllegalStateException{
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(pathToJsonFile));
		} catch (FileNotFoundException e) {
			throw new ProcessorIllegalStateException("Couldn't find " + pathToJsonFile,e);
		}
		//Load the json into Entries object
		Gson gson = new Gson();
		Entries newEntries = gson.fromJson(br, Entries.class);
		
		//Process the data, and create a map of apps to agents.
		createAppsToAgentsMap(newEntries.getEntries());
	}

	/**
	 * process the List of Entries, and will create a new Map in which the 
	 * keys are apps names, and the values are a Lists of String holding the agents 
	 * the apps are installed on.
	 * 
	 * @param apps
	 */
	private void createAppsToAgentsMap(List<Entry> entries) {
		Map<String,List<String>> appsToAgents = new HashMap<String,List<String>>();
		for(Entry entry : entries){
			List<String> agents = null;
			String appName = entry.getInitParameters().getApp();
			if ( appsToAgents.containsKey(appName)) {
				agents = appsToAgents.get(appName);
			}else{
				agents = new ArrayList<String>();
				appsToAgents.put(appName, agents);
			}
			agents.add(entry.getAgent());
		}
		service.setAppsToAgents(appsToAgents);	
	}
}
