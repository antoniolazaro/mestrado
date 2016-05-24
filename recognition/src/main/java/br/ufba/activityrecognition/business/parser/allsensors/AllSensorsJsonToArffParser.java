package br.ufba.activityrecognition.business.parser;

import java.io.File;
import java.util.List;

import br.ufba.activityrecognition.business.exception.ApplicationException;
import br.ufba.activityrecognition.core.weka.DataActivityModel;
import weka.core.Instances;

public class JsonToArffParser extends ArffParserAb {
	
	protected List<DataActivityModel> convertContentFileToDataActivityModel(File file) throws Exception{
		return null;
	}
	
	public Instances parserToArff(List<DataActivityModel> dataActvitieList) throws ApplicationException{
		return getArrFileAsInstances(dataActvitieList);
	}

}
