import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Main {

  public static void main(String[] args){
	  String countryFile = "Countries.txt";
	  String continentFile = "Continents.txt";
	  String borderingCountryFile  = "BorderingCountries.txt";
	  String fileLine;
	  String fileInput;
	  BufferedReader reader;
	  StringBuilder stringBuilder;
	  String[] Countries;
	  String[] Continents;
	  String[] borderingCountries;
	  RiskBoard Board;
	  boolean createdBoard;

	  createdBoard = false;
	  Board = new RiskBoard();

	  try{
  		reader = new BufferedReader(new FileReader(countryFile));
  		stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null) {
  			stringBuilder.append(fileLine);
		   }
  		fileInput = stringBuilder.toString();
  		Countries = fileInput.split("\t");
  		System.out.println(Arrays.toString(Countries) + "\n");

  		reader = new BufferedReader(new FileReader(borderingCountryFile));
  		stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null){
  			stringBuilder.append(fileLine);
  		}
  		fileInput = stringBuilder.toString();
  		borderingCountries = fileInput.split("\t");
  		System.out.println(Arrays.toString(borderingCountries));

  		reader = new BufferedReader(new FileReader(continentFile));
  		stringBuilder = new StringBuilder();
  		while((fileLine = reader.readLine()) != null) {
  			stringBuilder.append(fileLine);
  		}
  		fileInput = stringBuilder.toString();
  		Continents = fileInput.split("\t");
  		System.out.println(Arrays.toString(Continents) + "\n");

		  createdBoard = Board.SetBoard(Countries, Continents, borderingCountries);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
	}

    String sColorOption[] = {"Red", "Green", "Blue", "Purple", "Orange", "Yellow", "Teal"};
    String sWinner[] = {"0", "0", "0", "0", "0", "0"};
    int nNumPlayers = 0;
    int nColor = 0;
    int nArmies = 0;

    String sUserInput;
    int nUserInput;

    Players[] players;
    Dice dice = new Dice();

    boolean bGameRunning = true;
    Scanner sc;

    Deck deck = new Deck();
    deck.shuffle();
    if(deck.shuffle()){
      System.out.println("The deck has been shuffled.");
    }

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
      /* PLAYER DOES NOT NEED COLOR
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
      */

      players[p] = new Players(sName, nArmies);
      //sColorOption[nColor-1] = null;

      System.out.println();
      System.out.println("=============================================================\n\n");
    }

    for(int p = 0; p < nNumPlayers; p++) {
      System.out.println("=============================================================");
      System.out.println("Player " + (p+1) + " is name: " + players[p].getName());
      // System.out.println("Player " + (p+1) + " is color: " + players[p].getColor());
    }
    // Let the player imbrace with their name
    System.out.println("Press Enter key to continue...");
    try
    {
        System.in.read();
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
    System.out.println("=============================================================\n\n");

    // Setup number 2 - whoever rolls the highest number gets to choose any territory
    System.out.println("===================== Whoever rolls the dice gets to pick first territory ========================================\n");
    int nPlayerTurn = 0;
    bGameRunning = true;
    while(bGameRunning == true) {
      int nWinner = 0;

      for(int p = 0; p < nNumPlayers; p++) {
        if(sWinner[p] != null) {
          System.out.println("=============================================================");
          players[p].setDice(dice.rollDice(1));
          System.out.println("Player " + (p+1) + " roll a: " + players[p].getDice());
          System.out.println("=============================================================");

          if(players[nPlayerTurn].getDice() < players[p].getDice()) {
            sWinner[nPlayerTurn] = null;
            nPlayerTurn = p;
          }else if(players[nPlayerTurn].getDice() > players[p].getDice()) {
            sWinner[p] = null;
          }

        }
      }

      // Check if there is a winner
      for(int c = 0; c < nNumPlayers; c++) {
        if(sWinner[c] != null)
            nWinner++;
      }

      // This will check if ONE player has the highest number
      if(nWinner == 1) {
        System.out.println("\n=============================================================");
        System.out.println("Player " + (nPlayerTurn+1) + " gets to pick territory first... ");
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

    // Set up - Claim territories
    int nCountriesClaim = Board.returnCountries().size();
    boolean bValidName = false;
    while(nCountriesClaim >= 1) {
      System.out.println("Player " + (nPlayerTurn+1) + ": " + players[nPlayerTurn].getName() + " which country would you like to claim?");
      System.out.println("1. List all the countries...");

      bValidName = false;
      sc = new Scanner(System.in);
      sUserInput = sc.nextLine();

      if(sUserInput.equals("1"))
      {
        for(int i = 0; i < Board.returnVacancy().size(); i++) {
            System.out.println(Board.returnVacancy().get(i).getName());
        }
      }
      else
      {

        // Check if the country has been taken
        for(int i = 0; i < Board.returnVacancy().size(); i++)
        {
          if(sUserInput.equals(Board.returnVacancy().get(i).getName()))
            bValidName = true; // Country has not been claim

        }
        // If user has input a valid country and it is not occupy by any players. Then let the player take control of that country
        if(bValidName)
        {
          Board.setPlayer(sUserInput, players[nPlayerTurn]);
          players[nPlayerTurn].gainCountry(Board.returnNameOfCountry(sUserInput));
          Board.setNumOfArmies(sUserInput, 1); // Add 1 troops to country
          players[nPlayerTurn].loseArmies(1);

          // Player take turn
          // *** USE THIS TO ROTATE PLAYER TURNS ***
          if(nPlayerTurn < nNumPlayers-1)
            nPlayerTurn++;
          else
            nPlayerTurn = 0;
        }
        else
        {
          // Player has input something that is incorrect. Don't exit the game, just continue looping...
          System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSomething went wrong...");
          System.out.println("1. Country has been claim already...");
          System.out.println("2. Incorrect input (Press 1 to list country and type the exact way...)\n");
        }
      }
      nCountriesClaim = Board.returnVacancy().size(); // Check if all the countries are claimed
    }

    // Set remaining troops that players have
    bGameRunning = true;
    while(bGameRunning)
    {
      // All user have place their troops
      bGameRunning = false;
      for(int p = 0; p < nNumPlayers; p++) {
        if(players[p].getNumOfArmies() > 0) {
          bGameRunning = true;
        }
      }

      if(players[nPlayerTurn].getNumOfArmies() > 0)
      {
        bValidName = false;
        System.out.println("Player " + (nPlayerTurn+1) + ": " + players[nPlayerTurn].getName() + ", which country would you like to add troop to?");
        sc = new Scanner(System.in);
        sUserInput = sc.nextLine();

        // Check if the country belongs to that player
        for(int i = 0; i < players[nPlayerTurn].countriesPlayerHas().size(); i++)
        {
          if(sUserInput.equals(players[nPlayerTurn].countriesPlayerHas().get(i).getName()))
            bValidName = true;
        }

        if(bValidName)
        {
          players[nPlayerTurn].loseArmies(0); // Display how many troop this player has left
          System.out.println("How many troops would you like to add to " + sUserInput + "?");
          sc = new Scanner(System.in);
          nUserInput = sc.nextInt();

          if(nUserInput <= players[nPlayerTurn].getNumOfArmies() && nUserInput >= 0)
          {
            // Add troop to country
            for(int i = 0; i < players[nPlayerTurn].countriesPlayerHas().size(); i++)
            {
              if(sUserInput.equals(players[nPlayerTurn].countriesPlayerHas().get(i).getName()))
              {
                players[nPlayerTurn].countriesPlayerHas().get(i).incArmies(nUserInput);
                players[nPlayerTurn].loseArmies(nUserInput);
              }
            }

            // Player take turn
            if(nPlayerTurn < nNumPlayers-1)
              nPlayerTurn++;
            else
              nPlayerTurn = 0;
          }
        }
        else
        {
          System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSomething went wrong...");
          System.out.println("1. Country does NOT belong to this player...");
          System.out.println("2. Incorrect input (Press 1 to list country your country and type the exact way...)\n");
        }
      }
      else
      {
        // Player take turn
        if(nPlayerTurn < nNumPlayers-1)
          nPlayerTurn++;
        else
          nPlayerTurn = 0;
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

public static void attackTerritory(Players player, RiskBoard Board) {
		    boolean attacking = true;
		    boolean validBorderCountry = false;
		    boolean isOpponent = false;
		    boolean validAtkRoll = false;
		    boolean validDefRoll = false;
		    String atkCountryInput;
		    String defCountryInput;
		    String atkCountry;
		    String defCountry;
		    String a,b,c;
		    String defPlayer;
		    int atkArmyLoss = 0;
		    int defArmyLoss = 0;
		    int nAtkDice;
		    int nDefDice;
		    int nAtkRolls;
		    int nDefRolls;
		    while(attacking) {
		    	boolean bValidName = false;
		    	System.out.println("\"Player : " + player.getName() + ", From which of your countries would you like to attack from?");
		    	System.out.println("\n1. list countries you currently occupy");
		    	sc = new Scanner(System.in);
		    	atkCountryInput = sc.nextLine();
		    	if(atkCountryInput.equals("1")) {
		    		for(int i = 0;i < player.countriesPlayerHas().size();i++) {
		    			System.out.println("\n" + player.countriesPlayerHas().get(i).getName());
		    		}
		    	}
		    	
		    	for(int i = 0;i < player.countriesPlayerHas();size();i++) {
		    		if(atkCountryInput.equals(player.countriesPlayerHas().get(i).getName()))
		    			bValidName = true;
		    			atkCountry = Board.returnNameOfCountry(atkCountryInput)
		    	}
		    	
		    	if(!bValidName) {
		    		System.out.println("\nYOU DO NOT OWN THIS COUNTRY, PLEASE PRESS 1 TO LIST YOUR COUNTRIES");
		    	}
		    	
				while(bValidName) {
					validBorderCountry = false;
				
					//attacking = false;
		    		System.out.println("\nWHICH NEARBY COUNTRY WOULD YOU LIKE TO ATTACK FROM " + atkCountry);
		    		System.out.println("\nPRESS 1 TO LIST COUNTRIES NEARBY " + atkCountry);
		    		sc = new Scanner(System.in);
					defCountryInput = sc.nextLine();
		    		if(defCountryInput.equals("1")) {
		    			for(int j = 0 ; j < Board.returnBorders(defCountry).size(); j++) {
		    				System.out.println("\n" + Board.returnBorders(defCountryInput).get(j).getName());
		    			}
		    		}
				}
		    		
				validBorderCountry = Board.verifyBorder(atkCountry, defCountryInput);
		    		
		    	if(!validBorderCountry) {
		    		System.out.println("THIS COUNTRY DOES NOT BORDERS " + atkCountry + "OR CHECK SPELLING OF COUNTRY")
		    	}
		    	
		    	while(validBorderCountry) {
		    		bValidName = false;
		    		defCountry = Board.returnNameOfCountry(defCountryInput);
		    		defPlayer = Board.returnPlayer(defCountry);
		    		if(player.equals(defCountry.getPlayer())) {
		    			System.out.println("\nYOU CAN NOT ATTACK YOUR OWN COUNTRY");
		    		}
		    		else
		    			isOpponent = true;
		    	}
		    	while(isOpponent) {
		    		dice = New Dice();
		    		System.out.println("\n" + player + ", HOW MANY DICES WOULD YOU LIKE TO ROLL");
		    		sc new Scanner(System.in);
		    		nUserInput = sc.nextInt();
		    		try{
		    			if(nUserInput < 1 || nUserInput >= Board.returnNumOfArmies(atkCountry)) {
		    				throw new IllegalArgumentException();
		    			}
		    			nAtkDice = nUserInput;
	    				validAtkRoll = true;
		    		}catch (IllegalArgumentException e) {
		    			System.out.println("\nYOU DO NOT HAVE THIS MANY ARMY IN THIS COUNTRY")
		    		}catch (NumberFormatException e) {
		    			System.out.println("\nNOT A VALID INPUT");
		    		}
		    		while(validAtkRoll) {
		    			System.out.println("\n" + defPlayer + ", HOW MANY DICES WOULD YOU LIKE TO ROLL");
		    			sc = new Scanner(System.in);
		    			nUserInput = sc.nextInt();
		    			try {
		    				if(nUserInput < 1 || nUserInput >= Board.returnNumOfArmies(defCountry)) {
		    					throw new IllegalArgumentException();
		    				}
		    				nDefDice = nUserInput;
		    				validDefRoll = true;
		    			}catch(IllegaArgumentException e) {
		    				System.out.println("\nYOU DO NOT HAVE THIS MANY ARMY IN THIS COUNTRY");
		    			}catch(NumberFormatException e) {
		    				System.out.println("\nNOT A VALID INPUT");
		    			}
		    			if(validDefRoll) {
		    				nAtkRolls = dice.rollDice(nAtkDice);
		    				nDefRolls = dice.rollDice(nDefDice);
		    				if(nAtkRolls > nDefRolls) {
		    					defArmyLoss
		    				}
		    			}
		    		}
		    		
		    	}
		   }
}

  public static void fortifyArmy(Players player, RiskBoard Board) {
    boolean bFortify = true;
    String sUserInputCountry;
    String sUserInputAdjacent;
    Scanner sc;
    while(bFortify) {
      int nUserInput;
      boolean bValidName = false;
      System.out.println(player.getName() + ", which country would you like to fortify?");
      sc = new Scanner(System.in);
      sUserInputCountry = sc.nextLine();

      if(sUserInputCountry.equals("1"))
      {
        for(int i = 0; i < Board.returnVacancy().size(); i++) {
            System.out.println(Board.returnVacancy().get(i).getName());
        }
      }

      // Check if the country belongs to that player
      for(int i = 0; i < player.countriesPlayerHas().size(); i++)
      {
        if(sUserInputCountry.equals(player.countriesPlayerHas().get(i).getName()))
          bValidName = true;
      }

      if(!bValidName)
      {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSomething went wrong...");
        System.out.println("1. Country does NOT belong to this player...");
        System.out.println("2. Incorrect input (Press 1 to list country your country and type the exact way...)\n");
      }

      while(bValidName)
      {
        boolean bValidAdjacentName = false;
        bFortify = false;
        System.out.println("Which adjacent of " + sUserInputCountry + " do you want to fortify?");
        sc = new Scanner(System.in);
        sUserInputAdjacent = sc.nextLine();

        if(sUserInputAdjacent.equals("1"))
        {
          for(int i = 0; i < Board.returnBorders(sUserInputCountry).size(); i++) {
              System.out.println(Board.returnBorders(sUserInputCountry).get(i).getName());
          }
        }

        // Check if the country is adjacent to each other
        bValidAdjacentName = Board.verifyBorder(sUserInputCountry, sUserInputAdjacent);

        if(!bValidAdjacentName)
        {
          System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSomething went wrong...");
          System.out.println("1. Country does NOT belong to this player...");
          System.out.println("2. Incorrect input (Press 1 to list country that is adjacent to that country...)\n");
        }

        while(bValidAdjacentName) {
          bValidName = false;

          System.out.println("How many troops would you like to add " + sUserInputCountry + " to " + sUserInputAdjacent + "?");
          sc = new Scanner(System.in);
          nUserInput = sc.nextInt();

          // Display how many armies does the country have
          if(sUserInputCountry.equals("-1"))
          {
            for(int i = 0; i < player.countriesPlayerHas().size(); i++)
            {
              if(sUserInputCountry.equals(player.countriesPlayerHas().get(i).getName()))
              {
                player.countriesPlayerHas().get(i).decArmies(0);
              }
              if(sUserInputAdjacent.equals(player.countriesPlayerHas().get(i).getName()))
              {
                player.countriesPlayerHas().get(i).decArmies(0);
              }
            }
          }

          if(nUserInput <= (Board.returnNumOfArmies(sUserInputCountry)-1) && nUserInput >= 0)
          {
            bValidAdjacentName = false;
            // Add troop to country
            for(int i = 0; i < player.countriesPlayerHas().size(); i++)
            {
              if(sUserInputCountry.equals(player.countriesPlayerHas().get(i).getName()))
              {
                player.countriesPlayerHas().get(i).decArmies(nUserInput);
              }
              if(sUserInputAdjacent.equals(player.countriesPlayerHas().get(i).getName()))
              {
                player.countriesPlayerHas().get(i).incArmies(nUserInput);
              }
            }
          }
          else
          {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSomething went wrong...");
            System.out.println("1. You have entered more than the country army limit...");
            System.out.println("2. Incorrect input (Press -1 to list country army number...)\n");
          }
        }
      }
    }
  }
}
