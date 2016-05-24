package br.ufba.activityrecognition.business.evaluator;

import br.ufba.activityrecognition.business.classifier.SVMClassifier;

public class SVMEvaluator extends EvaluatorAb {

	public SVMEvaluator(SVMClassifier classifier){
		super(classifier);
	}

	public SVMEvaluator() throws Exception {
		super(new SVMClassifier());
	}

	@Override
	public String getAlgorithmName() {
		return "SVM";
	}

}
