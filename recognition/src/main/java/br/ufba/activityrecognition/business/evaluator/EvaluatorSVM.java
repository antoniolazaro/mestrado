package br.ufba.activityrecognition.business.evaluator;

import br.ufba.activityrecognition.business.classifier.SVMClassifier;


public class EvaluatorSVM extends EvaluatorAb {
	
	public EvaluatorSVM() throws Exception {
		super(new SVMClassifier());
	}
	
	@Override
	public String getAlgorithmName() {
		return "SVM";
	}

}
