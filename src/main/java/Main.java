
import java.io.IOException;
import twitter4j.TwitterException;

public class Main {
  public static void main(String[] args) throws TwitterException, IOException {
    setUpGame game = new setUpGame();
    game.runningGame();
  }
}
