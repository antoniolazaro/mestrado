package br.ufba.activityrecognition.main;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.util.AlghoritmRunner;
import br.ufba.activityrecognition.business.util.IOUtil;

public abstract class AccelerometerMainAb {
	
	private static final Logger logger = LoggerFactory.getLogger(AccelerometerMainAb.class);
	
	protected static String[] DATA_SET_SOURCES_SMARTPHONE = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste1_AccelerometerAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste1_AccelerometerCorrer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Testes2_AccelerometerAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste2_AccelerometerCorrer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste3_AccelerometerAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste3_AccelerometerCorrer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/DatasetPetalaPhone/Teste4_AccelerometerAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/DatasetPetalaPhone/Teste4_AccelerometerCorrer.csv"
		};
	protected static String[] DATA_SET_SOURCES_SMARTWATCH = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/DatasetIgorWatch/teste 1_AccelerometerAndar.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/DatasetIgorWatch/teste 1_AccelerometerCorrer.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Dataset/teste2_AccelerometerAndar.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Dataset/teste2_AccelerometerCorrer.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Dataset/teste3_AccelerometerAndar.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Dataset/teste3_AccelerometerCorrer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/DatasetPetalaWatch/teste 4_AccelerometerAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/DatasetPetalaWatch/teste 4_AccelerometerCorrer.csv"
		};

	protected static String[] EXPERIMENTO_SOURCES_SMARTPHONE_ANDAR = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Teste1_Accelerometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Testes2_Accelerometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Teste3_Accelerometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/ExperimentoPetalaPhone/Teste4_Accelerometer.csv"
		};
	
	protected static String[] EXPERIMENTO_SOURCES_SMARTPHONE_CORRER = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Testes1.1_Accelerometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Teste2.1_Accelerometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Teste3.1_Accelerometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/ExperimentoPetalaPhone/Teste4.1_Accelerometer.csv"
		};
	
	protected static String[] EXPERIMENTO_SOURCES_SMARTWATCH_ANDAR = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/ExperimentoIgorWatch/teste 1_Accelerometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Experimento/teste2_Accelerometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Experimento/teste3_Accelerometer.csv",
         "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/ExperimentoPetalaWatch/teste 4_Accelerometer.csv"		
		};
	
	protected static String[] EXPERIMENTO_SOURCES_SMARTWATCH_CORRER = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/ExperimentoIgorWatch/teste 1.1_Accelerometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Experimento/teste2.1_Accelerometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Experimento/testes3.1_Accelerometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/ExperimentoPetalaWatch/teste 4.1_Accelerometer.csv"
		};
	
	protected static void runTest(String targetDataSet,String[] experimentoSources) throws Exception{
		logger.info("######################## 1 COMPARANDO ARQUIVOS.\n");
		for(String fileName: experimentoSources){
			logger.info("#### COMPARANDO ARQUIVOS. USUARIO: \n");
			AlghoritmRunner.runJ48(targetDataSet,fileName);
			AlghoritmRunner.runKnn(targetDataSet,fileName);
			AlghoritmRunner.runSVM(targetDataSet,fileName);
			AlghoritmRunner.runMultiLayerPerceptronMLP(targetDataSet,fileName);
			AlghoritmRunner.runNaiveBayes(targetDataSet,fileName);
			AlghoritmRunner.runRandomForrest(targetDataSet,fileName);
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
