package com.github.flaviodev.dp.model.registros.remessa;

import org.apache.log4j.Logger;

import com.github.flaviodev.dp.builder.RemessaBuilder;
import com.github.flaviodev.dp.model.Remessa;
import com.github.flaviodev.dp.model.registros.base.Cabecalho;

public class CabecalhoRemessa extends Cabecalho {

	private Logger logger = Logger.getLogger(CabecalhoRemessa.class);
	
	public CabecalhoRemessa(String registroDoArquivo) {
		super(registroDoArquivo);
	}

	@Override
	public Remessa processaRegistroArquivo() {
		
		RemessaBuilder builder = getBuilderRegistro().populaRegistro(processaDetalheVinculado());

		Remessa remessa = builder.constroi();

		logger.info(remessa);

		return remessa;
	}

}
