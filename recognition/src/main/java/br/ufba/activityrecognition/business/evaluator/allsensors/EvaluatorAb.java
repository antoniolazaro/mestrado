package br.ufba.activityrecognition.business.evaluator.allsensors;

import java.util.List;

import br.ufba.activityrecognition.business.classifier.allsensors.ClassifierAb;
import br.ufba.activityrecognition.business.parser.allsensors.AllSensorsJsonToArffParser;
import br.ufba.activityrecognition.core.enuns.ActivitiesEnum;
import br.ufba.activityrecognition.core.weka.DataActivityModel;
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;
import weka.core.Instances;


public abstract class EvaluatorAb {
	
	private ClassifierAb classifier;
	private AllSensorsJsonToArffParser jsonToArffParser;
	
	public EvaluatorAb(ClassifierAb classifier){
		this.classifier = classifier;
		this.jsonToArffParser = new AllSensorsJsonToArffParser();
	}
	
	public ResponseRecognitionModel evaluate(List<DataActivityModel> listaActivities) throws Exception{
		Instances testInstance = jsonToArffParser.parserToArff(listaActivities);
		return evaluate(testInstance);
	}
	
	public ResponseRecognitionModel evaluate(Instances testInstance) throws Exception{
		classifier.classifierTrainingInstances();
		testInstance.setClassIndex(testInstance.numAttributes() - 1);
		Instances unLabeled = new Instances(testInstance);
		ResponseRecognitionModel responseRecognitionModel = new ResponseRecognitionModel();
		int quantidadeTotalRegistros = testInstance.numInstances();
		for (int i = 0; i < quantidadeTotalRegistros; i++) {
			double clsLabel = classifier.getClassifier().classifyInstance(testInstance.instance(i));
			unLabeled.instance(i).setClassValue(clsLabel);
			String valor = unLabeled.instance(i).stringValue(9);
			if(ActivitiesEnum.DOWNSTAIRS.getNome().equals(valor)){
				responseRecognitionModel.addTotalDownstairs();
			}else if(ActivitiesEnum.RUNNING.getNome().equals(valor)){
				responseRecognitionModel.addTotalRunning();
			}else if(ActivitiesEnum.SITTING.getNome().equals(valor)){
				responseRecognitionModel.addTotalSitting();
			}else if(ActivitiesEnum.STANDING.getNome().equals(valor)){
				responseRecognitionModel.addTotalStanding();
			}else if(ActivitiesEnum.UPSTAIRS.getNome().equals(valor)){
				responseRecognitionModel.addTotalUpstairs();
			}else if(ActivitiesEnum.WALKING.getNome().equals(valor)){
				responseRecognitionModel.addTotalWalking();
			}
			responseRecognitionModel.addQuantidadeTotal();
		}
		StringBuilder retornoFinal = new StringBuilder().
		append("Algoritimo selecionado: ").append(getAlgorithmName()).append("\n").
		append(responseRecognitionModel.getRetornoFormatado());
		responseRecognitionModel.setMensagem(retornoFinal.toString());
		return responseRecognitionModel;
	}
	
	public abstract String getAlgorithmName();

}
