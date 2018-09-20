import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Card {
  @Test
  private String armyType;
  private Country country;

  @Test
  public Card( String type, Country country ) {
	this.armyType = type;
	this.country = country;
  }

  @Test
	public String getName() {
		return country.getName() + ", " + armyType;
	}

  @Test
  public String getType() {
	return armyType;
  }

  @Test
  public Country getCountry() {
	return country;
  }
}
