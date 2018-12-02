import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestCountry {

  @Test
  public void TestSetPlayer() {
    
    Country country = new Country("China");
    Players player = new Players("Georgy",5);
    
    country.setPlayer(player);
    country.getPlayer();

    country.occupied();
  }

  @Test
  public void TestSetArmies() {

    Country country = new Country("China");
    Players player = new Players("Georgy",5);

    country.setPlayer(player);
    country.setNumberOfArmies(player.getNumOfArmies());
    country.getArmies();

    country.incArmies(1);
    country.decArmies(1);
  }

}
