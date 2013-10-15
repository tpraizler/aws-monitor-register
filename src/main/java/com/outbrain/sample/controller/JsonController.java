package com.outbrain.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.outbrain.sample.service.AppService;

/**
 * This controller will answer to all glu.gson related requests.
 * 
 * @author tomer
 *
 */
@Controller
@RequestMapping("/json")
public class JsonController{
 
	@Autowired
	private AppService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<String> getApps(@RequestParam(value = "apps", required = true) final List<String> apps ) {
		List<String> allApps = new ArrayList<String>();
		for( String app : apps){
			List<String> agents = service.getAgents(app);
			
			if (agents != null){
				allApps.addAll(service.getAgents(app));
			}
		}
		
        return allApps; 
	}
}