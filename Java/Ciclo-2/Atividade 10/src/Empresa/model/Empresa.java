package Empresa.model;

public class Empresa {
    private String nome;

    private Cliente[] clientes = new Cliente[5];
    private int totalClientes = 0;

    private Funcionario[] funcionarios = new Funcionario[10];
    private int totalFuncionarios = 0;

    public Empresa(String nome) {
        this.nome = nome;
    }

    // --------- Parte 1: Associação ----------
    public boolean adicionarCliente(String nome, String email) {
        if (totalClientes >= clientes.length) {
            return false; 
        }
        clientes[totalClientes] = new Cliente(nome, email);
        totalClientes++;
        return true;
    }

    public String exibirClientes() {
        if (totalClientes == 0) {
            return "Nenhum cliente cadastrado.\n";
        }
        StringBuilder sb = new StringBuilder("=== CLIENTES ===\n");
        for (int i = 0; i < totalClientes; i++) {
            sb.append((i + 1)).append(") ")
              .append(clientes[i].toString())
              .append("\n");
        }
        return sb.toString();
    }

    // --------- Parte 2: Composição ----------
    public boolean adicionarFuncionario(String nome, String cargo, double salario) {
        if (totalFuncionarios >= funcionarios.length) {
            return false;
        }
        funcionarios[totalFuncionarios] = new Funcionario(nome, cargo, salario);
        totalFuncionarios++;
        return true;
    }

    public String exibirFuncionarios() {
        if (totalFuncionarios == 0) {
            return "Nenhum funcionário cadastrado.\n";
        }
        StringBuilder sb = new StringBuilder("=== FUNCIONÁRIOS ===\n");
        for (int i = 0; i < totalFuncionarios; i++) {
            sb.append((i + 1)).append(") ")
              .append(funcionarios[i].toString())
              .append("\n");
        }
        return sb.toString();
    }

    public double calcularFolhaSalarial() {
        double total = 0;
        for (int i = 0; i < totalFuncionarios; i++) {
            total += funcionarios[i].getSalario();
        }
        return total;
    }

    // --------- Parte 3: Dependência com Calculadora ----------
    public double calcularMediaSalarial() {
        if (totalFuncionarios == 0) {
            return 0.0;
        }

        Calculadora calc = new Calculadora(); 
        double soma = 0;

        for (int i = 0; i < totalFuncionarios; i++) {
            soma = calc.somar(soma, funcionarios[i].getSalario());
        }

        double media = soma / totalFuncionarios;
        return media;
    }

    public String exibirMediaSalarial() {
        double media = calcularMediaSalarial();
        if (media == 0.0) {
            return "Não há funcionários para calcular a média salarial.\n";
        }
        return "Média salarial dos funcionários: R$ " + String.format("%.2f", media) + "\n";
    }
}
