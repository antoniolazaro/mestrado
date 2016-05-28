package br.ufba.activityrecognition.executor.pessoal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.core.enuns.ActivitiesEnum;
import br.ufba.activityrecognition.core.enuns.DevicesEnum;
import br.ufba.activityrecognition.executor.ab.ExecutorAb;

public abstract class ExecutorPessoalAb extends ExecutorAb{
	
	private static final Logger logger = LoggerFactory.getLogger(ExecutorPessoalAb.class);
	
	public void runSmartphone(String[] dataSource) throws Exception{
		
		for(int indice=0;indice<getUserList().length;indice++){
			logger.info("############################################# CAMINHADA USUARIO..."+getUserList()[indice]+"\n");
			processActivityOnDeviceByUser(dataSource,
					getDataTargeFileSmartphone()[indice],DevicesEnum.SMARTPHONE.getNome(),getUserList()[indice],ActivitiesEnum.WALKING.getNome(),
					new String[]{getExperimentoSmartphoneAndar()[indice]});
			logger.info("############################################# CORRIDA USUARIO..."+getUserList()[indice]+"\n");
			processActivityOnDeviceByUser(dataSource,
					getDataTargeFileSmartphone()[indice],DevicesEnum.SMARTPHONE.getNome(),getUserList()[indice],ActivitiesEnum.RUNNING.getNome(),
					new String[]{getExperimentoSmartphoneAndar()[indice]});
		}
	}
	
	public void runSmartwatch(String[] dataSource) throws Exception{
		
		for(int indice=0;indice<getUserList().length;indice++){
			logger.info("############################################# CAMINHADA USUARIO..."+getUserList()[indice]+"\n");
			processActivityOnDeviceByUser(dataSource,
					getDataTargeFileSmartphone()[indice],DevicesEnum.SMARTWATCH.getNome(),getUserList()[indice],ActivitiesEnum.WALKING.getNome(),
					new String[]{getExperimentoSmartphoneAndar()[indice]});
			logger.info("############################################# CORRIDA USUARIO..."+getUserList()[indice]+"\n");
			processActivityOnDeviceByUser(dataSource,
					getDataTargeFileSmartphone()[indice],DevicesEnum.SMARTWATCH.getNome(),getUserList()[indice],ActivitiesEnum.RUNNING.getNome(),
					new String[]{getExperimentoSmartphoneAndar()[indice]});
		}
	}
	
}
