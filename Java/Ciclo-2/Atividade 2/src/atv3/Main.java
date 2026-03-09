package atv3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[][] mat1 = new int[3][3];
		int cont = 1;
		
		System.out.println("Insira os valores da matriz: ");
		for (int L = 0; L < 3; L++) {
			System.out.println("Linha " + cont);
			
			for (int C = 0; C < 3; C++) {
				mat1 [C][L] = scan.nextInt();
			}
			
			cont++;
			System.out.println();
		}
		
		System.out.println("Matriz antes da transposição");
		for (int L = 0; L < 3; L++) {
			
			for (int C = 0; C < 3; C++) {
			System.out.print(" | " + mat1[C][L]);
			}
			System.out.println();
		}
		
		int[][] matR = new int[3][3];
		
		for (int L = 0; L < 3; L++) {
			
			for (int C = 0; C < 3; C++) {
				matR [C][L] = mat1[L][C];
			}
		}
		
		System.out.println("");
		
		System.out.println("Matriz depois da transposição");
		for (int L = 0; L < 3; L++) {
			
			for (int C = 0; C < 3; C++) {
			System.out.print(" | " + matR[C][L]);
			}
			System.out.println();
		}
		
		scan.close();
	}

}
