package Calculadora.model;

public class Calculadora implements IOperacaoMatematica{

	@Override
	public double soma(double a, double b) {
		double soma = a+b;
		System.out.println(soma);
		return 0;
	}

	@Override
	public double subtracao(double a, double b) {
		return a-b;
	}

	@Override
	public double multiplicacao(double a, double b) {
		return a*b;
	}

	@Override
	public double divisao(double a, double b) {
		if (b == 0) {
			System.out.println("Divisão Indeterminada");
		}
		else {
			return a/b;
		}
			
		return 0;
	}

}
