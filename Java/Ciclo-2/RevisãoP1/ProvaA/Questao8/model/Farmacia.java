package Questao8.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Farmacia {
    private String[] nomesMedicamentos;
    private int[] diasParaVencimento;
    private double[] precos;
    private int tamanho;

    public Farmacia(String[] nomesMedicamentos, int[] diasParaVencimento, double[] precos) {
        this.nomesMedicamentos = Arrays.copyOf(nomesMedicamentos, nomesMedicamentos.length);
        this.diasParaVencimento = Arrays.copyOf(diasParaVencimento, diasParaVencimento.length);
        this.precos = Arrays.copyOf(precos, precos.length);
        this.tamanho = nomesMedicamentos.length;
    }

    public void mostrarTodos() {
        if (tamanho == 0) {
            System.out.println("Sem medicamentos.");
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            System.out.println((i + 1) + " - " + nomesMedicamentos[i] + " | Preço: R$ " + String.format("%.2f", precos[i]) + " | Dias p/ vencer: " + diasParaVencimento[i]);
        }
    }

    public double mediaDiasParaVencimento() {
        if (tamanho == 0) return 0.0;
        int soma = 0;
        for (int i = 0; i < tamanho; i++) soma += diasParaVencimento[i];
        return soma / (double) tamanho;
    }

    public String[] identificarProximosDeVencer(int limiteDias) {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            if (diasParaVencimento[i] < limiteDias) lista.add(nomesMedicamentos[i]);
        }
        return lista.toArray(new String[0]);
    }

    public void aplicarDescontoProximos(int limiteDias) {
        for (int i = 0; i < tamanho; i++) {
            if (diasParaVencimento[i] < limiteDias) precos[i] = precos[i] * 0.5;
        }
    }

    public boolean vender(String nome) {
        int idx = -1;
        for (int i = 0; i < tamanho; i++) {
            if (nomesMedicamentos[i].equalsIgnoreCase(nome)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return false;
        for (int i = idx; i < tamanho - 1; i++) {
            nomesMedicamentos[i] = nomesMedicamentos[i + 1];
            diasParaVencimento[i] = diasParaVencimento[i + 1];
            precos[i] = precos[i + 1];
        }
        tamanho--;
        return true;
    }
}

