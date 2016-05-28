package br.ufba.activityrecognition.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.core.enuns.UsersEnum;
import br.ufba.activityrecognition.executor.impessoal.AccelerometerExecutorImpessoal;
import br.ufba.activityrecognition.executor.impessoal.AllSensorsExecutorImpessoal;
import br.ufba.activityrecognition.executor.impessoal.GyroscopeExecutorImpessoal;
import br.ufba.activityrecognition.executor.impessoal.MagnetometerExecutorImpessoal;
import br.ufba.activityrecognition.executor.pessoal.AccelerometerExecutorPessoal;
import br.ufba.activityrecognition.executor.pessoal.AllSensorsExecutorPessoal;
import br.ufba.activityrecognition.executor.pessoal.GyroscopeExecutorPessoal;
import br.ufba.activityrecognition.executor.pessoal.MagnetometerExecutorPessoal;

public class MainExecutor{
	
	private static final Logger logger = LoggerFactory.getLogger(MainExecutor.class);
	
	public static void main(String[] args) throws Exception{
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando processo pessoal para todos usuários. Quantidade = "+UsersEnum.values().length);
		runPessoal();
//		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ rodando processo impessoal para todos usuários. Quantidade = "+UsersEnum.values().length);
//		runImpessoal();
	}

	private static void runImpessoal() throws Exception {
		new AllSensorsExecutorImpessoal().run();
		new GyroscopeExecutorImpessoal().run();
		new MagnetometerExecutorImpessoal().run();
		new AccelerometerExecutorImpessoal().run();
	}

	private static void runPessoal() throws Exception {
		new AllSensorsExecutorPessoal().run();
		new GyroscopeExecutorPessoal().run();
		new MagnetometerExecutorPessoal().run();
		new AccelerometerExecutorPessoal().run();
	}
	
	
}
