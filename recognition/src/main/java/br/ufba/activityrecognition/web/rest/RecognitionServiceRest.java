package br.ufba.activityrecognition.web.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufba.activityrecognition.business.classifier.J48Classifier;
import br.ufba.activityrecognition.business.classifier.KNNClassifier;
import br.ufba.activityrecognition.business.classifier.SVMClassifier;
import br.ufba.activityrecognition.business.evaluator.EvaluatorAb;
import br.ufba.activityrecognition.business.evaluator.J48Evaluator;
import br.ufba.activityrecognition.business.evaluator.KNNEvaluator;
import br.ufba.activityrecognition.business.evaluator.SVMEvaluator;
import br.ufba.activityrecognition.core.weka.DataActivityModel;
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;
import br.ufba.activityrecognition.web.listener.ClassifiersListener;

@RestController
public class RecognitionServiceRest {

	@Autowired private ServletContext servletContext;

	private static final Logger logger = LoggerFactory.getLogger(RecognitionServiceRest.class);

	protected ResponseRecognitionModel tratarExcecao(Exception ex) {
		ResponseRecognitionModel response = new ResponseRecognitionModel();
		response.setCodigoRetorno(0);
		response.setMensagem(ex.getMessage());
		return response;
	}

	protected ResponseRecognitionModel callEvaluator(List<DataActivityModel> listaActivities,EvaluatorAb evaluator){
		try{
			System.out.println("Iniciando avaliacao no algoritimo "+ evaluator.getClass()+" "+new Date());
			return evaluator.evaluate(listaActivities);
		}catch(Exception ex){
			return tratarExcecao(ex);
		}
	}

	private Object getServletContextAttribute(String attributeName){
		return servletContext.getAttribute(attributeName);
	}

	private J48Evaluator getEvaluatorJ48(){
		J48Classifier j48Classifier = (J48Classifier) getServletContextAttribute(ClassifiersListener.CLASSIFIER_J48_ATTRIBUTE_NAME);
		return new J48Evaluator(j48Classifier);
	}

	private KNNEvaluator getEvaluatorKNN(){
		KNNClassifier kNNClassifier = (KNNClassifier) getServletContextAttribute(ClassifiersListener.CLASSIFIER_KNN_ATTRIBUTE_NAME);
		return new KNNEvaluator(kNNClassifier);
	}

	private SVMEvaluator getEvaluatorSVM(){
		SVMClassifier sVMClassifier = (SVMClassifier) getServletContextAttribute(ClassifiersListener.CLASSIFIER_SVM_ATTRIBUTE_NAME);
		return new SVMEvaluator(sVMClassifier);
	}

	@RequestMapping(value = "/rest/all", method = RequestMethod.POST)
	public @ResponseBody ResponseRecognitionModel askRecognition(ArrayList<DataActivityModel> listaActivities){

		ResponseRecognitionModel response = new ResponseRecognitionModel();
		try{
			StringBuilder retornoFinal = new StringBuilder();

			response = callEvaluator(listaActivities, getEvaluatorJ48());
			retornoFinal.append(response.getMensagem()).append("\n\n");

			response = callEvaluator(listaActivities, getEvaluatorKNN());
			retornoFinal.append(response.getMensagem().toString()).append("\n\n");

			response = callEvaluator(listaActivities, getEvaluatorSVM());
			retornoFinal.append(response.getMensagem().toString()).append("\n\n");

			response.setMensagem(retornoFinal.toString());

			return response;
		}catch(Exception ex){
			return tratarExcecao(ex);
		}
	}

	@RequestMapping(value = "/rest/j48", method = RequestMethod.POST)
	public @ResponseBody ResponseRecognitionModel askRecognitionJ48(ArrayList<DataActivityModel> listaActivities){
		try{
			return callEvaluator(listaActivities,getEvaluatorJ48());
		}catch(Exception ex){
			return tratarExcecao(ex);
		}
	}

	@RequestMapping(value = "/rest/knn", method = RequestMethod.POST)
	public @ResponseBody ResponseRecognitionModel askRecognitionKNN(ArrayList<DataActivityModel> listaActivities){
		try{
			return callEvaluator(listaActivities,getEvaluatorKNN());
		}catch(Exception ex){
			return tratarExcecao(ex);
		}
	}

	@RequestMapping(value = "/rest/svm", method = RequestMethod.POST)
	public @ResponseBody ResponseRecognitionModel askRecognitionSVM(ArrayList<DataActivityModel> listaActivities){
		try{
			return callEvaluator(listaActivities,getEvaluatorSVM());
		}catch(Exception ex){
			return tratarExcecao(ex);
		}
	}

}
