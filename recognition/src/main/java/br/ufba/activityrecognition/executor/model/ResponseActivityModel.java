package br.ufba.activityrecognition.executor.model;

import java.util.List;

import br.ufba.activityrecognition.core.weka.ResponseRecognitionModel;

public class ResponseActivityModel {
	
	private RequestActivityModel requestActivity;
	private List<ResponseRecognitionModel> listaOcorrencias;
	
	public List<ResponseRecognitionModel> getListaOcorrencias() {
		return listaOcorrencias;
	}
	public void setListaOcorrencias(List<ResponseRecognitionModel> listaOcorrencias) {
		this.listaOcorrencias = listaOcorrencias;
	}
	public RequestActivityModel getRequestActivity() {
		return requestActivity;
	}
	public void setRequestActivity(RequestActivityModel requestActivity) {
		this.requestActivity = requestActivity;
	}
	

}
