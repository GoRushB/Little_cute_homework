package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.LoginLogic;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login extends JFrame{
	private JTextField txtName;
	private JPasswordField txtPwd;
	public Login() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5723\u8299\u857E\u96C5\u5B66\u56ED\u5973\u6B66\u795E\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		lblNewLabel.setBounds(89, 33, 275, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u767B\u9646\u540D:");
		lblNewLabel_1.setBounds(93, 88, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u9646\u5BC6\u7801:");
		lblNewLabel_2.setBounds(93, 134, 66, 15);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txtname = txtName.getText();
				String txtpwd = String.valueOf(txtPwd.getPassword());
				LoginLogic ll =new LoginLogic();
				ll.OpenDisplayValkyries(txtname,txtpwd);
			}
		});
		btnNewButton.setBounds(101, 205, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(248, 205, 93, 23);
		getContentPane().add(btnNewButton_1);
		
		txtName = new JTextField();
		txtName.setBounds(169, 88, 172, 21);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(169, 134, 172, 21);
		getContentPane().add(txtPwd);
	}
}
