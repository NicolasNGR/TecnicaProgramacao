package programacao_orientada_objeto.model;

public class Animais {

	public static class Cachorro {
		public String raca;
		public int idade;
		public String corPelo;

		public void dormir() {
			System.out.print("ZZZZZZZZZZZZZZZZZ");
		}

		public void latir() {
			System.out.print("AU AU AU AU AU");
		}
	}

	public static class Coruja {
		public String tipo;
		public double envergaduraAsas;
		public int idade;
		public String corPenas;

		public void voar() {
			System.out.println("A coruja está voando silenciosamente!");
		}

		public void piar() {
			System.out.println("Piu! Piu! (som de coruja)");
		}

		public void cacar() {
			System.out.println("A coruja está caçando à noite!");
		}
	}

	public static class Gato {
		public String raca;
		public int idade;
		public String corPelo;

		public void dormir() {
			System.out.print("ZZZZZZZZZZZZZZZZZ");
		}

		public void miar() {
			System.out.print("MIAU MIAU MIAU");
		}
	}

	public static class Tigre {
		public String corPelagem;
		public double peso;
		public double altura;

		public void cacar() {
			System.out.print("Presa á vista.");
		}

		public void rugir() {
			System.out.print("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAR");
		}
	}

	public static class Cavalo {
		public String corPelagem;
		public double peso;
		public double altura;

		public void saltar() {
			System.out.print("saltando!");
		}

		public void relinchar() {
			System.out.print("lirriiiiiii");
		}
	}

	public static class Leao {
		public double velocidade;
		public double peso;
		public double altura;

		public void caçar() {
			System.out.print("perseguindo a presa!");
		}

		public void rugir() {
			System.out.print("ROOAAAAAR");
		}
	}

	public static class Elefante {
		public double tamanhoTromba;
		public double peso;
		public double altura;

		public void tromba() {
			System.out.print("usando a tromba!");
		}

		public void dormir() {
			System.out.print("ZZZZZZZZ");
		}
	}

	public static class Macaco {
		public String habitat;
		public double peso;
		public double altura;

		public void balancar() {
			System.out.print("balançando em árvore");
		}

		public void usarFerramenta() {
			System.out.print("ferramenta sendo utilizada...");
		}
	}

	public static class Girafa {
		public double comprimentoPescoco;
		public double peso;
		public double altura;

		public void correr() {
			System.out.print("correndo");
		}

		public void comer() {
			System.out.print("comendo");
		}
	}

	public static class Jacare {
		public int idade;
		public double peso;
		public double altura;

		public void morder() {
			System.out.print("mordendo");
		}

		public void nadar() {
			System.out.print("nadando");
		}
	}

	public static class Tubarao {
		public double velocidadeNado;
		public double peso;
		public double altura;

		public void nadar() {
			System.out.print("nadando");
		}

		public void cacar() {
			System.out.print("caçando");
		}
	}

	public static class Golfinho {
		public int inteligencia;
		public double peso;
		public double altura;

		public void nadar() {
			System.out.print("nadando");
		}

		public void brincar() {
			System.out.print("brincando");
		}
	}

	public static class Aguia {
		public int inteligencia;
		public double peso;
		public double altura;

		public void voar() {
			System.out.print("voando");
		}

		public void cacar() {
			System.out.print("cacando");
		}
	}

	public static class Pinguim {
		public int idade;
		public double peso;
		public double altura;

		public void nadar() {
			System.out.print("nadando");
		}

		public void mergulhar() {
			System.out.print("mergulhando");
		}
	}

	public static class Raposa {
		public String corPelo;
		public double peso;
		public double tamanho;

		public void cacar() {
			System.out.print("caçando");
		}

		public void correr() {
			System.out.print("correndo");
		}
	}

	public static class Camelo {
		public String corPelagem;
		public double peso;
		public double altura;

		public void caminhar() {
			System.out.print("Caminhando pelo deserto...");
		}

		public void resfolegar() {
			System.out.print("Resfolegando... Uff...");
		}
	}

	public static class Papagaio {
		public String corPenas;
		public int idade;

		public void voar() {
			System.out.print("Voando alto!");
		}

		public void falar() {
			System.out.print("Olá! Olá!");
		}
	}

	public static class Zebra {
		public String corPelagem;
		public double peso;
		public double altura;

		public void correr() {
			System.out.print("Correndo pela savana!");
		}

		public void relinchar() {
			System.out.print("Relinchando como um cavalo!");
		}
	}

	public static class Coelho {
		public String corPelagem;
		public int idade;

		public void pular() {
			System.out.print("Pulando de um lado para o outro!");
		}

		public void roer() {
			System.out.print("Roendo uma cenoura...");
		}
	}

	public static class Urso {
		public String corPelagem;
		public double peso;
		public double altura;

		public void hibernar() {
			System.out.print("Hibernando no inverno...");
		}

		public void rugir() {
			System.out.print("ROOOOOAR!");
		}
	}
}
