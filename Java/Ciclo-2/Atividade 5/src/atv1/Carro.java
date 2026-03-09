package atv1;

public class Carro {

    private String modelo;
    private int ano;
    public double capacidadeTanque;
    public double atualTanque;
    private boolean ligado = false;
    private boolean andando = false;
    
    public Carro(String modelo, int ano, double capacidadeTanque, double atualTanque) {
        this.modelo = modelo;
        this.ano = ano;
        this.capacidadeTanque = capacidadeTanque;
        this.atualTanque = atualTanque;
    }
    
    public void ligar() {
    	if (!ligado) {
    		System.out.println("Carro ligando...");
    		System.out.println("Carro ligado!\n");
    		ligado = true;
    	} else {
    		System.out.println("O carro já está ligado!\n");
    	}
    }
    
    public void desligar() {
    	if (ligado) {
    		System.out.println("Carro desligando...");
    		System.out.println("Carro desligado\n");
    		ligado = false;
    	} else {
    		System.out.println("O carro já está desligado.\n");
    	}
    }
    
    public void acelerar() {
    	if (ligado && atualTanque > 0) {
                System.out.println("Carro andando...\n");
                andando = true;
                atualTanque--;
    	} else if (!ligado && atualTanque > 0) {
    		System.out.println("O carro está desligado");
    		this.ligar();
    		this.acelerar();
    	} else if (ligado && atualTanque == 0) {
    		System.out.println("Carro sem gasolina! Finalize o programa.\n");
    	} else {
    		this.ligar();
    		System.out.println("Carro sem gasolina! Finalize o programa.\n");
    	}
    }
    
    public void frear() {
    	if (andando) {
    		System.out.println("Freando carro...");
    		System.out.println("Carro parado\n");
    	} else {
    		System.out.println("O carro já está parado.\n");
    	}
    }
    
    public void buzinar() {
    	System.out.println("Biiii! Biiii!\n");
    	if (andando && atualTanque > 0) { atualTanque--; }
    }

    // Getters e Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }
    
    public double getAtualTanque() {
        return atualTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public double calcularValorTotal(double precoGasolina) {
        return (capacidadeTanque - atualTanque) * precoGasolina;
    }
    
    public void abastecerTanque(double capacidadeTanque, double tanqueAtual) {
    	this.atualTanque = capacidadeTanque;
    }

    public void info() {
        System.out.println("Modelo: " + modelo + "\nAno: " + ano + "\nCapacidade do tanque: " + capacidadeTanque + "L");
    }
}
