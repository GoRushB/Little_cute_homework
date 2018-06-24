package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import logic.EditScLogic;
import logic.EditStudentLogic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditSc extends JFrame{
	public JTextField txtScSno;
	public JTextField txtScCno;
	public JTextField txtScGrade;
	public JTextField txtScScid;
	private EditScLogic editScLogic;
	public EditSc() {
		getContentPane().setLayout(null);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editScLogic.Edit(txtScSno.getText(),txtScCno.getText(),Double.parseDouble(txtScGrade.getText()));
			}
		});
		button.setBounds(103, 261, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setBounds(317, 261, 93, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editScLogic.Delete();
			}
		});
		button_2.setBounds(206, 261, 93, 23);
		getContentPane().add(button_2);
		
		JLabel label = new JLabel("\u4FEE\u6539\u5B66\u751F\u5B66\u53F7");
		label.setBounds(91, 101, 93, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u4FEE\u6539\u8BFE\u7A0B\u7F16\u53F7");
		label_1.setBounds(91, 153, 80, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u4FEE\u6539\u8BFE\u7A0B\u6210\u7EE9");
		label_2.setBounds(91, 203, 80, 15);
		getContentPane().add(label_2);
		
		txtScSno = new JTextField();
		txtScSno.setColumns(10);
		txtScSno.setBounds(214, 98, 196, 21);
		getContentPane().add(txtScSno);
		
		txtScCno = new JTextField();
		txtScCno.setColumns(10);
		txtScCno.setBounds(214, 150, 196, 21);
		getContentPane().add(txtScCno);
		
		txtScGrade = new JTextField();
		txtScGrade.setColumns(10);
		txtScGrade.setBounds(214, 200, 196, 21);
		getContentPane().add(txtScGrade);
		
		JLabel label_3 = new JLabel("\u4FEE\u6539\u6210\u7EE9\u5355\u7F16\u53F7");
		label_3.setBounds(91, 51, 93, 15);
		getContentPane().add(label_3);
		
		txtScScid = new JTextField();
		txtScScid.setColumns(10);
		txtScScid.setBounds(214, 48, 196, 21);
		getContentPane().add(txtScScid);
		editScLogic = new EditScLogic(this);
		editScLogic.init();
	}

}
