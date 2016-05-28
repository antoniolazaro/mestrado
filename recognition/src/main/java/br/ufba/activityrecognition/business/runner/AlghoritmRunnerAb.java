package br.ufba.activityrecognition.business.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.evaluator.EvaluatorAb;
import br.ufba.activityrecognition.business.parser.CSVToArffParser;
import br.ufba.activityrecognition.business.parser.allsensors.AllSensorsCSVToArffParser;
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;
import br.ufba.activityrecognition.executor.model.RequestActivityModel;
import weka.core.Instances;

public abstract class AlghoritmRunnerAb implements AlghoritmRunnerIf{
	
	private static final Logger logger = LoggerFactory.getLogger(AlghoritmRunnerAb.class);
	
	public ResponseRecognitionModel runRecognitionProcess(EvaluatorAb evaluator,String fileName) throws Exception {
		logger.info("\n INICIANDO CONVERSAO DO ARQUIVO DE RECONHECIMENTO -> "+fileName);
		Instances recognitonInstances = null;
		if(evaluator.getClassifier().isHasAllSensors()){
			recognitonInstances = new AllSensorsCSVToArffParser().parserToArff(fileName);
		}else{
			recognitonInstances = new CSVToArffParser().parserToArff(fileName);
		}
		ResponseRecognitionModel responseRecognition = evaluator.evaluate(recognitonInstances);
		responseRecognition.setAlgoritimo(evaluator.getAlgorithmName());
		return responseRecognition;
	}
	
	protected ResponseRecognitionModel getResponseRecognition(String recognitionFileName,RequestActivityModel requestActivity, EvaluatorAb evaluator) throws Exception {
		ResponseRecognitionModel responseRecognition = runRecognitionProcess(evaluator,recognitionFileName);
		responseRecognition.setNomeUsuarioExperimento(requestActivity.getNomeUsuarioExperimento());
		responseRecognition.setAtividade(requestActivity.getAtividade());
		responseRecognition.setEquipamento(requestActivity.getEquipamento());
		return responseRecognition;
	}

}
