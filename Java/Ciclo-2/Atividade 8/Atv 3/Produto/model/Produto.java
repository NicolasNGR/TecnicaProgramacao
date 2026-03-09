package Produto.model;

public class Produto {
	
	private String nome;
	private int quantidade;
	private double preco;
	
	public Produto(String nome) {
		
		this.nome = nome;
		this.quantidade = 0;
		this.preco = 0.00;
	}
	
	public Produto(String nome, double preco) {
		
		this.nome = nome;
		this.quantidade = 0;
		this.preco = preco;
	}
	
	public Produto(String nome, double preco, int quantidade) {
		
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	
	
	
	
	public void exibirInfo() {
        System.out.println("Produto: " + nome + 
                           ", Preço: R$" + preco + 
                           ", Quantidade: " + quantidade);
    }

}
