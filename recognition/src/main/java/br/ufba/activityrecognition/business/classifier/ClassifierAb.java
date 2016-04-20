package br.ufba.activityrecognition.business.classifier;

import br.ufba.activityrecognition.business.parser.ArffParserAb;
import br.ufba.activityrecognition.business.parser.CSVToArffParser;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;


public abstract class ClassifierAb {

	private ArffParserAb arffParser;
	private Classifier classifier;
	private Evaluation evalutationTest;
	private Instances learningInstances;

	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Desenvolvimento/workspace/mestrado/Activity_Recognition_DataSet/";
//	private static String pathFile = "D:\\Antonio\\Desenvolvimento\\Vivo\\WORKSPACE_VIVO\\GITHUB\\mestrado\\Activity_Recognition_DataSet\\";
	public static String fileName = pathFile+"Wrist.csv";

	public ClassifierAb(Classifier classifier) throws Exception {
		this(classifier,fileName);
	}

	public ClassifierAb(Classifier classifier,String nameTrainingFile) throws Exception {
		this.arffParser = new CSVToArffParser();
		this.classifier = classifier;
		this.learningInstances = arffParser.parserToArff(nameTrainingFile);
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
		learningInstances.setClassIndex(learningInstances.numAttributes() - 1);
		getClassifier().buildClassifier(learningInstances);
		this.evalutationTest = new Evaluation(learningInstances);
		this.evalutationTest.evaluateModel(getClassifier(), learningInstances);
	}


}
