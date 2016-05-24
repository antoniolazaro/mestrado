package br.ufba.activityrecognition.main.allsensors;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.util.AlghoritmRunnerAllSensors;
import br.ufba.activityrecognition.business.util.IOUtil;

public abstract class MainAb {
	
	private static final Logger logger = LoggerFactory.getLogger(MainAb.class);
	
	protected static String[] DATA_SET_SOURCES_SMARTPHONE = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste1_AllSensorsAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste1_AllSensorsCorrer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste2_AllSensorsCorrer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Testes2_AllSensorsAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste3_AllSensorsAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste3_AllSensorsCorrer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/DatasetPetalaPhone/Teste4_AllSensorsAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/DatasetPetalaPhone/Teste4_AllSensorsCorrer.csv"
		};
	protected static String[] DATA_SET_SOURCES_SMARTWATCH = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/DatasetIgorWatch/teste 1_AllSensorsAndar.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/DatasetIgorWatch/teste 1_AllSensorsCorrer.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Dataset/teste2_AllSensorsAndar.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Dataset/teste2_AllSensorsCorrer.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Dataset/teste3_AllSensorsAndar.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Dataset/teste3_AllSensorsCorrer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/DatasetPetalaWatch/teste 4_AllSensorsAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/DatasetPetalaWatch/teste 4_AllSensorsCorrer.csv"
		};

	protected static String[] EXPERIMENTO_SOURCES_SMARTPHONE_ANDAR = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Teste1_AllSensors.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Testes2_AllSensors.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Teste3_AllSensors.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/ExperimentoPetalaPhone/Teste4_AllSensors.csv"
		};
	
	protected static String[] EXPERIMENTO_SOURCES_SMARTPHONE_CORRER = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Testes1.1_AllSensors.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Teste2.1_AllSensors.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Teste3.1_AllSensors.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/ExperimentoPetalaPhone/Teste4.1_AllSensors.csv"
		};
	
	protected static String[] EXPERIMENTO_SOURCES_SMARTWATCH_ANDAR = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/ExperimentoIgorWatch/teste 1_AllSensors.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Experimento/teste2_AllSensors.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Experimento/teste3_AllSensors.csv",
         "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/ExperimentoPetalaWatch/teste 4_AllSensors.csv"		
		};
	
	protected static String[] EXPERIMENTO_SOURCES_SMARTWATCH_CORRER = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/ExperimentoIgorWatch/teste 1.1_AllSensors.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Experimento/teste2.1_AllSensors.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Experimento/teste3.1_AllSensors.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/ExperimentoPetalaWatch/teste 4.1_AllSensors.csv"
		};
	
	protected static void runTest(String targetDataSet,String[] experimentoSources) throws Exception{
		logger.info("######################## 1 COMPARANDO ARQUIVOS.\n");
		for(String fileName: experimentoSources){
			logger.info("#### COMPARANDO ARQUIVOS. USUARIO: \n");
			AlghoritmRunnerAllSensors.runJ48(targetDataSet,fileName);
			AlghoritmRunnerAllSensors.runKnn(targetDataSet,fileName);
			AlghoritmRunnerAllSensors.runSVM(targetDataSet,fileName);
			AlghoritmRunnerAllSensors.runMultiLayerPerceptronMLP(targetDataSet,fileName);
			AlghoritmRunnerAllSensors.runNaiveBayes(targetDataSet,fileName);
			AlghoritmRunnerAllSensors.runRandomForrest(targetDataSet,fileName);
		}
	}
	
	protected static void run(String[] dataSetSource,String targetFile,String[]...param) throws IOException, Exception {
		IOUtil.mergeFiles(dataSetSource,targetFile);
		logger.info("####################### INICIANDO RECONHECIMENTO ATIVIDADE ANDAR...\n");
		runTest(targetFile, param[0]);
		logger.info("####################### INICIANDO RECONHECIMENTO ATIVIDADE CORRER...\n");
		runTest(targetFile, param[1]);
	}

}
