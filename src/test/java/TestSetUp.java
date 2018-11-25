import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestSetUp {

  @Test
  public void initBoardGame() {
    setUpGame game = new setUpGame();
    game.creatingBoard();

    game.numberOfPlayerPlaying(3);

    game.initPlayer(true);

    game.chooseFirstTurn(true);

    //game.claimCountry();
    //game.setArmyToCountry();
  }
}
