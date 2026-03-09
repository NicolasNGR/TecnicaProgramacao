package View;

import DAO.CategoriaDAO;
import DAO.TarefaDAO;
import Model.Categoria;
import Model.Tarefa;

import java.util.List;
import java.util.Scanner;

public class menuConsole {
    private final Scanner scanner = new Scanner(System.in);
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();
    private final TarefaDAO tarefaDAO = new TarefaDAO();

    public void iniciar() {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarCategoria();
                case 2 -> cadastrarTarefa();
                case 3 -> listarTarefas(tarefaDAO.listarTodas());
                case 4 -> editarTarefa();
                case 5 -> concluirTarefa();
                case 6 -> excluirTarefa();
                case 7 -> filtrarPorCategoria();
                case 8 -> filtrarPorStatus();
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\n===== GESTÃO DE TAREFAS =====");
        System.out.println("1 - Cadastrar categoria");
        System.out.println("2 - Cadastrar tarefa");
        System.out.println("3 - Listar todas as tarefas");
        System.out.println("4 - Editar tarefa");
        System.out.println("5 - Marcar tarefa como concluída");
        System.out.println("6 - Excluir tarefa");
        System.out.println("7 - Filtrar por categoria");
        System.out.println("8 - Filtrar por status");
        System.out.println("0 - Sair");
    }

    private void cadastrarCategoria() {
        System.out.print("Nome da categoria: ");
        String nome = scanner.nextLine();
        categoriaDAO.inserir(new Categoria(nome));
    }

    private void cadastrarTarefa() {
        if (!categoriaDAO.temCategorias()) {
            System.out.println("Cadastre pelo menos uma categoria antes de criar tarefas.");
            return;
        }

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        listarCategorias();
        int categoriaId = lerInteiro("Digite o ID da categoria: ");

        if (!categoriaDAO.existeCategoria(categoriaId)) {
            System.out.println("Categoria inválida.");
            return;
        }

        Tarefa tarefa = new Tarefa(titulo, descricao, "PENDENTE", categoriaId);
        tarefaDAO.inserir(tarefa);
    }

    private void editarTarefa() {
        int id = lerInteiro("Digite o ID da tarefa que deseja editar: ");
        Tarefa tarefa = tarefaDAO.buscarPorId(id);

        if (tarefa == null) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        System.out.println("Tarefa atual: " + tarefa);

        System.out.print("Novo título: ");
        String titulo = scanner.nextLine();

        System.out.print("Nova descrição: ");
        String descricao = scanner.nextLine();

        listarCategorias();
        int categoriaId = lerInteiro("Novo ID da categoria: ");

        if (!categoriaDAO.existeCategoria(categoriaId)) {
            System.out.println("Categoria inválida.");
            return;
        }

        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setCategoriaId(categoriaId);

        if (tarefaDAO.atualizar(tarefa)) {
            System.out.println("Tarefa atualizada com sucesso!");
        } else {
            System.out.println("Não foi possível atualizar a tarefa.");
        }
    }

    private void concluirTarefa() {
        int id = lerInteiro("Digite o ID da tarefa a concluir: ");

        if (tarefaDAO.concluir(id)) {
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private void excluirTarefa() {
        int id = lerInteiro("Digite o ID da tarefa a excluir: ");

        if (tarefaDAO.excluir(id)) {
            System.out.println("Tarefa excluída com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private void filtrarPorCategoria() {
        listarCategorias();
        int categoriaId = lerInteiro("Digite o ID da categoria: ");
        listarTarefas(tarefaDAO.listarPorCategoria(categoriaId));
    }

    private void filtrarPorStatus() {
        System.out.print("Digite o status (PENDENTE ou CONCLUIDA): ");
        String status = scanner.nextLine().trim().toUpperCase();
        listarTarefas(tarefaDAO.listarPorStatus(status));
    }

    private void listarCategorias() {
        List<Categoria> categorias = categoriaDAO.listarTodas();

        System.out.println("\n--- Categorias ---");
        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.");
            return;
        }

        for (Categoria c : categorias) {
            System.out.println(c);
        }
    }

    private void listarTarefas(List<Tarefa> tarefas) {
        System.out.println("\n--- Tarefas ---");

        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
            return;
        }

        for (Tarefa t : tarefas) {
            System.out.println(t);
        }
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}