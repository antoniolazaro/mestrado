package br.ufba.activityrecognition.business.evaluator;

import br.ufba.activityrecognition.business.classifier.MultiLayerPerceptronMLPClassifier;


public class MultiLayerPerceptronMLPEvaluator extends EvaluatorAb {

	public MultiLayerPerceptronMLPEvaluator(MultiLayerPerceptronMLPClassifier classifier){
		super(classifier);
	}

	public MultiLayerPerceptronMLPEvaluator() throws Exception {
		super(new MultiLayerPerceptronMLPClassifier());
	}

	@Override
	public String getAlgorithmName() {
		return "Multi-layer perceptron (MLP)";
	}
}
