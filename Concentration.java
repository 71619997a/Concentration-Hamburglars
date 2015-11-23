import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

		
public class Concentration {

    //instance variables
    private Tile[][] _board;     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private String[] _words = {"A","B","C","D","E","F","G","H","A","B","C","D","E","F","G","H"};     //list of unique Strings used for Tile vals
    private static int _numRows = 4;

    //insert constructor and methods here
    public Concentration() {
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

	printBoard();
	processMatch(tile1,tile2);
	

    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
	game.play();
    }

}//end class Concentration

