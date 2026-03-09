package Empresa.view;

import Empresa.model.Empresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmpresaApp extends JFrame {

    private Empresa empresa;

    private JTextField txtNomeCliente;
    private JTextField txtEmailCliente;

    private JTextField txtNomeFuncionario;
    private JTextField txtCargoFuncionario;
    private JTextField txtSalarioFuncionario;

    private JTextArea areaSaida;

    public EmpresaApp() {
        super("Sistema Empresa - Clientes e Funcionários");

        this.empresa = new Empresa("Minha Empresa");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTabbedPane abas = new JTabbedPane();
        abas.addTab("Clientes", criarPainelClientes());
        abas.addTab("Funcionários", criarPainelFuncionarios());

        add(abas, BorderLayout.NORTH);

        areaSaida = new JTextArea();
        areaSaida.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaSaida);
        add(scroll, BorderLayout.CENTER);
    }

    private JPanel criarPainelClientes() {
        JPanel painel = new JPanel(new GridLayout(3, 2, 5, 5));

        txtNomeCliente = new JTextField();
        txtEmailCliente = new JTextField();

        JButton btnAdicionarCliente = new JButton("Adicionar Cliente");
        JButton btnExibirClientes = new JButton("Exibir Clientes");

        painel.setBorder(BorderFactory.createTitledBorder("Cadastro de Clientes"));

        painel.add(new JLabel("Nome:"));
        painel.add(txtNomeCliente);

        painel.add(new JLabel("Email:"));
        painel.add(txtEmailCliente);

        painel.add(btnAdicionarCliente);
        painel.add(btnExibirClientes);

        btnAdicionarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNomeCliente.getText().trim();
                String email = txtEmailCliente.getText().trim();

                if (nome.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(EmpresaApp.this, "Preencha nome e email do cliente.",
                            "Atenção", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                boolean ok = empresa.adicionarCliente(nome, email);
                if (ok) {
                    JOptionPane.showMessageDialog(EmpresaApp.this, "Cliente adicionado com sucesso!");
                    txtNomeCliente.setText("");
                    txtEmailCliente.setText("");
                } else {
                    JOptionPane.showMessageDialog(EmpresaApp.this, "Limite de 5 clientes atingido!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnExibirClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaSaida.append(empresa.exibirClientes());
            }
        });

        return painel;
    }

    private JPanel criarPainelFuncionarios() {
        JPanel painel = new JPanel(new GridLayout(4, 2, 5, 5));

        txtNomeFuncionario = new JTextField();
        txtCargoFuncionario = new JTextField();
        txtSalarioFuncionario = new JTextField();

        JButton btnAdicionarFuncionario = new JButton("Adicionar Funcionário");
        JButton btnExibirFuncionarios = new JButton("Exibir Funcionários");
        JButton btnFolha = new JButton("Calcular Folha Salarial");
        JButton btnMedia = new JButton("Exibir Média Salarial");

        painel.setBorder(BorderFactory.createTitledBorder("Cadastro de Funcionários"));

        painel.add(new JLabel("Nome:"));
        painel.add(txtNomeFuncionario);

        painel.add(new JLabel("Cargo:"));
        painel.add(txtCargoFuncionario);

        painel.add(new JLabel("Salário:"));
        painel.add(txtSalarioFuncionario);

        painel.add(btnAdicionarFuncionario);
        painel.add(btnExibirFuncionarios);

        JPanel painelBotoesExtra = new JPanel(new GridLayout(1, 2, 5, 5));
        painelBotoesExtra.add(btnFolha);
        painelBotoesExtra.add(btnMedia);

        JPanel painelWrapper = new JPanel(new BorderLayout());
        painelWrapper.add(painel, BorderLayout.CENTER);
        painelWrapper.add(painelBotoesExtra, BorderLayout.SOUTH);

        btnAdicionarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNomeFuncionario.getText().trim();
                String cargo = txtCargoFuncionario.getText().trim();
                String salarioStr = txtSalarioFuncionario.getText().trim();

                if (nome.isEmpty() || cargo.isEmpty() || salarioStr.isEmpty()) {
                    JOptionPane.showMessageDialog(EmpresaApp.this, "Preencha nome, cargo e salário.",
                            "Atenção", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                double salario;
                try {
                    salario = Double.parseDouble(salarioStr.replace(",", "."));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EmpresaApp.this, "Salário inválido.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean ok = empresa.adicionarFuncionario(nome, cargo, salario);
                if (ok) {
                    JOptionPane.showMessageDialog(EmpresaApp.this, "Funcionário adicionado com sucesso!");
                    txtNomeFuncionario.setText("");
                    txtCargoFuncionario.setText("");
                    txtSalarioFuncionario.setText("");
                } else {
                    JOptionPane.showMessageDialog(EmpresaApp.this, "Limite de 10 funcionários atingido!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnExibirFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaSaida.append(empresa.exibirFuncionarios());
            }
        });

        btnFolha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = empresa.calcularFolhaSalarial();
                areaSaida.append("Total da folha salarial: R$ " + String.format("%.2f", total) + "\n");
            }
        });

        btnMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaSaida.append(empresa.exibirMediaSalarial());
            }
        });

        return painelWrapper;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmpresaApp().setVisible(true);
            }
        });
    }
}
