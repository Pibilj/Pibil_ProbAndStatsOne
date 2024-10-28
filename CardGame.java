import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CardGame
{
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prizeCards;
    private Card onField ;
    private int noPoke_counter = 0;
    private int poke_counter = 0;
    private int deckSize = 0;
    
    public CardGame(){
         deck = new ArrayList<>();
         hand = new ArrayList<>();
         prizeCards = new ArrayList<>();
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
    //add hand back to deck
    public void newHand(){
        for(int i = 0; i<=hand.size(); i++){
            if(!isDeckEmpty()){
                 deck.add(hand.get(i));
                 hand.remove(i);
            }
            
        }
        drawHand();
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
            System.out.print(i + ".) " +hand.get(i)+ " ");
        }
    }
    //check if there is a pokemon in hand
    public boolean checkPokemon(){
        for(Card singleCard : hand){
            if(singleCard instanceof Charmander ||
            singleCard instanceof Radiant_Charzard){
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
            //remove only one rare charzard from hand
            for(Card singleCard : hand){
                if(singleCard instanceof Charzard && count == 0){
                    hand.remove(singleCard instanceof Charzard);
                    count++;
                
                }
            }
            //reset count for rarecandy
            count = 0;
            //remove only one rare candy card from hand
            for(Card singleCard : hand){
                if(singleCard instanceof RareCandy && count == 0){
                    hand.remove(singleCard instanceof RareCandy);
                    count++;
                
                }
            }
            addToField(new Charzard());
        }
        
        
        
        
        
    }
    //use professors Research
    public void useProfessorsResearch(){
        for(Card singleCard : hand){
            hand.remove(singleCard);
        }
        drawHand();
    }
    //use greatBall
    public void useGreatBall(){
        for(Card singleCard : deck){
            if(singleCard instanceof Charmander){
                hand.add(singleCard);
                deck.remove(singleCard);
                
            }
        }
    }
    //put card on field
    public void addToField(Card pokemon){
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
    //add prize cards
    public void addPrizeCards(){
        Random rng = new Random();
        
        for(int i = 0; i<6; i++){
            if(!isDeckEmpty()){
                int cardToTakeIndex = rng.nextInt(deck.size());
            
                prizeCards.add(deck.get(cardToTakeIndex));
                deck.remove(cardToTakeIndex);
            }
            
            
        }
    }
    //prize cards
    public boolean havePrizeCards(){
        if(prizeCards.size() == 0){
            return false;
        }
        else{
            return true;
        }
        
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
    //start playing the game with user input
    public void startGame(){
        printHand();
        printField();
        //place pokemon in field
        //add pokemon to field from hand
        //addToField(new Charmander());
        userInput();
        
        
        
    }
    //check user input
    public void userInput(){
        //promt user with action
        boolean endTurn = false;
        
        while(!endTurn){
            int input;
            if(onField == null){
                System.out.println("Place a pokemon on the field.");
                input = scanner.nextInt();
                addToField(hand.get(input));
                printField();
            }
            input = scanner.nextInt();
            if(hand.get(input)  instanceof ProfessorsResearch){
                useProfessorsResearch();
            }
            if(hand.get(input) instanceof GreatBall){
                useGreatBall();
            }
            
            if(hand.get(input) instanceof RareCandy){
                useRareCandy();
            }
            System.out.println("To end turn type: true");
            endTurn = scanner.nextBoolean();
            checkIfLost();
        }
        
    }
    //check if you lost
    public boolean checkIfLost(){
        if(isDeckEmpty()){
            System.out.println("You have lost your deck is empty!");
            return true;
        }
        else if(onField == null){
            if(!checkPokemon()){
                System.out.println("You have lost you have no more pokemon to play!");
                return true;
            }
        }
        else if(!havePrizeCards()){
            System.out.println("You have lost your are out of prize cards!");
            return true;
        }
        else{
            return false; 
        }
        return false;
    }
    // add methods here as you need to, to make your program run.
    public void run(){
        
        fillDeck();
        addPrizeCards();
        //shuffle
        //draw hand
        drawHand();
        //check if pokemon in hand if not new hand unit you do.
        while(!checkPokemon()){
            newHand();
        }
        startGame();
        
        
        //check how many reshuffles will it take on avg
        
        
    }
    
}
