import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Life extends JFrame{

	boolean board[][];
	Square[][] display;
	boolean running = false;
	JButton[] buttonArray;
	JPanel displayPanel = new JPanel();
	JPanel controlPanel = new JPanel();
	JPanel statusPanel = new JPanel();
	
	JButton clear = new JButton("Clear");
	JButton move = new JButton("Move");
	JButton run = new JButton("Run");
	JLabel countLabel = new JLabel("Life Count");
	JTextField lifeCountDisplay = new JTextField(5);
	Timer t = new Timer(200, new MoveListener());

	public Life(int size) {
		int r,c;
		board = new boolean[size][size];
		display = new Square[size][size];

		setTitle("Game of Life");
		setSize(size*50,size*55);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		displayPanel.setLayout(new GridLayout(size,size));

		display = new Square[size][size];
		for(r=0;r<size;r++) {
			for(c=0;c<size;c++) {
				display[r][c] = new Square(this,r,c);
				displayPanel.add(display[r][c]);
				board[r][c] = false;
			}
		}
		add(displayPanel,BorderLayout.CENTER);

		statusPanel.add(countLabel);
		statusPanel.add(lifeCountDisplay);
		add(statusPanel,BorderLayout.NORTH);

		controlPanel.add(clear);
		controlPanel.add(move);
		move.addActionListener(new MoveListener());
		controlPanel.add(run);
		run.addActionListener(new RunListener());
		add(controlPanel,BorderLayout.SOUTH);
		setVisible(true);
	}

	private void makeMove() {
		int r,c;
		int count;

		for(r=0;r<board.length;r++)
			for(c=0;c<board[r].length;c++) {
				count = 0;
				if(r-1>=0 && c-1>=0 && display[r-1][c-1].alive) count++;
				if(r-1>=0 && display[r-1][c].alive) count++;
				if(r-1>=0 && c+1<display.length && display[r-1][c+1].alive) count++;
				if(c-1>=0 &&display[r][c-1].alive) count++;
				if(c+1<display.length && display[r][c+1].alive) count++;
				if(r+1<display.length && c-1>=0 && display[r+1][c-1].alive) count++;
				if(r+1<display.length && display[r+1][c].alive) count++;
				if(c+1<display.length && r+1<display.length && display[r+1][c+1].alive) count++;
				if(display[r][c].alive) {
					if(count<2 || count>3)
						board[r][c]=false;
					else
						board[r][c]=true;
				}
				else
					if(count==3) board[r][c]=true;
			}
		for(r=0;r<board.length;r++)
			for(c=0;c<board[r].length;c++) {
				if(board[r][c]!=display[r][c].alive) {
					if(display[r][c].alive)
						display[r][c].setBackground(null);
					else
						display[r][c].setBackground(Color.green);
					display[r][c].alive = board[r][c];
				}
			}

	}

	private class MoveListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			makeMove();

		}

	}
	
	private class RunListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(!running) {
				t.start();
				run.setText("Stop");
				running = true;
			}
			else {
				running = false;
				t.stop();
				run.setText("Run");
			}
		}
		
	}

	public static void main(String[] args) {
		new Life(10);

	}

}
