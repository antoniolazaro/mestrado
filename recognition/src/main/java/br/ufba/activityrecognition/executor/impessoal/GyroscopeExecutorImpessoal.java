package br.ufba.activityrecognition.executor.impessoal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.runner.AlghoritmRunner;
import br.ufba.activityrecognition.business.runner.AlghoritmRunnerIf;
import br.ufba.activityrecognition.executor.ab.GyroscopeExecutorAb;


public class GyroscopeExecutorImpessoal extends GyroscopeExecutorAb {
	
	private static final Logger logger = LoggerFactory.getLogger(GyroscopeExecutorImpessoal.class);
	
	public String[] getDataTargeFileSmartphone(){
		return new String[]
		{getPathBaseTarget()+"concatenado_gyroscope_smartphone_impessoal.csv"
		};
	}
	
	public String[] getDataTargeFileSmartwatch(){
		return new String[]
		{getPathBaseTarget()+"concatenado_gyroscope_smartwatch_impessoal.csv"
		};
	}
	
	@Override
	public AlghoritmRunnerIf getAlghoritmRunner() {
		return new AlghoritmRunner();
	}
	
	@Override
	public String getFileNameResult() {
		return "result_gyroscope_impessoal.csv";
	}
	
	public void run() throws Exception{
		logger.info("\n @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Processando giroscopio com dataset impessoal...\n");
		runImpessoal();
	}

}
