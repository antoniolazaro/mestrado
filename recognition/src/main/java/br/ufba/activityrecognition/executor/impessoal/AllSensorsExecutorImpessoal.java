package br.ufba.activityrecognition.executor.impessoal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.runner.AlghoritmRunnerIf;
import br.ufba.activityrecognition.business.runner.AllSensorsAlghoritmRunner;
import br.ufba.activityrecognition.executor.ab.AllSensorsExecutorAb;

public class AllSensorsExecutorImpessoal extends AllSensorsExecutorAb {
	
	private static final Logger logger = LoggerFactory.getLogger(AllSensorsExecutorImpessoal.class);
	
	public String[] getDataTargeFileSmartphone(){
		return new String[]
		{getPathBaseTarget()+"concatenado_smartphone_impessoal.csv"
		};
	}
	
	public String[] getDataTargeFileSmartwatch(){
		return new String[]
		{getPathBaseTarget()+"concatenado_smartwatch_impessoal.csv"
		};
	}
	
	@Override
	public AlghoritmRunnerIf getAlghoritmRunner() {
		return new AllSensorsAlghoritmRunner();
	}
	
	@Override
	public String getFileNameResult() {
		return "result_allsensors_impessoal.csv";
	}
	
	public void run() throws Exception{
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Processando allsensors com dataset impessoal...\n");
		runImpessoal();
	}

}
