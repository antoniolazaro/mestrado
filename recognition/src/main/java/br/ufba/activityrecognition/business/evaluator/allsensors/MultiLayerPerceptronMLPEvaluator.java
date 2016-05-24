package br.ufba.activityrecognition.business.evaluator.allsensors;

import br.ufba.activityrecognition.business.classifier.allsensors.MultiLayerPerceptronMLPClassifier;


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
