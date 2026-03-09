import java.util.Scanner;

public class atv5 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num;
		
		System.out.println("Digite um número: ");
		num = scan.nextInt();
		
		if (num%2 == 0) {
			System.out.println("Seu número é par");
		}
		else if (num%2 != 0) {
			System.out.println("Seu número é impar");
		}
		
		scan.close();

	}

}
