import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
	private static int round = 1;
	private static Scanner scan = new Scanner(System.in);
	private static List<Player> players = new ArrayList<Player>();
	private static Player player1, player2;
	private static char[][] gameBoard = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
	static HashMap<Integer, Character> map = new HashMap<Integer, Character>();

	public static void main(String[] args) {
		banner();
		gameSetup();
		boolean play = true;
		
		while (play) {
			clearBoard();
			player1.reset();
			player2.reset();
			printBoard(gameBoard);
			while (true) {
				initialiseMap();
				addPiece(gameBoard, player1.getMove(gameBoard, map), player1);
				if (player1.checkGameOver()) break;
				initialiseMap();
				addPiece(gameBoard, player2.getMove(gameBoard, map), player2);
				if (player2.checkGameOver()) break;
				if (boardFull()) {
					System.out.println("Its a tie! ");
					break;
				}
			}
			play = playAgain();
			if (play) {
				clearScreen();
				round++;
				banner();
				
			}
		}
		
		printResult();
	}

	public static void printBoard(char[][] board) {
		System.out.println("=====");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
				if (j == 0 || j==1) {
					System.out.print("|");
				}
			}
			if (i<2) {
				System.out.println();
				System.out.print("-+-+-");
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("=====");
		System.out.println();
	}

	public static void addPiece(char[][] board, int pos, Player player) {
		char symbol = 'X';

		if (player.getClass().equals(HumanPlayer.class)) {
			symbol = player.getSymbol();
		} else {
			symbol = 'O';
		}

		switch (pos) {
		case 1:
			board[0][0] = symbol;
			break;
		case 2:
			board[0][1] = symbol;
			break;
		case 3:
			board[0][2] = symbol;
			break;
		case 4:
			board[1][0] = symbol;
			break;
		case 5:
			board[1][1] = symbol;
			break;
		case 6:
			board[1][2] = symbol;
			break;
		case 7:
			board[2][0] = symbol;
			break;
		case 8:
			board[2][1] = symbol;
			break;
		case 9:
			board[2][2] = symbol;
			break;
		}
		clearScreen();
		printBoard(gameBoard);
	}

	private static void clearScreen() {
		// TODO Auto-generated method stub
		System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen
	}

	public static void gameSetup() {
		System.out.println("------------------------------------------------");
		System.out.println("Select Game Mode: Single [1] or Multi Player [2]");
		System.out.println("------------------------------------------------");
		int choice = scan.nextInt();
		scan.nextLine();
		if (choice == 1) {
			System.out.println("Enter Player Name: ");
			String name = scan.nextLine();
			player1 = new HumanPlayer(name, 'X');
			players.add(player1);
			player2 = new BotPlayer("CPU");
			players.add(player2);
		} else {
			System.out.println("Enter Player 1 Name: ");
			String name1 = scan.nextLine();
			player1 = new HumanPlayer(name1, 'X');
			System.out.println("Enter Player 2 Name: ");
			String name2 = scan.nextLine();
			player2 = new HumanPlayer(name2, 'O');
		}
	}

	private static void initialiseMap() {
		map.put(1, gameBoard[0][0]);
		map.put(2, gameBoard[0][1]);
		map.put(3, gameBoard[0][2]);
		map.put(4, gameBoard[1][0]);
		map.put(5, gameBoard[1][1]);
		map.put(6, gameBoard[1][2]);
		map.put(7, gameBoard[2][0]);
		map.put(8, gameBoard[2][1]);
		map.put(9, gameBoard[2][2]);
	}
	
	private static boolean boardFull() {
		for (char[] row : gameBoard) {
			for (char c : row) {
				if (c == ' ') {
					return false;
				}
			}
		}
		return true;
		
	}
	
	private static boolean playAgain() {
		Scanner s = new Scanner(System.in);
		System.out.println("-----------------------------------------");
		System.out.println("Would you like to play again? (Yes or No)");
		System.out.println("-----------------------------------------");
		String input = s.nextLine();
		
		while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
			System.out.println("--------------------------------------");
			System.out.println("Please enter a valid input (yes or no)");
			System.out.println("--------------------------------------");
			input = s.nextLine();
		}
		
		
		if (input.equalsIgnoreCase("yes")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	private static void clearBoard() {
		gameBoard = new char[][]{ { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
	}
	
	private static void printResult() {
		System.out.println("===============");
		System.out.println("EXITING GAME...");
		System.out.println(player1.getName() + " Score: " + player1.getWins());
		System.out.println(player2.getName() + " Score: " + player2.getWins());
		System.out.println("===============");
	}
	
	private static void banner() {
		System.out.println("===========");
		System.out.println("TIC-TAC-TOE");
		System.out.println("===========");
		System.out.println("  Round"+" " + round);
		System.out.println("===========");
		
	}
	
}
