package br.ufba.activityrecognition.web.rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.ufba.activityrecognition.business.evaluator.EvaluatorAb;
import br.ufba.activityrecognition.business.evaluator.EvaluatorJ48;
import br.ufba.activityrecognition.business.evaluator.EvaluatorKNN;
import br.ufba.activityrecognition.business.evaluator.EvaluatorSVM;
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
			
			StringBuilder retornoFinal = new StringBuilder();
			
			System.out.println("Iniciando configuracao para avaliacao no algoritimo J48 "+new Date());
			EvaluatorAb evaluator = new EvaluatorJ48();
			System.out.println("Iniciando avaliacao no algoritimo J48 "+new Date());
			responseRecognitionModel = evaluator.evaluate(listaActivities);
			retornoFinal.append(responseRecognitionModel.getMensagem()).append("\n\n");
			
			System.out.println("Iniciando configuracao para avaliacao no algoritimo KNN "+new Date()); 
			evaluator = new EvaluatorKNN();
			System.out.println("Iniciando avaliacao no algoritimo KNN "+new Date());
			responseRecognitionModel = evaluator.evaluate(listaActivities);
			retornoFinal.append(responseRecognitionModel.getMensagem()).append("\n\n");
			
			System.out.println("Iniciando configuracao para avaliacao no algoritimo SVM "+new Date());
			evaluator = new EvaluatorSVM();
			System.out.println("Iniciando avaliacao no algoritimo SVM "+new Date());
			responseRecognitionModel = evaluator.evaluate(listaActivities);
			retornoFinal.append(responseRecognitionModel.getMensagem()).append("\n\n");
			
			responseRecognitionModel.setMensagem(retornoFinal.toString());
		}catch(Exception ex){
			responseRecognitionModel.setCodigoRetorno(-1);
			responseRecognitionModel.setMensagem("Erro -> "+ex.getMessage());
		}
		return responseRecognitionModel;
	}

}
