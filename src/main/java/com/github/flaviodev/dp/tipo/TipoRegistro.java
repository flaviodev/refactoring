package com.github.flaviodev.dp.tipo;

public enum TipoRegistro {
	CABECALHO_REMESSA("01"), 
	DETALHE_REMESSA("07"), 
	DETALHE_REMESSA_DADOS_MULTA("05"), 
	DETALHE_REMESSA_EMAIL_SACADO("77");

	private String codigo;

	private TipoRegistro(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public static TipoRegistro getPeloCodigo(String codigo) {
		for(TipoRegistro tipo : TipoRegistro.values()) {
			if(tipo.getCodigo().equals(codigo))
				return tipo;
		}
		
		return null;
	}
}
