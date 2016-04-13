package br.ufba.activityrecognition.web.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;

public class RecognitionServiceRestTest {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080").path("recognition/service/all");
		 
		Form form = new Form();
//		form.param("activitiesList",);
		 
		ResponseRecognitionModel bean =
		target.request(MediaType.APPLICATION_JSON_TYPE)
		    .post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),
		    		ResponseRecognitionModel.class); 
	}

}
