package br.ufba.activityrecognition.business.evaluator;

import br.ufba.activityrecognition.business.classifier.NaiveBayesClassifier;

public class NaiveBayesEvaluator extends EvaluatorAb {

	public NaiveBayesEvaluator(NaiveBayesClassifier classifier){
		super(classifier);
	}

	public NaiveBayesEvaluator() throws Exception {
		super(new NaiveBayesClassifier());
	}

	@Override
	public String getAlgorithmName() {
		return "Naive Bayes (NB)";
	}
}
