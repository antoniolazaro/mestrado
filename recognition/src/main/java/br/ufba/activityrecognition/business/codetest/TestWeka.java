package br.ufba.activityrecognition.business.codetest;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import br.ufba.activityrecognition.business.parser.XlsxToArffParser;
import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class TestWeka {
	
	private static String pathFile = "/Users/antoniolazarocarvalhoborges/Documents/Current/Mestrado/Projeto Prático/Activity_Recognition_DataSet/";
	public static String fileName = pathFile+"Belt.xlsx";
	
	public static void main(String[] args) throws Exception {
		
//		XlsxToArffParser xlsxToArffParser = new XlsxToArffParser();
//		byte[] content = xlsxToArffParser.parserToArff(fileName);
//		InputStream is = new ByteArrayInputStream(content);
//		DataSource source = new DataSource(is);
//		
//		 FileOutputStream fileOuputStream = new FileOutputStream(pathFile+"belt.arff"); 
//	    fileOuputStream.write(content);
//	    fileOuputStream.close();
//		
//		 Instances data = source.getDataSet();
//		 
//		 Classifier classifier = new J48();
//		 classifier.buildClassifier(data);
		 
//		 WekaWrapper wekaClassifier = new WekaWrapper();
//		 wekaClassifier.buildClassifier(data);
	}

}
