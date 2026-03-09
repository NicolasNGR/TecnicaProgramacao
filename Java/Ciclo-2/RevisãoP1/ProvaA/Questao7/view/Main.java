package Questao7.view;
import Questao7.model.*;

public class Main {

	public static void main(String[] args) {
		Aluno a = new Aluno();
        a.setNome("Nicolas");
        a.setMatricula("2025A001");
        a.setNotaFinal(10);
        System.out.println("Nome: " + a.getNome());
        System.out.println("Matrícula: " + a.getMatricula());
        System.out.println("Nota final: " + a.getNotaFinal());
	}

}
