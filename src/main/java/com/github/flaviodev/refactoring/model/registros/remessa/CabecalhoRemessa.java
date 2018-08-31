package com.github.flaviodev.refactoring.model.registros.remessa;

import org.apache.log4j.Logger;

import com.github.flaviodev.refactoring.builder.ConvenioBuilder;
import com.github.flaviodev.refactoring.builder.RemessaBuilder;
import com.github.flaviodev.refactoring.model.Cedente;
import com.github.flaviodev.refactoring.model.Remessa;
import com.github.flaviodev.refactoring.model.registros.base.Cabecalho;
import com.github.flaviodev.refactoring.model.registros.base.Registro;
import com.github.flaviodev.refactoring.observer.PersisteRemessaObserver;
import com.github.flaviodev.refactoring.tipo.Banco;
import com.github.flaviodev.refactoring.tipo.TipoRegistro;

public class CabecalhoRemessa extends Cabecalho {

	private Logger logger = Logger.getLogger(CabecalhoRemessa.class);

	public CabecalhoRemessa() {
		getBuilderRegistro().adicionaAcaoAoConstruir(new PersisteRemessaObserver());
	}
	

	@Override
	public TipoRegistro getTipo() {
		return TipoRegistro.CABECALHO_REMESSA;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Remessa processaRegistroArquivo(String registroDoArquivo, Registro registroVinculado) {
		setRegistroVinculado(registroVinculado);
		
		RemessaBuilder builder = getBuilderRegistro();

		ConvenioBuilder convenioBuilder = new ConvenioBuilder();
		convenioBuilder.comNumero(registroDoArquivo.substring(10, 20)).naAgencia(registroDoArquivo.substring(148, 153).trim())
				.noBanco(Banco.getPeloNumero(registroDoArquivo.substring(125, 128)))
				.paraCedente(new Cedente(registroDoArquivo.substring(20, 111).trim(), registroDoArquivo.substring(111, 125).trim()))
				.paraConta(registroDoArquivo.substring(153, 163).trim());

		builder.comSequencia(Long.parseLong(registroDoArquivo.substring(2, 10))).doConvenio(convenioBuilder.constroi())
				.naData(toDate(registroDoArquivo.substring(163, 171)));

		Remessa remessa = processaRegistroVinculado(builder.constroi());
		setRemessa(remessa);

		logger.info(remessa);

		return remessa;
	}

}
