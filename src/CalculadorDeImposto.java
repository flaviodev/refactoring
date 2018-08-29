
public class CalculadorDeImposto {

	public void realizaCalculo(Orcamento orcamento, String tipoImposto) {

		if (tipoImposto.equals("ICMS")) {
			double icms = orcamento.getValor() * 0.1;
			System.out.println(icms);
		} else if (tipoImposto.equals("ISS")) {
			double iss = orcamento.getValor() * 0.6;
			System.out.println(iss);
		}

	}

}
