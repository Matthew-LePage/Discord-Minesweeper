//By Ardaceus
//Makes a minesweeper game that you can post in Discord for your friends.

// NOTE: Discord has a max emoji limit of 99 in a message,
// in order for the copy paste to work for games above 100 total tiles,
// copy the text result in segments accordingly in seperate messages

public class MineCreator {
	public static void main(String[] args) {
		// How many bombs will be put into the grid
		short bombs = 10;
		
		// How wide and tall the board is
		// If this was a method, it would take variables from the method call
		byte boardy = 10;
		byte boardx = 10;
		// The board of the game
		// -1 indicates, the tile has not been set
		// 0 indicates no bombs are on the tile
		// 1-8 indicates how many bombs are around the tile
		// 10 indicates the position of a bomb
		byte [][]board = new byte[boardy][boardx];
		for (byte i = 0; i != boardy; i++) {
			for (byte j = 0; j != boardx; j++) {
				board[i][j] = -1;
			}
		}
		
		// Generates Bomb locations, making sure not to overlap bombs
		for (short i = 0; i != bombs; i++) {
			int x = (byte)(Math.random() * boardx);
			int y = (byte)(Math.random() * boardy);
			if (board[y][x] == 10) {
				i--;
			} else {
				board[y][x] = 10;
			}
		}
		
		// These variables are to prevent out of bounds exceptions
		boolean ceiling = true;
		boolean leftwall = true;
		boolean rightwall = false;
		boolean floor = false;
		// This variable is for counting how many bombs surround a tile
		byte bombtotal = 0;
		
		for (int i = 0; i != boardy; i++) {
			// If on the first row, there is no row above
			ceiling = (i == 0);
			// If on the last row, there is no row below
			floor = (i == boardy - 1);
			
			for (int j = 0; j != boardx; j++) {
				// If on the first value of a row, there is no column left
				leftwall = (j == 0);
				// If on the last value of a row, there is no column right
				rightwall = (j == boardx -1);

				bombtotal = 0;
				if (board[i][j] != 10){
					if (ceiling == false) {
						//Top Left
						if (leftwall == false)
							if (board[i-1][j-1] == 10)
								bombtotal++;
						//Above
						if (board[i-1][j] == 10)
							bombtotal++;
						//Top Right
						if (rightwall == false)
							if (board[i-1][j+1] == 10)
								bombtotal++;
					}
					//Left
					if (leftwall == false)
						if (board[i][j-1] == 10)
							bombtotal++;
					//Right
					if (rightwall == false)
						if (board[i][j+1] == 10)
							bombtotal++;
					
					if (floor == false) {
						//Bottom Left
						if (leftwall == false)
							if (board[i+1][j-1] == 10)
								bombtotal++;
						//Below
						if (board[i+1][j] == 10)
							bombtotal++;
						//Bottom Right
						if (rightwall == false)
							if (board[i+1][j+1] == 10)
								bombtotal++;
					}
				}
				switch (bombtotal) {
					case 0:
						System.out.print("||:white_large_square:|| ");
						break;
					case 1:
						System.out.print("||:one:|| ");
						break;
					case 2:
						System.out.print("||:two:|| ");
						break;
					case 3:
						System.out.print("||:three:|| ");
						break;
					case 4:
						System.out.print("||:four:|| ");
						break;
					case 5:
						System.out.print("||:five:|| ");
						break;
					case 6:
						System.out.print("||:six:|| ");
						break;
					case 7:
						System.out.print("||:seven:|| ");
						break;
					case 8:
						System.out.print("||:eight:|| ");
						break;
					case 10:
						System.out.print("||:bomb:|| ");
						break;
				}
			}
			System.out.println();
		}
	}
}
