import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import twitter4j.TwitterException;

//Create a deck with 42 cards
//Ignores wild cards and secret mission cards
public class TestTwitter {

  @Test
  public void messagePost() throws TwitterException {
    PostTwitter postTwitter = new PostTwitter();
    try{
      postTwitter.TweetOnTwitter("Testing Unit case");
    }catch (TwitterException e) {
      System.out.println("Did not post to twitter.");
    }
  }

}
