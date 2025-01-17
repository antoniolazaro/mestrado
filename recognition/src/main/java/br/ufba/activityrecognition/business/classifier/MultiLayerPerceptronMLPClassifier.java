package br.ufba.activityrecognition.business.classifier;

import weka.classifiers.functions.MultilayerPerceptron;

public class MultiLayerPerceptronMLPClassifier extends ClassifierAb {

	public MultiLayerPerceptronMLPClassifier() throws Exception {
		super(new MultilayerPerceptron());
	}
	
	public MultiLayerPerceptronMLPClassifier(String fileName) throws Exception {
		super(new MultilayerPerceptron(),fileName,true);
	}
	
	public MultiLayerPerceptronMLPClassifier(String fileName,boolean hasAllSensors) throws Exception {
		super(new MultilayerPerceptron(),fileName,hasAllSensors);
	}
}
