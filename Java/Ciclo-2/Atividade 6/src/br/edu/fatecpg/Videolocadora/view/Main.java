package br.edu.fatecpg.Videolocadora.view;
import br.edu.fatecpg.Videolocadora.model.*;

public class Main {
    public static void main(String[] args) {
        Videolocadora locadora = new Videolocadora(3);

        locadora.setFilme(0, "Matrix", 10.0);
        locadora.setFilme(1, "Vingadores", 12.5);
        locadora.setFilme(2, "Titanic", 8.0);

        locadora.listarFilmes();

        locadora.alugarFilme(0); 
        locadora.alugarFilme(1); 
        locadora.alugarFilme(1); 
        System.out.println();
        locadora.listarFilmes();

        System.out.println();
        System.out.println("Faturamento esperado (1 aluguel por filme): R$" + locadora.faturamentoEsperado());
        System.out.println(locadora.filmeMaisAlugado());

        locadora.devolverFilme(1);
    }
}

