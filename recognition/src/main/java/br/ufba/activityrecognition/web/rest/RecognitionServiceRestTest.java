package br.ufba.activityrecognition.web.rest;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import br.ufba.activityrecognition.core.weka.DataActivityModel;
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;

import static org.junit.Assert.*;

public class RecognitionServiceRestTest {

    public static final String SERVER_URI = "http://localhost:8080/recognition";

    private static final Logger logger = LoggerFactory.getLogger(RecognitionServiceRestTest.class);

	@Test
	public void testAll() {
		List<DataActivityModel> request = new ArrayList<DataActivityModel>();
    	RestTemplate restTemplate = new RestTemplate();
        ResponseRecognitionModel response = restTemplate.postForObject(SERVER_URI+"/service/all", request, ResponseRecognitionModel.class);
        assertEquals(Integer.valueOf(1),response.getCodigoRetorno());
    }

	@Test
	public void testJ48() {
		List<DataActivityModel> request = new ArrayList<DataActivityModel>();
    	RestTemplate restTemplate = new RestTemplate();
        ResponseRecognitionModel response = restTemplate.postForObject(SERVER_URI+"/service/j48", request, ResponseRecognitionModel.class);
        assertEquals(Integer.valueOf(1),response.getCodigoRetorno());
    }

	@Test
	public void testKnn() {
		List<DataActivityModel> request = new ArrayList<DataActivityModel>();
    	RestTemplate restTemplate = new RestTemplate();
        ResponseRecognitionModel response = restTemplate.postForObject(SERVER_URI+"/service/knn", request, ResponseRecognitionModel.class);
        assertEquals(Integer.valueOf(1),response.getCodigoRetorno());
    }

	@Test
	public void testSvm() {
		List<DataActivityModel> request = new ArrayList<DataActivityModel>();
    	RestTemplate restTemplate = new RestTemplate();
        ResponseRecognitionModel response = restTemplate.postForObject(SERVER_URI+"/service/svm", request, ResponseRecognitionModel.class);
        assertEquals(Integer.valueOf(1),response.getCodigoRetorno());
    }

}
