public class Players {

  String sName;
  String sColor;
  int nDice;
  int nArmies;

  Players(String name, String color, int armies) {
    this.sName = name;
    this.sColor = color;
    this.nDice = 0;
    this.nArmies = armies;
  }

  public String getName() {
    return this.sName;
  }

  public String getColor() {
    return this.sColor;
  }

  public void setDice(int dice) {
    this.nDice = dice;
  }

  public int getDice() {
    return this.nDice;
  }

  public void displayInfo() {
    System.out.println("=============================================================");
    System.out.println("Name: " + this.sName);
    System.out.println("Color: " + this.sColor);
    System.out.println("=============================================================");
  }

}
