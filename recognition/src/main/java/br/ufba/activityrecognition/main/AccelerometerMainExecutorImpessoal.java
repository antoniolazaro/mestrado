package br.ufba.activityrecognition.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AccelerometerMainExecutorImpessoal extends AccelerometerMainAb {
	
	private static final Logger logger = LoggerFactory.getLogger(AccelerometerMainExecutorImpessoal.class);
	
	private static String TARGET_FILE_SMARTPHONE = "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/concatenado_accelerometer_smartphone.csv";
	private static String TARGET_FILE_SMARTWATCH = "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/concatenado_accelerometer_smartwatch.csv";
	
	
	public static void main(String[] args) throws Exception{
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ BLOCO SMARTPHONE...\n");
		run(DATA_SET_SOURCES_SMARTPHONE,TARGET_FILE_SMARTPHONE,EXPERIMENTO_SOURCES_SMARTPHONE_ANDAR,EXPERIMENTO_SOURCES_SMARTPHONE_CORRER);
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ BLOCO SMARTWATCH...\n");
		run(DATA_SET_SOURCES_SMARTWATCH,TARGET_FILE_SMARTWATCH,EXPERIMENTO_SOURCES_SMARTWATCH_ANDAR,EXPERIMENTO_SOURCES_SMARTWATCH_CORRER);
	}

}
