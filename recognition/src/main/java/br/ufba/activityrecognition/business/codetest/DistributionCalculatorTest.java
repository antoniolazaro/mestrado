package br.ufba.activityrecognition.business.codetest;

import br.ufba.activityrecognition.business.parser.ArffParserAb;
import br.ufba.activityrecognition.business.parser.CSVToArffParser;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;


public class DistributionCalculatorTest {
	
	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Desenvolvimento/workspace/mestrado/Activity_Recognition_DataSet/";
//	private static String pathFile = "D:\\Antonio\\Desenvolvimento\\Vivo\\WORKSPACE_VIVO\\GITHUB\\mestrado\\Activity_Recognition_DataSet\\";
	public static String fileName = pathFile+"Wrist.csv";
	
	public static void main(String[] args) throws Exception{
	
		ArffParserAb xlsxToArffParser = new CSVToArffParser();
		Instances instanceTraining = xlsxToArffParser.parserToArff(fileName);
		instanceTraining.setClassIndex(instanceTraining.numAttributes() - 1);
		
		Classifier classifier = new J48();
		classifier.buildClassifier(instanceTraining);
		
		Evaluation eTest = new Evaluation(instanceTraining);
		eTest.evaluateModel(classifier, instanceTraining);
		
		String strSummary = eTest.toSummaryString();
//		System.out.println("1: "+eTest.toSummaryString());
		System.out.println("2: "+eTest.weightedFMeasure()); 
		System.out.println("3: "+eTest.weightedPrecision()); 
		System.out.println("4: "+eTest.weightedRecall());
		double[][] cmMatrix = eTest.confusionMatrix();
		 
		double[] fDistribution = classifier.distributionForInstance(instanceTraining.firstInstance());
//		System.out.println("Classifier: "+classifier.toString());
		System.out.println(fDistribution[0]);
		System.out.println(fDistribution[1]);
		
	}
	

}
