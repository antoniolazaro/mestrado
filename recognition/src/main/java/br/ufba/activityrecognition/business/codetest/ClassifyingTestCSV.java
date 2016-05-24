package br.ufba.activityrecognition.business.codetest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import br.ufba.activityrecognition.business.parser.allsensors.AllSensorsArffParserAb;
import br.ufba.activityrecognition.business.parser.allsensors.AllSensorsCSVToArffParser;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;


public class ClassifyingTestCSV {
	
	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Downloads/ExcerciseRecognition/mobile/DataSet/";
	public static String fileName = pathFile+"Teste1_AllSensorsAndar.csv";
	
	public static String fileNameUnlabel = "/Users/antoniolazarocarvalhoborges/Downloads/ExcerciseRecognition/mobile/Experiment/Teste1_AllSensors.csv";
	
	public static void main(String[] args) throws Exception{
	
		AllSensorsArffParserAb arffParser = new AllSensorsCSVToArffParser();
		Instances instanceTraining = arffParser.parserToArff(fileName);
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
