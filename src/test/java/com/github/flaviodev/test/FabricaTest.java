package com.github.flaviodev.test;

import com.github.flaviodev.dp.model.Cliente;

public class FabricaTest {

	private FabricaTest() {

	}

	public static Cliente criaCliente() {
		
		return new Cliente("Flávio Almeida", "111.111.111-11", "flavio@almeida.com.br");
	}

}
