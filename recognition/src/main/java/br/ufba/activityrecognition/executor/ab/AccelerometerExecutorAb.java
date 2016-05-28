package br.ufba.activityrecognition.executor.ab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AccelerometerExecutorAb extends ExecutorAb {
	
	private static final Logger logger = LoggerFactory.getLogger(AccelerometerExecutorAb.class);
	
	public String[] getDataSourceSmartphone(){
		return new String[] 
		{getPathBaseDados()+"mobile/DataSet/Teste1_AccelerometerAndar.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste1_AccelerometerCorrer.csv",
		 getPathBaseDados()+"mobile/DataSet/Testes2_AccelerometerAndar.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste2_AccelerometerCorrer.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste3_AccelerometerAndar.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste3_AccelerometerCorrer.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaPhone/Teste4_AccelerometerAndar.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaPhone/Teste4_AccelerometerCorrer.csv"
		};
	}
	
	public String[] getDataSourceSmartwatch(){ 
		return new String[] 
		{getPathBaseDados()+"DatasetIgorWatch/teste 1_AccelerometerAndar.csv",
	     getPathBaseDados()+"DatasetIgorWatch/teste 1_AccelerometerCorrer.csv",
	     getPathBaseDados()+"wearable/Dataset/teste2_AccelerometerAndar.csv",
	     getPathBaseDados()+"wearable/Dataset/teste2_AccelerometerCorrer.csv",
	     getPathBaseDados()+"wearable/Dataset/teste3_AccelerometerAndar.csv",
	     getPathBaseDados()+"wearable/Dataset/teste3_AccelerometerCorrer.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaWatch/teste 4_AccelerometerAndar.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaWatch/teste 4_AccelerometerCorrer.csv"
		};
	}

	public String[] getExperimentoSmartphoneAndar(){ 
		return new String[] 
		{getPathBaseDados()+"mobile/Experiment/Teste1_Accelerometer.csv",
		 getPathBaseDados()+"mobile/Experiment/Testes2_Accelerometer.csv",
		 getPathBaseDados()+"mobile/Experiment/Teste3_Accelerometer.csv",
		 getPathBaseDados()+"Petala/ExperimentoPetalaPhone/Teste4_Accelerometer.csv"
		};
	}
	
	public String[] getExperimentoSmartphoneCorrer(){ 
		return new String[] 
		{getPathBaseDados()+"mobile/Experiment/Testes1.1_Accelerometer.csv",
		 getPathBaseDados()+"mobile/Experiment/Teste2.1_Accelerometer.csv",
		 getPathBaseDados()+"mobile/Experiment/Teste3.1_Accelerometer.csv",
		 getPathBaseDados()+"Petala/ExperimentoPetalaPhone/Teste4.1_Accelerometer.csv"
		};
	}
	
	public String[] getExperimentoSmartwatchAndar(){ 
		return new String[] 
		{getPathBaseDados()+"ExperimentoIgorWatch/teste 1_Accelerometer.csv",
		 getPathBaseDados()+"wearable/Experimento/teste2_Accelerometer.csv",
		 getPathBaseDados()+"wearable/Experimento/teste3_Accelerometer.csv",
         getPathBaseDados()+"Petala/ExperimentoPetalaWatch/teste 4_Accelerometer.csv"		
		};
	}
	
	public String[] getExperimentoSmartwatchCorrer(){
		return new String[] 
		{getPathBaseDados()+"ExperimentoIgorWatch/teste 1.1_Accelerometer.csv",
		 getPathBaseDados()+"wearable/Experimento/teste2.1_Accelerometer.csv",
		 getPathBaseDados()+"wearable/Experimento/testes3.1_Accelerometer.csv",
		 getPathBaseDados()+"Petala/ExperimentoPetalaWatch/teste 4.1_Accelerometer.csv"
		};
	}
	
}
