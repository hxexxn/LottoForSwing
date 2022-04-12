package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class Lotto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lotto frame = new Lotto();
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
	public Lotto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel oneLabel = new JLabel();
		oneLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		oneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		oneLabel.setBackground(new Color(255, 240, 245));
		oneLabel.setBounds(32, 118, 96, 89);
		oneLabel.setOpaque(true);
		contentPane.add(oneLabel);
		
		
		JLabel twoLabel = new JLabel();
		twoLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		twoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		twoLabel.setBounds(160, 118, 96, 89);
		twoLabel.setBackground(new Color(255, 240, 245));
		twoLabel.setOpaque(true);
		contentPane.add(twoLabel);
		
		JLabel threeLabel = new JLabel();
		threeLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		threeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		threeLabel.setBackground(new Color(255, 240, 245));
		threeLabel.setBounds(288, 118, 96, 89);
		threeLabel.setOpaque(true);
		contentPane.add(threeLabel);
		
		JLabel fourLabel = new JLabel();
		fourLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		fourLabel.setOpaque(true);
		fourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fourLabel.setBackground(new Color(255, 240, 245));
		fourLabel.setBounds(416, 118, 96, 89);
		contentPane.add(fourLabel);
		
		JLabel fiveLabel = new JLabel();
		fiveLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		fiveLabel.setOpaque(true);
		fiveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fiveLabel.setBackground(new Color(255, 240, 245));
		fiveLabel.setBounds(544, 118, 96, 89);
		contentPane.add(fiveLabel);
		
		JLabel sixLabel = new JLabel();
		sixLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		sixLabel.setOpaque(true);
		sixLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sixLabel.setBackground(new Color(255, 240, 245));
		sixLabel.setBounds(672, 118, 96, 89);
		contentPane.add(sixLabel);
		
		JButton rouletteBtn = new JButton("룰렛 돌리기");
		rouletteBtn.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				List<Integer> resultNum = new ArrayList<Integer>(); // 첫번째 배열
				TreeSet<Integer> num = new TreeSet<Integer>(resultNum);

				while (num.size() < 6) {
					num.add((int)(Math.random()*45) + 1);
//					num.addAll(resultNum);
					}							
				
				//List<Integer> finNum =  new ArrayList<Integer>(num);
				resultNum = new ArrayList<Integer>(num);

				oneLabel.setText(Integer.toString(resultNum.get(0)));
				twoLabel.setText(Integer.toString(resultNum.get(1)));
				threeLabel.setText(Integer.toString(resultNum.get(2)));
				fourLabel.setText(Integer.toString(resultNum.get(3)));
				fiveLabel.setText(Integer.toString(resultNum.get(4)));
				sixLabel.setText(Integer.toString(resultNum.get(5)));
				
//				System.out.println(resultNum.get(0));
				
			}
		});
		
		rouletteBtn.setBounds(288, 256, 224, 55);
		contentPane.add(rouletteBtn);
		
		JLabel lblNewLabel = new JLabel("로또 번호 뽑기");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(325, 31, 151, 28);
		contentPane.add(lblNewLabel);
	}
}
