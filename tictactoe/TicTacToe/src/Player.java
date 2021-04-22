import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unused")

public abstract class Player {
	private String name;
	private char symbol;
	private List<Integer> moves = new ArrayList<Integer>();
	private int wins = 0;
	private static List<List<Integer>> possibleWins  = new ArrayList<List<Integer>>();
	static {
		possibleWins.add(Arrays.asList(1,2,3));
		possibleWins.add(Arrays.asList(4,5,6));
		possibleWins.add(Arrays.asList(7,8,9));
		possibleWins.add(Arrays.asList(1,4,7));
		possibleWins.add(Arrays.asList(2,5,8));
		possibleWins.add(Arrays.asList(3,6,9));
		possibleWins.add(Arrays.asList(1,5,9));
		possibleWins.add(Arrays.asList(3,5,7));
	}
	
	Player(String name, char symbol){
		this.name = name;
		this.symbol = symbol;
	}

	public char getSymbol() {
		// TODO Auto-generated method stub
		return this.symbol;
	}
	
	public String getName() {
		return this.name;
	}
		
	abstract int getMove(char[][] board, HashMap<Integer, Character> map);
	
	public void setMoves(int move) {
		this.moves.add(move);
	}
	
	public void reset() {
		this.moves = new ArrayList<Integer>();
	}
	
	public int getWins() {
		return this.wins;
	}
	
	public boolean checkGameOver() {
		
		
		for (List<Integer> winCombo : possibleWins) {
			if (this.moves.containsAll(winCombo)) {
				System.out.println(this.name + " wins!");
				this.wins++;
				return true;
			}
		}
		
		return false;
	}
	
}
