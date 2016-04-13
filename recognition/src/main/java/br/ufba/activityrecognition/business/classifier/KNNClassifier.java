package br.ufba.activityrecognition.business.classifier;

import weka.classifiers.lazy.IBk;

public class KNNClassifier extends ClassifierAb {
	
	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Documents/Current/Mestrado/Projeto Prático/Activity_Recognition_DataSet/";
	public static String fileName = pathFile+"Wrist.xlsx";
	
	public KNNClassifier() throws Exception {
		super(new IBk(),fileName);
	}
	

}
