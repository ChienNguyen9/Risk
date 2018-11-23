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
    player.getNumOfCredits();
    player.getName();
    player.gainCredits(100);
    player.loseCredits(100);
    player.gainUndo(100);
    player.loseUndo(100);
	}

  @Test
  public void initPlayerLoseAmries(){
		Players player = new Players("Georgy", 200);
		player.loseArmies(10);
    player.displayInfo();
    player.getNumOfArmies();
    player.getNumOfCredits();
    player.getName();
    player.gainCredits(500);
    player.loseCredits(100);
    player.gainUndo(500);
    player.loseUndo(100);
	}

  @Test
  public void nameWithSymbol(){
		Players player = new Players("Georgy-=-=12", 200);
		player.loseArmies(10);
    player.displayInfo();
    player.getNumOfArmies();
    player.getNumOfCredits();
    player.getName();
    player.gainCredits(100);
    player.gainUndo(100);
	}

  @Test
  public void negativeArmies(){
		Players player = new Players("Georgy-=-=12", -1);
		player.loseArmies(10);
    player.displayInfo();
    player.getNumOfArmies();
    player.getNumOfCredits();
    player.getName();
    player.gainCredits(-100);
    player.loseCredits(100);
    player.gainUndo(-100);
    player.loseUndo(100);
	}

  @Test
  public void subtractArmies(){
		Players player = new Players("Georgy-=-=12", -1);
		player.loseArmies(-110);
    player.displayInfo();
    player.getNumOfArmies();
    player.getNumOfCredits();
    player.getName();
	}

  @Test
  public void positiveDice(){
		Players player = new Players("Georgy-=-=12", -1);
		player.setDice(4);
    player.getDice();
	}

  @Test
  public void negativeDice(){
		Players player = new Players("Georgy-=-=12", -1);
		player.setDice(-1);
    player.getDice();
	}

  @Test
  public void zeroDice(){
		Players player = new Players("Georgy-=-=12", -1);
		player.setDice(0);
    player.getDice();
	}

  @Test
  public void testGainCountry(){
		Players player = new Players("Georgy-=-=12", -1);
    Country testCountry = new Country("China");
		player.gainCountry(testCountry);
	}

  @Test
  public void testLoseCountry(){
		Players player = new Players("Georgy", -1);
    Country testCountry = new Country("Japan");
		player.lostCountry("Japan");
	}

  @Test
  public void testGainContinent(){
		Players player = new Players("Georgy-=-=12", -1);
    Country testCountry = new Country("China");
    ArrayList<Country> localCountries = new ArrayList<Country>();
    localCountries.add(testCountry);
    Continent testContinent = new Continent("US", 10, localCountries);
		player.gainContinent(testContinent);
	}

  @Test
  public void testLoseContinent(){
		Players player = new Players("Georgy-=-=12", -1);
    Country testCountry = new Country("China");
    ArrayList<Country> localCountries = new ArrayList<Country>();
    localCountries.add(testCountry);
    Continent testContinent = new Continent("US", 10, localCountries);
		player.gainContinent(testContinent);
    player.lostContinent("China");
	}

  @Test
  public void testLoseContinentNonExist(){
		Players player = new Players("Georgy-=-=12", -1);
    Country testCountry = new Country("China");
    ArrayList<Country> localCountries = new ArrayList<Country>();
    localCountries.add(testCountry);
    Continent testContinent = new Continent("US", 10, localCountries);
		player.gainContinent(testContinent);
    player.lostContinent("blah");
	}

  @Test
  public void getPlayerCountriesTesting(){
    Players player = new Players("Georgy-=-=12", -1);
    Country testCountry = new Country("China");
		player.gainCountry(testCountry);
    player.countriesPlayerHas();
	}

  @Test
  public void gainCards(){
    Players player = new Players("Georgy-=-=12", -1);
    Card card = new Card( "Type", "Japan" );
    player.gainRiskCard(card);
    player.getPlayersHand();
	}

  @Test
  public void loseCards(){
    Players player = new Players("Georgy-=-=12", -1);
    Card card = new Card( "Type", "Japan" );
    int[] arrayCard = new int[5];
    player.gainRiskCard(card);
    player.loseCards(arrayCard);
    player.getPlayersHand();
	}

}
