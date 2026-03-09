package SistemaSeguranca.view;

import SistemaSeguranca.model.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        SistemaSeguranca sistema = new SistemaSeguranca();

        boolean logado = false;

        while (!logado) {
            System.out.print("👤 Usuário: ");
            String usuario = sc.nextLine();

            System.out.print("🔑 Senha: ");
            String senha = sc.nextLine();

            logado = sistema.login(usuario, senha);
        }

        System.out.println("\n🎉 Bem-vindo ao sistema, admin!\n");

        System.out.print("Deseja fazer logout? (s/n): ");
        String opcao = sc.nextLine();

        if (opcao.equalsIgnoreCase("s")) {
            sistema.logout();
        } else {
            System.out.println("😉 Sessão mantida. Até logo!");
        }

        sc.close();
		

	}

}
