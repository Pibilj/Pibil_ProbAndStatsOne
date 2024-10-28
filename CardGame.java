import java.util.ArrayList;
import java.util.Random;

public class CardGame
{
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private Card onField ;
    private int noPoke_counter = 0;
    private int poke_counter = 0;
    private int deckSize = 0;
    
    public CardGame(){
         deck = new ArrayList<>();
         hand = new ArrayList<>();
         onField = null;
    }
    public void checkDeckSize(){
        if(deckSize >60){
            System.out.println("Deck size limit has been reached");
        }
        System.out.println("Deck size is: " + deckSize);
    }
    
    public void fillDeck(){
        
        for(int i = 0; i <4; i++){
            deck.add(new Charmander());
            deckSize++;
        }
        for(int i = 0; i <4; i++){
            deck.add(new Charmeleon());
            deckSize++;
        }
        for(int i = 0; i <4; i++){
            deck.add(new Charzard());
            deckSize++;
        }
        for(int i = 0; i <4; i++){
            deck.add(new Radiant_Charzard());
            deckSize++;
        }
        for(int i = 0; i <4; i++){
            deck.add(new RareCandy());
            deckSize++;
        }
        for(int i = 0; i <4; i++){
            deck.add(new ProfessorsResearch());
            deckSize++;
        }
        for(int i = 0; i <4; i++){
            deck.add(new GreatBall());
            deckSize++;
        }
        if(deckSize<60){
            for(int i = 0; i < 60-deckSize; i++){
                deck.add(new Energy());
                deckSize++;
            }
        }
        checkDeckSize();
        //printDeck();
        
        
    }
    //print deck
    public void printDeck(){
        for(int i = 0; i <deck.size(); i++){
            System.out.print(deck.get(i)+ " ");
        }
    }
    //check if deck is empty
    public boolean isDeckEmpty(){
        if(deck.size()>0){
            return false;
        }
        else{
            System.out.println("You lost your Deck is empty!");
            return true ;
        }
        
    }
    //draw new hand
    public void drawHand(){
        Random rng = new Random();
        
        for(int i = 0; i<7; i++){
            if(!isDeckEmpty()){
                int cardToTakeIndex = rng.nextInt(deck.size());
            
                hand.add(deck.get(cardToTakeIndex));
                deck.remove(cardToTakeIndex);
            }
            
            
        }
    }
    //draw one card
    public void drawCard(){
        Random rng = new Random();
        if(!isDeckEmpty()){
            int cardToTakeIndex = rng.nextInt(deck.size());
            
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
        
    }
    //check hand size
    public int checkHandSize(){
        return hand.size();
    }
    //print hand
    public void printHand(){
        for(int i = 0; i <hand.size(); i++){
            System.out.print(hand.get(i)+ " ");
        }
    }
    //check if there is a pokemon in hand
    public boolean checkPokemon(){
        for(Card singleCard : hand){
            if(singleCard instanceof Charmander){
                //System.out.println("I found a Charmander");
                return true;
            }
        }
        return false;
    }
    //check if you can use Rare Candy
    public boolean checkRareCandy(){
        boolean checkCharmander = false;
        boolean checkCharzard = false;
        for(Card singleCard : hand){
            if(singleCard instanceof Charzard){
                checkCharzard = true;
            }
        }
            if(onField instanceof Charmander){
                checkCharmander = true;
            }
            if( checkCharmander && checkCharzard){
                return true;
            }
        
        return false;
    }
    //use rareCandy
    public void useRareCandy(){
        int count = 0;
        boolean isRareCandy = false;
        for(Card singleCard : hand){
            if(singleCard instanceof RareCandy){
                isRareCandy = checkRareCandy();
            }
        }
        if(isRareCandy){
            for(Card singleCard : hand){
                if(singleCard instanceof Charzard && count == 0){
                    hand.remove(singleCard instanceof Charzard);
                    count++;
                
                }
            }
            //reset count for rarecandy
            count = 0;
            for(Card singleCard : hand){
                if(singleCard instanceof RareCandy && count == 0){
                    hand.remove(singleCard instanceof RareCandy);
                    count++;
                
                }
            }
        }
        onField = new Charzard();
        
        
        
        
    }
    //use professors Research
    public void useProfessorsResearch(){
        for(Card singleCard : hand){
            hand.remove(singleCard);
        }
        drawHand();
    }
    //use greatBall
    public void greatBall(){
        for(Card singleCard : deck){
            if(singleCard instanceof Charmander){
                hand.add(singleCard);
                deck.remove(singleCard);
                
            }
        }
    }
    //put card on field
    public void onField(Card pokemon){
        if(onField == null){
            onField = pokemon;
            hand.remove(pokemon);
        }
        else{
            System.out.println("Field already has a pokemon.");
        }
    }
    //remove pokemon from field
    public void removePokemon(){
        if(onField instanceof Pokemon){
            onField = null;
        }
        else{
            System.out.println("Field does not have a pokemon.");
        }
    }
    //show field
    public void printField(){
        System.out.println("Pokemon on field: " + onField);
    }
    // *add new object each run + 2 loops for each itteration
    public void montyProb(){
        //if your hand doesn't have pokemon
        boolean found = false;
        found = checkPokemon();
        if(found){
            poke_counter++;
        }
        
           /* System.out.println("deck size"+ deck.size());
            System.out.println("hand size" + hand.size());
            System.out.println("Num sucess: " + poke_counter + " Num hands drawn: " + noPoke_counter +" "+ poke_counter);
            */
            //clear deck and hand for new draw.
            //clearDeck();
        //}
        
        
    }
    //clear deck and hand
    public void clearDeck(){
        
            deck = new ArrayList<>();
            hand = new ArrayList<>();
    }
    public void getNumSucess(){
        //System.out.println("Number of hands drawn: "+ poke_counter + "+" + noPoke_counter);
        System.out.println("Number of times pokemon in hand: " + poke_counter);
        //System.out.println("deck size"+ deck.size());
        //System.out.println("hand size" + hand.size());
    }
    // add methods here as you need to, to make your program run.
    public void run(){
        fillDeck();
        //shuffle
        //draw hand
        drawHand();
        //check if pokemon in hand
        checkPokemon();
        //check how many reshuffles will it take on avg
        
        
    }
    
}
