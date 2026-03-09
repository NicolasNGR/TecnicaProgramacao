package Questao8.view;
import Questao8.model.*;

public class MainC {

	public static void main(String[] args) {
		String[] tipos = {"Gasolina", "Etanol", "Diesel"};
        double[] precos = {5.89, 3.79, 4.99};
        int[] litros = {12000, 8000, 15000};

        PostoCombustivel posto = new PostoCombustivel(tipos, precos, litros);

        System.out.println("Situação inicial:");
        posto.listar();

        System.out.println("\nTotal em estoque: R$ " + String.format("%.2f", posto.totalEmEstoque()));

        System.out.println("\nMaior e menor estoque:");
        System.out.println(posto.maiorMenorEstoque());

        System.out.println("\nVendendo 500 L de Gasolina: " + (posto.vender("Gasolina", 500) ? "OK" : "Falhou"));
        System.out.println("Vendendo 9000 L de Etanol: " + (posto.vender("Etanol", 9000) ? "OK" : "Falhou"));

        System.out.println("\nApós vendas:");
        posto.listar();

        System.out.println("\nReabastecendo 3000 L de Etanol: " + (posto.reabastecer("Etanol", 3000) ? "OK" : "Falhou"));

        System.out.println("\nApós reabastecimento:");
        posto.listar();

        System.out.println("\nTotal em estoque: R$ " + String.format("%.2f", posto.totalEmEstoque()));
        System.out.println("\nMaior e menor estoque:");
        System.out.println(posto.maiorMenorEstoque());
	}

}
