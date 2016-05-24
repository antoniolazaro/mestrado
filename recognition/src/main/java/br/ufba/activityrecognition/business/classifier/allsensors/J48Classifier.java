package br.ufba.activityrecognition.business.classifier;

import weka.classifiers.trees.J48;


public class J48Classifier extends ClassifierAb {

	public J48Classifier() throws Exception {
		super(new J48());
	}
	
	public J48Classifier(String fileName) throws Exception {
		super(new J48(),fileName);
	}


}
