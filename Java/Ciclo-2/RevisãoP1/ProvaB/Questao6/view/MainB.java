package Questao6.view;
import Questao6.model.*;

public class MainB {

	public static void main(String[] args) {
		Livro l = new Livro();
        l.titulo = "A Menina que Roubava Livros";
        l.autor = "Markus Zusak";
        l.anoPublicacao = 2005;
        System.out.println("Título: " + l.titulo);
        System.out.println("Autor: " + l.autor);
        System.out.println("Ano de Publicação: " + l.anoPublicacao);
	}

}
