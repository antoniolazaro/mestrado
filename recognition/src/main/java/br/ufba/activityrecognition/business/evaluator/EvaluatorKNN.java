package br.ufba.activityrecognition.business.evaluator;

import br.ufba.activityrecognition.business.classifier.KNNClassifier;


public class EvaluatorKNN extends EvaluatorAb {
	
	public EvaluatorKNN() throws Exception {
		super(new KNNClassifier());
	}

	@Override
	public String getAlgorithmName() {
		return "KNN";
	}
}
