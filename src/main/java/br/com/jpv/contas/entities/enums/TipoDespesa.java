package br.com.jpv.contas.entities.enums;

public enum TipoDespesa {
	VARIAVEL(1),
	FIXA(2),
	OUTRA(3);
	
	private int code;
	
	private TipoDespesa (int code) {
		this.code=code;
	}
	
	public int getCode() {
		return code;
		
	}
	
	public static TipoDespesa valueOf (int code) {
		for(TipoDespesa value : TipoDespesa.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}

}
