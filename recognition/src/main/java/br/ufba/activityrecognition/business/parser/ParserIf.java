package br.ufba.activityrecognition.business.parser;

import java.io.File;

import weka.core.Instances;

public interface ParserIf {
	
	public Instances parserToArff(String fileName) throws Exception;
	public Instances parserToArff(File file) throws Exception;

}
