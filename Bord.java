/* 
 * Vorname : Izzeldeen
 * Nachname : Alzeer
 * Email izzeldeen.alzeer@tu-clausthal.de
 * @author Izzeldeen ALzeer 
 * version 14.0.1
 * Gruppe Partner : Fadi Abuqutheileh
 * Partner-Email: fadi.abuqutheileh@tu-clausthal.de
 */
package VierGewinnt;

import java.util.LinkedList;

import VierGewinnt.Player.Winner;
import VierGewinnt.Token.Color;

public class Bord extends GameObjekt{
	private static final int COLUMN=7;
	private static final int LINE=6;
	private int columnIndex;
	private static LinkedList<String> redArray=new LinkedList<>();
	private static LinkedList<String> yellowArray= new LinkedList<>();
	
	public int getColumnIndex() {
		return columnIndex;
	}

	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}

	public Bord() {
		feld = new String[LINE][COLUMN];
		for(int i=0; i<LINE; i++) {
			for(int j=0; j<COLUMN; j++) {
				feld[i][j]=" ";
			}
		}
	}
	
	public boolean canDrop(int columnIndex) {
		setColumnIndex(columnIndex);
		if (feld[LINE-1][getColumnIndex()].equals(" ")) {
			return true;
		}
		else
			return false;
	}
	/*f*/public void dropToken(Token token, int columnIndex) throws ColumnFullException, IllegalMoveException {
		setColumnIndex(columnIndex);
		if (canDrop(getColumnIndex())==false) {
			throw new ColumnFullException();
		}
		else {
			for (int i=0; i<LINE; i++) {
				if (feld[i][getColumnIndex()].equals(" ")){
							feld[i][getColumnIndex()]=getToken(token.color);
					break;
				}
			}
			
		}
			
		
	}

	public String toString() {
			return   "["+feld[5][0]+"]"+"["+feld[5][1]+"]"+"["+feld[5][2]+"]"+"["+feld[5][3]+"]"+"["+feld[5][4]+"]"+"["+feld[5][5]+"]"+"["+feld[5][6]+"]\n"
					+"["+feld[4][0]+"]"+"["+feld[4][1]+"]"+"["+feld[4][2]+"]"+"["+feld[4][3]+"]"+"["+feld[4][4]+"]"+"["+feld[4][5]+"]"+"["+feld[4][6]+"]\n"
					+"["+feld[3][0]+"]"+"["+feld[3][1]+"]"+"["+feld[3][2]+"]"+"["+feld[3][3]+"]"+"["+feld[3][4]+"]"+"["+feld[3][5]+"]"+"["+feld[3][6]+"]\n"
					+"["+feld[2][0]+"]"+"["+feld[2][1]+"]"+"["+feld[2][2]+"]"+"["+feld[2][3]+"]"+"["+feld[2][4]+"]"+"["+feld[2][5]+"]"+"["+feld[2][6]+"]\n"
					+"["+feld[1][0]+"]"+"["+feld[1][1]+"]"+"["+feld[1][2]+"]"+"["+feld[1][3]+"]"+"["+feld[1][4]+"]"+"["+feld[1][5]+"]"+"["+feld[1][6]+"]\n"
					+"["+feld[0][0]+"]"+"["+feld[0][1]+"]"+"["+feld[0][2]+"]"+"["+feld[0][3]+"]"+"["+feld[0][4]+"]"+"["+feld[0][5]+"]"+"["+feld[0][6]+"]\n";
			
	}
	
	private String getToken(Color color){
		String t="";
		switch(color) {
			case RED:
				t="X";
				redArray.removeLast();
				break;
			case YELLOW:
				t="O";
				yellowArray.removeLast();
				break;
			}
		return t;	
	}
	
	private String getTok(Color color){
		String t="";
		switch(color) {
			case RED:
				t="X";
				break;
			case YELLOW:
				t="O";
				break;
			}
		return t;	
	}

	private boolean isRowVictory(Color color){
		boolean test = false;
		for (int j=0;j<LINE;j++) {
			for(int i=0; i<4;i++) {
				if (feld[j][i].equals(getTok(color))&&
					feld[j][i].equals(feld[j][i+1])&&
					feld[j][i].equals(feld[j][i+2])&&
					feld[j][i].equals(feld[j][i+3]))
				test=true;
			}
		}
		return test;
	}
	
	private boolean isColumnVictory(Color color){
		boolean test = false;
		for (int i=0;i<LINE;i++) {
			for(int j=0; j<4;j++) {
				if (feld[j][i].equals(getTok(color))&&
					feld[j][i].equals(feld[j+1][i])&&
					feld[j][i].equals(feld[j+2][i])&&
					feld[j][i].equals(feld[j+3][i]))
				test=true;
			}
		}	
		return test;
	}
	
	private boolean isDiagonalVictory(Color color){
		boolean test = false;
		for (int j=0; j<3;j++) {
			for(int i=0;i<4;i++ ) {
				if (feld[j][i].equals(getTok(color))&&
					feld[j][i].equals(feld[j+1][i+1])&&
					feld[j][i].equals(feld[j+2][i+2])&&
					feld[j][i].equals(feld[j+3][i+3]))
				test=true;
			}
		}
		for (int j=0; j<3;j++) {
			for(int i=6;i>2;i-- ) {
				if (feld[j][i].equals(getTok(color))&&
					feld[j][i].equals(feld[j+1][i-1])&&
					feld[j][i].equals(feld[j+2][i-2])&&
					feld[j][i].equals(feld[j+3][i-3]))
				test=true;
			}
		}	
		return test;
	}
//Hier wird der Fall "Sieger" präsentiert.
	public Winner testVictory() {
		Winner winner = Winner.NONE;
		if (isRowVictory(Color.RED)||isColumnVictory(Color.RED)||isDiagonalVictory(Color.RED))
			winner = Winner.RED;
		else if(isRowVictory(Color.YELLOW)||isColumnVictory(Color.YELLOW)||isDiagonalVictory(Color.YELLOW))
			winner = Winner.YELLOW;
		else if (isTie())
			winner = Winner.TIE;
			
		return winner;
	}
	
	public LinkedList<String> getRedArray() {
		return redArray;
	}

	
	public void setRedArray(LinkedList<String> redArray) {
		Bord.redArray = redArray;
		for(int i=0; i<21;i++) {
			redArray.add("X");
		}
	}

	public LinkedList<String> getYellowArray() {
		return yellowArray;
	}

	public void setYellowArray(LinkedList<String> yellowArray) {
		Bord.yellowArray = yellowArray;
		for(int i=0; i<21;i++) {
			yellowArray.add("O");
		}
	}
	
	 public boolean hasToken(Color color) {
		boolean available = false;
		switch(color) {
			case RED:
				if (redArray.getFirst()=="X")
					available=true;
				else 
					available=false;
				break;
			case YELLOW:
				if (yellowArray.getFirst()=="O")
					available=true;
				else 
					available=false;
				break;	
		}
		return available;
	}
//Hier wird der Fall "Unentschieden" präsentiert.
	  private boolean isTie() {
		boolean tie=false;
		if (redArray.getFirst()==null && yellowArray.getFirst()==null)
			tie=true;
	return tie;
		
}

	public static void main(String[] args) throws ColumnFullException, IllegalMoveException {
		Bord b= new Bord();
		Bord b1= new Bord();
		Bord b2= new Bord();
		//Token hier sind die Spielsteine
		Token r= new Token(Color.RED);
		Token y= new Token(Color.YELLOW);
		
		b.setRedArray(redArray);
		b.setYellowArray(yellowArray);

		System.out.println(b.getRedArray());
		System.out.println(b.getYellowArray());
		
		b.dropToken(r, 6);
		b.dropToken(r, 6);
		b.dropToken(r, 6);
		b.dropToken(y, 6);
		b.dropToken(y, 5);
		b.dropToken(r, 5);
		b.dropToken(y, 4);
		b.dropToken(y, 4);
		b.dropToken(r, 4);
		b.dropToken(y, 3);
		b.dropToken(y, 2);
		b.dropToken(r, 2);	
		
		System.out.println(b.getRedArray());
		System.out.println(b.getYellowArray());
		
		b1.dropToken(y, 6);
		b1.dropToken(y, 6);
		b1.dropToken(y, 6);
		b1.dropToken(y, 5);
		b1.dropToken(r, 5);
		b1.dropToken(y, 4);
		b1.dropToken(r, 4);
		b1.dropToken(r, 4);
		b1.dropToken(r, 4);
		b1.dropToken(r, 4);
		b1.dropToken(r, 3);
		b1.dropToken(y, 2);
		b1.dropToken(r, 2);
		b1.dropToken(r, 1);
		b1.dropToken(y, 0);
		

		b2.dropToken(r, 6);
		b2.dropToken(r, 6);
		b2.dropToken(r, 6);
		b2.dropToken(y, 6);
		b2.dropToken(y, 5);
		b2.dropToken(r, 5);
		b2.dropToken(y, 5);
		b2.dropToken(y, 4);
		b2.dropToken(y, 4);
		b2.dropToken(r, 4);
		b2.dropToken(y, 3);
		b2.dropToken(y, 3);
		b2.dropToken(r, 3);
		b2.dropToken(r, 3);
		
	

		System.out.println(b.toString());
		
		System.out.println(b1.toString());
		
		System.out.println(b2.toString());
		
		
		System.out.println(b.testVictory()+" is the Winner of the first game");
		System.out.println(b1.testVictory()+" is the Winner of the second game");
		System.out.println(b2.testVictory()+" is the Winner of the third game");
	}

}
