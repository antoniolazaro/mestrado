package br.ufba.activityrecognition.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import br.ufba.activityrecognition.business.parser.XlsxToArffParser;
import br.ufba.activityrecognition.core.weka.DataActivityModel;
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;


public class ClassifyingTest {
	
	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Documents/Current/Mestrado/Projeto Prático/Activity_Recognition_DataSet/";
	public static String fileName = pathFile+"Belt.xlsx";
	
	public static String fileNameUnlabel = pathFile+"belt_unlabel.arff";
	
	public static void main(String[] args) throws Exception{
	
		XlsxToArffParser xlsxToArffParser = new XlsxToArffParser();
		Instances instanceTraining = xlsxToArffParser.parserToArff(fileName);
		instanceTraining.setClassIndex(instanceTraining.numAttributes() - 1);
		
		Classifier classifier = new J48();
		classifier.buildClassifier(instanceTraining);
		
		Evaluation eTest = new Evaluation(instanceTraining);
		eTest.evaluateModel(classifier, instanceTraining);
		
		
		Instances unlabeled = new Instances(new BufferedReader(new FileReader(fileNameUnlabel)));

		// set class attribute
		unlabeled.setClassIndex(unlabeled.numAttributes() - 1);
		
		// create copy
		Instances labeled = new Instances(unlabeled);
		
		// label instances
		for (int i = 0; i < unlabeled.numInstances(); i++) {
			double clsLabel = classifier.classifyInstance(unlabeled.instance(i));
			labeled.instance(i).setClassValue(clsLabel);
			System.out.println("label -> "+labeled.instance(i).stringValue(9));
		}
		

		// save labeled data
		BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile+"resultado.arff"));
		writer.write(labeled.toString());
		writer.newLine();
		writer.flush();
		writer.close();
		
	}
	
	

}
