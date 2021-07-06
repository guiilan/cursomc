package com.ilanguilherme.cursomcmain.domain.enums;

public enum EstadoPagamento {
	PENDENTE(1, "PENDENTE"),
	QUITADO(2, "QUITADO"),
	CANCELADO(3, "CANCELADO");
	

	private int cod;
	private String des;
	
	private EstadoPagamento(int cod, String des){
		this.cod = cod;
		this.des = des;
	}
	
	public int getCode() {
		return cod;
	}
	
	public String getDes() {
		return des;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		} for ( EstadoPagamento x : EstadoPagamento.values()) {
			if( cod.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" 
				 + cod);
	}
}
