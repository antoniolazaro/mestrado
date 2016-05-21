package br.ufba.activityrecognition.business.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
	        	if(StringUtils.isNotEmpty(line.trim())){
		        	line = line.replaceAll(",",";");
		            String[] content = line.split(cvsSplitBy);
		            DataActivityModel dataActivity = new DataActivityModel();
				    dataActivity.setAccelerometerX(Double.valueOf(content[0]));
				    dataActivity.setAccelerometerY(Double.valueOf(content[1]));
				    dataActivity.setAccelerometerZ(Double.valueOf(content[2]));
				    dataActivity.setGyroscopeX(Double.valueOf(content[3]));
				    dataActivity.setGyroscopeY(Double.valueOf(content[4]));
				    dataActivity.setGyroscopeZ(Double.valueOf(content[5]));
				    dataActivity.setMagnetometerX(Double.valueOf(content[6]));
				    dataActivity.setMagnetometerY(Double.valueOf(content[7]));
				    dataActivity.setMagnetometerZ(Double.valueOf(content[8]));
				    dataActivity.setActivity(content[9]);	
				    listaDados.add(dataActivity);	
	        	}
	        }
	        br.close();
		}catch(IOException ex){
			throw new EnvironmentException(ex);
		}
		return listaDados;
	}
	
}
