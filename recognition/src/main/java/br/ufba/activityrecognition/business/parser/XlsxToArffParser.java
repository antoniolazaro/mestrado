package br.ufba.activityrecognition.business.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.ufba.activityrecognition.business.exception.ApplicationException;
import br.ufba.activityrecognition.business.exception.EnvironmentException;
import br.ufba.activityrecognition.core.weka.DataActivityModel;

public class XlsxToArffParser extends ArffParserAb {
	
	@Override
	protected List<DataActivityModel> convertContentFileToDataActivityModel(File file) throws Exception {
		List<DataActivityModel> listaDados = new ArrayList<DataActivityModel>();
		try{
			XSSFWorkbook workbook = new XSSFWorkbook (file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int quantidadeLinhas = sheet.getLastRowNum();
			int quantidadeLinhasLidas = 1;
			while(quantidadeLinhasLidas < quantidadeLinhas) {
			    Row row = sheet.getRow(quantidadeLinhasLidas);
			    DataActivityModel dataActivity = new DataActivityModel();
			    String contentData = contentData(row,1);
			    dataActivity.setAccelerometerX(Double.valueOf(contentData));
			    contentData = contentData(row,2);
			    dataActivity.setAccelerometerY(Double.valueOf(contentData));
			    contentData = contentData(row,3);
			    dataActivity.setAccelerometerZ(Double.valueOf(contentData));
			    contentData = contentData(row,4);
			    dataActivity.setGyroscopeX(Double.valueOf(contentData));
			    contentData = contentData(row,5);
			    dataActivity.setGyroscopeY(Double.valueOf(contentData));
			    contentData = contentData(row,6);
			    dataActivity.setGyroscopeZ(Double.valueOf(contentData));
			    contentData = contentData(row,7);
			    dataActivity.setMagnetometerX(Double.valueOf(contentData));
			    contentData = contentData(row,8);
			    dataActivity.setMagnetometerY(Double.valueOf(contentData));
			    contentData = contentData(row,9);
			    dataActivity.setMagnetometerZ(Double.valueOf(contentData));
			    contentData = contentData(row,10);
			    dataActivity.setActivity(contentData);	
			    listaDados.add(dataActivity);
			    quantidadeLinhasLidas++;
			}
			workbook.close();
		}catch(ApplicationException ex){
			throw ex;
		}catch(InvalidFormatException ex){
			throw new EnvironmentException(ex);
		}catch(IOException ex){
			throw new EnvironmentException(ex);
		}
		return listaDados;
	}
	
	private String contentData(Row row,int indiceColuna) throws ApplicationException{
		Cell data = row.getCell(indiceColuna);
		switch(data.getCellType()){
			case Cell.CELL_TYPE_NUMERIC:
				Double numericValue = data.getNumericCellValue();
				return numericValue.toString();
			case Cell.CELL_TYPE_STRING:
				String contentData = data.getStringCellValue();
		        if(StringUtils.isEmpty(contentData)){
		        	throw new ApplicationException("Campo obrigatório não preenchido. Índice: "+indiceColuna+". Linha: "+row.getRowNum());
		        }
		        return contentData.toString();
		}
		throw new ApplicationException("Campo obrigatório não preenchido. Índice: "+indiceColuna+". Linha: "+row.getRowNum());
	}

}
