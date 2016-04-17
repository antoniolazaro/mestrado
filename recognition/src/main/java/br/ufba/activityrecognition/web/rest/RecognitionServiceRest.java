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
			StringBuilder retornoFinal = new StringBuilder();
			
			Response response = callEvaluator(listaActivities, new EvaluatorJ48());
			retornoFinal.append(response.getEntity().toString()).append("\n\n");
			
			response = callEvaluator(listaActivities, new EvaluatorKNN());
			retornoFinal.append(response.getEntity().toString()).append("\n\n");
			
			response = callEvaluator(listaActivities, new EvaluatorSVM());
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
	public Response askRecognitionJ48(@FormParam("activitiesList") List<DataActivityModel> listaActivities){
		try{
			return callEvaluator(listaActivities,new EvaluatorJ48());
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
			return callEvaluator(listaActivities,new EvaluatorKNN());
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
			return callEvaluator(listaActivities,new EvaluatorSVM());
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}

}
