import java.util.HashMap;
import java.util.Scanner;

public class HumanPlayer extends Player {
	
	HumanPlayer(String name, char symbol) {
		super(name, symbol);
		System.out.println("Human Player Created || Name = " + name + " || Symbol = " + symbol);

	}
	
	@Override
	public int getMove(char[][] board, HashMap<Integer, Character> map) {
		int move;
		Scanner scan = new Scanner(System.in);
		System.out.println(super.getName() + " || Enter Placement (1-9)");
		move = scan.nextInt();
		while (move < 1 || move > 9 || map.get(move) != ' ' ) {
			System.out.println("Enter valid placement: (1-9)");
			move = scan.nextInt();
		}
		
		this.setMoves(move);
		
		return move;
	}
	
}
