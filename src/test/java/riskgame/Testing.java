package riskgame;

import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Testing {
    Players players;

    @Before
    public void asetup() {
      players = new Players("HeyNow", "Green", 1000000);
    }

    @Test
    public void displayPlayerInfo() {
      players.displayInfo();
    }

    @Test
    public void losePlayerArmies() {
  	  players.loseArmies(5);
    }

    @Test
    public void gainPlayerArmies() {
  	  players.gainArmies(50000);
    }

    @Test
    public void TestingcountriesPlayerHas() {
  	  players.countriesPlayerHas();
    }

    @Test
    public void getPlayerColor() {
  	  players.getColor();
    }


}
