package br.ufba.activityrecognition.business.classifier;

import weka.classifiers.functions.SMO;

public class SVMClassifier extends ClassifierAb {
	
	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Documents/Current/Mestrado/Projeto Prático/Activity_Recognition_DataSet/";
	public static String fileName = pathFile+"Wrist.xlsx";
	
	public SVMClassifier() throws Exception {
		super(new SMO(),fileName);
	}
	

}
