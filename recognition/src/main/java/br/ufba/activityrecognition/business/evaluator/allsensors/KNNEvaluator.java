package br.ufba.activityrecognition.business.evaluator.allsensors;

import br.ufba.activityrecognition.business.classifier.allsensors.KNNClassifier;


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
