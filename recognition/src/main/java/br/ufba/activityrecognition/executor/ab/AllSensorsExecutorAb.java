package br.ufba.activityrecognition.executor.ab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AllSensorsExecutorAb extends ExecutorAb {
	
	private static final Logger logger = LoggerFactory.getLogger(AllSensorsExecutorAb.class);
	
	public String[] getDataSourceSmartphone(){
		return new String[]
		{getPathBaseDados()+"mobile/DataSet/Teste1_AllSensorsAndar.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste1_AllSensorsCorrer.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste2_AllSensorsCorrer.csv",
		 getPathBaseDados()+"mobile/DataSet/Testes2_AllSensorsAndar.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste3_AllSensorsAndar.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste3_AllSensorsCorrer.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaPhone/Teste4_AllSensorsAndar.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaPhone/Teste4_AllSensorsCorrer.csv"
		};
	}
	
	public String[] getDataSourceSmartwatch(){ 
		return new String[]
		{getPathBaseDados()+"DatasetIgorWatch/teste 1_AllSensorsAndar.csv",
	     getPathBaseDados()+"DatasetIgorWatch/teste 1_AllSensorsCorrer.csv",
	     getPathBaseDados()+"wearable/Dataset/teste2_AllSensorsAndar.csv",
	     getPathBaseDados()+"wearable/Dataset/teste2_AllSensorsCorrer.csv",
	     getPathBaseDados()+"wearable/Dataset/teste3_AllSensorsAndar.csv",
	     getPathBaseDados()+"wearable/Dataset/teste3_AllSensorsCorrer.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaWatch/teste 4_AllSensorsAndar.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaWatch/teste 4_AllSensorsCorrer.csv"
		};
	}

	public String[] getExperimentoSmartphoneAndar(){ 
		return new String[]
		{getPathBaseDados()+"mobile/Experiment/Teste1_AllSensors.csv",
		 getPathBaseDados()+"mobile/Experiment/Testes2_AllSensors.csv",
		 getPathBaseDados()+"mobile/Experiment/Teste3_AllSensors.csv",
		 getPathBaseDados()+"Petala/ExperimentoPetalaPhone/Teste4_AllSensors.csv"
		};
	}
	
	public String[] getExperimentoSmartphoneCorrer(){ 
		return new String[]
		{getPathBaseDados()+"mobile/Experiment/Testes1.1_AllSensors.csv",
		 getPathBaseDados()+"mobile/Experiment/Teste2.1_AllSensors.csv",
		 getPathBaseDados()+"mobile/Experiment/Teste3.1_AllSensors.csv",
		 getPathBaseDados()+"Petala/ExperimentoPetalaPhone/Teste4.1_AllSensors.csv"
		};
	}
	
	public String[] getExperimentoSmartwatchAndar(){ 
		return new String[]
		{getPathBaseDados()+"ExperimentoIgorWatch/teste 1_AllSensors.csv",
		 getPathBaseDados()+"wearable/Experimento/teste2_AllSensors.csv",
		 getPathBaseDados()+"wearable/Experimento/teste3_AllSensors.csv",
         getPathBaseDados()+"Petala/ExperimentoPetalaWatch/teste 4_AllSensors.csv"		
		};
	}
	
	public String[] getExperimentoSmartwatchCorrer(){
			return new String[]
		{getPathBaseDados()+"ExperimentoIgorWatch/teste 1.1_AllSensors.csv",
		 getPathBaseDados()+"wearable/Experimento/teste2.1_AllSensors.csv",
		 getPathBaseDados()+"wearable/Experimento/teste3.1_AllSensors.csv",
		 getPathBaseDados()+"Petala/ExperimentoPetalaWatch/teste 4.1_AllSensors.csv"
		};
	}

}
