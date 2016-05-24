package br.ufba.activityrecognition.business.evaluator.allsensors;

import br.ufba.activityrecognition.business.classifier.allsensors.J48Classifier;


public class J48Evaluator extends EvaluatorAb {

	public J48Evaluator(J48Classifier classifier){
		super(classifier);
	}

	public J48Evaluator() throws Exception {
		super(new J48Classifier());
	}

	@Override
	public String getAlgorithmName() {
		return "J48";
	}
}
