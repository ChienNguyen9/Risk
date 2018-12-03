import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

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
  @Test
  public void testSameCardTradeIn() {
    playerHand hand = new playerHand();
    Card card1 = new Card("Infantry", "Japan");
    Card card2 = new Card("Infantry", "China");
    Card card3 = new Card("Infantry", "Indonesia");
    hand.add(card1);
    hand.add(card2);
    hand.add(card3);
    hand.removeFromHand(0,1,2);
  }

  @Test
  public void testUniqueCardsTradeIn() {
    playerHand hand = new playerHand();
    Card card1 = new Card("Infantry", "Japan");
    Card card2 = new Card("Cavalry", "China");
    Card card3 = new Card("Artillery", "Indonesia");
    hand.add(card1);
    hand.add(card2);
    hand.add(card3);
    hand.removeFromHand(0,1,2);
  }
  @Test
  public void testInvalidTradeIn() {
    playerHand hand = new playerHand();
    Card card1 = new Card("Infantry", "Japan");
    Card card2 = new Card("Infantry", "China");
    Card card3 = new Card("Artillery", "Indonesia");
    hand.add(card1);
    hand.add(card2);
    hand.add(card3);
    hand.removeFromHand(0,1,2);
  }

}
