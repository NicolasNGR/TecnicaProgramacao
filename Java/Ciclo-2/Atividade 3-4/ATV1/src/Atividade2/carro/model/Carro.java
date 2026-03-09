package Atividade2.carro.model;

public class Carro {

    public String marca;
    public String modelo;
    public String cor;
    public int ano;
    public float capacidadeTanque;
    public boolean ligado;

    public Carro() {
        ligado = false;
    }

    public void ligar() {
        if (!ligado) {
            System.out.println("Carro ligado! VRUM VRUM");
            ligado = true;
        } else {
            System.out.println("Carro já está ligado!");
        }
    }

    public void acelerar() {
        if (ligado) {
            System.out.println("Carro acelerando... VRUUUUM!");
        } else {
            System.out.println("Ligue o carro primeiro!");
        }
    }

    public void desligar() {
        if (ligado) {
            System.out.println("Carro desligado.");
            ligado = false;
        } else {
            System.out.println("Carro já está desligado.");
        }
    }

    public void frear() {
        if (ligado) {
            System.out.println("Carro freando... IIIIIII!");
        } else {
            System.out.println("Carro está desligado.");
        }
    }

    public void buzinar() {
        System.out.println("BIBI BIBI! 🚗");
    }
}