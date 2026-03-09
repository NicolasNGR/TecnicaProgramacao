package swing.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_prova;
	private JTextField txt_trabalho;
	private JTextField txt_apresentacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_prova = new JTextField();
		txt_prova.setBounds(263, 34, 124, 19);
		contentPane.add(txt_prova);
		txt_prova.setColumns(10);
		
		JLabel lblNota1 = new JLabel("Nota Prova");
		lblNota1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNota1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota1.setBounds(30, 27, 125, 30);
		contentPane.add(lblNota1);
		
		txt_trabalho = new JTextField();
		txt_trabalho.setColumns(10);
		txt_trabalho.setBounds(263, 70, 124, 19);
		contentPane.add(txt_trabalho);
		
		JLabel lblNota2 = new JLabel("Nota Trabalho");
		lblNota2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNota2.setBounds(30, 63, 125, 30);
		contentPane.add(lblNota2);
		
		txt_apresentacao = new JTextField();
		txt_apresentacao.setColumns(10);
		txt_apresentacao.setBounds(263, 110, 124, 19);
		contentPane.add(txt_apresentacao);
		
		JLabel lblApresentacao = new JLabel("Nota Apresentação");
		lblApresentacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblApresentacao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApresentacao.setBounds(30, 103, 129, 30);
		contentPane.add(lblApresentacao);
		
		JLabel lblMedia = new JLabel("A média é: ");
		lblMedia.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMedia.setBounds(164, 190, 118, 32);
		contentPane.add(lblMedia);
		
		JButton btn_calcular = new JButton("Calcular");
		btn_calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double prova = Double.parseDouble(txt_prova.getText());
				double trab = Double.parseDouble(txt_trabalho.getText());
				double apre = Double.parseDouble(txt_apresentacao.getText());
				double media = Math.round((prova+trab+apre)/3);
				
				lblMedia.setText("A média é: " + media);
				if (media >= 6) JOptionPane.showMessageDialog(null, "Aprovado"); 
				else 			JOptionPane.showMessageDialog(null, "Reprovado"); 
			}
		});
		btn_calcular.setBounds(167, 159, 105, 21);
		contentPane.add(btn_calcular);
	}
}
