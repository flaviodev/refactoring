package com.github.flaviodev.refactoring.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.github.flaviodev.refactoring.model.base.EntidadeBase;
import com.github.flaviodev.refactoring.tipo.EstadoTitulo;

@Entity
public class TituloCobranca extends EntidadeBase<String> {

	private static final long serialVersionUID = 987684112407950607L;

	@Id
	@GeneratedValue(generator = "UUIDGenerator")
	@GenericGenerator(name = "UUIDGenerator", strategy = "com.github.flaviodev.refactoring.model.base.UUIDGenerator")
	@Column(name = "id_titulo", length = 32)
	private String id;

	@Column(nullable = false, length = 10)
	private String numero;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Remessa remessa;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Sacado sacado;

	@Temporal(TemporalType.DATE)
	@Basic(fetch = FetchType.LAZY, optional = false)
	private Date dataVencimento;

	private BigDecimal valor;

	private BigDecimal valorMultaAtraso;

	private BigDecimal percentualJurosDia;

	@Temporal(TemporalType.DATE)
	@Basic(fetch = FetchType.LAZY, optional = false)
	private Date dataLiquidacao;

	private BigDecimal valorRecebido;

	@Enumerated(EnumType.STRING)
	@Basic(fetch = FetchType.LAZY, optional = false)
	@Column(length = 20)
	private EstadoTitulo estado;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Remessa getRemessa() {
		return remessa;
	}

	public void setRemessa(Remessa remessa) {
		this.remessa = remessa;
	}

	public Sacado getSacado() {
		return sacado;
	}

	public void setSacado(Sacado sacado) {
		this.sacado = sacado;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorMultaAtraso() {
		return valorMultaAtraso;
	}

	public void setValorMultaAtraso(BigDecimal valorMultaAtraso) {
		this.valorMultaAtraso = valorMultaAtraso;
	}

	public BigDecimal getPercentualJurosDia() {
		return percentualJurosDia;
	}

	public void setPercentualJurosDia(BigDecimal percentualJurosDia) {
		this.percentualJurosDia = percentualJurosDia;
	}

	public Date getDataLiquidacao() {
		return dataLiquidacao;
	}

	public void setDataLiquidacao(Date dataLiquidacao) {
		this.dataLiquidacao = dataLiquidacao;
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public EstadoTitulo getEstado() {
		return estado;
	}

	public void setEstado(EstadoTitulo estado) {
		this.estado = estado;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return String.format(
				"TituloCobranca [id=%s, numero=%s, remessa=%s, sacado=%s, dataVencimento=%s, valor=%s, valorMultaAtraso=%s, percentualJurosDia=%s, dataLiquidacao=%s, valorRecebido=%s, estado=%s]",
				id, numero, remessa, sacado, dataVencimento, valor, valorMultaAtraso, percentualJurosDia,
				dataLiquidacao, valorRecebido, estado);
	}
	
	
}
