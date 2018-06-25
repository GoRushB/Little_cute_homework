package logic;

import javax.swing.JFrame;

import display.DisplayValkyries;

public class LoginLogic {
	public void OpenDisplayValkyries(String name,String pwd){
		if(name.equals("admin")&&pwd.equals("1234")){
			DisplayValkyries displayValkyries=new DisplayValkyries();
			displayValkyries.setBounds(100,50,550,550);
			displayValkyries.setVisible(true);
			displayValkyries.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}
