import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        // ─────────────────────────────────────────────
        // 1. POPULAÇÃO DA LISTA
        // ─────────────────────────────────────────────
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
            new Funcionario("Ana Souza",       "TI",          5800.00, 12),
            new Funcionario("Bruno Lima",      "TI",          4200.00,  7),
            new Funcionario("Carlos Mendes",   "RH",          3100.00, 15),
            new Funcionario("Diana Ferreira",  "RH",          2800.00,  3),
            new Funcionario("Eduardo Costa",   "Financeiro",  7500.00, 20),
            new Funcionario("Fernanda Rocha",  "Financeiro",  2500.00,  1),
            new Funcionario("Gabriel Alves",   "TI",          6300.00, 11),
            new Funcionario("Helena Martins",  "RH",          3900.00,  9),
            new Funcionario("Igor Nascimento", "Financeiro",  4800.00, 14),
            new Funcionario("Juliana Pires",   "TI",          2200.00,  2)
        ));

        separador("LISTA COMPLETA DE FUNCIONÁRIOS");
        funcionarios.forEach(System.out::println);


        // ─────────────────────────────────────────────
        // 2. FILTRAGEM — salário > R$ 3.000
        // ─────────────────────────────────────────────
        separador("FUNCIONÁRIOS COM SALÁRIO SUPERIOR A R$ 3.000");

        List<Funcionario> filtradosPorSalario = funcionarios.stream()
            .filter(f -> f.getSalario() > 3000)
            .collect(Collectors.toList());

        filtradosPorSalario.forEach(System.out::println);


        // ─────────────────────────────────────────────
        // 3. MAPEAMENTO — aumento de 5% para +10 anos
        // ─────────────────────────────────────────────
        separador("APLICANDO AUMENTO DE 5% PARA FUNCIONÁRIOS COM MAIS DE 10 ANOS DE SERVIÇO");

        funcionarios.stream()
            .filter(f -> f.getAnosDeServico() > 10)
            .forEach(f -> {
                double novoSalario = f.getSalario() * 1.05;
                f.setSalario(novoSalario);
            });

        funcionarios.stream()
            .filter(f -> f.getAnosDeServico() > 10)
            .forEach(System.out::println);


        // ─────────────────────────────────────────────
        // 4. ORDENAÇÃO — por nome em ordem alfabética
        // ─────────────────────────────────────────────
        separador("FUNCIONÁRIOS ORDENADOS ALFABETICAMENTE PELO NOME");

        funcionarios.stream()
            .sorted(Comparator.comparing(Funcionario::getNome))
            .forEach(System.out::println);


        // ─────────────────────────────────────────────
        // 5. REDUÇÃO — total gasto com salários
        // ─────────────────────────────────────────────
        separador("TOTAL DA FOLHA DE PAGAMENTO");

        double totalSalarios = funcionarios.stream()
            .mapToDouble(Funcionario::getSalario)
            .reduce(0.0, Double::sum);

        System.out.printf("Total gasto com salários: R$ %.2f%n", totalSalarios);


        // ─────────────────────────────────────────────
        // 6. AGRUPAMENTO — média salarial por departamento
        // ─────────────────────────────────────────────
        separador("MÉDIA SALARIAL POR DEPARTAMENTO");

        Map<String, Double> mediaPorDepartamento = funcionarios.stream()
            .collect(Collectors.groupingBy(
                Funcionario::getDepartamento,
                Collectors.averagingDouble(Funcionario::getSalario)
            ));

        mediaPorDepartamento.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry ->
                System.out.printf("%-12s → Média: R$ %.2f%n",
                    entry.getKey(), entry.getValue())
            );


        // ─────────────────────────────────────────────
        // 7. DESAFIO — funcionário com maior tempo de serviço
        // ─────────────────────────────────────────────
        separador("FUNCIONÁRIO COM MAIOR TEMPO DE SERVIÇO");

        funcionarios.stream()
            .max(Comparator.comparingInt(Funcionario::getAnosDeServico))
            .ifPresent(f ->
                System.out.printf("Funcionário: %s | Anos de Serviço: %d%n",
                    f.getNome(), f.getAnosDeServico())
            );


        // ─────────────────────────────────────────────
        // 8. DESAFIO — saída formatada personalizada
        // ─────────────────────────────────────────────
        separador("SAÍDA FORMATADA PERSONALIZADA");

        funcionarios.stream()
            .sorted(Comparator.comparing(Funcionario::getNome))
            .forEach(f ->
                System.out.printf(
                    "Funcionário: %s, Departamento: %s, Salário: R$ %.2f%n",
                    f.getNome(), f.getDepartamento(), f.getSalario()
                )
            );
    }

    // ─────────────────────────────────────────────
    // Utilitário para separar seções no console
    // ─────────────────────────────────────────────
    private static void separador(String titulo) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  " + titulo);
        System.out.println("=".repeat(60));
    }
}
