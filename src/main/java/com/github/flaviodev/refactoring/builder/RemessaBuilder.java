package com.github.flaviodev.refactoring.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.flaviodev.refactoring.model.Convenio;
import com.github.flaviodev.refactoring.model.Remessa;
import com.github.flaviodev.refactoring.model.TituloCobranca;

public class RemessaBuilder extends RegistroBuilder<String, Remessa> {

	private Long sequencia;
	private Convenio convenio;
	private Date data;
	private List<TituloCobranca> titulos;


	public RemessaBuilder() {
		titulos = new ArrayList<>();
	}

	public RemessaBuilder comSequencia(Long sequencia) {
		if (sequencia != null)
			this.sequencia = sequencia;

		return this;
	}

	public RemessaBuilder doConvenio(Convenio convenio) {
		if (convenio != null)
			this.convenio = convenio;

		return this;
	}

	public RemessaBuilder naData(Date data) {
		if (data != null)
			this.data = data;

		return this;
	}

	public RemessaBuilder adicionaTitulo(TituloCobranca titulo) {
		this.titulos.add(titulo);

		return this;
	}
	
	@Override
	public RemessaBuilder comDadosDeOutraEntidade(Remessa remessa) {

		if (remessa == null)
			return this;

		comSequencia(remessa.getSequencia());
		doConvenio(remessa.getConvenio());
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

		getAcoesAoConstruir().forEach(acao -> acao.executa(remessa));
		
		return remessa;
	}
}
