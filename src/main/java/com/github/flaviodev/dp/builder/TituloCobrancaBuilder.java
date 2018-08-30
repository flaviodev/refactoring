package com.github.flaviodev.dp.builder;

import java.math.BigDecimal;
import java.util.Date;

import com.github.flaviodev.dp.model.Remessa;
import com.github.flaviodev.dp.model.Sacado;
import com.github.flaviodev.dp.model.TituloCobranca;
import com.github.flaviodev.dp.tipo.EstadoTitulo;

public class TituloCobrancaBuilder implements BuilderRegistro<String,TituloCobranca> {
	private String numero;
	private Remessa remessa;
	private Sacado sacado;
	private Date dataVencimento;
	private BigDecimal valor;
	private BigDecimal valorMultaAtraso;
	private BigDecimal percentualJurosDia;
	private Date dataLiquidacao;
	private BigDecimal valorRecebido;
	private EstadoTitulo estado;

	public TituloCobrancaBuilder comNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public TituloCobrancaBuilder naRemessa(Remessa remessa) {
		this.remessa = remessa;
		return this;
	}

	public TituloCobrancaBuilder doSacado(Sacado sacado) {
		this.sacado = sacado;
		return this;
	}
	
	public TituloCobrancaBuilder comVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
		return this;
	}

	public TituloCobrancaBuilder comValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}

	public TituloCobrancaBuilder comMulta(BigDecimal valorMultaAtraso) {
		this.valorMultaAtraso = valorMultaAtraso;
		return this;
	}

	public TituloCobrancaBuilder comJurosDia(BigDecimal percentualJurosDia) {
		this.percentualJurosDia = percentualJurosDia;
		return this;
	}

	public TituloCobrancaBuilder liquidadoEm(Date dataLiquidacao) {
		this.dataLiquidacao = dataLiquidacao;
		return this;
	}

	public TituloCobrancaBuilder comValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
		return this;
	}

	public TituloCobrancaBuilder noEstado(EstadoTitulo estado) {
		this.estado = estado;
		return this;
	}
	
	@Override
	public TituloCobrancaBuilder populaRegistro(TituloCobranca titulo) {
		
		if(titulo == null)
			return this;
		
		if(titulo.getDataLiquidacao()!=null)
			dataLiquidacao = titulo.getDataLiquidacao();
		
		if(titulo.getDataVencimento()!=null)
			dataVencimento = titulo.getDataVencimento();
			
		if(titulo.getEstado()!=null)
			estado = titulo.getEstado();
		
		if(titulo.getNumero()!=null)
			numero = titulo.getNumero();
		
		if(titulo.getPercentualJurosDia()!=null)
			percentualJurosDia = titulo.getPercentualJurosDia();
		
		if(sacado == null) 
			sacado = new Sacado();

		if(titulo.getSacado()!=null && titulo.getSacado().getNomeRazaoSocial()!=null) 
			sacado.setNomeRazaoSocial(titulo.getSacado().getNomeRazaoSocial());

		if(titulo.getSacado()!=null && titulo.getSacado().getCpfCnpj()!=null) 
			sacado.setCpfCnpj(titulo.getSacado().getCpfCnpj());
		
		if(titulo.getSacado()!=null && titulo.getSacado().getEmail()!=null) 
			sacado.setEmail(titulo.getSacado().getEmail());
		
		if(titulo.getValor()!=null)
			valor = titulo.getValor();
		
		if(titulo.getValorMultaAtraso()!=null)
			valorMultaAtraso = titulo.getValorMultaAtraso();
		
		if(titulo.getValorRecebido()!=null)
			valorMultaAtraso = titulo.getValorRecebido();
		
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
