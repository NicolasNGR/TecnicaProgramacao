import java.util.Scanner;

public class atv6 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o número para fatoriar: ");
		int n = scan.nextInt();
		
		long resultado = 1;
		
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
		
		System.out.println(n + "! = " + resultado);
		
		scan.close();

	}

}
