package br.ufba.activityrecognition.executor.ab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GyroscopeExecutorAb extends ExecutorAb {
	
	private static final Logger logger = LoggerFactory.getLogger(GyroscopeExecutorAb.class);
	
	public String[] getDataSourceSmartphone(){
		return new String[] 
		{getPathBaseDados()+"mobile/DataSet/Teste1_GyroscopeAndar.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste1_GyroscopeCorrer.csv",
		 getPathBaseDados()+"mobile/DataSet/Testes2_GyroscopeAndar.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste2_GyroscopeCorrer.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste3_GyroscopeAndar.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste3_GyroscopeCorrer.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaPhone/Teste4_GyroscopeAndar.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaPhone/Teste4_GyroscopeCorrer.csv"
		};
	}
	
	public String[] getDataSourceSmartwatch(){ 
		return new String[]
		{getPathBaseDados()+"DatasetIgorWatch/teste 1_GyroscopeAndar.csv",
	     getPathBaseDados()+"DatasetIgorWatch/teste 1_GyroscopeCorrer.csv",
	     getPathBaseDados()+"wearable/Dataset/teste2_GyroscopeAndar.csv",
	     getPathBaseDados()+"wearable/Dataset/teste2_GyroscopeCorrer.csv",
	     getPathBaseDados()+"wearable/Dataset/teste3_GyroscopeAndar.csv",
	     getPathBaseDados()+"wearable/Dataset/teste3_GyroscopeCorrer.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaWatch/teste 4_GyroscopeAndar.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaWatch/teste 4_GyroscopeCorrer.csv"
		};
	}

	public String[] getExperimentoSmartphoneAndar(){ 
		return new String[]
		{getPathBaseDados()+"mobile/Experiment/Teste1_Gyroscope.csv",
		 getPathBaseDados()+"mobile/Experiment/Testes2_Gyroscope.csv",
		 getPathBaseDados()+"mobile/Experiment/Teste3_Gyroscope.csv",
		 getPathBaseDados()+"Petala/ExperimentoPetalaPhone/Teste4_Gyroscope.csv"
		};
	}
	
	public String[] getExperimentoSmartphoneCorrer(){ 
		return new String[] 
		{getPathBaseDados()+"mobile/Experiment/Testes1.1_Gyroscope.csv",
		 getPathBaseDados()+"mobile/Experiment/Teste2.1_Gyroscope.csv",
		 getPathBaseDados()+"mobile/Experiment/Teste3.1_Gyroscope.csv",
		 getPathBaseDados()+"Petala/ExperimentoPetalaPhone/Teste4.1_Gyroscope.csv"
		};
	}
	
	public String[] getExperimentoSmartwatchAndar(){ 
		return new String[] 
		{getPathBaseDados()+"ExperimentoIgorWatch/teste 1_Gyroscope.csv",
		 getPathBaseDados()+"wearable/Experimento/teste2_Gyroscope.csv",
		 getPathBaseDados()+"wearable/Experimento/teste3_Gyroscope.csv",
         getPathBaseDados()+"Petala/ExperimentoPetalaWatch/teste 4_Gyroscope.csv"		
		};
	}
	
	public String[] getExperimentoSmartwatchCorrer(){ 
		return new String[]  
		{getPathBaseDados()+"ExperimentoIgorWatch/teste 1.1_Gyroscope.csv",
		 getPathBaseDados()+"wearable/Experimento/teste2.1_Gyroscope.csv",
		 getPathBaseDados()+"wearable/Experimento/teste 3.1_Gyroscope.csv",
		 getPathBaseDados()+"Petala/ExperimentoPetalaWatch/teste 4.1_Gyroscope.csv"
		};
	}

}
