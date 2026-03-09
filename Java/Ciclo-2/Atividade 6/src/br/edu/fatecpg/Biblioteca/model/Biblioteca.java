package br.edu.fatecpg.Biblioteca.model;

public class Biblioteca {

    private String[] livros;
    private int[] diasAtraso;
    private double[] multaPorDia;
    private boolean[] disponivel; 

    public Biblioteca(int qtdLivros) {
        livros = new String[qtdLivros];
        diasAtraso = new int[qtdLivros];
        multaPorDia = new double[qtdLivros];
        disponivel = new boolean[qtdLivros];
    }

    public void setLivro(int i, String nome, double multaDia) {
        livros[i] = nome;
        multaPorDia[i] = multaDia;
        diasAtraso[i] = 0;
        disponivel[i] = true; 
    }

    public void listarLivros() {
        System.out.println("Lista de Livros:");
        for (int i = 0; i < livros.length; i++) {
            System.out.println((i + 1) + ". " +
                livros[i] +
                " | Dias de Atraso: " + diasAtraso[i] +
                " | Multa por Dia: R$" + multaPorDia[i] +
                " | Disponível: " + (disponivel[i] ? "Sim" : "Não"));
        }
    }

    public double calcularMultaTotal() {
        double total = 0;
        for (int i = 0; i < livros.length; i++) {
            total += diasAtraso[i] * multaPorDia[i];
        }
        return total;
    }

    public double mediaDiasAtraso() {
        int totalDias = 0;
        int count = 0;
        for (int i = 0; i < diasAtraso.length; i++) {
            if (diasAtraso[i] > 0) {
                totalDias += diasAtraso[i];
                count++;
            }
        }
        return count > 0 ? (double) totalDias / count : 0;
    }

    public void emprestarLivro(int i) {
        if (i >= 0 && i < livros.length) {
            if (disponivel[i]) {
                disponivel[i] = false;
                System.out.println("Livro emprestado: " + livros[i]);
            } else {
                System.out.println("Livro já está emprestado.");
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void devolverLivro(int i, int diasDeAtraso) {
        if (i >= 0 && i < livros.length) {
            disponivel[i] = true;
            diasAtraso[i] += diasDeAtraso;
            System.out.println("Livro devolvido: " + livros[i]);
            if (diasDeAtraso > 0) {
                double multa = diasDeAtraso * multaPorDia[i];
                System.out.println("Atraso de " + diasDeAtraso + " dias. Multa: R$" + multa);
            } else {
                System.out.println("Devolvido no prazo. Sem multa.");
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }
}
