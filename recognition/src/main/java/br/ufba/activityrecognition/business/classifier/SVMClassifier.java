package br.ufba.activityrecognition.business.classifier;

import weka.classifiers.functions.SMO;

public class SVMClassifier extends ClassifierAb {

	public SVMClassifier() throws Exception {
		super(new SMO());
	}

	public SVMClassifier(String fileName) throws Exception {
		super(new SMO(),fileName,true);
	}
	
	public SVMClassifier(String fileName,boolean hasAllSensors) throws Exception {
		super(new SMO(),fileName,hasAllSensors);
	}

}
