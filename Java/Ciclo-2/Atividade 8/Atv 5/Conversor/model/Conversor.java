package Conversor.model;

public class Conversor {
	
	   public double converter(double celsius) {
	        return (celsius * 9 / 5) + 32;
	    }
	   
	    public double converter(double quilometros, boolean kmParaMilhas) {
	        if (kmParaMilhas) {
	            return quilometros * 0.621371;
	        }
	        return quilometros; 
	    }

	    public String converter(String texto) {
	        return texto.toUpperCase();
	    }

}
