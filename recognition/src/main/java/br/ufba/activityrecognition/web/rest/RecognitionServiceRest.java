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
import br.ufba.activityrecognition.business.evaluator.J48Evaluator;
import br.ufba.activityrecognition.business.evaluator.KNNEvaluator;
import br.ufba.activityrecognition.business.evaluator.SVMEvaluator;
import br.ufba.activityrecognition.core.weka.DataActivityModel;
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;

@Path("/v1")
public class RecognitionServiceRest {
		
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(value="/all")
	public Response askRecognition(List<DataActivityModel> listaActivities){
		
		try{
			StringBuilder retornoFinal = new StringBuilder();
			
			Response response = callEvaluator(listaActivities, new J48Evaluator());
			retornoFinal.append(response.getEntity().toString()).append("\n\n");
			
			response = callEvaluator(listaActivities, new KNNEvaluator());
			retornoFinal.append(response.getEntity().toString()).append("\n\n");
			
			response = callEvaluator(listaActivities, new SVMEvaluator());
			retornoFinal.append(response.getEntity().toString()).append("\n\n");
			
			return Response.status(200).entity(retornoFinal.toString()).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
		
	}
	
	protected Response callEvaluator(List<DataActivityModel> listaActivities,EvaluatorAb evaluator){
		try{
			System.out.println("Iniciando avaliacao no algoritimo "+ evaluator.getClass()+" "+new Date());
			ResponseRecognitionModel responseRecognitionModel = evaluator.evaluate(listaActivities);
			return Response.status(200).entity(responseRecognitionModel.getMensagem()).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(value="/j48")
	public Response askRecognitionJ48(List<DataActivityModel> listaActivities){
		try{
			return callEvaluator(listaActivities,new J48Evaluator());
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(value="/knn")
	public Response askRecognitionKNN(List<DataActivityModel> listaActivities){
		try{
			return callEvaluator(listaActivities,new KNNEvaluator());
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(value="/svm")
	public Response askRecognitionSVM(List<DataActivityModel> listaActivities){
		try{
			return callEvaluator(listaActivities,new SVMEvaluator());
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}

}
