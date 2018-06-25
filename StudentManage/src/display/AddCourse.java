package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import logic.AddCourseLogic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCourse extends JFrame{
	private JTextField txtCouCno;
	private JTextField txtCouCname;
	private JTextField txtCouCprior;
	private AddCourseLogic addCourseLogic;
	public AddCourse() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u65B0\u589E\u7F16\u53F7");
		label.setBounds(104, 49, 72, 29);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u65B0\u589E\u8BFE\u7A0B\u540D\u79F0");
		label_1.setBounds(101, 108, 88, 29);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u65B0\u589E\u8BFE\u7A0B\u5B66\u5206");
		label_2.setBounds(101, 166, 88, 29);
		getContentPane().add(label_2);
		
		JButton button = new JButton("\u65B0\u589E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCourseLogic.addCourse(txtCouCno.getText(), txtCouCname.getText(), Double.parseDouble(txtCouCprior.getText()));
			}
		});
		button.setBounds(127, 244, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setBounds(281, 244, 93, 23);
		getContentPane().add(button_1);
		
		txtCouCno = new JTextField();
		txtCouCno.setBounds(199, 53, 186, 21);
		txtCouCno.setColumns(10);
		getContentPane().add(txtCouCno);
		
		txtCouCname = new JTextField();
		txtCouCname.setBounds(199, 112, 186, 21);
		txtCouCname.setColumns(10);
		getContentPane().add(txtCouCname);
		
		txtCouCprior = new JTextField();
		txtCouCprior.setBounds(199, 170, 186, 21);
		txtCouCprior.setColumns(10);
		getContentPane().add(txtCouCprior);
		addCourseLogic = new AddCourseLogic(this);
	}

}
