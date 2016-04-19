package br.ufba.activityrecognition.web.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RecognitionConfig extends Application{//extends ResourceConfig {
	
	private Set<Object> singletons = new HashSet<Object>();

	public RecognitionConfig() {
		singletons.add(new TestRest());
		singletons.add(new RecognitionServiceRest());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
