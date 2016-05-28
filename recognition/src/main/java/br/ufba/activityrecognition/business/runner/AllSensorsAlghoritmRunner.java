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

public class AllSensorsAlghoritmRunner extends AlghoritmRunnerAb {
	
	private static final Logger logger = LoggerFactory.getLogger(AllSensorsAlghoritmRunner.class);
	
	public ResponseRecognitionModel runSVM(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando allsensors SVM \n");
		SVMClassifier classifierSVM = new SVMClassifier(dataSetFileName);
		EvaluatorAb evaluator = new SVMEvaluator(classifierSVM);
		return getResponseRecognition(recognitionFileName,requestActivity, evaluator);
	}

	public ResponseRecognitionModel runKnn(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando allsensors KNN \n");
		KNNClassifier classifierKNN = new KNNClassifier(dataSetFileName);
		EvaluatorAb evaluator = new KNNEvaluator(classifierKNN);
		return getResponseRecognition(recognitionFileName,requestActivity, evaluator);
	}

	public ResponseRecognitionModel runJ48(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando allsensors J48 \n");
		J48Classifier classifierJ48 = new J48Classifier(dataSetFileName);
		EvaluatorAb evaluator = new J48Evaluator(classifierJ48);
		return getResponseRecognition(recognitionFileName,requestActivity, evaluator);
	}
	
	public ResponseRecognitionModel runMultiLayerPerceptronMLP(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando allsensors MultiLayerPerceptron (MLP) \n");
		MultiLayerPerceptronMLPClassifier classifier = new MultiLayerPerceptronMLPClassifier(dataSetFileName);
		EvaluatorAb evaluator = new MultiLayerPerceptronMLPEvaluator(classifier);
		return getResponseRecognition(recognitionFileName,requestActivity, evaluator);
	}
	
	public ResponseRecognitionModel runNaiveBayes(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando allsensors NaiveBayes (NB)\n");
		NaiveBayesClassifier classifier = new NaiveBayesClassifier(dataSetFileName);
		EvaluatorAb evaluator = new NaiveBayesEvaluator(classifier);
		return getResponseRecognition(recognitionFileName,requestActivity, evaluator);
	}
	
	public ResponseRecognitionModel runRandomForrest(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando allsensors RandomForrestClassifier (RF)\n");
		RandomForrestClassifier classifier = new RandomForrestClassifier(dataSetFileName);
		EvaluatorAb evaluator = new RandomForrestEvaluator(classifier);
		return getResponseRecognition(recognitionFileName,requestActivity, evaluator);
	}

}
