package br.ufba.activityrecognition.main;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.util.AlghoritmRunner;
import br.ufba.activityrecognition.business.util.IOUtil;

public abstract class MagnetometerMainAb {
	
	private static final Logger logger = LoggerFactory.getLogger(MagnetometerMainAb.class);
	
	protected static String[] DATA_SET_SOURCES_SMARTPHONE = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste1_MagnetometerAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste1_MagnetometerCorrer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Testes2_MagnetometerAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste2_MagnetometerCorrer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste3_MagnetometerAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/DataSet/Teste3_MagnetometerCorrer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/DatasetPetalaPhone/Teste4_MagnetometerAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/DatasetPetalaPhone/Teste4_MagnetometerCorrer.csv"
		};
	protected static String[] DATA_SET_SOURCES_SMARTWATCH = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/DatasetIgorWatch/teste 1_MagnetometerAndar.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/DatasetIgorWatch/teste 1_MagnetometerCorrer.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Dataset/teste2_MagnetometerAndar.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Dataset/teste2_MagnetometerCorrer.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Dataset/teste3_MagnetometerAndar.csv",
	     "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Dataset/teste3_MagnetometerCorrer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/DatasetPetalaWatch/teste 4_MagnetometerAndar.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/DatasetPetalaWatch/teste 4_MagnetometerCorrer.csv"
		};

	protected static String[] EXPERIMENTO_SOURCES_SMARTPHONE_ANDAR = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Teste1_Magnetometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Testes2_Magnetometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Teste3_Magnetometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/ExperimentoPetalaPhone/Teste4_Magnetometer.csv"
		};
	
	protected static String[] EXPERIMENTO_SOURCES_SMARTPHONE_CORRER = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Testes1.1_Magnetometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Teste2.1_Magnetometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/mobile/Experiment/Teste3.1_Magnetometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/ExperimentoPetalaPhone/Teste4.1_Magnetometer.csv"
		};
	
	protected static String[] EXPERIMENTO_SOURCES_SMARTWATCH_ANDAR = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/ExperimentoIgorWatch/teste 1_Magnetometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Experimento/teste2_Magnetometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Experimento/teste3_Magnetometer.csv",
         "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/ExperimentoPetalaWatch/teste 4_Magnetometer.csv"		
		};
	
	protected static String[] EXPERIMENTO_SOURCES_SMARTWATCH_CORRER = 
		{"/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/ExperimentoIgorWatch/teste 1.1_Magnetometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Experimento/teste2.1_Magnetometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/wearable/Experimento/teste3.1_Magnetometer.csv",
		 "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/dados/Petala/ExperimentoPetalaWatch/teste 4.1_Magnetometer.csv"
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
