
import java.util.Scanner;

public class atv1 {
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num;
		
		System.out.println("Digite um número: ");
		num = scan.nextInt();
		
		if (num > 0) {
			System.out.println("Seu número é positivo");
		}
		else if (num < 0) {
			System.out.println("Seu número é negativo");
		}
		else {
			System.out.println("Seu número é nulo");
		}
		
		scan.close();
	}

}
