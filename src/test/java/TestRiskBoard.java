import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestRiskBoard {

  @Test
  public void testSetBoard() throws FileNotFoundException,IOException {
        setUpGame game = new setUpGame();
        final String[] countries = {"Alaska","Alberta","Central America","Eastern United States",
                                    "Greenland","Northwest Territory","Ontario","Quebec","Western United States",
                                    "Argentina","Brazil","Venezuela","Great Britain","Iceland","Northern Europe",
                                    "Scandinavia","Southern Europe","Ukraine","Western Europe","Congo","East Africa",
                                    "Egypt","Madagascar","North Africa","South Africa","Afghanistan","China","India",
                                    "Irkutsk","Japan","Kamchatka","Middle East","Mongolia","Siam","Siberia","Ural",
                    "Yakutsk","Eastern Australia","Indonesia","LotR","New Guinea","Western Australia"};
        final String[] continents = {"North America","South America", "Australia", "Asia", "Africa", "Europe"};
        String fileLine;
       BufferedReader reader = new BufferedReader(new FileReader("src/test/java/BorderingCountries.txt"));
  		StringBuilder stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null){
  			stringBuilder.append(fileLine);
  		}
  		String fileInput = stringBuilder.toString();
  		final String[] borderingCountries = fileInput.split("\t");
        RiskBoard board = new RiskBoard();
        board.SetBoard(countries, continents, borderingCountries);

        assertEquals(board.returnCountries().size(), 42);
        System.out.println(board.returnNameOfCountry("Japan").getName());
        System.out.println(board.returnBorders("China").size());
        System.out.println(board.verifyBorder("China", "Japan"));
        System.out.println(board.verifyBorder("Alaska", "Alberta"));
        System.out.println(board.returnContinents().size());
        System.out.println(board.returnNameOfContinent("Australia").getName());
        System.out.println(board.returnLocalCountries("Australia").size());
        System.out.println(board.returnExtraArmies("Australia"));

        Players player = new Players("Rush", 100);
        board.setPlayer("China", player);
        System.out.println(board.returnPlayer("Japan").getName());
        board.setNumOfArmies("Japan", 100);
        System.out.println(board.returnNumOfArmies("Japan"));
        System.out.println(board.returnVacancy().size());


        board.returnCountries();
        board.returnNameOfCountry("China");
        board.returnContinents();
        board.returnNameOfContinent("North America");
  }

  @Test
  public void testSetArmy() throws IOException,FileNotFoundException {
    setUpGame game = new setUpGame();
        final String[] countries = {"Alaska","Alberta","Central America","Eastern United States",
                                    "Greenland","Northwest Territory","Ontario","Quebec","Western United States",
                                    "Argentina","Brazil","Venezuela","Great Britain","Iceland","Northern Europe",
                                    "Scandinavia","Southern Europe","Ukraine","Western Europe","Congo","East Africa",
                                    "Egypt","Madagascar","North Africa","South Africa","Afghanistan","China","India",
                                    "Irkutsk","Japan","Kamchatka","Middle East","Mongolia","Siam","Siberia","Ural",
                    "Yakutsk","Eastern Australia","Indonesia","LotR","New Guinea","Western Australia"};
        final String[] continents = {"North America","South America", "Australia", "Asia", "Africa", "Europe"};
        String fileLine;
       BufferedReader reader = new BufferedReader(new FileReader("src/test/java/BorderingCountries.txt"));
  		StringBuilder stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null){
  			stringBuilder.append(fileLine);
  		}
  		String fileInput = stringBuilder.toString();
  		final String[] borderingCountries = fileInput.split("\t");
        Players player = new Players("Georgy",30);
        RiskBoard board = new RiskBoard();
        board.SetBoard(countries, continents, borderingCountries);
        board.setPlayer("China", player);
        board.returnPlayer("China");
        board.setNumOfArmies("China", 5);
        board.returnNumOfArmies("China");

  }

}
