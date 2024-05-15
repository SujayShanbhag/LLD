import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    Queue<Player> players;
    List<Player> winners;
    Board board;

    Dice dice;

    Game(int numOfPlayers) {
        players= new LinkedList<>();
        winners= new LinkedList<>();
        board = new Board(100);
        dice = new Dice(6);
        for(int i=1;i<=numOfPlayers;i++) {
            players.add(new Player("P" + i));
        }
    }

    public void start() {
        while(!players.isEmpty())
        {
            //board.printBoard();
            Player playersTurn = players.peek();
            int rolledNumber= dice.roll();
            System.out.println(playersTurn.name + " rolled "+ rolledNumber);
            int newCell =playersTurn.position + rolledNumber;
            if(newCell<100) {
                System.out.println(playersTurn.name+ " moves to " + newCell);
                playersTurn.setPosition(newCell);
                if(board.hasSpecialEntity(newCell)) {
                    if(board.getEndPosition(newCell)>newCell) {
                        System.out.println("Woo-hoo! its a Ladder");
                    } else {
                        System.out.println("OOPS! its a Snake");
                    }
                    playersTurn.setPosition(board.getEndPosition(newCell));
                    System.out.println(playersTurn.name+ " moves to " + playersTurn.position);
                }
            }
            else if(newCell==100) {
                winners.add(playersTurn);
                players.remove();
                continue;
            }
            else if(rolledNumber==6){
                continue;
            }
            players.remove();
            players.add(playersTurn);
        }
        System.out.println("Winners are..");
        for(Player player : winners){
            System.out.println(player.name);
        }
    }
}
