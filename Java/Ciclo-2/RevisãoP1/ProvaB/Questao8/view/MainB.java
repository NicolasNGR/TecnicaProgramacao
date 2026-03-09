package Questao8.view;
import Questao8.model.*;

public class MainB {

	public static void main(String[] args) {
		String[] nomes = {"Arroz 5kg", "Feijão 1kg", "Café 500g", "Leite 1L"};
        double[] precos = {29.90, 8.50, 17.80, 4.99};
        double[] descontos = {0.10, 0.05, 0.15, 0.00};

        Supermercado s = new Supermercado(nomes, precos, descontos);

        System.out.println("Lista inicial:");
        s.listarProdutos();

        System.out.println("\nTotal com desconto: R$ " + String.format("%.2f", s.totalComDesconto()));

        System.out.println("\nProduto com maior economia: " + s.produtoMaiorEconomia());

        System.out.println("\nComprando 'Café 500g': " + (s.comprar("Café 500g") ? "OK" : "Não encontrado"));
        s.listarProdutos();

        System.out.println("\nRepondo 'Café 500g':");
        s.repor("Café 500g", 17.80, 0.15);
        s.listarProdutos();
	}

}
