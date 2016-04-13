package br.ufba.activityrecognition.business.classifier;

import br.ufba.activityrecognition.business.parser.XlsxToArffParser;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;


public abstract class ClassifierAb {
	
	private XlsxToArffParser xlsxToArffParser;
	private Classifier classifier;
	private Evaluation evalutationTest;
	private Instances learningInstances;
	
	public ClassifierAb(Classifier classifier,String nameTrainingFile) throws Exception {
		this.xlsxToArffParser = new XlsxToArffParser();
		this.classifier = classifier;
		this.learningInstances = xlsxToArffParser.parserToArff(nameTrainingFile);
	}
	
	public Classifier getClassifier(){
		return classifier;
	}
	
	public Evaluation getEvalutationTest() {
		return evalutationTest;
	}
	
	public Instances getLearningInstances() throws Exception{
		learningInstances.setClassIndex(learningInstances.numAttributes() - 1);
		return learningInstances; 
	}
	
	public void classifierTrainingInstances() throws Exception{
		getClassifier().buildClassifier(learningInstances);
		this.evalutationTest = new Evaluation(learningInstances);
		this.evalutationTest.evaluateModel(getClassifier(), learningInstances);
	}


}
