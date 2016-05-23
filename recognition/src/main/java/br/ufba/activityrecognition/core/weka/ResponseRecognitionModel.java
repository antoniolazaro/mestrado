package br.ufba.activityrecognition.core.weka;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="responseRecognitionModel")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseRecognitionModel implements Serializable{

	private static final long serialVersionUID = -3255265335230896364L;

	@XmlElement
	private Integer codigoRetorno;
	@XmlElement
	private String mensagem;
	@XmlElement
	private Integer totalDownstairs;
	@XmlElement
	private Integer totalRunning;
	@XmlElement
	private Integer totalSitting;
	@XmlElement
	private Integer totalStanding;
	@XmlElement
	private Integer totalUpstairs;
	@XmlElement
	private Integer totalWalking;
	@XmlElement
	private Integer totalNaoReconhecido;
	@XmlElement
	private Integer quantidadeTotal;
	@XmlElement
	private String retornoFormatado;

	public ResponseRecognitionModel() {
		this.codigoRetorno = 1;
		this.mensagem = "OK.";
		this.totalDownstairs = Integer.valueOf(0);
		this.totalRunning = Integer.valueOf(0);
		this.totalSitting = Integer.valueOf(0);
		this.totalStanding = Integer.valueOf(0);
		this.totalUpstairs = Integer.valueOf(0);
		this.totalWalking = Integer.valueOf(0);
		this.totalNaoReconhecido = Integer.valueOf(0);
		this.quantidadeTotal = Integer.valueOf(0);
	}

	public Integer getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(Integer codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void addTotalDownstairs() {
		this.totalDownstairs = this.totalDownstairs+1;
	}

	public void addTotalRunning() {
		this.totalRunning = this.totalRunning+1;
	}

	public void addTotalSitting() {
		this.totalSitting = this.totalSitting+1;
	}

	public void addTotalStanding() {
		this.totalStanding = this.totalStanding+1;
	}

	public void addTotalUpstairs() {
		this.totalUpstairs = this.totalUpstairs+1;
	}

	public void addTotalWalking() {
		this.totalWalking = this.totalWalking+1;
	}
	
	public void addTotalNaoReconhecido() {
		this.totalNaoReconhecido = this.totalNaoReconhecido+1;
	}

	public void addQuantidadeTotal() {
		this.quantidadeTotal = this.quantidadeTotal+1;
	}

	public Double getTotalDownstairsPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			Double temp = (getTotalDownstairs().doubleValue()/getQuantidadeTotal().doubleValue());
			return temp * 100;
		}
		return 0.0;
	}

	public Double getTotalRunningPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			Double temp = (getTotalRunning().doubleValue()/getQuantidadeTotal().doubleValue());
			return temp * 100;
		}
		return 0.0;
	}

	public Double getTotalSittingPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			Double temp = (getTotalSitting().doubleValue()/getQuantidadeTotal().doubleValue());
			return temp * 100;
		}
		return 0.0;
	}

	public Double getTotalStandingPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			Double temp = (getTotalStanding().doubleValue()/getQuantidadeTotal().doubleValue());
			return temp * 100;
		}
		return 0.0;
	}

	public Double getTotalUpstairsPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			Double temp = (getTotalUpstairs().doubleValue()/getQuantidadeTotal().doubleValue());
			return temp * 100;
		}
		return 0.0;
	}

	public Double getTotalWalkingPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			Double temp = (getTotalWalking().doubleValue()/getQuantidadeTotal().doubleValue());
			return temp * 100;
		}
		return 0.0;
	}
	
	public Double getTotalNaoReconhecidoPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			Double temp = (getTotalNaoReconhecido().doubleValue()/getQuantidadeTotal().doubleValue());
			return temp * 100;
		}
		return 0.0;
	}

	public void setRetornoFormatado(String retornoFormatado) {
		this.retornoFormatado = retornoFormatado;
	}

	public String getRetornoFormatado(){
		StringBuilder builder = new StringBuilder();
		if(getTotalDownstairs() > 0){
			builder.append("Downstairs: ").append(getTotalDownstairs()).append(". (Percentual = ").append(getTotalDownstairsPercentual()).append(" %).\n");	
		}
		if(getTotalRunning() > 0){
			builder.append("Running: ").append(getTotalRunning()).append(". (Percentual = ").append(getTotalRunningPercentual()).append(" %).\n");	
		}
		if(getTotalSitting() > 0){
			builder.append("Sitting: ").append(getTotalSitting()).append(". (Percentual = ").append(getTotalSittingPercentual()).append(" %).\n");	
		}
		if(getTotalStanding() > 0){
			builder.append("Standing ").append(getTotalStanding()).append(". (Percentual = ").append(getTotalStandingPercentual()).append(" %).\n");	
		}
		if(getTotalUpstairs() > 0){
			builder.append("Upstairs: ").append(getTotalUpstairs()).append(". (Percentual = ").append(getTotalUpstairsPercentual()).append(" %).\n");	
		}
		if(getTotalWalking() > 0){
			builder.append("Walking: ").append(getTotalWalking()).append(". (Percentual = ").append(getTotalWalkingPercentual()).append(" %).\n");	
		}
		if(getTotalNaoReconhecido() > 0){
			builder.append("Não reconhecido: ").append(getTotalNaoReconhecido()).append(". (Percentual = ").append(getTotalNaoReconhecidoPercentual()).append(" %).\n");	
		}
		builder.append("Total: ").append(getQuantidadeTotal()).append("\n");
		return builder.toString();
	}

	public Integer getTotalDownstairs() {
		return totalDownstairs;
	}

	public Integer getTotalRunning() {
		return totalRunning;
	}

	public Integer getTotalSitting() {
		return totalSitting;
	}

	public Integer getTotalStanding() {
		return totalStanding;
	}

	public Integer getTotalUpstairs() {
		return totalUpstairs;
	}

	public Integer getTotalWalking() {
		return totalWalking;
	}

	public Integer getQuantidadeTotal() {
		return quantidadeTotal;
	}
	
	public Integer getTotalNaoReconhecido() {
		return totalNaoReconhecido;
	}
}
