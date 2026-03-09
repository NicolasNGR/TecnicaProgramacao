package Questao6.view;
import Questao6.model.*;

public class MainA {

	public static void main(String[] args) {
        Carro c = new Carro();
        c.marca = "Fiat";
        c.modelo = "Pulse";
        c.ano = 2024;
        System.out.println("Marca: " + c.marca);
        System.out.println("Modelo: " + c.modelo);
        System.out.println("Ano: " + c.ano);
	}

}
