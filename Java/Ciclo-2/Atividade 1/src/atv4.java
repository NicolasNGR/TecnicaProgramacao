import java.util.Scanner;

public class atv4 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o número da tabuada desejada: ");
		int tabuada = scan.nextInt();
		
		for (int i = 1; i <= 10; i++) {
			int resultado = i*tabuada;
			System.out.println(i + " x " + tabuada + " = " + resultado);
		}
		
		scan.close();
	}

}
