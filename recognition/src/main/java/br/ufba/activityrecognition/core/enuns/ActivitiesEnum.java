package br.ufba.activityrecognition.core.enuns;

public enum ActivitiesEnum {
	
	DOWNSTAIRS(1,"Downstairs"),RUNNING(2,"Running"),SITTING(3,"Sitting"),STANDING(4,"Standing"),UPSTAIRS(5,"Upstairs"),WALKING(6,"Walking");
	
	private Integer	codigo;
	private String nome;
	
	private ActivitiesEnum(Integer codigo,String nome){
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
