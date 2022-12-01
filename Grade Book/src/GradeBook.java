import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class GradeBook extends JFrame{
	String filename;
	JPanel nameList = new JPanel();
	JScrollPane nameListPane = new JScrollPane(nameList);
	JButton saveButton=  new JButton("Save"), 
			addButton =  new JButton("Add"), 
			deleteButton=new JButton("Delete"), 
			firstButton= new JButton("First"), 
			nextButton = new JButton("Next"); 
	JPanel  topPanel = new JPanel(),
			botPanel = new JPanel(),
			centerPanel=new JPanel();
	JLabel  nameLabel= new JLabel("Name: ");
	JTextField firstName = new JTextField(15),
			lastName  = new JTextField(15);
	JLabel  gradeLabel[]=new JLabel[4];
	JTextField gradeBox[]=new JTextField[4];
	JLabel  avgLabel = new JLabel("Average: ");
	JTextField avgBox = new JTextField(6);
	JLabel  blank = new JLabel("");

	JButton studentButton;
	LinkedList list =new LinkedList();

	public GradeBook() {
		File filevariable = null;
		Scanner in = null;
		int i;

		while (in==null) {
			filename = JOptionPane.showInputDialog("Enter the grade file's name");
			if (filename.equals("")) filename="GradeFile.txt";
			filevariable = new File(filename);
			try {
				in = new Scanner(filevariable);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,"Could not find that file\nClick OK andTry again");
			}
		}
		//  Read in the students from the file
		while (in.hasNext()) {
			String name = in.nextLine();
			String[] parts;
			parts = name.split(" ");
			//System.out.println(""+parts.length+": "+parts[0]+" - "+parts[1]);
			Student x = new Student(this,parts[0],parts[1]);
			for (i=0; i<4; i++)
				x.exams[i] = in.nextInt();
			in.nextLine();		// Read off the new line character
			list.insertRear(x);  // Add this student to the linked list
		}

		in.close();		

		// Create the JFrame Window
		setSize(450,500);
		setLocationRelativeTo(null);
		setTitle("Grade Book for "+filename);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new BorderLayout());
		botPanel.add(addButton);
		addButton.addActionListener(new addListener());
		botPanel.add(saveButton);
		saveButton.addActionListener(new saveListener());
		botPanel.add(deleteButton);
		deleteButton.addActionListener(new deleteListener());
		botPanel.add(firstButton);
		firstButton.addActionListener(new FirstListener());
		botPanel.add(nextButton);
		nextButton.addActionListener(new NextListener());
		//add(topPanel,BorderLayout.NORTH);
		add(botPanel,BorderLayout.SOUTH);
		nameList.setLayout(new GridLayout(list.getSize(),1));
		Student t = list.first();
		while (t!=null) {
			nameList.add(t);
			t = list.advance();
		}
		add(nameListPane,BorderLayout.WEST);
		topPanel.add(nameLabel);
		topPanel.add(firstName);
		topPanel.add(lastName);
		add(topPanel,BorderLayout.NORTH);
		centerPanel.setLayout(new GridLayout(12,2));
		for (i=0; i<4; i++) {
			gradeLabel[i] = new JLabel("Exam "+i+":");
			centerPanel.add(gradeLabel[i]);
			gradeBox[i] = new JTextField(6);
			centerPanel.add(gradeBox[i]);
		}
		centerPanel.add(new JLabel(""));
		centerPanel.add(new JLabel(""));
		centerPanel.add(avgLabel);
		centerPanel.add(avgBox);

		for (i=1; i<=6; i++) {
			centerPanel.add(new JLabel(""));
			centerPanel.add(new JLabel(""));
		}

		add(centerPanel,BorderLayout.CENTER);
		addWindowListener(new MyWindowListener());
		setVisible(true);
	}

	public static void main(String[] args) {
		new GradeBook();
	}

	class MyWindowListener implements WindowListener {

		@Override
		public void windowActivated(WindowEvent arg0) {
			//System.out.println("Activated");	
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			//System.out.println("Closed");	
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			System.out.println("Closing");
			// Put other work here to be done when closing the window
			// Hint: you want to write out a new copy 

			System.exit(0); // Terminate the program
			//System.out.println("I'll be back");
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			//System.out.println("De-Activated");
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			//System.out.println("De-iconified");	
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			//System.out.println("Iconified");
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			//System.out.println("Opened");	
		}

	}

	private class addListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		
			Student p = new Student(GradeBook.this, "", "");
			firstName.setText("");
			lastName.setText("");
			for (int i=0; i<4; i++)
				gradeBox[i].setText("");
			avgBox.setText("");
			list.insertRear(p);
			list.setCurrent(p);
			

		}
	}
	private class saveListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			list.saveCurrent();
		}
	}
	private class deleteListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Student x;
			x = list.deleteCurrent();
			double average = 0;
			if (x!=null) {
				firstName.setText(x.firstName);
				lastName.setText(x.lastName);
				for (int i=0; i<x.exams.length; i++) {
					gradeBox[i].setText(""+x.exams[i]);
					average += x.exams[i];
				}
				average /= x.exams.length;
				avgBox.setText(""+average);
			}
			else {
				firstName.setText("");
				lastName.setText("");
				for (int i=0; i<4; i++)
					gradeBox[i].setText("");
				avgBox.setText("");

			}
	
		}
	}
	private class FirstListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Student x;
			double average = 0;
			x = list.first();
			firstName.setText(x.firstName);
			lastName.setText(x.lastName);
			for (int i=0; i<x.exams.length; i++) {
				gradeBox[i].setText(""+x.exams[i]);
				average += x.exams[i];
			}
			average /= x.exams.length;
			avgBox.setText(""+average);
		}
	}

	
	private class NextListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Student x;
			double average = 0;
			x = list.advance();
			if (x!=null) {
				firstName.setText(x.firstName);
				lastName.setText(x.lastName);
				for (int i=0; i<x.exams.length; i++) {
					gradeBox[i].setText(""+x.exams[i]);
					average += x.exams[i];
				}
				average /= x.exams.length;
				avgBox.setText(""+average);
			}
			else {
				firstName.setText("");
				lastName.setText("");
				for (int i=0; i<4; i++)
					gradeBox[i].setText("");
				avgBox.setText("");

			}
		}
	}

}
