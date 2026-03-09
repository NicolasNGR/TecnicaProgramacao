package Pagamento.view;
import Pagamento.model.*;

public class Main {

	public static void main(String[] args) {
		
		Pagamento p1 = new Cartao();
		Pagamento p2 = new PagamentoBoleto();
		
		p1.processarPagamento(); 
        p2.processarPagamento();

	}

}
