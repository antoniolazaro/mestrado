package br.ufba.activityrecognition.business.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.classifier.J48Classifier;
import br.ufba.activityrecognition.business.classifier.KNNClassifier;
import br.ufba.activityrecognition.business.classifier.MultiLayerPerceptronMLPClassifier;
import br.ufba.activityrecognition.business.classifier.NaiveBayesClassifier;
import br.ufba.activityrecognition.business.classifier.RandomForrestClassifier;
import br.ufba.activityrecognition.business.classifier.SVMClassifier;
import br.ufba.activityrecognition.business.evaluator.EvaluatorAb;
import br.ufba.activityrecognition.business.evaluator.J48Evaluator;
import br.ufba.activityrecognition.business.evaluator.KNNEvaluator;
import br.ufba.activityrecognition.business.evaluator.MultiLayerPerceptronMLPEvaluator;
import br.ufba.activityrecognition.business.evaluator.NaiveBayesEvaluator;
import br.ufba.activityrecognition.business.evaluator.RandomForrestEvaluator;
import br.ufba.activityrecognition.business.evaluator.SVMEvaluator;
import br.ufba.activityrecognition.business.parser.ArffParserAb;
import br.ufba.activityrecognition.business.parser.CSVToArffParser;
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;
import weka.core.Instances;

public class AlghoritmRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(AlghoritmRunner.class);
	
	public static void runRecognitionProcess(EvaluatorAb evaluator,String fileName) throws Exception {
		ArffParserAb arffParser = new CSVToArffParser();
		logger.info("INICIANDO CONVERSAO DO ARQUIVO DE RECONHECIMENTO -> "+fileName);
		Instances recognitonInstances = arffParser.parserToArff(fileName);
		ResponseRecognitionModel response = evaluator.evaluate(recognitonInstances);
		logger.info(response.getMensagem());
	}
	
	public static void runSVM(String dataSetFileName,String recognitionFileName) throws Exception {
		SVMClassifier classifierSVM = new SVMClassifier(dataSetFileName);
		EvaluatorAb evaluator = new SVMEvaluator(classifierSVM);
		runRecognitionProcess(evaluator,recognitionFileName);
	}

	public static void runKnn(String dataSetFileName,String recognitionFileName) throws Exception {
		KNNClassifier classifierKNN = new KNNClassifier(dataSetFileName);
		EvaluatorAb evaluator = new KNNEvaluator(classifierKNN);
		runRecognitionProcess(evaluator,recognitionFileName);
	}

	public static void runJ48(String dataSetFileName,String recognitionFileName) throws Exception {
		J48Classifier classifierJ48 = new J48Classifier(dataSetFileName);
		EvaluatorAb evaluator = new J48Evaluator(classifierJ48);
		runRecognitionProcess(evaluator,recognitionFileName);
	}
	
	public static void runMultiLayerPerceptronMLP(String dataSetFileName,String recognitionFileName) throws Exception {
		MultiLayerPerceptronMLPClassifier classifier = new MultiLayerPerceptronMLPClassifier(dataSetFileName);
		EvaluatorAb evaluator = new MultiLayerPerceptronMLPEvaluator(classifier);
		runRecognitionProcess(evaluator,recognitionFileName);
	}
	
	public static void runNaiveBayes(String dataSetFileName,String recognitionFileName) throws Exception {
		NaiveBayesClassifier classifier = new NaiveBayesClassifier(dataSetFileName);
		EvaluatorAb evaluator = new NaiveBayesEvaluator(classifier);
		runRecognitionProcess(evaluator,recognitionFileName);
	}
	
	public static void runRandomForrest(String dataSetFileName,String recognitionFileName) throws Exception {
		RandomForrestClassifier classifier = new RandomForrestClassifier(dataSetFileName);
		EvaluatorAb evaluator = new RandomForrestEvaluator(classifier);
		runRecognitionProcess(evaluator,recognitionFileName);
	}

}
