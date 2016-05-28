package br.ufba.activityrecognition.business.runner;

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
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;
import br.ufba.activityrecognition.executor.model.RequestActivityModel;

public class AlghoritmRunner extends AlghoritmRunnerAb {
	
	private static final Logger logger = LoggerFactory.getLogger(AlghoritmRunner.class);
	
	public ResponseRecognitionModel runSVM(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando 1 sensor SVM \n");
		SVMClassifier classifierSVM = new SVMClassifier(dataSetFileName,false);
		EvaluatorAb evaluator = new SVMEvaluator(classifierSVM);
		return getResponseRecognition(recognitionFileName,requestActivity, evaluator);
	}

	public ResponseRecognitionModel runKnn(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando 1 sensor KNN \n");
		KNNClassifier classifierKNN = new KNNClassifier(dataSetFileName,false);
		EvaluatorAb evaluator = new KNNEvaluator(classifierKNN);
		return getResponseRecognition(recognitionFileName,requestActivity, evaluator);
	}

	public ResponseRecognitionModel runJ48(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando 1 sensor J48 \n");
		J48Classifier classifierJ48 = new J48Classifier(dataSetFileName,false);
		EvaluatorAb evaluator = new J48Evaluator(classifierJ48);
		return getResponseRecognition(recognitionFileName,requestActivity, evaluator);
	}
	
	public ResponseRecognitionModel runMultiLayerPerceptronMLP(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando 1 sensor MultiLayerPerceptronMLP \n");
		MultiLayerPerceptronMLPClassifier classifier = new MultiLayerPerceptronMLPClassifier(dataSetFileName,false);
		EvaluatorAb evaluator = new MultiLayerPerceptronMLPEvaluator(classifier);
		return getResponseRecognition(recognitionFileName,requestActivity, evaluator);
	}
	
	public ResponseRecognitionModel runNaiveBayes(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando 1 sensor NaiveBayes \n");
		NaiveBayesClassifier classifier = new NaiveBayesClassifier(dataSetFileName,false);
		EvaluatorAb evaluator = new NaiveBayesEvaluator(classifier);
		return getResponseRecognition(recognitionFileName,requestActivity, evaluator);
	}
	
	public ResponseRecognitionModel runRandomForrest(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando 1 sensor RandomForrest \n");
		RandomForrestClassifier classifier = new RandomForrestClassifier(dataSetFileName,false);
		EvaluatorAb evaluator = new RandomForrestEvaluator(classifier);
		return getResponseRecognition(recognitionFileName,requestActivity, evaluator);
	}

}
