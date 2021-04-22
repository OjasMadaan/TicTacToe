import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class BotPlayer extends Player{
	

	BotPlayer(String name) {
		super(name, 'O');
		System.out.println("Bot Player Created || Name = " + name + " || Symbol = " + 'O');
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getMove(char[][] board, HashMap<Integer, Character> map) {
		System.out.println("CPU's turn... Press Enter to Continue");
		
		Scanner scan = new Scanner(System.in);
		
		scan.nextLine();
		
		Random rand = new Random();
		int move = rand.nextInt(9)+1;
		
		while (map.get(move) != ' ') {
			move = rand.nextInt(9)+1;
		}
		
		this.setMoves(move);
		
		
		
		return move;
	}
	
	
	
	
}
