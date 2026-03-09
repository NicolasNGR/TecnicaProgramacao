package Questao8.view;
import Questao8.model.*;

public class Main {

	public static void main(String[] args) {
		String[] nomes = {"Paracetamol", "Ibuprofeno", "Amoxicilina", "Dipirona", "Omeprazol"};
        int[] dias = {3, 12, 2, 8, 4};
        double[] precos = {19.90, 25.50, 32.00, 14.75, 21.00};

        Farmacia f = new Farmacia(nomes, dias, precos);

        System.out.println("Lista inicial:");
        f.mostrarTodos();

        System.out.println("\nMédia de dias p/ vencimento: " + String.format("%.2f", f.mediaDiasParaVencimento()));

        System.out.println("\nPróximos de vencer (<5 dias):");
        for (String m : f.identificarProximosDeVencer(5)) System.out.println(m);

        System.out.println("\nAplicando desconto de 50% para próximos de vencer:");
        f.aplicarDescontoProximos(5);
        f.mostrarTodos();

        System.out.println("\nVendendo 'Omeprazol': " + (f.vender("Omeprazol") ? "OK" : "Não encontrado"));
        System.out.println("\nApós venda:");
        f.mostrarTodos();

	}

}
