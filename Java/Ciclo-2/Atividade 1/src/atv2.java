import java.util.Scanner;

public class atv2 {

		public static void main(String[] args) {
			
			int num1, num2;
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Digite o 1º valor: ");
			num1 = scan.nextInt();
			
			System.out.println("Digite o 2º valor: ");
			num2 = scan.nextInt();
			
			if (num1 > num2) {
				System.out.println(num1 + " é maior que " + num2);
			} else if (num1 < num2) {
				System.out.println(num2 + " é maior que " + num1);
			} else {
				System.out.println("Ambos os valores (" + num1 + ") são iguais.");
			}
			
			scan.close();
		}
}