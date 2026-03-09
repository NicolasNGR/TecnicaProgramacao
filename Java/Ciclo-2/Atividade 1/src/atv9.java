import java.util.Scanner;

public class atv9 {
    public static void main(String[] args) {
    	
        Scanner scan = new Scanner(System.in);
        
        String[] nomes = new String[5];
        
        System.out.println("Digite 5 nomes, um por vez:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Nome " + (i+1) + ": ");
            nomes[i] = scan.nextLine();
        }
        
        System.out.print("Digite um nome para verificar se está na lista: ");
        String nomeVerificar = scan.nextLine();
        
        boolean encontrado = false;
        for (String nome : nomes) {
            if (nome.equalsIgnoreCase(nomeVerificar)) {
                encontrado = true;
                break;
            }
        }
        
        if (encontrado) {
            System.out.println("\nO nome \"" + nomeVerificar + "\" está na lista!");
        } else {
            System.out.println("\nO nome \"" + nomeVerificar + "\" NÃO está na lista.");
        }
        
        scan.close();
    }
}
