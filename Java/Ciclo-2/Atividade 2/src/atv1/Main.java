package atv1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
	
	// A primeira chave são as linhas, a segunda são as colunas.
	int[][] mat1 = new int[3][3];
	int[][] mat2 = new int[3][3];
	int cont = 1;
	
	// Loop de inserção da primeira matriz
	System.out.println("Insira os valores da primeira matriz");
	for (int L = 0; L < 3; L++) {
		System.out.println("Linha " + cont);
		
		for (int C = 0; C < 3; C++) {
			mat1 [C][L] = scan.nextInt();
		}
		
		cont++;
		System.out.println();
	}
	
	cont = 1;
	System.out.println();
	
	// Loop de inserção da segunda matriz
	System.out.println("Insira os valores da segunda matriz");
	for (int L = 0; L < 3; L++) {
		System.out.println("Linha " + cont);
		
		for (int C = 0; C < 3; C++) {
			mat2 [C][L] = scan.nextInt();
		}
		
		cont++;
		System.out.println();
	}
	
	// Loop de soma das matrizes
	int[][] matR = new int[3][3];
	
	for (int L = 0; L < 3; L++) {
		
		for (int C = 0; C < 3; C++) {
			matR [C][L] = mat1[C][L] + mat2[C][L];
		}
	}
	
	System.out.println();
	
	// Exibir dados da matriz
	System.out.println("Resultado da soma de ambas as matrizes: ");
	for (int L = 0; L < 3; L++) {
			
			for (int C = 0; C < 3; C++) {
			System.out.print(" | " + matR[C][L]);
			}
			System.out.println();
		}
	
	scan.close();
 
	}

}
