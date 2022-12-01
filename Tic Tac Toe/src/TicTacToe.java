import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToe extends JFrame{
	
	JButton newgame;
	boolean gameover;
	char[][] board = new char[3][3];
	JButton[][] display = new JButton[3][3];
	JPanel displayPanel = new JPanel();
	JLabel outcome = new JLabel(" ");
	int counter = 0;
	char player = 'X';
	
	
	public TicTacToe() {
		int r,c;
		setTitle("TicTacToe");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		displayPanel.setLayout(new GridLayout(3,3));
		
		for (r=0;r<3;r++)
			for (c=0;c<3;c++) {
				display[r][c] = new JButton(" ");
				display[r][c].addActionListener(new SquareListener(r,c));
				displayPanel.add(display[r][c]);
				board[r][c] = ' ';
			}
		
		add(displayPanel,BorderLayout.CENTER);
		newgame = new JButton("New Game");
		newgame.addActionListener(new NewGameListener());
		add(newgame,BorderLayout.SOUTH);
		add(outcome,BorderLayout.NORTH);
		setVisible(true);
	}
	
	public boolean win(char player) {
		for(int i =0;i<3;i++) {
			if(board[i][0]==player && board[i][1]==player && board[i][2]==player)
				return true;
		}
		for(int i =0;i<3;i++) {
			if(board[0][i]==player && board[1][i]==player && board[2][i]==player)
				return true;
		}
		if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
			return true;
		if(board[2][0]==player && board[1][1]==player && board[0][2]==player)
			return true;
		
		
		return false;
	}
	
	public void	opp() {
		
		if(board[1][1]==' ') {
			display[1][1].setText(""+player);
			board[1][1] = player;
		}
		else if(board[2][0]==' ') {
			
			display[2][0].setText(""+player);
			board[2][0] = player;
		}
		
	}
	
	private class SquareListener implements ActionListener{
		int r,c;
		public SquareListener(int row, int col) {
			r = row;
			c = col;
		}
		public void actionPerformed(ActionEvent arg0) {
			if(board[r][c]!=' ')return;
			if(gameover)return;
			if(counter == 8) {
				outcome.setText("Game Over: Tie");
				gameover = true;
			}
			
			display[r][c].setText(""+player);
			board[r][c] = player;
			counter++;
			
			if(win(player)) {
				outcome.setText("Game Over: "+player+" Wins!!");
				gameover=true;
			}
			if(player=='X')
				player = 'O';
			else
				player = 'X';
			opp();
			if(player=='X')
				player = 'O';
			else
				player = 'X';
			
		}
		
	}
	
	
	private class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int r,c;
			for (r=0;r<3;r++)
				for (c=0;c<3;c++) {
					display[r][c].setText(null);
					board[r][c] = ' ';
					
				}
			outcome.setText(" ");
			gameover=false;
			player = 'X';
			counter=0;
		}
		
	}
	

	public static void main(String[] args) {
		new TicTacToe();

	}

}
