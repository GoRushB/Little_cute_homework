package display;

import javax.swing.JFrame;

import logic.WelcomeLogic;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame{
	public Welcome() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u5B66\u751F\u7BA1\u7406");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WelcomeLogic wl = new WelcomeLogic();
				wl.OpenDisplayStudent();
			}
		});
		btnNewButton.setBounds(120, 50, 198, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8BFE\u7A0B\u7BA1\u7406");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WelcomeLogic wl = new WelcomeLogic();
				wl.OpenDisplayCourse();
			}
		});
		btnNewButton_1.setBounds(120, 113, 198, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u9009\u8BFE\u7BA1\u7406");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeLogic wl = new WelcomeLogic();
				wl.OpenDisplaySc();
			}
		});
		btnNewButton_2.setBounds(120, 182, 198, 23);
		getContentPane().add(btnNewButton_2);
	}

}
