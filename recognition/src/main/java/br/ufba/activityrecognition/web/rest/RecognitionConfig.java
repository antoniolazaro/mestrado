package br.ufba.activityrecognition.web.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest")
public class RecognitionConfig extends ResourceConfig {
	
	public RecognitionConfig() {
		packages("br.ufba.activityrecognition.web.rest");
    }

}
