package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.DisplayStudentLogic;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayStudent extends JFrame{
	private DisplayStudentLogic logic;
	public JTextField txtStuSname;
	public JTextField txtStuSno;
	public JTextField txtStuSage;
	public DisplayStudent() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D");
		lblNewLabel.setBounds(86, 56, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u5B66\u53F7");
		lblNewLabel_1.setBounds(86, 111, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u5E74\u9F84");
		lblNewLabel_2.setBounds(86, 172, 54, 15);
		getContentPane().add(lblNewLabel_2);
		
		txtStuSname = new JTextField();
		txtStuSname.setBounds(209, 50, 196, 21);
		getContentPane().add(txtStuSname);
		txtStuSname.setColumns(10);
		
		txtStuSno = new JTextField();
		txtStuSno.setBounds(209, 105, 196, 21);
		getContentPane().add(txtStuSno);
		txtStuSno.setColumns(10);
		
		txtStuSage = new JTextField();
		txtStuSage.setBounds(209, 166, 196, 21);
		getContentPane().add(txtStuSage);
		txtStuSage.setColumns(10);
		
		JButton button_1 = new JButton("\u65B0\u589E\u5B66\u751F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.OpenAddStudent();
			}
		});
		button_1.setBounds(112, 265, 88, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u4FEE\u6539\u5B66\u751F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.OpenEditStudent();
			}
		});
		button_2.setBounds(210, 265, 88, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u663E\u793A\u6210\u7EE9");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.OpenDisplayGradeByStudent();
			}
		});
		button_3.setBounds(308, 265, 88, 23);
		getContentPane().add(button_3);
		
		JButton button = new JButton("\u4E0B\u4E00\u6761");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.next();
			}
		});
		button.setBounds(210, 216, 88, 23);
		getContentPane().add(button);
		
		JButton button_4 = new JButton("\u4E0A\u4E00\u6761");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.previous();
			}
		});
		button_4.setBounds(112, 216, 88, 23);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("\u5237\u65B0\u6570\u636E");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.refresh();
			}
		});
		button_5.setBounds(308, 216, 88, 23);
		getContentPane().add(button_5);
		logic = new DisplayStudentLogic(this);
		logic.init();
	}

}
