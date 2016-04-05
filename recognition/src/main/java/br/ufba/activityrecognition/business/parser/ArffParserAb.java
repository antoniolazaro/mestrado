package br.ufba.activityrecognition.business.parser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import br.ufba.activityrecognition.business.exception.EnvironmentException;
import br.ufba.activityrecognition.core.enuns.ActivitiesEnum;
import br.ufba.activityrecognition.core.weka.DataActivityModel;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class ArffParserAb {
	
	protected Instances getArrFileAsInstances(List<DataActivityModel> listaDados){
		
		StringBuilder contentArffFile = new StringBuilder(this.getArffFileHeaderContent());
		
		try{
			for(DataActivityModel dataActivity: listaDados){
				contentArffFile.append(dataActivity.getAccelerometerX()).append(",").
				append(dataActivity.getAccelerometerY()).append(",").
				append(dataActivity.getAccelerometerZ()).append(",").
				append(dataActivity.getGyroscopeX()).append(",").
				append(dataActivity.getGyroscopeY()).append(",").
				append(dataActivity.getGyroscopeZ()).append(",").
				append(dataActivity.getMagnetometerX()).append(",").
				append(dataActivity.getMagnetometerY()).append(",").
				append(dataActivity.getMagnetometerZ()).append(",").
				append(dataActivity.getActivity()).append("\n");
			}
			
			byte[] contentData = contentArffFile.toString().getBytes("UTF-8");
			InputStream is = new ByteArrayInputStream(contentData);
			DataSource source = new DataSource(is);
			return source.getDataSet();
		}catch(UnsupportedEncodingException ex){
			throw new EnvironmentException(ex);
		}catch(Exception ex){
			throw new EnvironmentException(ex);
		}
	}

	private String getArffFileHeaderContent() {
				
		StringBuilder builder = new StringBuilder("@relation activity\n\n").	
		append("@attribute Ax real").append("\n").
		append("@attribute Ay real").append("\n").
		append("@attribute Az real").append("\n").
		append("@attribute Gx real").append("\n").
		append("@attribute Gy real").append("\n").
		append("@attribute Gz real").append("\n").
		append("@attribute Mx real").append("\n").
		append("@attribute My real").append("\n").
		append("@attribute Mz real").append("\n").
		append(getActivitiesSupported()).append("\n\n").
		append("@data").append("\n");
		
		return builder.toString();
	}

	private String getActivitiesSupported() {
		StringBuilder builder = new StringBuilder("@attribute activity {");
		for(ActivitiesEnum activitiesEnum: ActivitiesEnum.values()){
			builder.append(activitiesEnum.getNome()).append(",");
		}
		builder.insert(builder.length()-1,"}").deleteCharAt(builder.length()-1);
		return builder.toString();
	}

}