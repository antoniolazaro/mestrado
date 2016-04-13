package br.ufba.activityrecognition.web.rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.ufba.activityrecognition.business.evaluator.EvaluatorAb;
import br.ufba.activityrecognition.business.evaluator.EvaluatorJ48;
import br.ufba.activityrecognition.business.evaluator.EvaluatorKNN;
import br.ufba.activityrecognition.business.evaluator.EvaluatorSVM;
import br.ufba.activityrecognition.core.weka.DataActivityModel;
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;

@Path("/rest")
public class RecognitionServiceRest {
		
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(value="/all")
	public Response askRecognition(@FormParam("activitiesList") List<DataActivityModel> listaActivities){
		
		try{
			ResponseRecognitionModel responseRecognitionModel = new ResponseRecognitionModel();	
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
			return Response.status(200).entity(responseRecognitionModel.getMensagem()).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
		
	}
	
	protected ResponseRecognitionModel callEvaluator(List<DataActivityModel> listaActivities,EvaluatorAb evaluator) throws Exception{
		System.out.println("Iniciando avaliacao no algoritimo "+ evaluator.getClass()+" "+new Date());
		return evaluator.evaluate(listaActivities);
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(value="/j48")
	public Response askRecognitionJ48(@FormParam("activitiesList") List<DataActivityModel> listaActivities){
		try{
			ResponseRecognitionModel responseRecognitionModel = new ResponseRecognitionModel();
			responseRecognitionModel = callEvaluator(listaActivities,new EvaluatorJ48());
			return Response.status(200).entity(responseRecognitionModel.getMensagem()).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(value="/knn")
	public Response askRecognitionKNN(@FormParam("activitiesList") List<DataActivityModel> listaActivities){
		try{
			ResponseRecognitionModel responseRecognitionModel = new ResponseRecognitionModel();
			responseRecognitionModel = callEvaluator(listaActivities,new EvaluatorKNN());
			return Response.status(200).entity(responseRecognitionModel.getMensagem()).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(value="/svm")
	public Response askRecognitionSVM(@FormParam("activitiesList") List<DataActivityModel> listaActivities){
		try{
			ResponseRecognitionModel responseRecognitionModel = new ResponseRecognitionModel();
			responseRecognitionModel = callEvaluator(listaActivities,new EvaluatorSVM());
			return Response.status(200).entity(responseRecognitionModel.getMensagem()).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}

}
