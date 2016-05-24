package br.ufba.activityrecognition.business.evaluator;

import br.ufba.activityrecognition.business.classifier.KNNClassifier;

public class KNNEvaluator extends EvaluatorAb {

	public KNNEvaluator(KNNClassifier classifier){
		super(classifier);
	}

	public KNNEvaluator() throws Exception {
		super(new KNNClassifier());
	}

	@Override
	public String getAlgorithmName() {
		return "KNN";
	}
}
