import java.util.Scanner;

public class atv10 {
    public static void main(String[] args) {
    	
        Scanner scan = new Scanner(System.in);
        
        String senhaSecreta = "Java123";
        String tentativa;
        boolean acertou = false;
        
        while (!acertou) {
            System.out.print("Digite a senha: ");
            tentativa = scan.nextLine();
            
            if (tentativa.equals(senhaSecreta)) {
                acertou = true;
                System.out.println("Senha correta! Acesso concedido.");
            } else {
                System.out.println("Senha incorreta. Tente novamente.");
            }
        }
        
        scan.close();
    }
}