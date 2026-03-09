package br.edu.fatecpg.Videolocadora.model;

public class Videolocadora {

    private String[] filmes;
    private int[] vezesAlugado;
    private double[] precosLocacao;

    public Videolocadora(int qtdFilmes) {
        filmes = new String[qtdFilmes];
        vezesAlugado = new int[qtdFilmes];
        precosLocacao = new double[qtdFilmes];
    }

    public void setFilme(int i, String nome, double preco) {
        filmes[i] = nome;
        precosLocacao[i] = preco;
        vezesAlugado[i] = 0; 
    }

    public void listarFilmes() {
        System.out.println("Lista de filmes:");
        for (int i = 0; i < filmes.length; i++) {
            System.out.println(
                (i + 1) + ". " + filmes[i] +
                " | Preço: R$" + precosLocacao[i] +
                " | Alugado: " + vezesAlugado[i] + "x"
            );
        }
    }

    public double faturamentoEsperado() {
        double total = 0;
        for (double preco : precosLocacao) {
            total += preco;
        }
        return total;
    }

    public String filmeMaisAlugado() {
        if (filmes.length == 0) {
            return "Nenhum filme cadastrado.";
        }

        int maisAlugadoIndex = 0;

        for (int i = 1; i < vezesAlugado.length; i++) {
            if (vezesAlugado[i] > vezesAlugado[maisAlugadoIndex]) {
                maisAlugadoIndex = i;
            }
        }

        return "Filme mais alugado: " + filmes[maisAlugadoIndex] +
               " (" + vezesAlugado[maisAlugadoIndex] + "x)";
    }

    public void alugarFilme(int i) {
        if (i >= 0 && i < filmes.length) {
            vezesAlugado[i]++;
            System.out.println("Você alugou: " + filmes[i]);
        } else {
            System.out.println("Filme inválido!");
        }
    }

    public void devolverFilme(int i) {
        if (i >= 0 && i < filmes.length) {
            System.out.println("Você devolveu: " + filmes[i]);
        } else {
            System.out.println("Filme inválido!");
        }
    }
}
