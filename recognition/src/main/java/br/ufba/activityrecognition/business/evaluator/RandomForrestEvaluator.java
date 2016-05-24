package br.ufba.activityrecognition.business.evaluator;

import br.ufba.activityrecognition.business.classifier.RandomForrestClassifier;

public class RandomForrestEvaluator extends EvaluatorAb {

	public RandomForrestEvaluator(RandomForrestClassifier classifier){
		super(classifier);
	}

	public RandomForrestEvaluator() throws Exception {
		super(new RandomForrestClassifier());
	}

	@Override
	public String getAlgorithmName() {
		return "Random Forrest";
	}
}
