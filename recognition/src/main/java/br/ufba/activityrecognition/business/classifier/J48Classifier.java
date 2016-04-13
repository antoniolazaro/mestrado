package br.ufba.activityrecognition.business.classifier;

import weka.classifiers.trees.J48;


public class J48Classifier extends ClassifierAb {
	
	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Documents/Current/Mestrado/Projeto Prático/Activity_Recognition_DataSet/";
	public static String fileName = pathFile+"Wrist.xlsx";
	
	public J48Classifier() throws Exception {
		super(new J48(),fileName);
	}
	

}
