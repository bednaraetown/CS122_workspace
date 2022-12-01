import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

public class MineButton extends JButton{

	MineSweeper game;
	int row,col, x;
	boolean mine;
	boolean flag;
	boolean exposed = false;
	boolean win = false;
	int size;
	MineButton[][] board;
	public MineButton(MineSweeper parentGame, int r,int c, MineButton[][] bd, int s) {
		game = parentGame;
		row=r;
		col=c;
		board = bd; 
		size =s;
		mine = (Math.random()<0.15); 	
		addMouseListener(new ButtonListener());

	}



	private class ButtonListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1 && !flag){
				if(!mine) {
					expose(row, col);
					exposed = true;
					checkWin();
					if(win) {
						JOptionPane.showMessageDialog(null, "YOU WIN");

					}
				}else {
					setBackground(Color.RED);
					setText("#");
					exposed = true;
					JOptionPane.showMessageDialog(null, "Game Over, You Lose!");
				}
			}else if(e.getButton() == MouseEvent.BUTTON3 && !exposed) {
				if(!flag) {
					setText("|>");
					setBackground(Color.yellow);
					flag = true;
				}else {
					setText(null);
					setBackground(null);
					flag = false;
				}
			}
		}
		public void mousePressed(MouseEvent e) {

		}
		public void mouseReleased(MouseEvent e) {

		}
		public void mouseEntered(MouseEvent e) {

		}
		public void mouseExited(MouseEvent e) {

		}

	}	
	public void expose(int row, int col) {
		int r,c,count=0;
		if (board[row][col].exposed) return;
		board[row][col].exposed = true;
		if (board[row][col].mine==false){
			board[row][col].setBackground(Color.CYAN);
			for (r=-1; r<=1; r++)
				for (c=-1; c<=1; c++) {
					try {
					if (board[row+r][col+c].mine) count++;
					}catch(IndexOutOfBoundsException error){
						
					}
					

				}

		}

		if (count>0)
			board[row][col].setText(""+count);
		else {
			for (r=-1; r<=1; r++)
				for (c=-1; c<=1; c++)
					try {
					if (!board[row+r][col+c].exposed)
						expose(row+r,col+c);
					}catch(IndexOutOfBoundsException error) {
						
					}
		}
	}

	public void checkWin() {
		int total = size*size;
		int expCount = 0;
		for (int i=0;i<size;i++) {
			for (int j=0;j<size;j++) {
				if (board[i][j].exposed || board [i][j].mine) {
					expCount++;
					System.out.print(expCount);
				}
			}
		}
		if(expCount==total) {
			win=true;
		}
	}


}
