package br.ufba.activityrecognition.business.codetest;

import java.util.List;

import br.ufba.activityrecognition.business.parser.allsensors.AllSensorsJsonToArffParser;
import br.ufba.activityrecognition.business.parser.allsensors.AllSensorsXlsxToArffParser;
import br.ufba.activityrecognition.core.enuns.ActivitiesEnum;
import br.ufba.activityrecognition.core.weka.DataActivityModel;
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;


public class DistributionCalculator {
	
	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Documents/Current/Mestrado/Projeto Prático/Activity_Recognition_DataSet/";
	public static String fileName = pathFile+"Wrist.xlsx";
	
	private AllSensorsXlsxToArffParser xlsxToArffParser;
	private AllSensorsJsonToArffParser jsonToArffParser;
	private Instances learningInstances; 
	private double[][] cmMatrix;
	private Classifier classifier;
	private Evaluation evalutationTest;
	
	public DistributionCalculator() throws Exception {
		this.xlsxToArffParser = new AllSensorsXlsxToArffParser();
		this.learningInstances = xlsxToArffParser.parserToArff(fileName);
		this.learningInstances.setClassIndex(learningInstances.numAttributes() - 1);
		this.classifier = new J48();
		this.classifier.buildClassifier(learningInstances);
		this.evalutationTest = new Evaluation(learningInstances);
		this.evalutationTest.evaluateModel(classifier, learningInstances);
		this.cmMatrix = evalutationTest.confusionMatrix();
		this.jsonToArffParser = new AllSensorsJsonToArffParser();
	}
	
	private double[] distributionForInstance(Instance instance) throws Exception{
		
		classifier.classifyInstance(instance);
		return classifier.distributionForInstance(instance);
	}
	
	public ResponseRecognitionModel distributionForInstancesGlobal(List<DataActivityModel> listaActivities) throws Exception{
		Instances testInstance = jsonToArffParser.parserToArff(listaActivities);
		this.evalutationTest.evaluateModel(classifier, testInstance);

		Instances labeled = new Instances(testInstance);
		ResponseRecognitionModel responseRecognitionModel = new ResponseRecognitionModel();
		int quantidadeTotalRegistros = testInstance.numInstances();
		for (int i = 0; i < quantidadeTotalRegistros; i++) {
			double clsLabel = classifier.classifyInstance(testInstance.instance(i));
			labeled.instance(i).setClassValue(clsLabel);
			String valor = labeled.instance(i).stringValue(9);
			if(ActivitiesEnum.DOWNSTAIRS.getNome().equals(valor)){
				responseRecognitionModel.addTotalDownstairs();
			}else if(ActivitiesEnum.RUNNING.getNome().equals(valor)){
				responseRecognitionModel.addTotalRunning();
			}else if(ActivitiesEnum.SITTING.getNome().equals(valor)){
				responseRecognitionModel.addTotalSitting();
			}else if(ActivitiesEnum.STANDING.getNome().equals(valor)){
				responseRecognitionModel.addTotalStanding();
			}else if(ActivitiesEnum.UPSTAIRS.getNome().equals(valor)){
				responseRecognitionModel.addTotalUpstairs();
			}else if(ActivitiesEnum.WALKING.getNome().equals(valor)){
				responseRecognitionModel.addTotalWalking();
			}else{
				responseRecognitionModel.addTotalNaoReconhecido();
			}
			responseRecognitionModel.addQuantidadeTotal();
		}
		responseRecognitionModel.setMensagem(responseRecognitionModel.getRetornoFormatado());
		return responseRecognitionModel;
	}
	


	public Instances getLearningInstances() {
		return learningInstances;
	}

	public double[][] getCmMatrix() {
		return cmMatrix;
	}

	public Classifier getClassifier() {
		return classifier;
	}

	public Evaluation getEvalutationTest() {
		return evalutationTest;
	}

}
