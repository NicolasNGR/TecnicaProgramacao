package Questao8.model;
import java.util.Arrays;

public class PostoCombustivel {
    private String[] tiposCombustivel;
    private double[] precosLitro;
    private int[] litrosDisponiveis;
    private int tamanho;

    public PostoCombustivel(String[] tiposCombustivel, double[] precosLitro, int[] litrosDisponiveis) {
        this.tiposCombustivel = Arrays.copyOf(tiposCombustivel, tiposCombustivel.length);
        this.precosLitro = Arrays.copyOf(precosLitro, precosLitro.length);
        this.litrosDisponiveis = Arrays.copyOf(litrosDisponiveis, litrosDisponiveis.length);
        this.tamanho = tiposCombustivel.length;
    }

    public void listar() {
        if (tamanho == 0) {
            System.out.println("Sem combustíveis.");
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            System.out.println((i + 1) + " - " + tiposCombustivel[i] + " | Preço/L: R$ " + String.format("%.2f", precosLitro[i]) + " | Estoque: " + litrosDisponiveis[i] + " L");
        }
    }

    public double totalEmEstoque() {
        double total = 0.0;
        for (int i = 0; i < tamanho; i++) {
            total += precosLitro[i] * litrosDisponiveis[i];
        }
        return total;
    }

    public String maiorMenorEstoque() {
        if (tamanho == 0) return "";
        int idxMaior = 0;
        int idxMenor = 0;
        for (int i = 1; i < tamanho; i++) {
            if (litrosDisponiveis[i] > litrosDisponiveis[idxMaior]) idxMaior = i;
            if (litrosDisponiveis[i] < litrosDisponiveis[idxMenor]) idxMenor = i;
        }
        return "Maior: " + tiposCombustivel[idxMaior] + " (" + litrosDisponiveis[idxMaior] + " L) | Menor: " + tiposCombustivel[idxMenor] + " (" + litrosDisponiveis[idxMenor] + " L)";
    }

    public boolean vender(String tipo, int litros) {
        if (litros <= 0) return false;
        int idx = indexOf(tipo);
        if (idx == -1) return false;
        if (litrosDisponiveis[idx] < litros) return false;
        litrosDisponiveis[idx] -= litros;
        return true;
    }

    public boolean reabastecer(String tipo, int litros) {
        if (litros <= 0) return false;
        int idx = indexOf(tipo);
        if (idx == -1) return false;
        litrosDisponiveis[idx] += litros;
        return true;
    }

    private int indexOf(String tipo) {
        for (int i = 0; i < tamanho; i++) {
            if (tiposCombustivel[i].equalsIgnoreCase(tipo)) return i;
        }
        return -1;
    }
}
