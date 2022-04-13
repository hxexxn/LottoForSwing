package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

@SuppressWarnings("serial")
public class RegistFrame extends JFrame {
	boolean idDuplicate = false;
	private JPanel layout;
	private JTextField idIputfield;
	private JPasswordField passwordField;
	private JPasswordField rePassWordField;
	
	public RegistFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2000, 100, 602, 490);
		layout = new JPanel();
		layout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layout);
		layout.setLayout(null);
		
		JLabel regLabel = new JLabel("회원 가입");
		regLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		regLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regLabel.setBackground(new Color(240, 128, 128));
		regLabel.setBounds(228, 0, 148, 46);
		layout.add(regLabel);
		
		JButton retrunBaseBtn = new JButton("r e t u r n");
		retrunBaseBtn.setBackground(Color.LIGHT_GRAY);
		retrunBaseBtn.setForeground(Color.BLACK);
		retrunBaseBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		retrunBaseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main main = new Main();				
				main.setVisible(true);
			}
		});
		retrunBaseBtn.setBounds(219, 362, 157, 28);
		layout.add(retrunBaseBtn);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(196, 58, 59, 18);
		layout.add(idLabel);
		
		idIputfield = new JTextField();
		idIputfield.setBounds(219, 84, 157, 35);
		layout.add(idIputfield);
		idIputfield.setColumns(10);
		
		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setBounds(196, 131, 59, 18);
		layout.add(pwLabel);
		
		JButton btnNewButton = new JButton("j o i n");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				// 아이디 유효성 검사 완료
				String id = idIputfield.getText();			
				boolean checkId = false;
				boolean checkPw = false;
				
				String resultID = id.trim().replaceAll(" ", "");
				String onlyEng = resultID.replaceAll("[^a-zA-Z0-9]", "");
				
//				System.out.println("아이디 : " + resultID);
//				System.out.println("아이디 길이 : " + resultLeng);
//				System.out.println("영어로만 입력된 아이디 : " + onlyEng);
//				System.out.println("영어로만 입력된 아이디 길이 : " + onlyEng.length());
				
				if (onlyEng.length() > 0) {
					System.out.println("영어로만 이루어진 아이디.");
					checkId = true;
				} else {
					JOptionPane.showMessageDialog(layout, "아이디는 영문과 숫자만 사용 가능합니다.", "회원가입 불가능", JOptionPane.WARNING_MESSAGE);
				}
				
				if (id.equals(onlyEng)) {
					System.out.println("아이디 입력됨.");
					checkId = true;
				} else {
					JOptionPane.showMessageDialog(layout, "아이디를 입력해주세요.", "회원가입 불가능", JOptionPane.WARNING_MESSAGE);
				}

				// 패스 워드 유효성 검사 완료. 
				
				String pw = passwordField.getText();
				String rePw = rePassWordField.getText();
				
				System.out.println("첫번째 비밀번호 : " + pw);
				System.out.println("두번째 비밀번호 : " + rePw);
				
				
				if (pw == null || pw.equals(" ") || pw.equals("")) {
					System.out.println("비밀번호가 비어있음.");
					JOptionPane.showMessageDialog(layout, "비밀번호를 입력해주세요.", "회원가입 불가능", JOptionPane.WARNING_MESSAGE);
				} else {
					String resultPw = pw.trim().replaceAll(" ", "");
					if (rePw.equals(resultPw)) {
						System.out.println("비밀번호가 일치합니다.");
						checkPw = true;
					} else {
						JOptionPane.showMessageDialog(layout, "비밀번호가 일치하지 않습니다.", "회원가입 불가능", JOptionPane.WARNING_MESSAGE);
						passwordField.setText("");
						rePassWordField.setText("");
						
					}
					System.out.println("비밀번호가 입력됨.");
				}
			
				// 아이디와 비밀번호가 true 라면 가입이 되게끔.
				
				if (checkId == true && checkPw == true && idDuplicate == true) {
					
					MySQLDB db = new MySQLDB();
					db.insert(onlyEng, pw);
					System.out.println("회원가입 완료.");
					
					Main main = new Main();				
					
					main.setVisible(true);
					setVisible(false);				
				} else {
					JOptionPane.showMessageDialog(layout, "아이디나 비밀번호를 다시 입력해주세요.", "회원가입 불가능", JOptionPane.WARNING_MESSAGE);
					passwordField.setText("");
					rePassWordField.setText("");
				}
				

				
//				if (pw == rePw) {
//					System.out.println(pw);
//					System.out.println(rePw);
//				}
				
//				MySQLDB db = new MySQLDB();
//				db.insert(id, pw);
//				System.out.println("insert 완료.");
//				
//				Main main = new Main();				
//				
//				main.setVisible(true);
//				setVisible(false);
			}
		});
		btnNewButton.setBounds(219, 307, 157, 28);
		layout.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(219, 161, 157, 35);
		layout.add(passwordField);
		
		JLabel rePwlabel = new JLabel("비밀번호 확인");
		rePwlabel.setBounds(196, 208, 87, 18);
		layout.add(rePwlabel);
		
		rePassWordField = new JPasswordField();
		rePassWordField.setBounds(219, 238, 157, 35);
		layout.add(rePassWordField);
		
		JButton dupIdBtn = new JButton("중복 확인");
		dupIdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idIputfield.getText();
				String resultID = id.trim().replaceAll(" ", "");
				String onlyEng = resultID.replaceAll("[^a-zA-Z0-9]", "");
				
				
				MySQLDB db = new MySQLDB();
				
				boolean idCheck = db.idCheck(onlyEng);
				
				if(idCheck == true) {
					JOptionPane.showMessageDialog(layout, "중복되는 아이디입니다.", "회원가입 불가능", JOptionPane.WARNING_MESSAGE);
					idIputfield.setText("");
				}else {
					idDuplicate=true;
					JOptionPane.showMessageDialog(layout, "사용 가능한 아이디입니다.", "회원가입 불가능", JOptionPane.WARNING_MESSAGE);
					System.out.println("중복x");
				}
				
//					if (idCheck == true) {
//						JOptionPane.showMessageDialog(layout, "사용 가능한 아이디입니다.", "회원가입 불가능", JOptionPane.WARNING_MESSAGE);
//				} else {
//					JOptionPane.showMessageDialog(layout, "중복되는 아이디입니다.", "회원가입 불가능", JOptionPane.WARNING_MESSAGE);
//				}
				
				
			}
		});
		dupIdBtn.setBounds(388, 84, 81, 35);
		layout.add(dupIdBtn);
		setVisible(false);
		
		
		
	}
}
