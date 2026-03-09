package Atividade2.carro.view;

import Atividade2.carro.model.Carro;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carro meuCarro = new Carro();
        
        meuCarro.marca = "Renault";
        meuCarro.modelo = "Logan";
        meuCarro.ano = 2015;
        meuCarro.cor = "Prata";
        meuCarro.capacidadeTanque = 50.0f;

        System.out.println("=== SISTEMA DE CONTROLE DO CARRO ===");
        System.out.println("Carro: " + meuCarro.marca + " " + meuCarro.modelo + " " + meuCarro.ano);
        System.out.println("Cor: " + meuCarro.cor);
        System.out.println("Capacidade do tanque: " + meuCarro.capacidadeTanque + " litros");
        System.out.println();

        boolean executando = true;
        
        while (executando) {
            System.out.println("\n=== MENU DE CONTROLE ===");
            System.out.println("1 - Ligar carro");
            System.out.println("2 - Acelerar");
            System.out.println("3 - Buzinar");
            System.out.println("4 - Frear");
            System.out.println("5 - Desligar carro");
            System.out.println("6 - Sair do sistema");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            System.out.println();
            
            switch (opcao) {
                case 1:
                    meuCarro.ligar();
                    break;
                    
                case 2:
                    meuCarro.acelerar();
                    break;
                    
                case 3:
                    meuCarro.buzinar();
                    break;
                    
                case 4:
                    meuCarro.frear();
                    break;
                    
                case 5:
                    meuCarro.desligar();
                    if (!meuCarro.ligado) {
                        executando = false;
                    }
                    break;
                    
                case 6:
                    System.out.println("Saindo do sistema...");
                    executando = false;
                    break;
                    
                default:
                    System.out.println("Opção inválida! Escolha entre 1 e 6.");
            }
            
            if (executando) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine(); 
                scanner.nextLine(); 
            }
        }
        
        System.out.println("Sistema encerrado. Obrigado!");
        scanner.close();
    }
}