import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class TestPlayers {

  @Test
  public void initPlayerGainAmries(){
		Players player = new Players("Georgy", 1000);
		player.gainArmies(10);
    player.displayInfo();
    player.getNumOfArmies();
    player.getName();
	}

  @Test
  public void initPlayerLoseAmries(){
		Players player = new Players("Georgy", 200);
		player.loseArmies(10);
    player.displayInfo();
    player.getNumOfArmies();
    player.getName();
	}

}
