package br.ufba.activityrecognition.business.evaluator;

import br.ufba.activityrecognition.business.classifier.J48Classifier;


public class J48Evaluator extends EvaluatorAb {
	
	public J48Evaluator() throws Exception {
		super(new J48Classifier());
	}

	@Override
	public String getAlgorithmName() {
		return "J48";
	}
}
