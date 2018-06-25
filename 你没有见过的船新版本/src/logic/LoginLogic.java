package logic;

import javax.swing.JFrame;

import display.DisplayValkyries;
import generic.Help.Keys;

public class LoginLogic {
	public void OpenDisplayValkyries(String name,String pwd){
		if(name.equals(Keys.UserName)&&pwd.equals(Keys.Password)){
			DisplayValkyries displayValkyries=new DisplayValkyries();
			displayValkyries.setBounds(100,50,550,550);
			displayValkyries.setVisible(true);
			displayValkyries.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}