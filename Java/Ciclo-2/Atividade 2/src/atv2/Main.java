package atv2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[][] logins = {{"MtgEmPo", "MtgEmPo2"}
						   ,{"Budweiser850", "skolSpaten"}
						   ,{"Lucas173", "lab&abLS"}
						   ,{"tepassoOvo", "Roger"}
						   ,{"azul_fox", "Alfa2025"}
						   ,{"sol_bravo", "NaoSobraNd"}};
		
		String login, senha;
		boolean block = true;
				
		while (block) {
			System.out.println("Insira seu login: ");
			login = scan.next();
			System.out.println("Insira sua senha: ");
			senha = scan.next();
			
			for (int i = 0; i < 6; i++) {

				if (login.equals(logins[i][0]) && senha.equals(logins[i][1])) {
					block = false;
				}
			}
			
			if (block) {
				System.out.println("Login ou senha incorreto!");
			}
		}
		
		System.out.println("Acesso concedido!");
		
		scan.close();
	}

}
