package com.github.flaviodev.refactoring.tipo;

public enum TipoRegistro {
	CABECALHO_REMESSA("01", null), DETALHE_REMESSA("07", CABECALHO_REMESSA), DETALHE_REMESSA_DADOS_MULTA("05",
			DETALHE_REMESSA), DETALHE_REMESSA_EMAIL_SACADO("77", DETALHE_REMESSA);

	private String codigo;
	private TipoRegistro tipoVinculado;

	private TipoRegistro(String codigo, TipoRegistro tipoVinculado) {
		this.codigo = codigo;
		this.tipoVinculado = tipoVinculado;
	}

	public String getCodigo() {
		return codigo;
	}

	public TipoRegistro getTipoVinculado() {
		return tipoVinculado;
	}

	public static TipoRegistro getPeloCodigo(String codigo) {
		for (TipoRegistro tipo : TipoRegistro.values()) {
			if (tipo.getCodigo().equals(codigo))
				return tipo;
		}

		return null;
	}
}
