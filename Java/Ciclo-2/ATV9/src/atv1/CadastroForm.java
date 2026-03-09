package atv1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	Cliente cl = new Cliente();
	private JTextField textf_nome;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroForm frame = new CadastroForm();
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
	public CadastroForm() {
		setTitle("Formulário de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textf_nome = new JTextField();
		textf_nome.setBounds(10, 32, 200, 26);
		textf_nome.setColumns(10);
		
		JLabel lbl_nome = new JLabel("Nome");
		lbl_nome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_nome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nome.setBounds(10, 10, 200, 22);
		
		JLabel lbl_idade = new JLabel("Idade");
		lbl_idade.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_idade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_idade.setBounds(10, 68, 200, 22);
		
		JSpinner spinner_idade = new JSpinner(new SpinnerNumberModel(0, 0, 150, 1));
		spinner_idade.setBounds(91, 90, 37, 26);
		
		JLabel lbl_sexo = new JLabel("Sexo");
		lbl_sexo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_sexo.setBounds(10, 126, 200, 22);
		
		JRadioButton rdbtn_masculino = new JRadioButton("Masculino");
		rdbtn_masculino.setActionCommand("masculino");
		rdbtn_masculino.setBounds(10, 154, 200, 20);
		
		JRadioButton rdbtn_feminino = new JRadioButton("Feminino");
		rdbtn_feminino.setActionCommand("feminino");
		rdbtn_feminino.setBounds(10, 176, 200, 20);
		
		ButtonGroup sexo_group = new ButtonGroup();
		sexo_group.add(rdbtn_masculino);
		sexo_group.add(rdbtn_feminino);
		
		JLabel lbl_resultado = new JLabel("N/A");
		lbl_resultado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_resultado.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_resultado.setBounds(220, 10, 206, 234);
		JButton btn_publicar = new JButton("Publicar");
		
		btn_publicar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_publicar.setBounds(65, 218, 84, 26);
		btn_publicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.nome = textf_nome.getText();
				cl.idade = (int)spinner_idade.getValue();
				ButtonModel valid = sexo_group.getSelection();
				cl.sexo = (valid != null) ? valid.getActionCommand() : null;
				
				
				
				if (sexo_group.getSelection() != null
					&& (int)spinner_idade.getValue() > 0
					&& (textf_nome.getText() != null && !cl.nome.trim().isEmpty()))
				{
					if ((int) spinner_idade.getValue() >= 100) {
						lbl_resultado.setText("<html>Seu nome é " + cl.nome 
								+ "<br>Caralho?! Você tem " + cl.idade + "anos?!"
								+ "<br>E você é do sexo " + cl.sexo 
								+ "</html>");
					} else {
					lbl_resultado.setText("<html>Seu nome é " + cl.nome 
										+ "<br>Você tem " + cl.idade + " anos"
										+ "<br>E você é do sexo " + cl.sexo 
										+ "</html>");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Há campos faltando!");
				}
			}
		});
		
		contentPane.add(lbl_nome);
		contentPane.add(textf_nome);
		contentPane.add(lbl_idade);
		contentPane.add(spinner_idade);
		contentPane.add(lbl_sexo);
		contentPane.add(rdbtn_masculino);
		contentPane.add(rdbtn_feminino);
		contentPane.add(btn_publicar);
		contentPane.add(lbl_resultado);
	}
}
