package com.github.flaviodev.refactoring.model.registros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.EnumMap;

import org.apache.log4j.Logger;

import com.github.flaviodev.refactoring.model.registros.base.Cabecalho;
import com.github.flaviodev.refactoring.model.registros.base.Registro;
import com.github.flaviodev.refactoring.model.registros.remessa.CabecalhoRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaEmail;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaMulta;
import com.github.flaviodev.refactoring.tipo.TipoRegistro;

@SuppressWarnings("rawtypes")
public class ProcessadorRemessa {

	private Logger logger = Logger.getLogger(ProcessadorRemessa.class);

	EnumMap<TipoRegistro, Registro> utltimoRegistroPorTipo = new EnumMap<>(TipoRegistro.class);

	private ProcessadorRemessa() {

	}

	public static ProcessadorRemessa get() {
		return new ProcessadorRemessa();
	}

	public Cabecalho processaRemessa(String caminhoArquivoRemessa) throws FileNotFoundException {
		return processaRemessa(new File(caminhoArquivoRemessa));
	}

	public Cabecalho processaRemessa(File arquivoRemessa) throws FileNotFoundException {
		return processaRemessa(new InputStreamReader(new FileInputStream(arquivoRemessa)));
	}

	public Cabecalho processaRemessa(InputStream inputStreamRemessa) {
		if (inputStreamRemessa == null)
			throw new IllegalArgumentException("InputStream da remessa não pode ser vazio!");

		return processaRemessa(new InputStreamReader(inputStreamRemessa));
	}

	public Cabecalho processaRemessa(InputStreamReader inputStreamReaderRemessa) {

		try (BufferedReader br = new BufferedReader(inputStreamReaderRemessa)) {

			String linha = null;

			while ((linha = br.readLine()) != null) {

				TipoRegistro tipo = getTipoRegistro(linha);

				if (tipo == null)
					continue;

				Registro registro = null;

				switch (tipo) {
				case CABECALHO_REMESSA:
					CabecalhoRemessa cabecalhoRemessa = new CabecalhoRemessa(linha);
					cabecalhoRemessa.processaRegistroArquivo();
					registro = cabecalhoRemessa;
					break;

				case DETALHE_REMESSA:
					DetalheRemessa detalheRemessa = new DetalheRemessa(linha,
							((CabecalhoRemessa) utltimoRegistroPorTipo.get(TipoRegistro.CABECALHO_REMESSA))
									.getRemessa());
					detalheRemessa.processaRegistroArquivo();
					registro = detalheRemessa;
					break;

				case DETALHE_REMESSA_DADOS_MULTA:
					DetalheRemessaMulta detalheRemessaMulta = new DetalheRemessaMulta(linha,
							(DetalheRemessa) utltimoRegistroPorTipo.get(TipoRegistro.DETALHE_REMESSA));
					detalheRemessaMulta.processaRegistroArquivo();
					registro = detalheRemessaMulta;
					break;

				case DETALHE_REMESSA_EMAIL_SACADO:
					DetalheRemessaEmail detalheRemessaEmail = new DetalheRemessaEmail(linha,
							(DetalheRemessa) utltimoRegistroPorTipo.get(TipoRegistro.DETALHE_REMESSA));
					detalheRemessaEmail.processaRegistroArquivo();
					registro = detalheRemessaEmail;
					break;

				default:
					break;
				}

				utltimoRegistroPorTipo.put(tipo, registro);

				logger.info(linha);
			}
		} catch (IOException e) {
			logger.error(e);
		}

		return null;
	}

	private boolean isLinhaRegistroValida(String linhaRegistro) {
		return linhaRegistro != null && linhaRegistro.length() == 200;
	}

	private TipoRegistro getTipoRegistro(String linhaRegistro) {
		if (!isLinhaRegistroValida(linhaRegistro))
			return null;

		return TipoRegistro.getPeloCodigo(linhaRegistro.substring(0, 2));
	}

}
