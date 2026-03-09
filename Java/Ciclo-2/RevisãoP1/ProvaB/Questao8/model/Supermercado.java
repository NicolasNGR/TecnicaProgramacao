package Questao8.model;
import java.util.Arrays;

public class Supermercado {
    private String[] nomesProdutos;
    private double[] precos;
    private double[] descontos;
    private int tamanho;

    public Supermercado(String[] nomesProdutos, double[] precos, double[] descontos) {
        this.nomesProdutos = Arrays.copyOf(nomesProdutos, nomesProdutos.length);
        this.precos = Arrays.copyOf(precos, precos.length);
        this.descontos = Arrays.copyOf(descontos, descontos.length);
        this.tamanho = nomesProdutos.length;
    }

    public void listarProdutos() {
        if (tamanho == 0) {
            System.out.println("Sem produtos.");
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            double precoDesc = precos[i] * (1 - descontos[i]);
            System.out.println((i + 1) + " - " + nomesProdutos[i] + " | Preço: R$ " + String.format("%.2f", precos[i]) + " | Com desconto: R$ " + String.format("%.2f", precoDesc));
        }
    }

    public double totalComDesconto() {
        double total = 0.0;
        for (int i = 0; i < tamanho; i++) {
            total += precos[i] * (1 - descontos[i]);
        }
        return total;
    }

    public String produtoMaiorEconomia() {
        if (tamanho == 0) return "";
        double maxEco = -1.0;
        int idx = 0;
        for (int i = 0; i < tamanho; i++) {
            double economia = precos[i] * descontos[i];
            if (economia > maxEco) {
                maxEco = economia;
                idx = i;
            }
        }
        return nomesProdutos[idx];
    }

    public boolean comprar(String nome) {
        int idx = -1;
        for (int i = 0; i < tamanho; i++) {
            if (nomesProdutos[i].equalsIgnoreCase(nome)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return false;
        for (int i = idx; i < tamanho - 1; i++) {
            nomesProdutos[i] = nomesProdutos[i + 1];
            precos[i] = precos[i + 1];
            descontos[i] = descontos[i + 1];
        }
        tamanho--;
        return true;
    }

    public void repor(String nome, double preco, double desconto) {
        String[] novosNomes = Arrays.copyOf(nomesProdutos, tamanho + 1);
        double[] novosPrecos = Arrays.copyOf(precos, tamanho + 1);
        double[] novosDescontos = Arrays.copyOf(descontos, tamanho + 1);
        novosNomes[tamanho] = nome;
        novosPrecos[tamanho] = preco;
        novosDescontos[tamanho] = desconto;
        nomesProdutos = novosNomes;
        precos = novosPrecos;
        descontos = novosDescontos;
        tamanho++;
    }
}