package Conversor.view;
import Conversor.model.*;

public class Main {

	public static void main(String[] args) {
		
		Conversor conv = new Conversor();
		
		System.out.println("Celsius para Fahrenheit: " + conv.converter(25.0));                 
		System.out.println("Quilômetros para Milhas: " + conv.converter(10.0, true));           
		System.out.println("Texto em maiúsculas: " + conv.converter("Merece um 10")); 

	}

}
