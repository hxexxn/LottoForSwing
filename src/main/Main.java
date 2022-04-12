package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField idInputfield;
	private JTextField pwInputfield;
	private JButton loginBtn;
	private JButton memRegBtn;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2000, 100, 602, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginLabel = new JLabel("L o g i n");
		loginLabel.setForeground(Color.WHITE);
		loginLabel.setBackground(Color.PINK);
		loginLabel.setOpaque(true);
		loginLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(153, 95, 267, 87);
		contentPane.add(loginLabel);
		
		idInputfield = new JTextField();
		idInputfield.setBounds(153, 228, 164, 22);
		idInputfield.setColumns(10);
		contentPane.add(idInputfield);
		
		pwInputfield = new JTextField();
		pwInputfield.setBounds(153, 262, 164, 22);
		pwInputfield.setColumns(10);
		contentPane.add(pwInputfield);
		
		loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idInputfield.getText();
				String pw = pwInputfield.getText();

			MySQLDB db = new MySQLDB();
			
			boolean login = db.loginSelect(id, pw);
				
			if (login == true) {
				Lotto lotto = new Lotto();
				lotto.setVisible(true);
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(contentPane, "일치하는 아이디나 비밀번호가 없습니다.", "로그인 불가능", JOptionPane.WARNING_MESSAGE);
			}

			}
		});
		
		loginBtn.setBackground(Color.LIGHT_GRAY);
		loginBtn.setBounds(340, 223, 80, 61);
		contentPane.add(loginBtn);
		
		memRegBtn = new JButton("회원가입");
		memRegBtn.setBackground(Color.LIGHT_GRAY);
		memRegBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistFrame rf = new RegistFrame();
				rf.setVisible(true);
				setVisible(false);
						
			}
		});
		memRegBtn.setBounds(153, 332, 267, 46);
		contentPane.add(memRegBtn);


	}
}
