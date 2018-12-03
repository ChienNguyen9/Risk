import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class TestRiskBoard {

  @Test
  public void testReturnMap(){
    
    String countryFile = "src/test/java/Countries.txt";
    String borderingCountryFile = "src/test/java/BorderingCountries.txt";
    String continentFile = "src/test/java/Continents.txt";
    String fileLine;
    RiskBoard board = new RiskBoard();
    
    try{
  		BufferedReader reader = new BufferedReader(new FileReader(countryFile));
  		StringBuilder stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null) {
  			stringBuilder.append(fileLine);
		   }
  		String fileInput = stringBuilder.toString();
  		String[] Countries = fileInput.split("\t");
  		System.out.println(Arrays.toString(Countries) + "\n");

  		reader = new BufferedReader(new FileReader(borderingCountryFile));
  		stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null){
  			stringBuilder.append(fileLine);
  		}
  		fileInput = stringBuilder.toString();
  		String[] borderingCountries = fileInput.split("\t");
  		System.out.println(Arrays.toString(borderingCountries));

  		reader = new BufferedReader(new FileReader(continentFile));
  		stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null) {
  			stringBuilder.append(fileLine);
  		}
  		fileInput = stringBuilder.toString();
  		String[] Continents = fileInput.split("\t");
  		System.out.println(Arrays.toString(Continents) + "\n");

		  board.SetBoard(Countries, Continents, borderingCountries);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
    }
    
    board.returnCountries();
    board.returnNameOfCountry("China");

    board.returnBorders("China");
    board.verifyBorder("China", "India");
    board.verifyBorder("China", "Brazil");

    board.returnContinents();
    board.returnNameOfContinent("Asia");
	board.returnLocalCountries("Asia");   
    
  }

  @Test
  public void testCountryStatus(){
    
    String countryFile = "src/test/java/Countries.txt";
    String borderingCountryFile = "src/test/java/BorderingCountries.txt";
    String continentFile = "src/test/java/Continents.txt";
    String fileLine;
    RiskBoard board = new RiskBoard();
    Players player = new Players("Georgy",10);
    
    try{
  		BufferedReader reader = new BufferedReader(new FileReader(countryFile));
  		StringBuilder stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null) {
  			stringBuilder.append(fileLine);
		   }
  		String fileInput = stringBuilder.toString();
  		String[] Countries = fileInput.split("\t");
  		System.out.println(Arrays.toString(Countries) + "\n");

  		reader = new BufferedReader(new FileReader(borderingCountryFile));
  		stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null){
  			stringBuilder.append(fileLine);
  		}
  		fileInput = stringBuilder.toString();
  		String[] borderingCountries = fileInput.split("\t");
  		System.out.println(Arrays.toString(borderingCountries));

  		reader = new BufferedReader(new FileReader(continentFile));
  		stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null) {
  			stringBuilder.append(fileLine);
  		}
  		fileInput = stringBuilder.toString();
  		String[] Continents = fileInput.split("\t");
  		System.out.println(Arrays.toString(Continents) + "\n");

		  board.SetBoard(Countries, Continents, borderingCountries);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
    }

    board.setPlayer("China", player);
    board.returnPlayer("China");
    
    board.setNumOfArmies("China", 5);
    board.returnNumOfArmies("China");

    board.returnVacancy();

    board.returnExtraArmies("Asia");
    
  }
  @Test
  public void testClaimCountry(){
    
    String countryFile = "src/test/java/Countries.txt";
    String borderingCountryFile = "src/test/java/BorderingCountries.txt";
    String continentFile = "src/test/java/Continents.txt";
    String fileLine;
	RiskBoard board = new RiskBoard();
	setUpGame game = new setUpGame();
    Players player = new Players("Georgy",10);
    
    try{
  		BufferedReader reader = new BufferedReader(new FileReader(countryFile));
  		StringBuilder stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null) {
  			stringBuilder.append(fileLine);
		   }
  		String fileInput = stringBuilder.toString();
  		String[] Countries = fileInput.split("\t");
  		System.out.println(Arrays.toString(Countries) + "\n");

  		reader = new BufferedReader(new FileReader(borderingCountryFile));
  		stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null){
  			stringBuilder.append(fileLine);
  		}
  		fileInput = stringBuilder.toString();
  		String[] borderingCountries = fileInput.split("\t");
  		System.out.println(Arrays.toString(borderingCountries));

  		reader = new BufferedReader(new FileReader(continentFile));
  		stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null) {
  			stringBuilder.append(fileLine);
  		}
  		fileInput = stringBuilder.toString();
  		String[] Continents = fileInput.split("\t");
  		System.out.println(Arrays.toString(Continents) + "\n");

		  board.SetBoard(Countries, Continents, borderingCountries);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
    }

    game.claimCountry(true, board);
    
  }
}