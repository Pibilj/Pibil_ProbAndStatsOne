import java.util.Scanner;


public class TestCardGame
{
    Scanner scanner =new Scanner(System.in);
    
    
    public static void main(String[] args){
        /*CardGame player1 = new CardGame();
        for(int i = 0; i<=100; i++){
            player1.run();
            player1.montyProb();
            //player1.printDeck();
            
            player1.clearDeck();
            //player1.printDeck();
        }
        player1.getNumSucess();*/
        CardGame player1 = new CardGame();
        player1.run();
        
        
    }
}
