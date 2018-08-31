package com.github.flaviodev.refactoring.observer;

import org.apache.log4j.Logger;

import com.github.flaviodev.refactoring.model.TituloCobranca;
import com.github.flaviodev.refactoring.observer.base.EntidadeBaseObserver;

public class EnviaBoletoParaClienteObserver implements EntidadeBaseObserver<String, TituloCobranca> {

	private Logger logger = Logger.getLogger(EnviaBoletoParaClienteObserver.class);

	@Override
	public TituloCobranca executa(TituloCobranca titulo) {

		logger.info("=====================================================================");
		logger.info("Enviando boleto para Cliente:  " + titulo.getSacado().getEmail());
		logger.info("=====================================================================\n\n");

		return titulo;
	}
}
