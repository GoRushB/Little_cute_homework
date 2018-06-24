package logic;

import javax.swing.JFrame;

import display.DisplayStudent;

public class WelcomeLogic {
	public void OpenDisplayStudent(){
		DisplayStudent dstudent = new DisplayStudent();
		dstudent.setBounds(100,50,500,350);
		dstudent.setVisible(true);
		dstudent.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
