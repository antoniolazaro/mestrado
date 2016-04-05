package br.ufba.activityrecognition.business.parser;

import java.util.List;

import br.ufba.activityrecognition.business.exception.ApplicationException;
import br.ufba.activityrecognition.core.weka.DataActivityModel;
import weka.core.Instances;

public class JsonToArffParser extends ArffParserAb {
	
//	public Instances parserToArff(String jsonContent) throws ApplicationException{
//		try{
//			List<DataActivityModel> listaDados = convertJsonToDataActivityModel(jsonContent);
//			return getArrFileAsInstances(listaDados);
//		}catch(ApplicationException ex){
//			throw ex;
//		}
//	}
//	
//	private List<DataActivityModel> convertJsonToDataActivityModel(String jsonContent) throws ApplicationException {
//		Type listOfTestObject = new TypeToken<List<DataActivityModel>>(){}.getType();
//		Gson gson = new Gson();
//		return gson.fromJson(jsonContent, listOfTestObject);
//	}
	
	public Instances parserToArff(List<DataActivityModel> dataActvitieList) throws ApplicationException{
		return getArrFileAsInstances(dataActvitieList);
	}

}
