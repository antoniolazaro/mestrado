package br.ufba.activityrecognition.main;

import java.util.Date;

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

public class MainExecutor {
	
	private static final Logger logger = LoggerFactory.getLogger(MainExecutor.class);
	
//	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Desenvolvimento/workspace/mestrado/Activity_Recognition_DataSet/";
//	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Downloads/ExcerciseRecognition/mobile/DataSet/";
//	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Downloads/ExcerciseRecognition/wearable/DataSet/";
	private static String pathFile = "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/Petala/DatasetPetalaWatch/";
//	private static String pathFile = "D:\\Antonio\\Desenvolvimento\\Vivo\\WORKSPACE_VIVO\\GITHUB\\mestrado\\Activity_Recognition_DataSet\\";
	public static String trainingFileName = pathFile+"teste 4_AllSensors_unified.csv";
//	public static String recognitonFileName = pathFile+"Teste1_AllSensors.csv";
	public static String recognitonFileName = "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/Petala/ExperimentoPetalaWatch/teste 4.1_AllSensors.csv";
//	public static String recognitonFileName = "/Users/antoniolazarocarvalhoborges/Downloads/ExcerciseRecognition/wearable/Experimento/teste2.1_AllSensors.csv";
	
	public static void main(String[] args) throws Exception{
		
		int valor = 0;
		if(args != null && args.length > 0){
			final String param = args[0];
			if(param != null){
				valor = Integer.valueOf(param);
			}
		}
		switch(valor){
		case 1:
			runJ48();
			break;
		case 2:
			runKnn();
			break;
		case 3:
			runSVM();
			break;
		case 4:
			runMultiLayerPerceptronMLP();
			break;
		case 5:
			runNaiveBayes();
			break;
		case 6:
			runRandomForrest();
			break;
		default:
			runJ48();
			runKnn();
			runSVM();
			runMultiLayerPerceptronMLP();
			runNaiveBayes();
			runRandomForrest();
			break;
		}
	}
	
	protected static void runRecognitionProcess(EvaluatorAb evaluator) throws Exception {
		ArffParserAb arffParser = new CSVToArffParser();
		System.out.println("INICIANDO CONVERSAO DO ARQUIVO DE RECONHECIMENTO -> "+recognitonFileName+" "+new Date());
		Instances recognitonInstances = arffParser.parserToArff(recognitonFileName);
		System.out.println("INICIANDO AVALIACAO DO ARQUIVO DE RECONHECIMENTO -> "+new Date());
		ResponseRecognitionModel response = evaluator.evaluate(recognitonInstances);
		System.out.println(response.getMensagem());
	}

	protected static void runSVM() throws Exception {
		System.out.println("VAI INICIAR CARGA DO CLASSIFICADOR SVM."+new Date());
		SVMClassifier classifierSVM = new SVMClassifier(trainingFileName);
		System.out.println("FINALIZOU CARGA E CLASSIFICACAO DO CLASSIFICADOR SVM."+new Date());
		EvaluatorAb evaluator = new SVMEvaluator(classifierSVM);
		runRecognitionProcess(evaluator);
	}

	protected static void runKnn() throws Exception {
		System.out.println("VAI INICIAR CARGA DO CLASSIFICADOR KNN."+new Date());
		KNNClassifier classifierKNN = new KNNClassifier(trainingFileName);
		System.out.println("FINALIZOU CARGA E CLASSIFICACAO DO CLASSIFICADOR KNN."+new Date());
		EvaluatorAb evaluator = new KNNEvaluator(classifierKNN);
		runRecognitionProcess(evaluator);
	}

	protected static void runJ48() throws Exception {
		J48Classifier classifierJ48 = new J48Classifier(trainingFileName);
		System.out.println("FINALIZOU CARGA E CLASSIFICACAO DO CLASSIFICADOR J48."+new Date());
		EvaluatorAb evaluator = new J48Evaluator(classifierJ48);
		runRecognitionProcess(evaluator);
	}
	
	protected static void runMultiLayerPerceptronMLP() throws Exception {
		MultiLayerPerceptronMLPClassifier classifier = new MultiLayerPerceptronMLPClassifier(trainingFileName);
		System.out.println("FINALIZOU CARGA E CLASSIFICACAO DO CLASSIFICADOR MLP."+new Date());
		EvaluatorAb evaluator = new MultiLayerPerceptronMLPEvaluator(classifier);
		runRecognitionProcess(evaluator);
	}
	
	protected static void runNaiveBayes() throws Exception {
		NaiveBayesClassifier classifierJ48 = new NaiveBayesClassifier(trainingFileName);
		System.out.println("FINALIZOU CARGA E CLASSIFICACAO DO CLASSIFICADOR NaiveBayes (NB)."+new Date());
		EvaluatorAb evaluator = new NaiveBayesEvaluator(classifierJ48);
		runRecognitionProcess(evaluator);
	}
	
	protected static void runRandomForrest() throws Exception {
		RandomForrestClassifier classifierJ48 = new RandomForrestClassifier(trainingFileName);
		System.out.println("FINALIZOU CARGA E CLASSIFICACAO DO CLASSIFICADOR RandomForrest (RF)."+new Date());
		EvaluatorAb evaluator = new RandomForrestEvaluator(classifierJ48);
		runRecognitionProcess(evaluator);
	}
}
