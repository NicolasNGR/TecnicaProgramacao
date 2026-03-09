import java.util.Scanner;

public class atv8 {

	public static void main(String[] args) {

		        Scanner scan = new Scanner(System.in);
		        
		        System.out.print("Digite um número inteiro positivo (n): ");
		        int n = scan.nextInt();
		        
		        if (n <= 0) {
		            System.out.println("Por favor, digite um número positivo maior que zero.");
		        } else {
		            int soma = 0;
		            int numeroImpar = 1;
		            
		            System.out.print("Soma dos primeiros " + n + " números ímpares: ");
		            
		            for (int i = 1; i <= n; i++) {
		                soma += numeroImpar;
		                
		                if (i == 1) {
		                    System.out.print(numeroImpar);
		                } else {
		                    System.out.print(" + " + numeroImpar);
		                }
		                
		                numeroImpar += 2;
		            }
		            
		            System.out.println(" = " + soma);
		        }
		        
		        scan.close();
		    }

}
