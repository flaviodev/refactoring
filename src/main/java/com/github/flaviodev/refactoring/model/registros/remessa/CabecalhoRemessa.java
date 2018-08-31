package com.github.flaviodev.refactoring.model.registros.remessa;

import org.apache.log4j.Logger;

import com.github.flaviodev.refactoring.builder.ConvenioBuilder;
import com.github.flaviodev.refactoring.builder.RemessaBuilder;
import com.github.flaviodev.refactoring.model.Cedente;
import com.github.flaviodev.refactoring.model.Remessa;
import com.github.flaviodev.refactoring.model.registros.base.Cabecalho;
import com.github.flaviodev.refactoring.tipo.Banco;
import com.github.flaviodev.refactoring.tipo.TipoRegistro;

public class CabecalhoRemessa extends Cabecalho {

	private Logger logger = Logger.getLogger(CabecalhoRemessa.class);

	public CabecalhoRemessa(String registroDoArquivo) {
		super(registroDoArquivo);
	}

	@Override
	public TipoRegistro getTipo() {
		return TipoRegistro.CABECALHO_REMESSA;
	}

	@Override
	public Remessa processaRegistroArquivo() {

		String registro = getRegistroDoArquivo();

		RemessaBuilder builder = getBuilderRegistro();

		ConvenioBuilder convenioBuilder = new ConvenioBuilder();
		convenioBuilder.comNumero(registro.substring(10, 20)).naAgencia(registro.substring(148, 153).trim())
				.noBanco(Banco.getPeloNumero(registro.substring(125, 128)))
				.paraCedente(new Cedente(registro.substring(20, 111).trim(), registro.substring(111, 125).trim()))
				.paraConta(registro.substring(153, 163).trim());

		builder.comSequencia(Long.parseLong(registro.substring(2, 10))).doConvenio(convenioBuilder.constroi())
				.naData(toDate(registro.substring(163, 171)));

		Remessa remessa = processaRegistroVinculado(builder.constroi());
		setRemessa(remessa);

		logger.info(remessa);

		return remessa;
	}

}
