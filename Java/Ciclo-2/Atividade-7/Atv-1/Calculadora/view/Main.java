package Calculadora.view;
import Calculadora.model.Calculadora;

public class Main {

	public static void main(String[] args) {
		Calculadora c = new Calculadora();
		
		c.soma(1, 5);
		c.divisao(1, 0);

	}

}
