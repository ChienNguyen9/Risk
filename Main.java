import java.util.Scanner;
import java.util.Vector;

public class Main {

  public static void main(String[] args) {

    String sColorOption[] = {"Red", "Green", "Blue", "Purple", "Orange", "Yellow", "Teal"};
    String sWinner[] = {"0", "0", "0", "0", "0", "0"};
    int nNumPlayers = 0;
    int nColor = 0;
    int nArmies = 0;

    Players[] players;
    Dice dice = new Dice();

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

    // Give each player the amount of infantry
    if(nNumPlayers == 2)  // Not sure what to do for 2 players
      nArmies = 1;
    if(nNumPlayers == 3)
      nArmies = 35;
    if(nNumPlayers == 4)
      nArmies = 30;
    if(nNumPlayers == 5)
      nArmies = 25;
    if(nNumPlayers == 6)
      nArmies = 20;



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

      players[p] = new Players(sName, sColorOption[nColor-1], nArmies);
      sColorOption[nColor-1] = null;

      System.out.println();
      System.out.println("=============================================================\n\n");
    }

    for(int p = 0; p < nNumPlayers; p++) {
      System.out.println("=============================================================");
      System.out.println("Player " + (p+1) + " is name: " + players[p].getName());
      System.out.println("Player " + (p+1) + " is color: " + players[p].getColor());
      System.out.println("=============================================================\n\n");
    }

    // Setup number 2 - whoever rolls the highest number gets to choose any territory
    System.out.println("===================== Whoever rolls the dice gets to pick first territory ========================================\n");
    int nPlayerWin = 0;
    bGameRunning = true;
    while(bGameRunning == true) {
      int nWinner = 0;

      for(int p = 0; p < nNumPlayers; p++) {
        if(sWinner[p] != null) {
          System.out.println("\n=============================================================");
          players[p].setDice(dice.rollDice(1));
          System.out.println("Player " + (p+1) + " roll a: " + players[p].getDice());
          System.out.println("=============================================================");

          if(players[nPlayerWin].getDice() < players[p].getDice()) {
            sWinner[nPlayerWin] = null;
            nPlayerWin = p;
          }else if(players[nPlayerWin].getDice() > players[p].getDice()) {
            sWinner[p] = null;
          }

        }
      }

      // Check if there is a winner
      for(int c = 0; c < nNumPlayers; c++) {
        if(sWinner[c] != null)
            nWinner++;
      }

      if(nWinner == 1) {
        System.out.println("\n=============================================================");
        System.out.println("Player " + nPlayerWin + " gets to pick territory first... ");
        System.out.println("=============================================================");
        bGameRunning = false;
      } else {
        System.out.println("\n\n There are 2 or more players that have the same number. Must roll again.");
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {
          System.out.println(e.getMessage());
        }
      }

    }




/*
    // Game Starts
    bGameRunning = true;
    int nTurn = 0;
    while(bGameRunning) {
      // Check if any player has conquers all the country

      switch(nTurn) {
        case 1:
        // Getting and placing new armies.
        // Attacking.
        // Fortifying your position.
        break;

        case 2:
        // Getting and placing new armies.
        // Attacking.
        // Fortifying your position.
        break;

        case 3:
        // Getting and placing new armies.
        // Attacking.
        // Fortifying your position.
        break;

        case 4:
        // Getting and placing new armies.
        // Attacking.
        // Fortifying your position.
        break;

        case 5:
        // Getting and placing new armies.
        // Attacking.
        // Fortifying your position.
        break;

        case 6:
        // Getting and placing new armies.
        // Attacking.
        // Fortifying your position.
        break;
      }
      nTurn++;  // Next player
    }
*/


  }
}
