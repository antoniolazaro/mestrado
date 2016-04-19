package br.ufba.activityrecognition.business.classifier;

import weka.classifiers.lazy.IBk;

public class KNNClassifier extends ClassifierAb {

	public KNNClassifier() throws Exception {
		super(new IBk());
	}


}
