package br.ufba.activityrecognition.business.classifier;

import weka.classifiers.lazy.IBk;

public class KNNClassifier extends ClassifierAb {

	public KNNClassifier() throws Exception {
		super(new IBk());
	}

	public KNNClassifier(String fileName) throws Exception {
		super(new IBk(),fileName,true);
	}
	
	public KNNClassifier(String fileName,boolean hasAllSensors) throws Exception {
		super(new IBk(),fileName,hasAllSensors);
	}

}
