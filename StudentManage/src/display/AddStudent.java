package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import logic.AddStudentLogic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame{
	private JTextField txtStuSno;
	private JTextField txtStuSname;
	private JTextField txtStuSage;
	private AddStudentLogic addStudentLogic;
	public AddStudent() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u65B0\u589E\u5B66\u53F7");
		lblNewLabel.setBounds(87, 59, 78, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u589E\u5B66\u751F\u59D3\u540D");
		lblNewLabel_1.setBounds(87, 118, 93, 31);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u65B0\u589E\u5B66\u751F\u5E74\u9F84");
		lblNewLabel_2.setBounds(87, 176, 93, 31);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u65B0\u589E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentLogic.addStudent(txtStuSno.getText(), txtStuSname.getText(), Integer.parseInt(txtStuSage.getText()));
			}
		});
		btnNewButton.setBounds(113, 255, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(267, 255, 93, 23);
		getContentPane().add(btnNewButton_1);
		
		txtStuSno = new JTextField();
		txtStuSno.setBounds(185, 64, 186, 21);
		getContentPane().add(txtStuSno);
		txtStuSno.setColumns(10);
		
		txtStuSname = new JTextField();
		txtStuSname.setBounds(185, 123, 186, 21);
		getContentPane().add(txtStuSname);
		txtStuSname.setColumns(10);
		
		txtStuSage = new JTextField();
		txtStuSage.setBounds(185, 181, 186, 21);
		getContentPane().add(txtStuSage);
		txtStuSage.setColumns(10);
		addStudentLogic = new AddStudentLogic(this);
	}

}
