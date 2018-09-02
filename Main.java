import javax.swing.JOptionPane;

public class Main {

  public static void main(String[] args) {

    Object[] obNumPlayer = {"2", "3", "4", "5", "6"}; // Option for number of players
    Players[] players = new Players[6];


    String sNumPlayers = (String)JOptionPane.showInputDialog(
                    null,
                    "Please select how many players are playing...",
                    "Player(s)",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    obNumPlayer,
                    obNumPlayer[0]);

    for(int p = 0; p < Integer.parseInt(sNumPlayers); p++) {
      String sName = "Player " + (p+1);

      sName = (String)JOptionPane.showInputDialog("Please enter " + sName + " name: ");
      players[p] = new Players(sName);
    }


  }

}
