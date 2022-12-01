import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Student extends JButton{
	String firstName;
	String lastName;
	double[] exams = new double[4];
	GradeBook parent;
	Student next;
	
	public Student(GradeBook parent, String fname, String lname) {
		this.parent = parent;
		firstName = fname;
		lastName = lname;
		setText(lastName+", "+firstName);
		addActionListener(new StudentListener());
	}
	
	private class StudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			parent.lastName.setText(lastName);
			parent.firstName.setText(firstName);
			for (int i=0; i<exams.length; i++) {
				parent.gradeBox[i].setText(""+exams[i]);
			}
			parent.avgBox.setText(""+computeAverage());
			parent.list.setCurrent(Student.this);
		}
	}
	
	public void save() {
		firstName= parent.firstName.getText();
		lastName= parent.lastName.getText();
		for (int i = 0; i<4; i++) {
			exams[i] = Double.parseDouble(parent.gradeBox[i].getText());
			
		}
	}
	
	public double computeAverage() {
		int i;
		double average = 0;
		for (i=0; i<exams.length; i++)
			average += exams[i];
		average/= exams.length;
		return average;
	}
	
}
