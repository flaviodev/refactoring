package com.github.flaviodev.dp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.github.flaviodev.dp.model.base.BaseEntity;

@Entity
public class Remessa extends BaseEntity<String> {

	private static final long serialVersionUID = 6548684112407950607L;

	@Id
	@GeneratedValue(generator = "UUIDGenerator")
	@GenericGenerator(name = "UUIDGenerator", strategy = "com.github.flaviodev.dp.model.base.UUIDGenerator")
	@Column(name = "id_remessa", length = 32)
	private String id;

	@Basic(optional = false)
	private Long sequencia;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Convenio convenio;

	@Temporal(TemporalType.DATE)
	@Basic(fetch = FetchType.LAZY, optional = false)
	private Date data;

	@OneToMany(fetch = FetchType.LAZY)
	private List<TituloCobranca> titulos;

	public Remessa() {

	}

	public Remessa(Long sequencia, Convenio convenio, Date data) {
		this.sequencia = sequencia;
		this.convenio = convenio;
		this.data = data;
	}

	@Override
	public String getId() {
		return id;
	}

	public Long getSequencia() {
		return sequencia;
	}

	public void setSequencia(Long sequencia) {
		this.sequencia = sequencia;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<TituloCobranca> getTitulos() {
		if (titulos == null)
			titulos = new ArrayList<>();

		return titulos;
	}

	public void setTitulos(List<TituloCobranca> titulos) {
		this.titulos = titulos;
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
		return String.format("Remessa [id=%s, sequencia=%s, convenio=%s, data=%s]", id, sequencia, convenio,
				data);
	}
	
	
}
