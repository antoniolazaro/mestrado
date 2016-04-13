package br.ufba.activityrecognition.business.evaluator;

import br.ufba.activityrecognition.business.classifier.J48Classifier;


public class EvaluatorJ48 extends EvaluatorAb {
	
	public EvaluatorJ48() throws Exception {
		super(new J48Classifier());
	}

	@Override
	public String getAlgorithmName() {
		return "J48";
	}
}
