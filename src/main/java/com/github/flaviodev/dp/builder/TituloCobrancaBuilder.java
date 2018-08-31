package com.github.flaviodev.dp.builder;

import java.math.BigDecimal;
import java.util.Date;

import com.github.flaviodev.dp.model.Remessa;
import com.github.flaviodev.dp.model.Sacado;
import com.github.flaviodev.dp.model.TituloCobranca;
import com.github.flaviodev.dp.tipo.EstadoTitulo;

public class TituloCobrancaBuilder implements RegistroBuilder<String, TituloCobranca> {
	private String numero;
	private Remessa remessa;
	private Sacado sacado;
	private Date dataVencimento;
	private BigDecimal valor;
	private BigDecimal valorMultaAtraso;
	private BigDecimal percentualJurosDia;
	private Date dataLiquidacao;
	private BigDecimal valorRecebido;
	private EstadoTitulo estado = EstadoTitulo.AGUARDANDO;

	public TituloCobrancaBuilder comNumero(String numero) {
		if (numero != null)
			this.numero = numero;

		return this;
	}

	public TituloCobrancaBuilder naRemessa(Remessa remessa) {
		if (remessa != null)
			this.remessa = remessa;

		return this;
	}

	public TituloCobrancaBuilder doSacado(Sacado sacado) {

		if (this.sacado == null)
			this.sacado = sacado;
		else
			atualizaSacado(sacado);

		return this;
	}

	private void atualizaSacado(Sacado sacado) {
		if (sacado == null)
			return;

		if (sacado.getNomeRazaoSocial() != null)
			this.sacado.setNomeRazaoSocial(sacado.getNomeRazaoSocial());

		if (sacado.getCpfCnpj() != null)
			this.sacado.setCpfCnpj(sacado.getCpfCnpj());

		if (sacado.getEmail() != null)
			this.sacado.setEmail(sacado.getEmail());
	}

	public TituloCobrancaBuilder comVencimento(Date dataVencimento) {
		if (dataVencimento != null)
			this.dataVencimento = dataVencimento;

		return this;
	}

	public TituloCobrancaBuilder comValor(BigDecimal valor) {
		if (valor != null)
			this.valor = valor;

		return this;
	}

	public TituloCobrancaBuilder comMulta(BigDecimal valorMultaAtraso) {
		if (valorMultaAtraso != null)
			this.valorMultaAtraso = valorMultaAtraso;

		return this;
	}

	public TituloCobrancaBuilder comJurosDia(BigDecimal percentualJurosDia) {
		if (percentualJurosDia != null)
			this.percentualJurosDia = percentualJurosDia;

		return this;
	}

	public TituloCobrancaBuilder liquidadoEm(Date dataLiquidacao) {
		if (dataLiquidacao != null)
			this.dataLiquidacao = dataLiquidacao;

		return this;
	}

	public TituloCobrancaBuilder comValorRecebido(BigDecimal valorRecebido) {
		if (valorRecebido != null)
			this.valorRecebido = valorRecebido;

		return this;
	}

	public TituloCobrancaBuilder noEstado(EstadoTitulo estado) {
		if (estado != null)
			this.estado = estado;

		return this;
	}

	@Override
	public TituloCobrancaBuilder comDadosDeOutraEntidade(TituloCobranca titulo) {

		if (titulo == null)
			return this;

		naRemessa(titulo.getRemessa());
		liquidadoEm(titulo.getDataLiquidacao());
		comVencimento(titulo.getDataVencimento());
		noEstado( titulo.getEstado());
		comNumero(titulo.getNumero());
		comJurosDia(titulo.getPercentualJurosDia());
		doSacado(titulo.getSacado());
		comValor(titulo.getValor());
		comMulta(titulo.getValorMultaAtraso());
		comValorRecebido(titulo.getValorRecebido());

		return this;
	}

	@Override
	public TituloCobranca constroi() {

		TituloCobranca titulo = new TituloCobranca();
		titulo.setDataLiquidacao(dataLiquidacao);
		titulo.setDataVencimento(dataVencimento);
		titulo.setEstado(estado);
		titulo.setNumero(numero);
		titulo.setPercentualJurosDia(percentualJurosDia);
		titulo.setRemessa(remessa);
		titulo.setSacado(sacado);
		titulo.setValor(valor);
		titulo.setValorMultaAtraso(valorMultaAtraso);
		titulo.setValorRecebido(valorRecebido);

		return titulo;
	}
}
