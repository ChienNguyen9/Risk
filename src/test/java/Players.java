import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Players {

  private String sName;
  private String sColor;
  private int nDice;
  private int nArmies;

  private int numOfArmies;
  private HashMap<String, Country> hasCountry;
  private HashMap<String, Continent> hasContinent;

  @Test
  public Players(String name, String color, int nArmy) {
	  this.sName = name;
	  this.sColor = color;
    this.nDice = 0;
	  this.numOfArmies = nArmy;
	  hasCountry = new HashMap<String, Country>();
	  hasContinent = new HashMap<String, Continent>();
  }

  @Test
  public String getName() {
    return this.sName;
  }

  @Test
  public String getColor() {
    return this.sColor;
  }

  @Test
  public int getNumOfArmies() {
	  return numOfArmies;
  }

  @Test
  public void setDice(int dice) {
    this.nDice = dice;
  }

  @Test
  public int getDice() {
    return this.nDice;
  }

  @Test
  public void displayInfo() {
    System.out.println("=============================================================");
    System.out.println("Name: " + this.sName);
    System.out.println("Color: " + this.sColor);
    System.out.println("=============================================================");
  }

  @Test
  public void gainCountry(Country nameOfCountry) {
	  System.out.println(nameOfCountry.getName() + " has been acquired by " + sName + ".");
	  hasCountry.put(nameOfCountry.getName(), nameOfCountry);
  }

  @Test
  public void gainCountry(ArrayList<Country> listOfCountries) {
	  for(int i = 0; i < listOfCountries.size(); i++) {
		  hasCountry.put(listOfCountries.get(i).getName(), listOfCountries.get(i));
	  }
  }

  @Test
  public void lostCountry(String nameOfCountry) {
	  System.out.println(nameOfCountry + " is no longer occupied by " + sName + ".");
	  hasCountry.remove(nameOfCountry);
  }

  @Test
  public void gainContinent(Continent nameOfContinent) {
	  System.out.println(nameOfContinent.getName() + " is now controlled by " + sName + ", and after every turn will receive " + nameOfContinent.getExtraArmies() + " bonus armies.");
	  hasContinent.put(nameOfContinent.getName(), nameOfContinent);
  }

  @Test
  public void lostContinent(String nameOfContinent) {
	  hasContinent.remove(nameOfContinent);
  }

  @Test
  public ArrayList<Country> countriesPlayerHas(){
	  return new ArrayList<Country>(hasCountry.values());
  }

  @Test
  public void gainArmies(int nArmies) {
	  numOfArmies = numOfArmies + nArmies;
	  System.out.println(sName + " has gained " + nArmies + " armies and now has " + numOfArmies + " total armies.");
  }

  @Test
  public void loseArmies(int nArmies) {
	  numOfArmies = numOfArmies - nArmies;
	  System.out.println(sName + "'s remaining number of armies: " + numOfArmies);
  }

}
