import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestDice {

  @Test
  public void negativeDieThrown() {
    Dice dice = new Dice();
    dice.rollDice(-1);
    dice.roll();
  }

  @Test
  public void zeroDieThrown() {
    Dice dice = new Dice();
    dice.rollDice(0);
    dice.roll();
  }

  @Test
  public void oneDieThrown() {
    Dice dice = new Dice();
    dice.rollDice(1);
    dice.roll();
  }

  @Test
  public void twoDieThrown() {
    Dice dice = new Dice();
    dice.rollDice(2);
    dice.roll();
  }

  @Test
  public void threeDieThrown() {
    Dice dice = new Dice();
    dice.rollDice(3);
    dice.roll();
  }

  @Test
  public void fourDieThrown() {
    Dice dice = new Dice();
    dice.rollDice(4);
    dice.roll();
  }

  @Test
  public void fiveDieThrown() {
    Dice dice = new Dice();
    dice.rollDice(5);
    dice.roll();
  }

  @Test
  public void sixDieThrown() {
    Dice dice = new Dice();
    dice.rollDice(6);
    dice.roll();
  }


}
