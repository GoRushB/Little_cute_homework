package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.EditValkyriesLogic;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditValkyries extends JFrame{
	public JTextField txtno;
	public JTextField txtname;
	public JTextField txtratings;
	public JTextField txtlevel;
	public JTextField txtweapon;
	public JTextField txtupperStigmata;
	public JTextField txtcentreStigmata;
	public JTextField txtlowerStigmata;
	private EditValkyriesLogic logic;
	public EditValkyries() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7F16\u53F7");
		label.setBounds(118, 26, 54, 15);
		getContentPane().add(label);
		
		txtno = new JTextField();
		txtno.setColumns(10);
		txtno.setBounds(214, 23, 198, 21);
		getContentPane().add(txtno);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(118, 72, 54, 15);
		getContentPane().add(label_1);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(214, 69, 198, 21);
		getContentPane().add(txtname);
		
		JLabel label_2 = new JLabel("\u8BC4\u7EA7");
		label_2.setBounds(118, 129, 54, 15);
		getContentPane().add(label_2);
		
		txtratings = new JTextField();
		txtratings.setColumns(10);
		txtratings.setBounds(214, 126, 198, 21);
		getContentPane().add(txtratings);
		
		JLabel label_3 = new JLabel("\u7B49\u7EA7");
		label_3.setBounds(118, 179, 54, 15);
		getContentPane().add(label_3);
		
		txtlevel = new JTextField();
		txtlevel.setColumns(10);
		txtlevel.setBounds(214, 176, 198, 21);
		getContentPane().add(txtlevel);
		
		JLabel label_4 = new JLabel("\u88C5\u5907");
		label_4.setBounds(118, 226, 54, 15);
		getContentPane().add(label_4);
		
		txtweapon = new JTextField();
		txtweapon.setColumns(10);
		txtweapon.setBounds(214, 223, 198, 21);
		getContentPane().add(txtweapon);
		
		JLabel label_5 = new JLabel("\u4E0A\u4F4D\u5723\u75D5");
		label_5.setBounds(118, 272, 54, 15);
		getContentPane().add(label_5);
		
		txtupperStigmata = new JTextField();
		txtupperStigmata.setColumns(10);
		txtupperStigmata.setBounds(214, 269, 198, 21);
		getContentPane().add(txtupperStigmata);
		
		JLabel label_6 = new JLabel("\u4E2D\u4F4D\u5723\u75D5");
		label_6.setBounds(118, 329, 54, 15);
		getContentPane().add(label_6);
		
		txtcentreStigmata = new JTextField();
		txtcentreStigmata.setColumns(10);
		txtcentreStigmata.setBounds(214, 326, 198, 21);
		getContentPane().add(txtcentreStigmata);
		
		JLabel label_7 = new JLabel("\u4E0B\u4F4D\u5723\u75D5");
		label_7.setBounds(118, 379, 54, 15);
		getContentPane().add(label_7);
		
		txtlowerStigmata = new JTextField();
		txtlowerStigmata.setColumns(10);
		txtlowerStigmata.setBounds(214, 376, 198, 21);
		getContentPane().add(txtlowerStigmata);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.Edit(
						txtname.getText(),
						txtratings.getText(),
						Integer.parseInt(txtlevel.getText()),
						txtweapon.getText(),
						txtupperStigmata.getText(),
						txtcentreStigmata.getText(),
						txtlowerStigmata.getText());
			}
		});
		button.setBounds(92, 444, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setBounds(355, 444, 93, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.Delete();
			}
		});
		button_2.setBounds(228, 444, 93, 23);
		getContentPane().add(button_2);
		logic = new EditValkyriesLogic(this);
		logic.init();
	}

}
