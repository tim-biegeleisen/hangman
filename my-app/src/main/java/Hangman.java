import java.util.Scanner;


public class Hangman {
	static Scanner input;
	static GameProvider game;
	
	public static void main(String[] args) {
		
		final String[] WORDS = {"hi", "bye", "fak", "duck"};
		final String CLEAR = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
		final String WIN ="U WIN!";
		final String LOSE ="U LOSE!";
		
		input = new Scanner(System.in);
		
		game = new GameProvider(WORDS, 7);
		
		while(!game.done()) {
			
			System.out.println("progress so far: "+new String(game.guessed));
			System.out.println("you have "+game.guesses+" guesses left!");
			System.out.print("\n pick a letter: ");
			game.guess(input.next().charAt(0));
			System.out.println(CLEAR);
		}
		System.out.println(game.won() ? WIN : LOSE);
		
		input.close();
	}
}
