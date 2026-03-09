package Questao6.view;
import Questao6.model.*;

public class MainC {

	public static void main(String[] args) {
		Celular c = new Celular();
        c.marca = "Samsung";
        c.modelo = "Galaxy A55";
        c.preco = 1999.90;
        System.out.println("Marca: " + c.marca);
        System.out.println("Modelo: " + c.modelo);
        System.out.println("Preço: R$ " + String.format("%.2f", c.preco));
	}

}
