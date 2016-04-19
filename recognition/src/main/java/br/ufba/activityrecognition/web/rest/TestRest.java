package br.ufba.activityrecognition.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRest {

	private static final Logger logger = LoggerFactory.getLogger(TestRest.class);

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@RequestMapping(value = "/rest/ping", method = RequestMethod.GET)
	public @ResponseBody String ping() {
		return "Hey, This is Jersey JAX-RS !";
	}

	@RequestMapping(value = "/rest/ping2", method = RequestMethod.GET)
	public @ResponseBody String simplejson() {
		return "teste ";
	}
}
