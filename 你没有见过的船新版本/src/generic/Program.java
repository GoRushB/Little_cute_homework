package generic;

import javax.swing.JFrame;

import display.Login;

public class Program {
	public static void main(String[] args){
		Login login=new Login();
		login.setBounds(100,50,500,350);
		login.setVisible(true);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
