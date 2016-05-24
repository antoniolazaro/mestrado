package br.ufba.activityrecognition.business.parser.allsensors;

import java.io.File;
import java.util.List;

import br.ufba.activityrecognition.business.exception.ApplicationException;
import br.ufba.activityrecognition.core.weka.DataActivityModel;
import weka.core.Instances;

public class AllSensorsJsonToArffParser extends AllSensorsArffParserAb {
	
	protected List<DataActivityModel> convertContentFileToDataActivityModel(File file) throws Exception{
		return null;
	}
	
	public Instances parserToArff(List<DataActivityModel> dataActvitieList) throws ApplicationException{
		return getArrFileAsInstances(dataActvitieList);
	}

}
