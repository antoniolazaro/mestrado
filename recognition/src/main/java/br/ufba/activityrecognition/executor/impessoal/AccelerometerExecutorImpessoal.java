package br.ufba.activityrecognition.executor.impessoal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.runner.AlghoritmRunner;
import br.ufba.activityrecognition.business.runner.AlghoritmRunnerIf;
import br.ufba.activityrecognition.executor.ab.AccelerometerExecutorAb;


public class AccelerometerExecutorImpessoal extends AccelerometerExecutorAb {
	
	private static final Logger logger = LoggerFactory.getLogger(AccelerometerExecutorImpessoal.class);
	
	public String[] getDataTargeFileSmartphone(){
		return new String[]
		{getPathBaseTarget()+"concatenado_accelerometer_smartphone_impessoal.csv"
		};
	}
	
	public String[] getDataTargeFileSmartwatch(){
		return new String[]
		{getPathBaseTarget()+"concatenado_accelerometer_smartwatch_impessoal.csv"
		};
	}
	
	@Override
	public AlghoritmRunnerIf getAlghoritmRunner() {
		return new AlghoritmRunner();
	}
	
	@Override
	public String getFileNameResult() {
		return "result_accelerometer_impessoal.csv";
	}
	
	public void run() throws Exception{
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Processando acelerometero com dataset impessoal...\n");
		runImpessoal();	
	}

}
