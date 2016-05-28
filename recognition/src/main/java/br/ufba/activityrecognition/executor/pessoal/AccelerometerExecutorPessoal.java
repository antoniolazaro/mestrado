package br.ufba.activityrecognition.executor.pessoal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.runner.AlghoritmRunner;
import br.ufba.activityrecognition.business.runner.AlghoritmRunnerIf;
import br.ufba.activityrecognition.executor.ab.AccelerometerExecutorAb;

public class AccelerometerExecutorPessoal extends AccelerometerExecutorAb{
	
	private static final Logger logger = LoggerFactory.getLogger(AccelerometerExecutorPessoal.class);
	
	public String[] getDataTargeFileSmartphone(){
		return new String[]
		{getPathBaseTarget()+"concatenado_accelerometer_smartphone_pessoal_igor.csv",
		 getPathBaseTarget()+"concatenado_accelerometer_smartphone_pessoal_geane.csv",
		 getPathBaseTarget()+"concatenado_accelerometer_smartphone_pessoal_antonio.csv",
		 getPathBaseTarget()+"concatenado_accelerometer_smartphone_pessoal_petala.csv"
		};
	}
	
	public String[] getDataTargeFileSmartwatch(){
		return new String[]
		{getPathBaseTarget()+"concatenado_accelerometer_smartwatch_pessoal_igor.csv",
		 getPathBaseTarget()+"concatenado_accelerometer_smartwatch_pessoal_geane.csv",
		 getPathBaseTarget()+"concatenado_accelerometer_smartwatch_pessoal_antonio.csv",
		 getPathBaseTarget()+"concatenado_accelerometer_smartwatch_pessoal_petala.csv"
		};
	}
	
	@Override
	public AlghoritmRunnerIf getAlghoritmRunner() {
		return new AlghoritmRunner();
	}
	
	@Override
	public String getFileNameResult() {
		return "result_accelerometer_pessoal.csv";
	}
	
	public void run() throws Exception{
		logger.info("\n @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Processando acelerometero com dataset pessoal...\n");
		runPessoal();	
	}
	
}
