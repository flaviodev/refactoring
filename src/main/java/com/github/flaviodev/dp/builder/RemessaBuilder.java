package com.github.flaviodev.dp.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.flaviodev.dp.model.Convenio;
import com.github.flaviodev.dp.model.Remessa;
import com.github.flaviodev.dp.model.Sacado;
import com.github.flaviodev.dp.model.TituloCobranca;

public class RemessaBuilder implements BuilderRegistro<String, Remessa> {

	private Long sequencia;
	private Convenio convenio;
	private Date data;
	private List<TituloCobranca> titulos;

	public RemessaBuilder() {
		titulos = new ArrayList<>();
	}

	public RemessaBuilder comSequencia(Long sequencia) {
		this.sequencia = sequencia;
		return this;
	}

	public RemessaBuilder doConvenio(Convenio convenio) {
		this.convenio = convenio;
		return this;
	}

	public RemessaBuilder naData(Date data) {
		this.data = data;
		return this;
	}

	public RemessaBuilder adicionaTitulo(TituloCobranca titulo) {
		this.titulos.add(titulo);
		return this;
	}

	@Override
	public RemessaBuilder populaRegistro(Remessa remessa) {
		
		if(remessa == null)
			return this;

		if (remessa.getSequencia() != null)
			comSequencia(remessa.getSequencia());

		if(convenio == null) 
			convenio = new Convenio();

	
		// FIXME implementar para convenio

	

		
		
		if (remessa.getData() != null)
			naData(remessa.getData());
		
		return this;
	}

	@Override
	public Remessa constroi() {

		Remessa remessa = new Remessa();
		remessa.setConvenio(convenio);
		remessa.setData(data);
		remessa.setSequencia(sequencia);
		remessa.setTitulos(titulos);

		return remessa;
	}
}
