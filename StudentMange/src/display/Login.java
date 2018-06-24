package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.LoginLogic;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame{
	private JTextField txtName;
	private JPasswordField txtPwd;
	public Login() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u9009\u8BFE\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setBounds(219, 43, 96, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u767B\u9646\u540D:");
		lblNewLabel_1.setBounds(131, 94, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u9646\u5BC6\u7801:");
		lblNewLabel_2.setBounds(131, 140, 54, 15);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txtname = txtName.getText();
				String txtpwd = String.valueOf(txtPwd.getPassword());
				LoginLogic ll =new LoginLogic();
				ll.OpenWelcome(txtname,txtpwd);
			}
		});
		btnNewButton.setBounds(140, 209, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(287, 209, 93, 23);
		getContentPane().add(btnNewButton_1);
		
		txtName = new JTextField();
		txtName.setBounds(207, 94, 172, 21);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(207, 140, 172, 21);
		getContentPane().add(txtPwd);
	}
}
