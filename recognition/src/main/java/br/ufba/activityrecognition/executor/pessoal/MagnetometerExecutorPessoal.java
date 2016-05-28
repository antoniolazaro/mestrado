
package br.ufba.activityrecognition.executor.pessoal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.runner.AlghoritmRunner;
import br.ufba.activityrecognition.business.runner.AlghoritmRunnerIf;
import br.ufba.activityrecognition.executor.ab.MagnetometerExecutorAb;

public class MagnetometerExecutorPessoal extends MagnetometerExecutorAb{
	
	private static final Logger logger = LoggerFactory.getLogger(MagnetometerExecutorPessoal.class);
	
	public String[] getDataTargeFileSmartphone(){
		return new String[]
		{getPathBaseTarget()+"concatenado_magnetometer_smartphone_pessoal_igor.csv",
		 getPathBaseTarget()+"concatenado_magnetometer_smartphone_pessoal_geane.csv",
		 getPathBaseTarget()+"concatenado_magnetometer_smartphone_pessoal_antonio.csv",
		 getPathBaseTarget()+"concatenado_magnetometer_smartphone_pessoal_petala.csv"
		};
	}
	
	public String[] getDataTargeFileSmartwatch(){
		return new String[]
		{getPathBaseTarget()+"concatenado_magnetometer_smartwatch_pessoal_igor.csv",
		 getPathBaseTarget()+"concatenado_magnetometer_smartwatch_pessoal_geane.csv",
		 getPathBaseTarget()+"concatenado_magnetometer_smartwatch_pessoal_antonio.csv",
		 getPathBaseTarget()+"concatenado_magnetometer_smartwatch_pessoal_petala.csv"
		};
	}
	
	@Override
	public AlghoritmRunnerIf getAlghoritmRunner() {
		return new AlghoritmRunner();
	}
	
	@Override
	public String getFileNameResult() {
		return "result_magnetometer_pessoal.csv";
	}
	
	public void run() throws Exception{
		logger.info("\n @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Processando magnetometro com dataset pessoal...\n");
		runPessoal();
	}
	
}
