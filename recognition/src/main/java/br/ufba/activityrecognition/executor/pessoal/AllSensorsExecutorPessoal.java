package br.ufba.activityrecognition.executor.pessoal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.runner.AlghoritmRunnerIf;
import br.ufba.activityrecognition.business.runner.AllSensorsAlghoritmRunner;
import br.ufba.activityrecognition.executor.ab.AllSensorsExecutorAb;

public class AllSensorsExecutorPessoal extends AllSensorsExecutorAb{
	
	private static final Logger logger = LoggerFactory.getLogger(AllSensorsExecutorPessoal.class);
	
	public String[] getDataTargeFileSmartphone(){
		return new String[]
		{getPathBaseTarget()+"concatenado_allsensors_smartphone_pessoal_igor.csv",
		 getPathBaseTarget()+"concatenado_allsensors_smartphone_pessoal_geane.csv",
		 getPathBaseTarget()+"concatenado_allsensors_smartphone_pessoal_antonio.csv",
		 getPathBaseTarget()+"concatenado_allsensors_smartphone_pessoal_petala.csv"
		};
	}
	
	public String[] getDataTargeFileSmartwatch(){
		return new String[]
		{getPathBaseTarget()+"concatenado_allsensors_smartwatch_pessoal_igor.csv",
		 getPathBaseTarget()+"concatenado_allsensors_smartwatch_pessoal_geane.csv",
		 getPathBaseTarget()+"concatenado_allsensors_smartwatch_pessoal_antonio.csv",
		 getPathBaseTarget()+"concatenado_allsensors_smartwatch_pessoal_petala.csv"
		};
	}
	
	@Override
	public AlghoritmRunnerIf getAlghoritmRunner() {
		return new AllSensorsAlghoritmRunner();
	}
	
	@Override
	public String getFileNameResult() {
		return "result_allsensors_pessoal.csv";
	}
	
	public void run() throws Exception{
		logger.info("\n @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Processando allsensors com dataset pessoal...\n");
		runPessoal();
	}

}
