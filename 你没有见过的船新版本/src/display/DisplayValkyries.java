package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.DisplayValkyriesLogic;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayValkyries extends JFrame{
	public JTextField txtno;
	public JTextField txtname;
	public JTextField txtratings;
	public JTextField txtlevel;
	public JTextField txtweapon;
	public JTextField txtupperStigmata;
	public JTextField txtcentreStigmata;
	public JTextField txtlowerStigmata;
	private DisplayValkyriesLogic logic;
	public DisplayValkyries() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7F16\u53F7");
		label.setBounds(125, 30, 54, 15);
		getContentPane().add(label);
		
		txtno = new JTextField();
		txtno.setColumns(10);
		txtno.setBounds(221, 27, 198, 21);
		getContentPane().add(txtno);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(125, 76, 54, 15);
		getContentPane().add(label_1);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(221, 73, 198, 21);
		getContentPane().add(txtname);
		
		JLabel label_2 = new JLabel("\u8BC4\u7EA7");
		label_2.setBounds(125, 133, 54, 15);
		getContentPane().add(label_2);
		
		txtratings = new JTextField();
		txtratings.setColumns(10);
		txtratings.setBounds(221, 130, 198, 21);
		getContentPane().add(txtratings);
		
		JLabel label_3 = new JLabel("\u7B49\u7EA7");
		label_3.setBounds(125, 183, 54, 15);
		getContentPane().add(label_3);
		
		txtlevel = new JTextField();
		txtlevel.setColumns(10);
		txtlevel.setBounds(221, 180, 198, 21);
		getContentPane().add(txtlevel);
		
		JLabel label_4 = new JLabel("\u88C5\u5907");
		label_4.setBounds(125, 230, 54, 15);
		getContentPane().add(label_4);
		
		txtweapon = new JTextField();
		txtweapon.setColumns(10);
		txtweapon.setBounds(221, 227, 198, 21);
		getContentPane().add(txtweapon);
		
		JLabel label_5 = new JLabel("\u4E0A\u4F4D\u5723\u75D5");
		label_5.setBounds(125, 276, 54, 15);
		getContentPane().add(label_5);
		
		txtupperStigmata = new JTextField();
		txtupperStigmata.setColumns(10);
		txtupperStigmata.setBounds(221, 273, 198, 21);
		getContentPane().add(txtupperStigmata);
		
		JLabel label_6 = new JLabel("\u4E2D\u4F4D\u5723\u75D5");
		label_6.setBounds(125, 333, 54, 15);
		getContentPane().add(label_6);
		
		txtcentreStigmata = new JTextField();
		txtcentreStigmata.setColumns(10);
		txtcentreStigmata.setBounds(221, 330, 198, 21);
		getContentPane().add(txtcentreStigmata);
		
		JLabel label_7 = new JLabel("\u4E0B\u4F4D\u5723\u75D5");
		label_7.setBounds(125, 383, 54, 15);
		getContentPane().add(label_7);
		
		txtlowerStigmata = new JTextField();
		txtlowerStigmata.setColumns(10);
		txtlowerStigmata.setBounds(221, 380, 198, 21);
		getContentPane().add(txtlowerStigmata);
		
		JButton btnNewButton = new JButton("\u4E0A\u4E00\u6761");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.previous();
			}
		});
		btnNewButton.setBounds(10, 453, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4E0B\u4E00\u6761");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.next();
			}
		});
		btnNewButton_1.setBounds(113, 453, 93, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5237\u65B0\u6570\u636E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.refresh();
			}
		});
		btnNewButton_2.setBounds(216, 453, 93, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton button = new JButton("\u65B0\u589E\u5973\u6B66\u795E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.OpenAddCourse();
			}
		});
		button.setBounds(319, 453, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u4FEE\u6539\u5973\u6B66\u795E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.OpenEditCourse();
			}
		});
		button_1.setBounds(422, 453, 93, 23);
		getContentPane().add(button_1);
		logic = new DisplayValkyriesLogic(this);
		logic.output();
	}
}
