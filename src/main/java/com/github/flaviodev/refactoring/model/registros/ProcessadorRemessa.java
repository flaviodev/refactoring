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

import com.github.flaviodev.refactoring.factory.RemessaEnvioFactory;
import com.github.flaviodev.refactoring.model.registros.base.Cabecalho;
import com.github.flaviodev.refactoring.model.registros.base.Registro;
import com.github.flaviodev.refactoring.tipo.Banco;
import com.github.flaviodev.refactoring.tipo.TipoRegistro;

@SuppressWarnings("rawtypes")
public class ProcessadorRemessa {

	private Logger logger = Logger.getLogger(ProcessadorRemessa.class);

	private EnumMap<TipoRegistro, Registro> utltimoRegistroPorTipo = new EnumMap<>(TipoRegistro.class);
	private InputStreamReader inputStreamReaderRemessa;
	private RemessaEnvioFactory remessaFactory;

	public ProcessadorRemessa(InputStreamReader inputStreamReaderRemessa) {
		if (inputStreamReaderRemessa == null)
			throw new IllegalArgumentException("InputStream da remessa não pode ser vazio!");

		this.inputStreamReaderRemessa = inputStreamReaderRemessa;
	}

	public ProcessadorRemessa(String caminhoArquivoRemessa) throws FileNotFoundException {
		this(new File(caminhoArquivoRemessa));
	}

	public ProcessadorRemessa(File arquivoRemessa) throws FileNotFoundException {
		this(new InputStreamReader(new FileInputStream(arquivoRemessa)));
	}

	public ProcessadorRemessa(InputStream inputStreamRemessa) {
		this(new InputStreamReader(inputStreamRemessa));
	}

	public Cabecalho processaRemessa() {

		try (BufferedReader br = new BufferedReader(inputStreamReaderRemessa)) {

			String linha = null;
			Banco banco = null;

			while ((linha = br.readLine()) != null) {

				if (banco == null) {
					banco = getBanco(linha);

					if (banco == null)
						throw new IllegalStateException("Banco não suportado");

					remessaFactory = banco.getRemessaFactory();

				}

				TipoRegistro tipo = getTipoRegistro(linha);

				if (tipo == null)
					continue;

				Registro registro = null;

				registro = remessaFactory.criaConformeOTipo(tipo);
				registro.processaRegistroArquivo(linha, utltimoRegistroPorTipo.get(tipo.getTipoVinculado()));

				utltimoRegistroPorTipo.put(tipo, registro);

				logger.info(linha);
			}
		} catch (IOException e) {
			logger.error(e);
		}

		return null;
	}

	private Banco getBanco(String linhaCabecalho) {
		TipoRegistro tipo = getTipoRegistro(linhaCabecalho);

		if (tipo != TipoRegistro.CABECALHO_REMESSA)
			throw new IllegalStateException("Erro ao tentar identificar o banco no cabeçalho do arquivo!");

		return Banco.getPeloNumero(linhaCabecalho.substring(125, 128));
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
