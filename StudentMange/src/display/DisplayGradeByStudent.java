package display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.DisplayGradeByStudentLogic;

import javax.swing.JList;
import javax.swing.AbstractListModel;

public class DisplayGradeByStudent extends JFrame{
	public JTextField txtSname;
	public JTextField txtSno;
	public JTextField txtSage;
	public JList courses;
	private DisplayGradeByStudentLogic logic;
	public DisplayGradeByStudent() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D");
		label.setBounds(79, 16, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u751F\u5B66\u53F7");
		label_1.setBounds(79, 47, 54, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u5E74\u9F84");
		label_2.setBounds(79, 78, 54, 15);
		getContentPane().add(label_2);
		
		txtSname = new JTextField();
		txtSname.setColumns(10);
		txtSname.setBounds(202, 10, 196, 21);
		getContentPane().add(txtSname);
		
		txtSno = new JTextField();
		txtSno.setColumns(10);
		txtSno.setBounds(202, 41, 196, 21);
		getContentPane().add(txtSno);
		
		txtSage = new JTextField();
		txtSage.setColumns(10);
		txtSage.setBounds(202, 72, 196, 21);
		getContentPane().add(txtSage);
		
		courses = new JList();
		courses.setModel(new AbstractListModel() {
			String[] values = new String[] {"      \u8BFE\u7A0B\u7F16\u53F7        \u8BFE\u7A0B\u540D\u79F0         \u5B66\u5206          \u6210\u7EE9"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		courses.setBounds(29, 111, 419, 424);
		getContentPane().add(courses);
		logic = new DisplayGradeByStudentLogic(this);
		logic.init();
	}
}
