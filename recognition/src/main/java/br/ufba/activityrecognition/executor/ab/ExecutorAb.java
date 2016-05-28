package br.ufba.activityrecognition.executor.ab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.runner.AlghoritmRunnerIf;
import br.ufba.activityrecognition.business.util.IOUtil;
import br.ufba.activityrecognition.core.enuns.ActivitiesEnum;
import br.ufba.activityrecognition.core.enuns.DevicesEnum;
import br.ufba.activityrecognition.core.enuns.UsersEnum;
import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;
import br.ufba.activityrecognition.executor.model.RequestActivityModel;
import br.ufba.activityrecognition.executor.model.ResponseActivityModel;

public abstract class ExecutorAb implements ExecutorIf {
	
	private static final Logger logger = LoggerFactory.getLogger(ExecutorAb.class);
	
	private List<ResponseActivityModel> responseList = new ArrayList<ResponseActivityModel>();
	
	public String[] getUserList(){
		return new String[]
		{UsersEnum.IGOR.getNome(),
		 UsersEnum.GEANE.getNome(),
		 UsersEnum.ANTONIO.getNome(),
		 UsersEnum.PETALA.getNome()
		};
	}
	
	private String getPathBase(){
		return "/Users/antoniolazarocarvalhoborges/desenvolvimento/workspace/mestrado/experimento_1-20.05.2016/";
	}
	
	protected String getPathBaseDados(){
		return getPathBase()+"/dados/";
	}
	
	protected String getPathBaseTarget(){
		return getPathBase()+"/target/";
	}
	
	protected String getPathBaseResult(){
		return getPathBase()+"/result/";
	}
	
	protected void addResponse(ResponseActivityModel responseActivity){
		responseList.add(responseActivity);
	}
	
	protected List<ResponseActivityModel> getResponseList(){
		return responseList;
	}
	
	public void processActivityOnDeviceByUser(String[] dataSource,String targetFile,String device,String user,String activity,String[] experimentoSource) throws Exception{
		ResponseActivityModel responseActivity = run(dataSource,targetFile,device,user,activity,experimentoSource);
		addResponse(responseActivity);
	}
	
	protected List<ResponseRecognitionModel> runTest(String targetDataSet,String[] experimentoSources,RequestActivityModel requestActivity) throws Exception{
		logger.info("######################## COMPARANDO ARQUIVOS.\n");
		List<ResponseRecognitionModel> listaResponse = new ArrayList<>();
		AlghoritmRunnerIf alghoritmRunner = getAlghoritmRunner();
		for(String fileName: experimentoSources){
			logger.info("#### COMPARANDO ARQUIVOS. USUARIO: \n");
			listaResponse.add(alghoritmRunner.runJ48(targetDataSet,fileName,requestActivity));
			listaResponse.add(alghoritmRunner.runKnn(targetDataSet,fileName,requestActivity));
			listaResponse.add(alghoritmRunner.runSVM(targetDataSet,fileName,requestActivity));
			listaResponse.add(alghoritmRunner.runMultiLayerPerceptronMLP(targetDataSet,fileName,requestActivity));
			listaResponse.add(alghoritmRunner.runNaiveBayes(targetDataSet,fileName,requestActivity));
			listaResponse.add(alghoritmRunner.runRandomForrest(targetDataSet,fileName,requestActivity));
		}
		return listaResponse;
	}
	
	protected ResponseActivityModel run(String[] dataSetSource,String targetFile,String equipamento,String nomeUsuarioExperimento,String atividade,String[] experimentoSource) throws IOException, Exception {
		IOUtil.mergeFiles(dataSetSource,targetFile);
		logger.info("####################### INICIANDO RECONHECIMENTO ATIVIDADE..."+atividade+"\n");
		RequestActivityModel requestActivityWalking = new RequestActivityModel();
		requestActivityWalking.setEquipamento(equipamento);
		requestActivityWalking.setNomeUsuarioExperimento(nomeUsuarioExperimento);
		requestActivityWalking.setAtividade(atividade);
		List<ResponseRecognitionModel> listaActivity = runTest(targetFile,experimentoSource,requestActivityWalking);
		ResponseActivityModel responseActivity = new ResponseActivityModel();
		responseActivity.setRequestActivity(requestActivityWalking);
		responseActivity.setListaOcorrencias(listaActivity);
		logger.info("####################### FIM RECONHECIMENTO ATIVIDADE..."+atividade+"\n");
		return responseActivity;
		
	}
	
	protected void generateResults(String fileName){
		List<ResponseActivityModel> lista = getResponseList();
		
		StringBuilder builder = new StringBuilder();
		
		for(ResponseActivityModel response:lista){
			RequestActivityModel requestActivityModel = response.getRequestActivity();
			builder.append(requestActivityModel.getNomeUsuarioExperimento()).
			append(";J48;KNN;SVM;MLP;NAIVE BAYES (NB);RANDOM FORREST").append("\n").
			append(requestActivityModel.getNomeUsuarioExperimento()).
			append(requestActivityModel.getAtividade()).append("\n").append(requestActivityModel.getEquipamento()).append(";");
			for(ResponseRecognitionModel responseRecognitionModel:response.getListaOcorrencias()){
				if(response.getRequestActivity().getAtividade().equals(ActivitiesEnum.WALKING.getNome())){
					builder.append(responseRecognitionModel.getTotalWalkingPercentual()).append(" %");
				}else if(response.getRequestActivity().getAtividade().equals(ActivitiesEnum.RUNNING.getNome())){
					builder.append(responseRecognitionModel.getTotalRunningPercentual()).append(" %");
				}else{
					builder.append("ERRO");
				}
			}
		}
		
		IOUtil.writeResults(fileName, builder.toString());
	}
	
	public void runSmartphone(String[] dataSource,int indice) throws Exception{
		
		logger.info("############################################# CAMINHADA USUARIO..."+getUserList()[indice]+"\n");
		processActivityOnDeviceByUser(dataSource,
				getDataTargeFileSmartphone()[indice],DevicesEnum.SMARTPHONE.getNome(),getUserList()[indice],ActivitiesEnum.WALKING.getNome(),
				new String[]{getExperimentoSmartphoneAndar()[indice]});
		logger.info("############################################# CORRIDA USUARIO..."+getUserList()[indice]+"\n");
		processActivityOnDeviceByUser(dataSource,
				getDataTargeFileSmartphone()[indice],DevicesEnum.SMARTPHONE.getNome(),getUserList()[indice],ActivitiesEnum.RUNNING.getNome(),
				new String[]{getExperimentoSmartphoneAndar()[indice]});
	}
	
	public void runSmartwatch(String[] dataSource,int indice) throws Exception{
		logger.info("############################################# CAMINHADA USUARIO..."+getUserList()[indice]+"\n");
		processActivityOnDeviceByUser(dataSource,
				getDataTargeFileSmartphone()[indice],DevicesEnum.SMARTWATCH.getNome(),getUserList()[indice],ActivitiesEnum.WALKING.getNome(),
				new String[]{getExperimentoSmartphoneAndar()[indice]});
		logger.info("############################################# CORRIDA USUARIO..."+getUserList()[indice]+"\n");
		processActivityOnDeviceByUser(dataSource,
				getDataTargeFileSmartphone()[indice],DevicesEnum.SMARTWATCH.getNome(),getUserList()[indice],ActivitiesEnum.RUNNING.getNome(),
				new String[]{getExperimentoSmartphoneAndar()[indice]});
	}
	
	public void runPessoal() throws Exception{
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ BLOCO PROCESSAMENTO SMARTPHONE...\n");
		runSmartphone(new String[]{getDataSourceSmartphone()[0],getDataSourceSmartphone()[1]},0);
		runSmartphone(new String[]{getDataSourceSmartphone()[2],getDataSourceSmartphone()[3]},1);
		runSmartphone(new String[]{getDataSourceSmartphone()[4],getDataSourceSmartphone()[5]},2);
		runSmartphone(new String[]{getDataSourceSmartphone()[6],getDataSourceSmartphone()[7]},3);
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ BLOCO PROCESSAMENTO SMARTWATCH...\n");
		runSmartwatch(new String[]{getDataSourceSmartwatch()[0],getDataSourceSmartwatch()[1]},0);
		runSmartwatch(new String[]{getDataSourceSmartwatch()[2],getDataSourceSmartwatch()[3]},1);
		runSmartwatch(new String[]{getDataSourceSmartwatch()[4],getDataSourceSmartwatch()[5]},2);
		runSmartwatch(new String[]{getDataSourceSmartwatch()[6],getDataSourceSmartwatch()[7]},3);
		
		generateResults(getPathBaseResult()+getFileNameResult());
	}
	
	public void runImpessoal() throws Exception{
		
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ BLOCO PROCESSAMENTO SMARTPHONE...\n");
		for(int indice=0;indice<getUserList().length;indice++){
			runSmartphone(getDataSourceSmartphone(),indice);
		}
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ BLOCO PROCESSAMENTO SMARTWATCH...\n");
		for(int indice=0;indice<getUserList().length;indice++){
			runSmartwatch(getDataSourceSmartwatch(),indice);
		}
		generateResults(getPathBaseResult()+getFileNameResult());
	}
	
}
