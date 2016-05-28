package br.ufba.activityrecognition.core.enuns;

public enum UsersEnum {
	
	IGOR(1,"Igor"),GEANE(2,"Geane"),ANTONIO(3,"Antonio"),PETALA(4,"Petala");
	
	private Integer	codigo;
	private String nome;
	
	private UsersEnum(Integer codigo,String nome){
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
