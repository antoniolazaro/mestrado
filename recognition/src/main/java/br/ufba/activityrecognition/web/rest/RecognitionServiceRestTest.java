package br.ufba.activityrecognition.web.rest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import br.ufba.activityrecognition.core.weka.DataActivityModel;



public class RecognitionServiceRestTest {
	
	@Test
	public void testAll() {
		
        List<DataActivityModel> request = new ArrayList<DataActivityModel>();
        
        Entity entity = Entity.json(request);
 
        Client client = ClientBuilder.newBuilder().register(RecognitionServiceRest.class).build();
 
        WebTarget target = client.target("http://localhost:8081/recognition/rest/v1/all");
 
        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(entity);
        
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
        System.out.println(response.getEntity().toString());
        
    }
 
}
