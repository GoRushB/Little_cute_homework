package logic;

import javax.swing.JFrame;

import display.Welcome;

public class LoginLogic {
	public void OpenWelcome(String name,String pwd){
		if(name.equals("admin")&&pwd.equals("1234")){
			Welcome welcome=new Welcome();
			welcome.setBounds(100,50,500,350);
			welcome.setVisible(true);
			welcome.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
	}
}
