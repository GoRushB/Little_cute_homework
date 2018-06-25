package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.DisplayCourseLogic;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayCourse extends JFrame{
	private DisplayCourseLogic logic;
	public JTextField txtCouCname;
	public JTextField txtCouCno;
	public JTextField txtCouCprior;
	public DisplayCourse() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u540D\u79F0");
		label.setBounds(70, 39, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u7F16\u53F7");
		label_1.setBounds(70, 94, 54, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u5B66\u5206");
		label_2.setBounds(70, 155, 54, 15);
		getContentPane().add(label_2);
		
		txtCouCname = new JTextField();
		txtCouCname.setColumns(10);
		txtCouCname.setBounds(193, 33, 196, 21);
		getContentPane().add(txtCouCname);
		
		txtCouCno = new JTextField();
		txtCouCno.setColumns(10);
		txtCouCno.setBounds(193, 88, 196, 21);
		getContentPane().add(txtCouCno);
		
		txtCouCprior = new JTextField();
		txtCouCprior.setColumns(10);
		txtCouCprior.setBounds(193, 149, 196, 21);
		getContentPane().add(txtCouCprior);
		
		JButton button = new JButton("\u65B0\u589E\u8BFE\u7A0B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.OpenAddCourse();
			}
		});
		button.setBounds(291, 227, 88, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u4FEE\u6539\u8BFE\u7A0B");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.OpenEditCourse();
			}
		});
		button_1.setBounds(389, 227, 88, 23);
		getContentPane().add(button_1);
		
		JButton button_3 = new JButton("\u4E0B\u4E00\u6761");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.next();
			}
		});
		button_3.setBounds(109, 227, 74, 23);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("\u4E0A\u4E00\u6761");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.previous();
			}
		});
		button_4.setBounds(25, 227, 74, 23);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("\u5237\u65B0\u6570\u636E");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.refresh();
			}
		});
		button_5.setBounds(193, 227, 88, 23);
		getContentPane().add(button_5);
		logic = new DisplayCourseLogic(this);
		logic.init();
	}
}
