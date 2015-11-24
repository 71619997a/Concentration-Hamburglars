/* Team Hamburglars -- Sarah Yoon, Gabriel Marks
   APCS1 pd10
   HW36 -- Some Folks Call It a Memory
   2015-11-23 */

import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

		
public class Concentration {

    //instance variables
    private Tile[][] _board;     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private String[] _words = {"A","B","C","D","E","F","G","H","A","B","C","D","E","F","G","H"};     //list of unique Strings used for Tile vals
    private static int _numRows = 4;
    private int _numberMoves;

    //insert constructor and methods here
    public Concentration() {
	_numberMoves = 0;
	_numberFaceUp = 0;
	_board = new Tile[_numRows][_numRows];
	for(int i = 0;i < _numRows;i++) {
	    for(int j = 0; j < _numRows;j++) {
		int wordN = (int)(Math.random()*16);
		while(_words[wordN].equals(" ")) {
		    wordN = (int)(Math.random()*16);
		}
		_board[i][j] = new Tile(_words[wordN]);
		_words[wordN] = " "; //kinda sloppy but meh
	    }
	}
    }
    //precond: both tiles assumed to be facing up because user just picked them
    //This function checks if a and b match, and flips accordingly
    public void processMatch(Tile a, Tile b) {
	if(!a.equals(b)) {
	    a.flip();
	    b.flip();
	    _numberFaceUp -= 2;
	    System.out.println("No match! Try again:");
	    printBoard();
	}
    }
    //Takes coordinates as input and flips those tiles, prints them, sends to processmatch
    public void flipFromInput() {
	System.out.println("Enter x-coordinate of the first tile: ");
	int x1 = Keyboard.readInt();
	System.out.println("Enter y-coordinate of the first tile: ");
	int y1 = Keyboard.readInt();
	System.out.println("Enter x-coordinate of the second tile: ");
	int x2 = Keyboard.readInt();
	System.out.println("Enter y-coordinate of the second tile: ");
	int y2 = Keyboard.readInt();
	
	Tile tile1 = _board[x1][y1];
	Tile tile2 = _board[x2][y2];
	tile1.flip();
	tile2.flip();
	_numberFaceUp += 2;
	_numberMoves += 1;

	printBoard();
	processMatch(tile1,tile2);
    }

    public void printBoard() {
	for (Tile[] i : _board) {
	    for (Tile i2: i) {
		System.out.print(i2.toString() + "\t");
	    }
	    System.out.println();
	}
    }
    
    public void play() {
	while (_numberFaceUp < (16)) {
	    flipFromInput();
	}
	System.out.println("Congratulations! You won in " + _numberMoves + " moves!");
    }
	

    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
	game.play();
    }

}//end class Concentration

