package com.ilanguilherme.cursomcmain.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1, "PF"),
	PESSOAJURIDICA(2,"PJ");
	
	private int cod;
	private String des;
	
	private TipoCliente(int cod, String des){
		this.cod = cod;
		this.des = des;
	}
	
	public int getCode() {
		return cod;
	}
	
	public String getDes() {
		return des;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		} for ( TipoCliente x : TipoCliente.values()) {
			if( cod.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" 
				 + cod);
		
	}


}
