package br.ufba.activityrecognition.business.parser;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import br.ufba.activityrecognition.business.exception.EnvironmentException;
import br.ufba.activityrecognition.core.enuns.ActivitiesEnum;
import br.ufba.activityrecognition.core.weka.DataActivityModel;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public abstract class ArffParserAb {
	
	public Instances parserToArff(String fileName) throws Exception{
		return parserToArff(new File(fileName));
	}
	
	public Instances parserToArff(File file) throws Exception{
		try{
			List<DataActivityModel> listaDados = convertContentFileToDataActivityModel(file);
			return getArrFileAsInstances(listaDados);
		}catch(Exception ex){
			throw ex;
		}
	}
	
	protected abstract List<DataActivityModel> convertContentFileToDataActivityModel(File file) throws Exception;
	
	protected Instances getArrFileAsInstances(List<DataActivityModel> listaDados){
		
		StringBuilder contentArffFile = new StringBuilder(this.getArffFileHeaderContent());
		
		try{
			if(listaDados != null && listaDados.size() > 0){
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(baos),CSVToArffParser.BUFFER_SIZE);
				
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
				bw.write(contentArffFile.toString());
				bw.close();
				InputStream is = new ByteArrayInputStream(baos.toByteArray());
				DataSource source = new DataSource(is);
				is.close();
				return source.getDataSet();
			}else{
				throw new Exception("Necessário passar uma lista com pelo menos um registro.");
			}
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