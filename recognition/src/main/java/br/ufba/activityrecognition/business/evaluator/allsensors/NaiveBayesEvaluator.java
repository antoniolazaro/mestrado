package br.ufba.activityrecognition.business.evaluator.allsensors;

import br.ufba.activityrecognition.business.classifier.allsensors.NaiveBayesClassifier;


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
