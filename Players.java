public class Players {

  String sName;
  String sColor;

  Players(String name, String color) {
    this.sName = name;
    this.sColor = color;
  }

  public String getName() {
    return this.sName;
  }

  public String getColor() {
    return this.sColor;
  }

  public void displayInfo() {
    System.out.println("=============================================================");
    System.out.println("Name: " + this.sName);
    System.out.println("Color: " + this.sColor);
    System.out.println("=============================================================");
  }

}
