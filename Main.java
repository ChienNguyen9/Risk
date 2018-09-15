import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;
import java.io.File;

public class Main {

  public static void main(String[] args) {
	private String countryFile = "Countries.txt";
	private String continentFile = "Continents.txt";
	private String borderingCountryFile  = "BorderingCountries.txt";
	private String fileLine;
	private String fileInput;
	private BufferedReader reader;
	private StringBuilder stringBuilder;
	private String[] Countries;
	private String[] Continents;
	private String[] borderingCountries;
	private RiskBoard Board;
	private boolean createdBoard;
	
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
		
		
		reader = new BufferedReader(new FileReader(continentFile));
		stringBuilder = new StringBuilder();
		while((fileLine = reader.readLine()) != null) {
			stringBuilder.append(fileLine);
		}
		fileInput = stringBuilder.toString();
		Continents = fileInput.split("\t");
		System.out.println(Arrays.toString(Continents) + "\n");
		
		reader = new BufferedReader(new FileReader(borderingCountryFile));
		stringBuilder = new StringBuilder();
		while((fileLine = reader.readLine()) != null){
			stringBuilder.append(fileLine);
		}
		fileInput = stringBuilder.toString();
		borderingCountries = fileInput.split(",");
		System.out.println(Arrays.toString(borderingCountries));
		
		createdBoard = Board.SetBoard(Countries, Continents, borderingCountries);
		
		
	}catch(FileNotFoundException e) {
		System.out.println(e.getMessage());
	}catch(IOException e) {
		System.out.println(e.getMessage());
	}
	
	 

    private String sColorOption[] = {"Red", "Green", "Blue", "Purple", "Orange", "Yellow", "Teal"};
    private int nNumPlayers = 0;
    private int nColor = 0;

    Players[] players;

    private boolean bGameRunning = true;
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
