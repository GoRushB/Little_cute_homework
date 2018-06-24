package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.DisplayScLogic;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplaySc extends JFrame{
	private DisplayScLogic logic;
	public JTextField txtScSno;
	public JTextField txtScCno;
	public JTextField txtScGrade;
	public JTextField txtScScid;
	public DisplaySc() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u5B66\u751F\u5B66\u53F7");
		label.setBounds(70, 91, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u7F16\u53F7");
		label_1.setBounds(70, 143, 54, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u6210\u7EE9");
		label_2.setBounds(70, 193, 54, 15);
		getContentPane().add(label_2);
		
		txtScSno = new JTextField();
		txtScSno.setColumns(10);
		txtScSno.setBounds(193, 88, 196, 21);
		getContentPane().add(txtScSno);
		
		txtScCno = new JTextField();
		txtScCno.setColumns(10);
		txtScCno.setBounds(193, 140, 196, 21);
		getContentPane().add(txtScCno);
		
		txtScGrade = new JTextField();
		txtScGrade.setColumns(10);
		txtScGrade.setBounds(193, 190, 196, 21);
		getContentPane().add(txtScGrade);
		
		JButton button = new JButton("\u65B0\u589E\u6210\u7EE9\u5355");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.OpenAddSc();
			}
		});
		button.setBounds(276, 265, 103, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u4FEE\u6539\u6210\u7EE9\u5355");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.OpenEditSc();
			}
		});
		button_1.setBounds(379, 265, 98, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u4E0B\u4E00\u6761");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.next();
			}
		});
		button_2.setBounds(94, 265, 74, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u4E0A\u4E00\u6761");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.previous();
			}
		});
		button_3.setBounds(10, 265, 74, 23);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("\u5237\u65B0\u6570\u636E");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.refresh();
			}
		});
		button_4.setBounds(178, 265, 88, 23);
		getContentPane().add(button_4);
		
		JLabel label_3 = new JLabel("\u6210\u7EE9\u5355\u7F16\u53F7");
		label_3.setBounds(70, 41, 74, 15);
		getContentPane().add(label_3);
		
		txtScScid = new JTextField();
		txtScScid.setColumns(10);
		txtScScid.setBounds(193, 38, 196, 21);
		getContentPane().add(txtScScid);
		logic = new DisplayScLogic(this);
		logic.init();
	}

}
