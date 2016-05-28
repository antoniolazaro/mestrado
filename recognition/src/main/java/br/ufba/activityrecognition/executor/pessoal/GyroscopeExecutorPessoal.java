package br.ufba.activityrecognition.executor.pessoal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.runner.AlghoritmRunner;
import br.ufba.activityrecognition.business.runner.AlghoritmRunnerIf;
import br.ufba.activityrecognition.executor.ab.GyroscopeExecutorAb;

public class GyroscopeExecutorPessoal extends GyroscopeExecutorAb{
	
	private static final Logger logger = LoggerFactory.getLogger(GyroscopeExecutorPessoal.class);
	
	public String[] getDataTargeFileSmartphone(){
		return new String[]
		{getPathBaseTarget()+"concatenado_gyroscope_smartphone_pessoal_igor.csv",
		 getPathBaseTarget()+"concatenado_gyroscope_smartphone_pessoal_geane.csv",
		 getPathBaseTarget()+"concatenado_gyroscope_smartphone_pessoal_antonio.csv",
		 getPathBaseTarget()+"concatenado_gyroscope_smartphone_pessoal_petala.csv"
		};
	}
	
	public String[] getDataTargeFileSmartwatch(){
		return new String[]
		{getPathBaseTarget()+"concatenado_gyroscope_smartwatch_pessoal_igor.csv",
		 getPathBaseTarget()+"concatenado_gyroscope_smartwatch_pessoal_geane.csv",
		 getPathBaseTarget()+"concatenado_gyroscope_smartwatch_pessoal_antonio.csv",
		 getPathBaseTarget()+"concatenado_gyroscope_smartwatch_pessoal_petala.csv"
		};
	}
	
	@Override
	public AlghoritmRunnerIf getAlghoritmRunner() {
		return new AlghoritmRunner();
	}
	
	@Override
	public String getFileNameResult() {
		return "result_gyroscope_pessoal.csv";
	}
	
	public void run() throws Exception{
		logger.info("\n @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Processando giroscopio com dataset pessoal...\n");
		runPessoal();
	}
	
}
