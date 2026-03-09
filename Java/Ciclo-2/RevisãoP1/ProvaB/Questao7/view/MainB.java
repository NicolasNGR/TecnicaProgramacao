package Questao7.view;
import Questao7.model.*;

public class MainB {

	public static void main(String[] args) {
		Funcionario f = new Funcionario();
        f.setNome("Nicolas Gomes");
        f.setSalario(8550.00);
        f.setCargo("Analista de dados");
        System.out.println("Nome: " + f.getNome());
        System.out.println("Salário: " + String.format("R$ %.2f", f.getSalario()));
        System.out.println("Cargo: " + f.getCargo());
	}

}
