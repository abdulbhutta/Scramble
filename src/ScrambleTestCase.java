import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;



class ScrambleTestCase {
	
	private final Logger log = Logger.getLogger(String.valueOf (this.getClass()));

	@Test
	void checkWord() {
		//public Play(String player1, String player2, String difficulty)
		Play word = new Play(null, null, "assets/Novice.txt");
		String newWord = word.getnewword();
		System.out.println(newWord);
		//assertNotNull();
	}
	
	@Test
	void wordScrambled() {
		String word = "testword";
		assertNotEquals("testword", Play.scramble(word));
	}
	
	@Test
	void test1() {
		String word = "testword";
		assertNotEquals("testword", Play.scramble(word));
	}

	/*
	//private Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    @Test
    public void main(){
        try {
            log.info("Starting execution of main");
            String[] wer = null;
            ;
            ;
            Level level  =new Level();
            level.main( wer);
            assertTrue(true);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void actionPerformed(){
        try {
            log.info("Starting execution of actionPerformed");
            ActionEvent event = null;
            ;
            ;
            Level level  =new Level();
            level.actionPerformed( event);
            assertTrue(true);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ActionEvent extends java.awt.event.ActionEvent {
        public ActionEvent(Object source, int id, String command) {
            super(source, id, command);
        }
    }
	*/
	

}
