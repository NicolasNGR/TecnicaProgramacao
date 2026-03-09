package br.edu.fatecpg.Biblioteca.view;
import br.edu.fatecpg.Biblioteca.model.*;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(3);

        biblioteca.setLivro(0, "Dom Casmurro", 1.50);
        biblioteca.setLivro(1, "O Hobbit", 2.00);
        biblioteca.setLivro(2, "1984", 2.50);

        biblioteca.listarLivros();

        biblioteca.emprestarLivro(0);
        biblioteca.emprestarLivro(1);

        biblioteca.devolverLivro(0, 3); 
        biblioteca.devolverLivro(1, 0); 

        System.out.println();

        biblioteca.listarLivros();

        System.out.println();
        System.out.println("Multa total acumulada: R$" + biblioteca.calcularMultaTotal());
        System.out.println("Média de dias de atraso: " + biblioteca.mediaDiasAtraso());
    }
}

