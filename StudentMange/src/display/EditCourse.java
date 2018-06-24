package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import logic.EditCourseLogic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditCourse extends JFrame{
	public JTextField txtCouCno;
	public JTextField txtCouCname;
	public JTextField txtCouCprior;
	private EditCourseLogic editCourseLogic;
	public EditCourse() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7F16\u53F7");
		label.setBounds(85, 47, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u4FEE\u6539\u8BFE\u7A0B\u540D\u79F0");
		label_1.setBounds(85, 106, 72, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u4FEE\u6539\u8BFE\u7A0B\u5B66\u5206");
		label_2.setBounds(85, 164, 72, 15);
		getContentPane().add(label_2);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editCourseLogic.Edit(txtCouCname.getText(), Double.parseDouble(txtCouCprior.getText()));
			}
		});
		button.setBounds(111, 235, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setBounds(325, 235, 93, 23);
		getContentPane().add(button_1);
		
		txtCouCno = new JTextField();
		txtCouCno.setColumns(10);
		txtCouCno.setBounds(183, 44, 186, 21);
		getContentPane().add(txtCouCno);
		
		txtCouCname = new JTextField();
		txtCouCname.setColumns(10);
		txtCouCname.setBounds(183, 103, 186, 21);
		getContentPane().add(txtCouCname);
		
		txtCouCprior = new JTextField();
		txtCouCprior.setColumns(10);
		txtCouCprior.setBounds(183, 161, 186, 21);
		getContentPane().add(txtCouCprior);
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editCourseLogic.Delete();
			}
		});
		button_2.setBounds(214, 235, 93, 23);
		getContentPane().add(button_2);
		editCourseLogic = new EditCourseLogic(this);
		editCourseLogic.init();
	}

}
