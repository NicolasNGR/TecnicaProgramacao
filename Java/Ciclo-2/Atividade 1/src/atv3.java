import java.util.Scanner;

public class atv3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
        
        System.out.println("MENU DE OPÇÕES");
        System.out.println("1. Calcular área do quadrado");
        System.out.println("2. Calcular área do círculo");
        System.out.print("Escolha uma opção (1 ou 2): ");
        
        int op = scan.nextInt();
        
        switch (op) {
        case 1: 
        	System.out.println("Digite o lado do quadrado: ");
        	double lado = scan.nextDouble();
        	System.out.println("A área do quadrado é: " + Math.pow(lado, 2));
        	break;
        	
        case 2: 
        	System.out.println("Digite o raio do círculo: ");
        	double raio = scan.nextDouble();
        	System.out.println("A área do círculo é: " + Math.PI * Math.pow(raio, 2));
        	break;
        	
        	default: 
        		System.out.println("Opção inválida!");
        		break;
        }
        
        scan.close();
	}

}
