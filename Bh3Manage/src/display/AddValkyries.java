package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.AddValkyriesLogic;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddValkyries extends JFrame{
	public JTextField txtno;
	public JTextField txtname;
	public JTextField txtratings;
	public JTextField txtlevel;
	public JTextField txtweapon;
	public JTextField txtupperStigmata;
	public JTextField txtcentreStigmata;
	public JTextField txtlowerStigmata;
	private AddValkyriesLogic logic;
	public AddValkyries() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7F16\u53F7");
		label.setBounds(123, 26, 54, 15);
		getContentPane().add(label);
		
		txtno = new JTextField();
		txtno.setColumns(10);
		txtno.setBounds(219, 23, 198, 21);
		getContentPane().add(txtno);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(123, 72, 54, 15);
		getContentPane().add(label_1);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(219, 69, 198, 21);
		getContentPane().add(txtname);
		
		JLabel label_2 = new JLabel("\u8BC4\u7EA7");
		label_2.setBounds(123, 129, 54, 15);
		getContentPane().add(label_2);
		
		txtratings = new JTextField();
		txtratings.setColumns(10);
		txtratings.setBounds(219, 126, 198, 21);
		getContentPane().add(txtratings);
		
		JLabel label_3 = new JLabel("\u7B49\u7EA7");
		label_3.setBounds(123, 179, 54, 15);
		getContentPane().add(label_3);
		
		txtlevel = new JTextField();
		txtlevel.setColumns(10);
		txtlevel.setBounds(219, 176, 198, 21);
		getContentPane().add(txtlevel);
		
		JLabel label_4 = new JLabel("\u88C5\u5907");
		label_4.setBounds(123, 226, 54, 15);
		getContentPane().add(label_4);
		
		txtweapon = new JTextField();
		txtweapon.setColumns(10);
		txtweapon.setBounds(219, 223, 198, 21);
		getContentPane().add(txtweapon);
		
		JLabel label_5 = new JLabel("\u4E0A\u4F4D\u5723\u75D5");
		label_5.setBounds(123, 272, 54, 15);
		getContentPane().add(label_5);
		
		txtupperStigmata = new JTextField();
		txtupperStigmata.setColumns(10);
		txtupperStigmata.setBounds(219, 269, 198, 21);
		getContentPane().add(txtupperStigmata);
		
		JLabel label_6 = new JLabel("\u4E2D\u4F4D\u5723\u75D5");
		label_6.setBounds(123, 329, 54, 15);
		getContentPane().add(label_6);
		
		txtcentreStigmata = new JTextField();
		txtcentreStigmata.setColumns(10);
		txtcentreStigmata.setBounds(219, 326, 198, 21);
		getContentPane().add(txtcentreStigmata);
		
		JLabel label_7 = new JLabel("\u4E0B\u4F4D\u5723\u75D5");
		label_7.setBounds(123, 379, 54, 15);
		getContentPane().add(label_7);
		
		txtlowerStigmata = new JTextField();
		txtlowerStigmata.setColumns(10);
		txtlowerStigmata.setBounds(219, 376, 198, 21);
		getContentPane().add(txtlowerStigmata);
		
		JButton btnNewButton = new JButton("\u65B0\u589E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.addCourse(
						txtno.getText(),
						txtname.getText(),
						txtratings.getText(),
						Integer.parseInt(txtlevel.getText()),
						txtweapon.getText(),
						txtupperStigmata.getText(),
						txtcentreStigmata.getText(),
						txtlowerStigmata.getText());
			}
		});
		btnNewButton.setBounds(139, 444, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(310, 444, 93, 23);
		getContentPane().add(btnNewButton_1);
		logic = new AddValkyriesLogic(this);
	}
}
