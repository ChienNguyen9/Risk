import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestPlayerHand {

  @Test
  public void EnoughCards() {
    playerHand hand = new playerHand();
    Card card = new Card("1", "Japan");
    hand.add(card);
    hand.add(new Card("2", "China"));
    hand.add(new Card("3", "Blah"));
    hand.getHand();
  }


}
