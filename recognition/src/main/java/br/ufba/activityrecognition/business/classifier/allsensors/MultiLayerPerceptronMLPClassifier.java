package br.ufba.activityrecognition.business.classifier.allsensors;

import weka.classifiers.functions.MultilayerPerceptron;

public class MultiLayerPerceptronMLPClassifier extends ClassifierAb {

	public MultiLayerPerceptronMLPClassifier() throws Exception {
		super(new MultilayerPerceptron());
	}
	
	public MultiLayerPerceptronMLPClassifier(String fileName) throws Exception {
		super(new MultilayerPerceptron(),fileName);
	}


}
