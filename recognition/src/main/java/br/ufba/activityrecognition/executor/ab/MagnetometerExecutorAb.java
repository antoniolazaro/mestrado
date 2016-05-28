package br.ufba.activityrecognition.executor.ab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MagnetometerExecutorAb extends ExecutorAb {
	
	private static final Logger logger = LoggerFactory.getLogger(MagnetometerExecutorAb.class);
	
	public String[] getDataSourceSmartphone(){
		return new String[] 
		{getPathBaseDados()+"mobile/DataSet/Teste1_MagnetometerAndar.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste1_MagnetometerCorrer.csv",
		 getPathBaseDados()+"mobile/DataSet/Testes2_MagnetometerAndar.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste2_MagnetometerCorrer.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste3_MagnetometerAndar.csv",
		 getPathBaseDados()+"mobile/DataSet/Teste3_MagnetometerCorrer.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaPhone/Teste4_MagnetometerAndar.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaPhone/Teste4_MagnetometerCorrer.csv"
		};
	}
	
	public String[] getDataSourceSmartwatch(){ 
		return new String[] 
		{getPathBaseDados()+"DatasetIgorWatch/teste 1_MagnetometerAndar.csv",
	     getPathBaseDados()+"DatasetIgorWatch/teste 1_MagnetometerCorrer.csv",
	     getPathBaseDados()+"wearable/Dataset/teste2_MagnetometerAndar.csv",
	     getPathBaseDados()+"wearable/Dataset/teste2_MagnetometerCorrer.csv",
	     getPathBaseDados()+"wearable/Dataset/teste3_MagnetometerAndar.csv",
	     getPathBaseDados()+"wearable/Dataset/teste3_MagnetometerCorrer.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaWatch/teste 4_MagnetometerAndar.csv",
		 getPathBaseDados()+"Petala/DatasetPetalaWatch/teste 4_MagnetometerCorrer.csv"
		};
	}
	
	public String[] getExperimentoSmartphoneAndar(){ 
		return new String[] 
		{getPathBaseDados()+"mobile/Experiment/Teste1_Magnetometer.csv",
		 getPathBaseDados()+"mobile/Experiment/Testes2_Magnetometer.csv",
		 getPathBaseDados()+"mobile/Experiment/Teste3_Magnetometer.csv",
		 getPathBaseDados()+"Petala/ExperimentoPetalaPhone/Teste4_Magnetometer.csv"
		};
	}
	
	public String[] getExperimentoSmartphoneCorrer(){ 
		return new String[]  
		{getPathBaseDados()+"mobile/Experiment/Testes1.1_Magnetometer.csv",
		 getPathBaseDados()+"mobile/Experiment/Teste2.1_Magnetometer.csv",
		 getPathBaseDados()+"mobile/Experiment/Teste3.1_Magnetometer.csv",
		 getPathBaseDados()+"Petala/ExperimentoPetalaPhone/Teste4.1_Magnetometer.csv"
		};
	}
	
	public String[] getExperimentoSmartwatchAndar(){ 
		return new String[]  
		{getPathBaseDados()+"ExperimentoIgorWatch/teste 1_Magnetometer.csv",
		 getPathBaseDados()+"wearable/Experimento/teste2_Magnetometer.csv",
		 getPathBaseDados()+"wearable/Experimento/teste3_Magnetometer.csv",
         getPathBaseDados()+"Petala/ExperimentoPetalaWatch/teste 4_Magnetometer.csv"		
		};
	}
	
	public String[] getExperimentoSmartwatchCorrer(){ 
		return new String[]   
		{getPathBaseDados()+"ExperimentoIgorWatch/teste 1.1_Magnetometer.csv",
		 getPathBaseDados()+"wearable/Experimento/teste2.1_Magnetometer.csv",
		 getPathBaseDados()+"wearable/Experimento/teste3.1_Magnetometer.csv",
		 getPathBaseDados()+"Petala/ExperimentoPetalaWatch/teste 4.1_Magnetometer.csv"
		};
	}

}
