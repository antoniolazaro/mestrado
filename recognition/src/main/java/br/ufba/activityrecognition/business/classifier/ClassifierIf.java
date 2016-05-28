package br.ufba.activityrecognition.business.classifier;

import weka.classifiers.Evaluation;
import weka.core.Instances;

public interface ClassifierIf {
	
	public Evaluation getEvalutationTest();
	public Instances getLearningInstances() throws Exception;
	public void classifierTrainingInstances() throws Exception;

}
