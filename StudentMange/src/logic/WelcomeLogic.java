package logic;

import javax.swing.JFrame;

import display.DisplayCourse;
import display.DisplaySc;
import display.DisplayStudent;

public class WelcomeLogic {
	public void OpenDisplayStudent(){
		DisplayStudent dstudent = new DisplayStudent();
		dstudent.setBounds(100,50,500,350);
		dstudent.setVisible(true);
		dstudent.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void OpenDisplayCourse(){
		DisplayCourse dcourse = new DisplayCourse();
		dcourse.setBounds(100,50,500,350);
		dcourse.setVisible(true);
		dcourse.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void OpenDisplaySc(){
		DisplaySc ds = new DisplaySc();
		ds.setBounds(100,50,500,350);
		ds.setVisible(true);
		ds.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
