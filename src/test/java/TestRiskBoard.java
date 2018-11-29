import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestRiskBoard {

  @Test
  public void testSetBoard() {
        setUpGame game = new setUpGame();
        final String[] countries = {"Alaska","Alberta","Central America","Eastern United States",
                                    "Greenland","Northwest Territory","Ontario","Quebec","Western United States",
                                    "Argentina","Brazil","Venezuela","Great Britain","Iceland","Northern Europe",
                                    "Scandinavia","Southern Europe","Ukraine","Western Europe","Congo","East Africa",
                                    "Egypt","Madagascar","North Africa","South Africa","Afghanistan","China","India",
                                    "Irkutsk","Japan","Kamchatka","Middle East","Mongolia","Siam","Siberia","Ural",
                    "Yakutsk","Eastern Australia","Indonesia","LotR","New Guinea","Western Australia"};
        final String[] continents = {"North America","South America", "Australia", "Asia", "Africa", "Europe"};
        final String[] borders = {};
        RiskBoard board = new RiskBoard();
        board.SetBoard(countries, continents, borders);
  }
}