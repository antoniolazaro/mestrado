package br.ufba.activityrecognition.business.codetest;

import br.ufba.activityrecognition.business.parser.XlsxToArffParser;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;


public class DistributionCalculatorTest {
	
	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Documents/Current/Mestrado/Projeto Prático/Activity_Recognition_DataSet/";
	public static String fileName = pathFile+"Belt.xlsx";
	
	public static void main(String[] args) throws Exception{
	
		XlsxToArffParser xlsxToArffParser = new XlsxToArffParser();
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
