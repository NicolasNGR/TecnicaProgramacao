package Pagamento.model;

public class pagamentoCartao implements IPagamento {

	private double valor;

	public pagamentoCartao(double valor) {
		this.valor = valor;
	}

	@Override
	public double calcularPagamento() {
		double taxa = 0.05;
		return valor * (1 + taxa);
	}

	@Override
	public String emitirRecibo() {
		return (
			    "--------------------------------------\n" +
			    "           RECIBO - CARTÃO           \n" +
			    "--------------------------------------\n" +
			    "Valor Base:    R$ " + this.valor + "\n" +
			    "Taxa (5%):     R$ " + Math.abs((this.valor-calcularPagamento())) + "\n" +
			    "Valor Final:   R$ " + calcularPagamento() + "\n" +
			    "--------------------------------------"
			);
	}
}
