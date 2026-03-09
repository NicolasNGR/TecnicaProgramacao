package Produto.view;
import Produto.model.*;

public class Main {

	public static void main(String[] args) {
		
		Produto p1 = new Produto("Caderno");
		Produto p2 = new Produto("Caderno", 10.50);
		Produto p3 = new Produto("Caderno", 10.50, 2);
		
		p1.exibirInfo();
		p2.exibirInfo();
		p3.exibirInfo();

	}

}
