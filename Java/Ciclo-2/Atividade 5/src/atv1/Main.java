package atv1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int opc;
		String opc2;
		boolean program = true;
		
		Carro carro = new Carro("Renault Kwid", 2024, 37, 37);
        carro.info();
		System.out.println("");
		System.out.println("Escolha o que fazer: \n"
				  		 + "1. Ligar\n"
						 + "2. Desligar\n"
						 + "3. Acelerar\n"
						 + "4. Frear\n"
						 + "5. Buzinar.\n"
						 + "6. Abastecer.\n"
						 + "7. Ver Gasolina\n"
						 + "0. Exibir restante do programa\n");
		
		while (program) {
			opc = scan.nextInt();
			
			switch (opc) {
				case 1: 
					carro.ligar();
					break;
					
				case 2:
					carro.desligar();
					break;
	
				case 3:
					carro.acelerar();
					break;
					
				case 4:
					carro.frear();
					break;
					
				case 5:
					carro.buzinar();
					break;
					
				case 6:
			        System.out.println("Custo para encher o tanque: R$" + carro.calcularValorTotal(5.79) 
			        + "Abastecer? S/N");
			        opc2 = scan.next().toUpperCase();
			        switch (opc2) {
			        	case "S":
			        		carro.abastecerTanque(carro.atualTanque, carro.capacidadeTanque);
			        		System.out.println("Tanque cheio!");
			        		break;
			        		
			        	case "N":
			        		System.out.println("Saindo...");
			        		break;
			        }
			        break;
			       
				case 7:
					System.out.println("Capacidade: " + carro.getCapacidadeTanque() +"L\nAtual: " + carro.getAtualTanque() + "L");
					break;
					
				case 0:
					program = false;
					break;
					
				default:
					System.out.println("Opção inválida!");
					break;
			}
		}
		
		// Testando ContaBancaria
        ContaBancaria conta = new ContaBancaria("João", 1000);
        conta.depositar(500);
        conta.sacar(300);
        conta.sacar(2000);
        System.out.println("Saldo final da conta de " + conta.getTitular() + ": R$" + conta.getSaldo());

        System.out.println("---------------------------------");

        // Testando Produto
        Produto produto = new Produto("Notebook", 3500, 10);
        produto.setPreco(-100); // teste inválido
        produto.setQuantidadeEstoque(-5); // teste inválido
        System.out.println("Produto: " + produto.getNome() + " | Preço: R$" + produto.getPreco() + " | Estoque: " + produto.getQuantidadeEstoque());
			
		scan.close();
	}

}
