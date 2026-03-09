package Pagamento.view;
import Pagamento.model.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double valor = 100;
		
		Scanner sc = new Scanner(System.in);
		pagamentoCartao pc = new pagamentoCartao(valor);
		pagamentoDinheiro pd = new pagamentoDinheiro(valor);
		
		System.out.println("=== ESCOLHA A FORMA DE PAGAMENTO ===");
		System.out.println("1 - Cartão");
		System.out.println("2 - Dinheiro");
		System.out.println("=> ");

		int op = sc.nextInt();

		switch (op) {
		    case 1:
		        System.out.println("=== PAGAMENTO COM CARTÃO ===");
		        System.out.println("");
		        System.out.println("Pagamento total: " + pc.calcularPagamento());
		        System.out.println(pc.emitirRecibo());
		        break;
		        
		    case 2:
		        System.out.println("=== PAGAMENTO COM DINHEIRO ===");
		        System.out.println("");
		        System.out.println("Pagamento total: " + pd.calcularPagamento());
		        System.out.println(pd.emitirRecibo());
		        break;
		        
		    default:
		        System.out.println("Opção inválida!");
		        break;
		}
		
		sc.close();
	}

}
