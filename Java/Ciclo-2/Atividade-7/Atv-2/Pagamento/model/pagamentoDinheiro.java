package Pagamento.model;

public class pagamentoDinheiro implements IPagamento {
	
	private double valor;

	public pagamentoDinheiro(double valor) {
		this.valor = valor;
	}

	@Override
	public double calcularPagamento() {
		double desconto = 0.10;
		return valor - valor*desconto;
	}

	@Override
	public String emitirRecibo() {
		return (
			    "--------------------------------------\n" +
			    "           RECIBO - DINHEIRO           \n" +
			    "--------------------------------------\n" +
			    "Valor Base:     R$ " + this.valor + "\n" +
			    "Desconto (10%): R$ " + Math.abs(this.valor - calcularPagamento())  + "\n" +
			    "Valor Final:    R$ " + calcularPagamento() + "\n" +
			    "--------------------------------------"
			);
	}

}
