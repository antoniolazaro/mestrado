package br.ufba.activityrecognition.business.classifier.allsensors;

import weka.classifiers.lazy.IBk;

public class KNNClassifier extends ClassifierAb {

	public KNNClassifier() throws Exception {
		super(new IBk());
	}

	public KNNClassifier(String fileName) throws Exception {
		super(new IBk(),fileName);
	}

}
