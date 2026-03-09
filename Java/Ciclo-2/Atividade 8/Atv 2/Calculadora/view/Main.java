package Calculadora.view;
import Calculadora.model.*;

public class Main {

	public static void main(String[] args) {
		
		Calculadora c = new Calculadora();
		
		System.out.println("Soma de 2 inteiros: " + c.somar(5, 10));         
        System.out.println("Soma de 3 inteiros: " + c.somar(3, 7, 2));       
        System.out.println("Soma de 2 doubles: " + c.somar(4.5, 2.3));

	}

}
