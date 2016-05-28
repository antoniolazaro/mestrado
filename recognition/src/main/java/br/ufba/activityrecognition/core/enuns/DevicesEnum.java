package br.ufba.activityrecognition.core.enuns;

public enum DevicesEnum {
	
	SMARTPHONE(1,"Smartphone"),SMARTWATCH(2,"Smartwatch");
	
	private Integer	codigo;
	private String nome;
	
	private DevicesEnum(Integer codigo,String nome){
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

}
