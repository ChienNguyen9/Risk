import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestGameCredit {

  @Test
  public void TestPlayerCredit() {
    Players player = new Players("TestingUnit", 100);
    setUpGame game = new setUpGame();
    game.purchaseCredits(player, 1, true);
  }




}
