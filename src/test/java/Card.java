import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Card {

    private String armyType;
    private String country;

    public Card( String type, String country ) {
		this.armyType = type;
		this.country = country;
    }
    @Test
    public String getType() {
		return armyType;
    }
    @Test
    public String getCountry() {
		return country;
    }
}
