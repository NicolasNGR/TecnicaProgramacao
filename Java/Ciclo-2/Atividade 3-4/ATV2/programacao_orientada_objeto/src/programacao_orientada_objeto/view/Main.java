package programacao_orientada_objeto.view;

import programacao_orientada_objeto.model.Animais;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE INFORMAÇÕES SOBRE ANIMAIS ===");
        System.out.println("Escolha o animal para ver as informações:");
        System.out.println("1 - Cachorro");
        System.out.println("2 - Gato");
        System.out.println("3 - Cavalo");
        System.out.println("4 - Leão");
        System.out.println("5 - Tigre");
        System.out.println("6 - Elefante");
        System.out.println("7 - Macaco");
        System.out.println("8 - Girafa");
        System.out.println("9 - Jacaré");
        System.out.println("10 - Tubarão");
        System.out.println("11 - Golfinho");
        System.out.println("12 - Águia");
        System.out.println("13 - Coruja");
        System.out.println("14 - Pinguim");
        System.out.println("15 - Urso");
        System.out.println("16 - Coelho");
        System.out.println("17 - Raposa");
        System.out.println("18 - Zebra");
        System.out.println("19 - Papagaio");
        System.out.println("20 - Camelo");
        System.out.print("Digite o número do animal: ");
        
        int op = scanner.nextInt();
        
        switch (op) {
            case 1:
                // Cachorro
                Animais.Cachorro cachorro = new Animais.Cachorro();
                cachorro.raca = "Labrador";
                cachorro.idade = 5;
                cachorro.corPelo = "Amarelo";
                System.out.println("Cachorro: " + cachorro.raca);
                cachorro.latir();
                break;
                
            case 2:
                // Gato
                Animais.Gato gato = new Animais.Gato();
                gato.raca = "Persa";
                gato.idade = 3;
                gato.corPelo = "Branco";
                System.out.println("Gato: " + gato.raca);
                gato.miar();
                break;
                
            case 3:
                // Cavalo
                Animais.Cavalo cavalo = new Animais.Cavalo();
                cavalo.corPelagem = "Preto";
                cavalo.peso = 450.0;
                cavalo.altura = 1.7;
                System.out.println("Cavalo: " + cavalo.corPelagem);
                cavalo.relinchar();
                break;
                
            case 4:
                // Leão
                Animais.Leao leao = new Animais.Leao();
                leao.velocidade = 80.0;
                leao.peso = 190.0;
                leao.altura = 1.2;
                System.out.println("Leão: Velocidade de caça " + leao.velocidade + " km/h");
                leao.rugir();
                break;
                
            case 5:
                // Tigre
                Animais.Tigre tigre = new Animais.Tigre();
                tigre.corPelagem = "Laranja com listras pretas";
                tigre.peso = 220.5;
                tigre.altura = 2.5;
                System.out.println("Tigre: " + tigre.corPelagem);
                tigre.rugir();
                break;
                
            case 6:
                // Elefante
                Animais.Elefante elefante = new Animais.Elefante();
                elefante.tamanhoTromba = 2.5;
                elefante.peso = 6000.0;
                elefante.altura = 3.0;
                System.out.println("Elefante: Tromba de " + elefante.tamanhoTromba + " metros");
                elefante.dormir();
                break;
                
            case 7:
                // Macaco
                Animais.Macaco macaco = new Animais.Macaco();
                macaco.habitat = "Floresta tropical";
                macaco.peso = 40.0;
                macaco.altura = 1.0;
                System.out.println("Macaco: Habitat " + macaco.habitat);
                macaco.balancar();
                break;
                
            case 8:
                // Girafa
                Animais.Girafa girafa = new Animais.Girafa();
                girafa.comprimentoPescoco = 2.5;
                girafa.peso = 800.0;
                girafa.altura = 5.5;
                System.out.println("Girafa: Comprimento do pescoço " + girafa.comprimentoPescoco + " metros");
                girafa.correr();
                break;
                
            case 9:
                // Jacaré
                Animais.Jacare jacare = new Animais.Jacare();
                jacare.idade = 12;
                jacare.peso = 300.0;
                jacare.altura = 1.5;
                System.out.println("Jacaré: Idade " + jacare.idade + " anos");
                jacare.nadar();
                break;
                
            case 10:
                // Tubarão
                Animais.Tubarao tubarao = new Animais.Tubarao();
                tubarao.velocidadeNado = 60.0;
                tubarao.peso = 1500.0;
                tubarao.altura = 3.5;
                System.out.println("Tubarão: Velocidade de nado " + tubarao.velocidadeNado + " km/h");
                tubarao.nadar();
                break;
                
            case 11:
                // Golfinho
                Animais.Golfinho golfinho = new Animais.Golfinho();
                golfinho.inteligencia = 80;
                golfinho.peso = 150.0;
                golfinho.altura = 2.5;
                System.out.println("Golfinho: Inteligência " + golfinho.inteligencia);
                golfinho.brincar();
                break;
                
            case 12:
                // Águia
                Animais.Aguia aguia = new Animais.Aguia();
                aguia.inteligencia = 90;
                aguia.peso = 5.0;
                aguia.altura = 1.0;
                System.out.println("Águia: Inteligência " + aguia.inteligencia);
                aguia.voar();
                break;
             
            case 13:
                // Coruja (NOVO)
                Animais.Coruja coruja = new Animais.Coruja();
                coruja.tipo = "Coruja-das-torres";
                coruja.envergaduraAsas = 0.9;
                coruja.idade = 3;
                coruja.corPenas = "Marrom";
                System.out.println("Coruja: " + coruja.tipo);
                coruja.voar();
                coruja.piar();
                break;
                
            case 14:
                // Pinguim
                Animais.Pinguim pinguim = new Animais.Pinguim();
                pinguim.idade = 4;
                pinguim.peso = 20.0;
                pinguim.altura = 1.0;
                System.out.println("Pinguim: Idade " + pinguim.idade + " anos");
                pinguim.nadar();
                break;
                
            case 15:
                // Urso
                Animais.Urso urso = new Animais.Urso();
                urso.corPelagem = "Marrom";
                urso.peso = 500.0;
                urso.altura = 2.5;
                System.out.println("Urso: Cor da pelagem " + urso.corPelagem);
                urso.rugir();
                break;
                
            case 16:
                // Coelho
                Animais.Coelho coelho = new Animais.Coelho();
                coelho.corPelagem = "Branco";
                coelho.idade = 1;
                System.out.println("Coelho: Cor da pelagem " + coelho.corPelagem);
                coelho.roer();
                break;
                
            case 17:
                // Raposa
                Animais.Raposa raposa = new Animais.Raposa();
                raposa.corPelo = "Vermelho";
                raposa.peso = 10.0;
                raposa.tamanho = 0.9;
                System.out.println("Raposa: Cor do pelo " + raposa.corPelo);
                raposa.correr();
                break;
                
            case 18:
                // Zebra
                Animais.Zebra zebra = new Animais.Zebra();
                zebra.corPelagem = "Listrada";
                zebra.peso = 400.0;
                zebra.altura = 1.5;
                System.out.println("Zebra: Cor da pelagem " + zebra.corPelagem);
                zebra.relinchar();
                break;
                
            case 19:
                // Papagaio
                Animais.Papagaio papagaio = new Animais.Papagaio();
                papagaio.corPenas = "Verde";
                papagaio.idade = 2;
                System.out.println("Papagaio: Cor das penas " + papagaio.corPenas);
                papagaio.falar();
                break;
                
            case 20:
                // Camelo
                Animais.Camelo camelo = new Animais.Camelo();
                camelo.corPelagem = "Bege";
                camelo.peso = 600.0;
                camelo.altura = 1.8;
                System.out.println("Camelo: Cor da pelagem " + camelo.corPelagem);
                camelo.resfolegar();
                break;
                
            default:
                System.out.println("Opção inválida! Por favor, digite um número entre 61 e 80.");
        }
        
        scanner.close();
        System.out.println();
    }
}