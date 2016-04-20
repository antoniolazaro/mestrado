package br.ufba.activityrecognition.business.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufba.activityrecognition.business.exception.ApplicationException;
import br.ufba.activityrecognition.business.exception.EnvironmentException;
import br.ufba.activityrecognition.core.weka.DataActivityModel;

public class CSVToArffParser extends ArffParserAb {
	
	public static final int BUFFER_SIZE = 8192;
	
	@Override
	protected List<DataActivityModel> convertContentFileToDataActivityModel(File file) throws ApplicationException {
		
		List<DataActivityModel> listaDados = new ArrayList<DataActivityModel>();
		
		try{
			BufferedReader br = null;
		    String line = "";
		    String cvsSplitBy = ";";

	        br = new BufferedReader(new FileReader(file),BUFFER_SIZE);
	        int i = 0;
	        while ((line = br.readLine()) != null){
	        	if(i == 0){
	        		line = br.readLine();
	        	}
	        	i++;
	            String[] content = line.split(cvsSplitBy);
	            DataActivityModel dataActivity = new DataActivityModel();
			    dataActivity.setAccelerometerX(Double.valueOf(content[1].replaceAll(",",".")));
			    dataActivity.setAccelerometerY(Double.valueOf(content[2].replaceAll(",",".")));
			    dataActivity.setAccelerometerZ(Double.valueOf(content[3].replaceAll(",",".")));
			    dataActivity.setGyroscopeX(Double.valueOf(content[4].replaceAll(",",".")));
			    dataActivity.setGyroscopeY(Double.valueOf(content[5].replaceAll(",",".")));
			    dataActivity.setGyroscopeZ(Double.valueOf(content[6].replaceAll(",",".")));
			    dataActivity.setMagnetometerX(Double.valueOf(content[7].replaceAll(",",".")));
			    dataActivity.setMagnetometerY(Double.valueOf(content[8].replaceAll(",",".")));
			    dataActivity.setMagnetometerZ(Double.valueOf(content[9].replaceAll(",",".")));
			    dataActivity.setActivity(content[10]);	
			    listaDados.add(dataActivity);			   
	        }
	        br.close();
		}catch(IOException ex){
			throw new EnvironmentException(ex);
		}
		return listaDados;
	}
	
}
