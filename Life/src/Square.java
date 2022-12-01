import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Square extends JButton{
	Life game;
	int row, col;
	boolean alive = false;
	public Square(Life parentGame,int r,int c) {
		game = parentGame;
		row=r;
		col=c;
		addActionListener(new SquareListener());
	}
	
	private class SquareListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("You Clicked Square ("+row+","+col+")");
			if(!alive) {
				setBackground(Color.green);
				
			}
			else
				setBackground(null);
			alive=!alive;
		}
		
	}
}
