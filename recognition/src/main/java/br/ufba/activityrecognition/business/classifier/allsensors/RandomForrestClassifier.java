package br.ufba.activityrecognition.business.classifier.allsensors;

import weka.classifiers.trees.RandomForest;

public class RandomForrestClassifier extends ClassifierAb {

	public RandomForrestClassifier() throws Exception {
		super(new RandomForest());
	}
	
	public RandomForrestClassifier(String fileName) throws Exception {
		super(new RandomForest(),fileName);
	}


}
