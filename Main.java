import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Vector;

public class Main {

  public static void main(String[] args) {

    String sColorOption[] = {"Red", "Green", "Blue", "Purple", "Orange", "Yellow", "Teal"};
    int nNumPlayers = 0;
    int nColor = 0;

    Players[] players;

    boolean bGameRunning = true;
    Scanner sc;

    System.out.println("=============================================================");
    System.out.println("============ Welcome to Risk Board Game !!! =================");
    System.out.println("=============================================================");

    // Keep running until user pick a valid number of players
    while(bGameRunning) {
      if(nNumPlayers >= 2 && nNumPlayers <= 6) {
        bGameRunning = false;
      } else {
        System.out.println("Please select how many players (2-6) are playing...");

        sc = new Scanner(System.in);
        nNumPlayers = sc.nextInt();
      }
    }

    System.out.println("=============================================================");
    System.out.println("============== You have select " + nNumPlayers  + " Players. ===================");
    System.out.println("=============================================================");

    players = new Players[nNumPlayers];


    for(int p = 0; p < nNumPlayers; p++) {
      String sName = "Player " + (p+1);

      System.out.println("Please name "+ sName + "...");
      sc = new Scanner(System.in);
      sName = sc.nextLine();

      bGameRunning = true;
      do{
        if(nColor >= 1 && nColor <= sColorOption.length && sColorOption[nColor-1] != null) {
          bGameRunning = false;
        } else {
          System.out.println("Please select the color for player " + sName + "...");
          for(int c = 0; c < sColorOption.length; c++) {
            if(sColorOption[c] != null)
              System.out.println((c+1) + ". " + sColorOption[c]);
          }
          sc = new Scanner(System.in);
          nColor = sc.nextInt();
        }
      }while(bGameRunning);

      players[p] = new Players(sName, sColorOption[nColor-1]);
      sColorOption[nColor-1] = null;

      System.out.println();
      System.out.println("=============================================================");
    }

    for(int p = 0; p < nNumPlayers; p++) {
      System.out.println("=============================================================");
      System.out.println("Player " + (p+1) + " is name: " + players[p].getName());
      System.out.println("Player " + (p+1) + " is color: " + players[p].getColor());
      System.out.println("=============================================================");
    }

  }
}
