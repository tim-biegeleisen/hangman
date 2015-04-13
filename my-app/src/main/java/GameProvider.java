import java.util.Random;
import java.util.Scanner;


public class GameProvider {
	String word;
	char[] guessed;
	int guesses;
	Scanner scan;
	char separator;
	
	
	public GameProvider(String[] words,int guesses) {
		separator ='-';
		this.guesses = guesses;
		
		word = words[new Random().nextInt(words.length-1)];
		guessed = new char[word.length()];
		
		for(int x=0; x < word.length(); x++) {
			guessed[x] = separator;
		}
	}

	public boolean done() {
		if(won() || lost()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean won() {
		return new String(guessed).indexOf(separator)==-1;
	}
	
	public boolean lost() {
		return guesses == 0 && new String(guessed).indexOf(separator)!=-1;
	}

	public void guess(char guess) {
		
		for(int x = 0; x < word.length(); x++) {
			if (word.toCharArray()[x] == guess) {
				guessed[x] = guess;
			}
		}
		guesses--;
	}
}
