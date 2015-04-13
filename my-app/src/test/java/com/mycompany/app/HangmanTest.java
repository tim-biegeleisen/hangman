import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HangmanTest {

	static GameProvider game;
	static int guesses;
	static String[] words;
	
	@Before
	public void setUp() throws Exception {
		words = new String[] {"xyz", "zyx"};
		guesses = 7;
		game = new GameProvider(words, guesses);
	}

	@After
	public void tearDown() throws Exception {
		words = null;
		guesses = -1;
		game = null;
	}

	@Test
	public void instantiationTest() {
		Assert.assertEquals(guesses, game.guesses);
		
		Assert.assertNotNull(game.word);
		Assert.assertNotNull(game.guessed);
		Assert.assertNotNull(game.guesses);
	}
	
	@Test
	public void guessTest() {
		game.guess('y');
		Assert.assertEquals(guesses-1, game.guesses);
		Assert.assertFalse(game.done());
		
	}
	
	@Test
	public void winTest() {
		for(int x=0; x<guesses-2; x++) {
			game.guess('x');
		}
		game.guess('y');
		game.guess('z');
		Assert.assertTrue(game.won());
		Assert.assertFalse(game.lost());
		Assert.assertTrue(game.done());
	}
	
	@Test
	public void loseTest() {
		for(int x=0; x<guesses; x++) {
			game.guess('y');
		}
		Assert.assertTrue(game.lost());
		Assert.assertFalse(game.won());
		Assert.assertTrue(game.done());
	}

}
