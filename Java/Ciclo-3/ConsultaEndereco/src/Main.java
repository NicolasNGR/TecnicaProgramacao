import Model.Endereco;
import Service.ViaCepService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Endereco> historico = new ArrayList<>();
        ViaCepService service = new ViaCepService();

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Buscar endereço");
            System.out.println("2 - Excluir endereço da lista");
            System.out.println("3 - Mostrar histórico");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o CEP: ");
                    String cepBusca = scanner.nextLine();

                    Endereco enderecoEncontrado = buscarNaLista(historico, cepBusca);

                    if (enderecoEncontrado != null) {
                        System.out.println("\nEndereço já estava na lista:");
                        System.out.println(enderecoEncontrado);
                    } else {
                        Endereco novoEndereco = service.buscarCep(cepBusca);

                        if (novoEndereco != null) {
                            historico.add(novoEndereco);
                            System.out.println("\nEndereço encontrado e adicionado ao histórico:");
                            System.out.println(novoEndereco);
                        } else {
                            System.out.println("CEP não encontrado.");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Digite o CEP que deseja excluir: ");
                    String cepExcluir = scanner.nextLine();

                    boolean removido = removerDaLista(historico, cepExcluir);

                    if (removido) {
                        System.out.println("Endereço removido com sucesso.");
                    } else {
                        System.out.println("CEP não encontrado na lista.");
                    }
                    break;

                case 3:
                    if (historico.isEmpty()) {
                        System.out.println("Nenhum endereço no histórico.");
                    } else {
                        System.out.println("\n===== HISTÓRICO =====");
                        for (Endereco e : historico) {
                            System.out.println(e);
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static Endereco buscarNaLista(ArrayList<Endereco> lista, String cep) {
        String cepLimpo = cep.replaceAll("[^0-9]", "");

        for (Endereco e : lista) {
            String cepLista = e.getCep().replaceAll("[^0-9]", "");
            if (cepLista.equals(cepLimpo)) {
                return e;
            }
        }
        return null;
    }

    public static boolean removerDaLista(ArrayList<Endereco> lista, String cep) {
        String cepLimpo = cep.replaceAll("[^0-9]", "");

        for (int i = 0; i < lista.size(); i++) {
            String cepLista = lista.get(i).getCep().replaceAll("[^0-9]", "");
            if (cepLista.equals(cepLimpo)) {
                lista.remove(i);
                return true;
            }
        }
        return false;
    }
}