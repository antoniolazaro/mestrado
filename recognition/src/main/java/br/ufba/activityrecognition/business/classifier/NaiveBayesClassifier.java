package br.ufba.activityrecognition.business.classifier;

import weka.classifiers.bayes.NaiveBayes;

public class NaiveBayesClassifier extends ClassifierAb {

	public NaiveBayesClassifier() throws Exception {
		super(new NaiveBayes());
	}
	
	public NaiveBayesClassifier(String fileName) throws Exception {
		super(new NaiveBayes(),fileName);
	}


}