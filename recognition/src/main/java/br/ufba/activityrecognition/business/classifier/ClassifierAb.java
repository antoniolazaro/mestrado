package br.ufba.activityrecognition.business.classifier;

import br.ufba.activityrecognition.business.parser.CSVToArffParser;
import br.ufba.activityrecognition.business.parser.ParserIf;
import br.ufba.activityrecognition.business.parser.allsensors.AllSensorsCSVToArffParser;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;


public abstract class ClassifierAb implements ClassifierIf {

	private ParserIf arffParser;
	private Classifier classifier;
	private Evaluation evalutationTest;
	private Instances learningInstances;
	private boolean hasAllSensors;

	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Desenvolvimento/workspace/mestrado/Activity_Recognition_DataSet/";
	public static String fileName = pathFile+"Wrist.csv";

	public ClassifierAb(Classifier classifier) throws Exception {
		this(classifier,fileName,true);
	}
	
	public ClassifierAb(Classifier classifier,boolean hasAllSensors) throws Exception {
		this(classifier,fileName,hasAllSensors);
	}

	public ClassifierAb(Classifier classifier,String nameTrainingFile,boolean hasAllSensors) throws Exception {
		this.hasAllSensors = hasAllSensors;
		if(hasAllSensors){
			this.arffParser = new AllSensorsCSVToArffParser();
		}else{
			this.arffParser = new CSVToArffParser();
		}
		this.classifier = classifier;
		this.learningInstances = arffParser.parserToArff(nameTrainingFile);
	}
	
	public boolean isHasAllSensors() {
		return hasAllSensors;
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
