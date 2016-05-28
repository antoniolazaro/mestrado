package br.ufba.activityrecognition.executor.ab;

import br.ufba.activityrecognition.business.runner.AlghoritmRunnerIf;

public interface ExecutorIf {
	
	public String[] getDataSourceSmartphone();
	public String[] getDataSourceSmartwatch();
	public String[] getExperimentoSmartphoneAndar();
	public String[] getExperimentoSmartphoneCorrer();
	public String[] getExperimentoSmartwatchAndar();
	public String[] getExperimentoSmartwatchCorrer();
	public String[] getDataTargeFileSmartphone();
	public String[] getDataTargeFileSmartwatch();
	public String[] getUserList();
	public void processActivityOnDeviceByUser(String[] dataSource,String targetFile,String device,String user,String activity,String[] experimentoSource) throws Exception;
	public void run() throws Exception;
	public AlghoritmRunnerIf getAlghoritmRunner();
	public String getFileNameResult();
		
}
