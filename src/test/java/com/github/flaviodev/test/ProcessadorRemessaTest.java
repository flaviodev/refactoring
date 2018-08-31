package com.github.flaviodev.test;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.github.flaviodev.refactoring.model.Remessa;
import com.github.flaviodev.refactoring.model.TituloCobranca;
import com.github.flaviodev.refactoring.model.base.JPAUtil;
import com.github.flaviodev.refactoring.model.registros.ProcessadorRemessa;

public class ProcessadorRemessaTest {

	private Logger logger = Logger.getLogger(ProcessadorRemessaTest.class);

	@SuppressWarnings("unchecked")
	@Test
	public void deveProcessarRemessa() {
		ProcessadorRemessa processador = ProcessadorRemessa.get();

		processador.processaRemessa(getClass().getClassLoader().getResourceAsStream("CB01012018.REM"));

		logger.info("\n\n--------------------------------------------------------------------------\n\n");

		JPAUtil.createCriteria(Remessa.class).list().forEach(logger::info);
		JPAUtil.createCriteria(TituloCobranca.class).list().forEach(logger::info);
	}

}
