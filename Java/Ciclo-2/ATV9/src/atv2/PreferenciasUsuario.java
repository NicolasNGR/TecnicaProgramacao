package atv2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;

public class PreferenciasUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Usuario user = new Usuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreferenciasUsuario frame = new PreferenciasUsuario();
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
	public PreferenciasUsuario() {
		setTitle("Preferências");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] temas = {"Claro", "Escuro"};
		JComboBox<String> cbo_tema = new JComboBox<>(temas);
		cbo_tema.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbo_tema.setBounds(12, 27, 98, 20);
		
		JCheckBox chckbx_notif = new JCheckBox("Notificações");
		chckbx_notif.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbx_notif.setBounds(121, 14, 105, 20);
		
		JLabel lbl_tema = new JLabel("Tema");
		lbl_tema.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_tema.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tema.setBounds(41, 10, 44, 12);
		
		JSlider slider_vol = new JSlider();
		slider_vol.setBounds(232, 27, 200, 25);
		
		JLabel lbl_volume = new JLabel("Volume");
		lbl_volume.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_volume.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_volume.setBounds(297, 10, 70, 12);
		
		JTextArea textArea_configs = new JTextArea();
		textArea_configs.setBounds(12, 132, 414, 121);
		
		JButton btn_salvar = new JButton("Salvar");
		btn_salvar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_salvar.setBounds(171, 84, 84, 20);
		btn_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usertheme = (String) cbo_tema.getSelectedItem();
				user.tema = usertheme;
				
				if (user.tema.equals("Escuro")) {
					contentPane.setBackground(new Color(59, 59, 59));
					slider_vol.setBackground(new Color(59, 59, 59));
					chckbx_notif.setBackground(new Color(59, 59, 59));
					btn_salvar.setBackground(new Color(59, 59, 59));
					cbo_tema.setBackground(new Color(92, 92, 92));
					textArea_configs.setBackground(new Color(92, 92, 92));
					
					textArea_configs.setForeground(new Color(255, 255, 255));
					cbo_tema.setForeground(new Color(255, 255, 255));
					chckbx_notif.setForeground(new Color(255, 255, 255));
					btn_salvar.setForeground(new Color(255, 255, 255));
					lbl_volume.setForeground(new Color(255, 255, 255));
					lbl_tema.setForeground(new Color(255, 255, 255));
				} else {
					contentPane.setBackground(new Color(240, 240, 240));
					slider_vol.setBackground(new Color(240, 240, 240));
					chckbx_notif.setBackground(new Color(240, 240, 240));
					btn_salvar.setBackground(new Color(240, 240, 240));
					cbo_tema.setBackground(new Color(255, 255, 255));
					textArea_configs.setBackground(new Color(255, 255, 255));
					
					textArea_configs.setForeground(new Color(0, 0, 0));
					cbo_tema.setForeground(new Color(0, 0, 0));
					chckbx_notif.setForeground(new Color(0, 0, 0));
					btn_salvar.setForeground(new Color(0, 0, 0));
					lbl_volume.setForeground(new Color(0, 0, 0));
					lbl_tema.setForeground(new Color(0, 0, 0));
				}
				
				String texto = "Tema: " + usertheme
                        + "\nNotificações: " + (chckbx_notif.isSelected() ? "Sim" : "Não")
                        + "\nVolume: " + slider_vol.getValue();
				textArea_configs.setText(texto);
			}
		});
		
		contentPane.add(cbo_tema);
		contentPane.add(chckbx_notif);
		contentPane.add(lbl_tema);
		contentPane.add(slider_vol);
		contentPane.add(lbl_volume);
		contentPane.add(btn_salvar);
		contentPane.add(textArea_configs);
	}
}
