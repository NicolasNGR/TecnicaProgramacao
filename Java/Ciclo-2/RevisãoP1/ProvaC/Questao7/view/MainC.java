package Questao7.view;
import Questao7.model.*;

public class MainC {

	public static void main(String[] args) {
		ContaBancaria cb = new ContaBancaria();
        cb.setTitular("Nicolas Gomes");
        cb.setNumeroConta(123456);
        cb.setSaldo(7800.75);
        System.out.println("Titular: " + cb.getTitular());
        System.out.println("Número da conta: " + cb.getNumeroConta());
        System.out.println("Saldo: R$ " + String.format("%.2f", cb.getSaldo()));
	}
}
