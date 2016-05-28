package br.ufba.activityrecognition.business.runner;

import br.ufba.activityrecognition.business.evaluator.EvaluatorAb;
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;
import br.ufba.activityrecognition.executor.model.RequestActivityModel;

public interface AlghoritmRunnerIf {
		
	public ResponseRecognitionModel runRecognitionProcess(EvaluatorAb evaluator,String fileName) throws Exception;

	public ResponseRecognitionModel runSVM(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception;
	public ResponseRecognitionModel runKnn(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception;
	public ResponseRecognitionModel runJ48(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception;
	public ResponseRecognitionModel runMultiLayerPerceptronMLP(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception;
	public ResponseRecognitionModel runNaiveBayes(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception;
	public ResponseRecognitionModel runRandomForrest(String dataSetFileName,String recognitionFileName,RequestActivityModel requestActivity) throws Exception;
	
}
