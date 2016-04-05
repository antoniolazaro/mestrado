package br.ufba.activityrecognition.core.weka;

import java.io.Serializable;
import java.math.BigDecimal;

public class ResponseRecognitionModel implements Serializable{
	
	private static final long serialVersionUID = -3255265335230896364L;
	
	private Integer codigoRetorno;
	private String mensagem;
	
	private BigDecimal totalDownstairs;
	private BigDecimal totalRunning;
	private BigDecimal totalSitting;
	private BigDecimal totalStanding;
	private BigDecimal totalUpstairs;
	private BigDecimal totalWalking;
	private BigDecimal quantidadeTotal;
	
	public ResponseRecognitionModel() {
		this.codigoRetorno = 1;
		this.mensagem = "OK.";
		this.totalDownstairs = new BigDecimal(0);
		this.totalRunning = new BigDecimal(0); 
		this.totalSitting = new BigDecimal(0);
		this.totalStanding = new BigDecimal(0);
		this.totalUpstairs = new BigDecimal(0);
		this.totalWalking = new BigDecimal(0);
		this.quantidadeTotal = new BigDecimal(0);
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

	public BigDecimal getTotalDownstairs() {
		return totalDownstairs;
	}

	public void setTotalDownstairs(BigDecimal totalDownstairs) {
		this.totalDownstairs = totalDownstairs;
	}

	public BigDecimal getTotalRunning() {
		return totalRunning;
	}

	public void setTotalRunning(BigDecimal totalRunning) {
		this.totalRunning = totalRunning;
	}

	public BigDecimal getTotalSitting() {
		return totalSitting;
	}

	public void setTotalSitting(BigDecimal totalSitting) {
		this.totalSitting = totalSitting;
	}

	public BigDecimal getTotalStanding() {
		return totalStanding;
	}

	public void setTotalStanding(BigDecimal totalStanding) {
		this.totalStanding = totalStanding;
	}

	public BigDecimal getTotalUpstairs() {
		return totalUpstairs;
	}

	public void setTotalUpstairs(BigDecimal totalUpstairs) {
		this.totalUpstairs = totalUpstairs;
	}

	public BigDecimal getTotalWalking() {
		return totalWalking;
	}

	public void setTotalWalking(BigDecimal totalWalking) {
		this.totalWalking = totalWalking;
	}

	public BigDecimal getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(BigDecimal quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}
	
	public void addTotalDownstairs() {
		this.totalDownstairs.add(new BigDecimal(1));
	}

	public void addTotalRunning() {
		this.totalRunning.add(new BigDecimal(1));
	}
	
	public void addTotalSitting() {
		this.totalSitting.add(new BigDecimal(1));
	}
	
	public void addTotalStanding() {
		this.totalStanding.add(new BigDecimal(1));
	}

	public void addTotalUpstairs() {
		this.totalUpstairs.add(new BigDecimal(1));
	}

	public void addTotalWalking() {
		this.totalWalking.add(new BigDecimal(1));
	}

	public void addQuantidadeTotal() {
		this.quantidadeTotal.add(new BigDecimal(1));
	}
	
	public BigDecimal getTotalDownstairsPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			new BigDecimal(getTotalDownstairs().intValue()).divide(getQuantidadeTotal()).multiply(new BigDecimal(100));
		}
		return new BigDecimal(0);
	}

	public BigDecimal getTotalRunningPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			new BigDecimal(getTotalRunning().intValue()).divide(getQuantidadeTotal()).multiply(new BigDecimal(100));
		}
		return new BigDecimal(0);
	}
	
	public BigDecimal getTotalSittingPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			new BigDecimal(getTotalSitting().intValue()).divide(getQuantidadeTotal()).multiply(new BigDecimal(100));
		}
		return new BigDecimal(0);
	}
	
	public BigDecimal getTotalStandingPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			new BigDecimal(getTotalStanding().intValue()).divide(getQuantidadeTotal()).multiply(new BigDecimal(100));
		}
		return new BigDecimal(0);
	}

	public BigDecimal getTotalUpstairsPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			new BigDecimal(getTotalUpstairs().intValue()).divide(getQuantidadeTotal()).multiply(new BigDecimal(100));
		}
		return new BigDecimal(0);
	}

	public BigDecimal getTotalWalkingPercentual() {
		if(getQuantidadeTotal().intValue() > 0){
			new BigDecimal(getTotalWalking().intValue()).divide(getQuantidadeTotal()).multiply(new BigDecimal(100));
		}
		return new BigDecimal(0);
	}
	
	public String getRetornoFormatado(){
		StringBuilder builder = new StringBuilder().
		append("Downstairs: ").append(getTotalDownstairsPercentual()).append(" %.\n").
		append("Running: ").append(getTotalRunningPercentual()).append(" %.\n").
		append("Sitting: ").append(getTotalSittingPercentual()).append(" %.\n").
		append("Standing ").append(getTotalStandingPercentual()).append(" %.\n").
		append("Upstairs: ").append(getTotalUpstairsPercentual()).append(" %.\n").
		append("Walking: ").append(getTotalWalkingPercentual()).append(" %.\n").
		append("Total: ").append(getQuantidadeTotal()).append("\n");
		return builder.toString();
	}
}
