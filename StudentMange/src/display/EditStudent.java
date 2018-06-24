package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import logic.EditStudentLogic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditStudent extends JFrame{
	public JTextField txtStuSno;
	public JTextField txtStuSname;
	public JTextField txtStuSage;
	private EditStudentLogic editStudentLogic;
	public EditStudent() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u5B66\u53F7");
		lblNewLabel.setBounds(87, 67, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4FEE\u6539\u5B66\u751F\u59D3\u540D");
		lblNewLabel_1.setBounds(87, 126, 72, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4FEE\u6539\u5B66\u751F\u5E74\u9F84");
		lblNewLabel_2.setBounds(87, 184, 72, 15);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStudentLogic.Edit(txtStuSname.getText(), Integer.parseInt(txtStuSage.getText()));
			}
		});
		btnNewButton.setBounds(113, 255, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(327, 255, 93, 23);
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
		
		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStudentLogic.Delete();
			}
		});
		button.setBounds(216, 255, 93, 23);
		getContentPane().add(button);
		editStudentLogic = new EditStudentLogic(this);
		editStudentLogic.init();
	}

}
