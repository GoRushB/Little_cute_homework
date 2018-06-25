package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.AddScLogic;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddSc extends JFrame{
	private JTextField txtScSno;
	private JTextField txtScCno;
	private JTextField txtScGrade;
	private JTextField txtScScid;
	private AddScLogic addScLogic;
	public AddSc() {
		getContentPane().setLayout(null);
		
		JButton button = new JButton("\u65B0\u589E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScLogic.addSc(txtScSno.getText(),txtScCno.getText(),Double.parseDouble(txtScGrade.getText()));
			}
		});
		button.setBounds(127, 251, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setBounds(281, 251, 93, 23);
		getContentPane().add(button_1);
		
		JLabel label = new JLabel("\u65B0\u589E\u5B66\u751F\u5B66\u53F7");
		label.setBounds(82, 83, 113, 29);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u65B0\u589E\u8BFE\u7A0B\u7F16\u53F7");
		label_1.setBounds(82, 129, 113, 40);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u65B0\u589E\u8BFE\u7A0B\u6210\u7EE9");
		label_2.setBounds(82, 179, 113, 29);
		getContentPane().add(label_2);
		
		txtScSno = new JTextField();
		txtScSno.setColumns(10);
		txtScSno.setBounds(205, 87, 196, 21);
		getContentPane().add(txtScSno);
		
		txtScCno = new JTextField();
		txtScCno.setColumns(10);
		txtScCno.setBounds(205, 139, 196, 21);
		getContentPane().add(txtScCno);
		
		txtScGrade = new JTextField();
		txtScGrade.setColumns(10);
		txtScGrade.setBounds(205, 189, 196, 21);
		getContentPane().add(txtScGrade);
		
		JLabel label_3 = new JLabel("\u65B0\u589E\u6210\u7EE9\u5355\u7F16\u53F7");
		label_3.setBounds(82, 40, 113, 29);
		getContentPane().add(label_3);
		
		txtScScid = new JTextField();
		txtScScid.setColumns(10);
		txtScScid.setBounds(205, 37, 196, 21);
		getContentPane().add(txtScScid);
		addScLogic = new AddScLogic(this);
	}

}