package br.ufba.activityrecognition.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.ufba.activityrecognition.business.DistributionCalculator;
import br.ufba.activityrecognition.core.weka.DataActivityModel;
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;

@Path("/recognition")
public class RecognitionServiceRest {

	private ResponseRecognitionModel responseRecognitionModel;
	
	public RecognitionServiceRest() {
		this.responseRecognitionModel = new ResponseRecognitionModel();
	}
			
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseRecognitionModel askRecognition(@FormParam("activitiesList")List<DataActivityModel> listaActivities){
		try{
			DistributionCalculator distributionCalculator = new DistributionCalculator();
			responseRecognitionModel = distributionCalculator.distributionForInstancesGlobal(listaActivities);
		}catch(Exception ex){
			responseRecognitionModel.setCodigoRetorno(-1);
			responseRecognitionModel.setMensagem("Erro -> "+ex.getMessage());
		}
		return responseRecognitionModel;
	}

}
