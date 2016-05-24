package br.ufba.activityrecognition.main.allsensors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainExecutorPessoal extends MainAb{
	
	private static final Logger logger = LoggerFactory.getLogger(MainExecutorPessoal.class);
	
	private static String TARGET_FILE_SMARTPHONE_IGOR = "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/concatenado_smartphone_pessoal_igor.csv";
	private static String TARGET_FILE_SMARTWATCH_IGOR = "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/concatenado_smartwatch_pessoal_igor.csv";
	
	private static String TARGET_FILE_SMARTPHONE_GEANE = "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/concatenado_smartphone_pessoal_geane.csv";
	private static String TARGET_FILE_SMARTWATCH_GEANE = "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/concatenado_smartwatch_pessoal_geane.csv";
	
	private static String TARGET_FILE_SMARTPHONE_ANTONIO = "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/concatenado_smartphone_pessoal_antonio.csv";
	private static String TARGET_FILE_SMARTWATCH_ANTONIO = "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/concatenado_smartwatch_pessoal_antonio.csv";
	
	private static String TARGET_FILE_SMARTPHONE_PETALA = "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/concatenado_smartphone_pessoal_petala.csv";
	private static String TARGET_FILE_SMARTWATCH_PETALA = "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/concatenado_smartwatch_pessoal_petala.csv";
	
	public static void main(String[] args) throws Exception{
		
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ BLOCO SMARTPHONE...\n");
		logger.info("############################################# USUARIO 1..\n");
		run(new String[]{DATA_SET_SOURCES_SMARTPHONE[0],DATA_SET_SOURCES_SMARTPHONE[1]},
			TARGET_FILE_SMARTPHONE_IGOR,
			new String[]{EXPERIMENTO_SOURCES_SMARTPHONE_ANDAR[0]},
			new String[]{EXPERIMENTO_SOURCES_SMARTPHONE_CORRER[0]});
		logger.info("############################################# USUARIO 2..\n");
		run(new String[]{DATA_SET_SOURCES_SMARTPHONE[2],DATA_SET_SOURCES_SMARTPHONE[3]},
				TARGET_FILE_SMARTPHONE_GEANE,
			new String[]{EXPERIMENTO_SOURCES_SMARTPHONE_ANDAR[1]},
			new String[]{EXPERIMENTO_SOURCES_SMARTPHONE_CORRER[1]});
		logger.info("############################################# USUARIO 3..\n");
		run(new String[]{DATA_SET_SOURCES_SMARTPHONE[4],DATA_SET_SOURCES_SMARTPHONE[5]},
				TARGET_FILE_SMARTPHONE_ANTONIO,
			new String[]{EXPERIMENTO_SOURCES_SMARTPHONE_ANDAR[2]},
			new String[]{EXPERIMENTO_SOURCES_SMARTPHONE_CORRER[2]});
		logger.info("############################################# USUARIO 4..\n");
		run(new String[]{DATA_SET_SOURCES_SMARTPHONE[6],DATA_SET_SOURCES_SMARTPHONE[7]},
				TARGET_FILE_SMARTPHONE_PETALA,
			new String[]{EXPERIMENTO_SOURCES_SMARTPHONE_ANDAR[3]},
			new String[]{EXPERIMENTO_SOURCES_SMARTPHONE_CORRER[3]});
		
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ BLOCO SMARTWATCH...\n");
		logger.info("############################################# USUARIO 1..\n");
		run(new String[]{DATA_SET_SOURCES_SMARTWATCH[0],DATA_SET_SOURCES_SMARTWATCH[1]},
				TARGET_FILE_SMARTWATCH_IGOR,
			new String[]{EXPERIMENTO_SOURCES_SMARTWATCH_ANDAR[0]},
			new String[]{EXPERIMENTO_SOURCES_SMARTWATCH_CORRER[0]});
		logger.info("############################################# USUARIO 2..\n");
		run(new String[]{DATA_SET_SOURCES_SMARTWATCH[2],DATA_SET_SOURCES_SMARTWATCH[3]},
				TARGET_FILE_SMARTWATCH_GEANE,
			new String[]{EXPERIMENTO_SOURCES_SMARTWATCH_ANDAR[1]},
			new String[]{EXPERIMENTO_SOURCES_SMARTWATCH_CORRER[1]});
		logger.info("############################################# USUARIO 3..\n");
		run(new String[]{DATA_SET_SOURCES_SMARTWATCH[4],DATA_SET_SOURCES_SMARTWATCH[5]},
				TARGET_FILE_SMARTWATCH_ANTONIO,
			new String[]{EXPERIMENTO_SOURCES_SMARTWATCH_ANDAR[2]},
			new String[]{EXPERIMENTO_SOURCES_SMARTWATCH_CORRER[2]});
		logger.info("############################################# USUARIO 4..\n");
		run(new String[]{DATA_SET_SOURCES_SMARTWATCH[6],DATA_SET_SOURCES_SMARTWATCH[7]},
				TARGET_FILE_SMARTWATCH_PETALA,
			new String[]{EXPERIMENTO_SOURCES_SMARTWATCH_ANDAR[3]},
			new String[]{EXPERIMENTO_SOURCES_SMARTWATCH_CORRER[3]});
		
			
	}
	
}
