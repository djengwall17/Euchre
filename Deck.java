import java.util.*;
public class Deck
{
    public ArrayList<Card> Deck= new ArrayList<Card> (
    Arrays.asList(
      new Card("jack","diamonds","red",3),
      new Card("jack","hearts","red",3),
      new Card("jack","spades","black",3),
      new Card("jack","clubs","black",3),
      new Card("queen","hearts","red",4),
      new Card("queen","diamonds","red",4),
      new Card("queen","spades","black",4),
      new Card("queen","clubs","black",4),
      new Card ("king","hearts","red",5),
      new Card ("king","clubs","black",5),
      new Card ("king","spades","black",5),
      new Card ("king","diamonds","red",5),
      new Card ("ace","hearts","red",6),
      new Card ("ace","diamonds","red",6),
      new Card ("ace","spades","black",6),
      new Card ("ace","clubs","black",6),
      new Card ("ten","clubs", "black",2),
      new Card ("ten","spades", "black",2),
      new Card ("ten","diamonds", "red",2),
      new Card ("ten","hearts","red",2),
      new Card ("nine","hearts","red",1),
      new Card ("nine","diamonds","red",1),
      new Card ("nine","spades","black",1),
      new Card ("nine","clubs","black",1)
      ));
      
     public Card draw()
     {
         Random randomGen = new Random();
         int cardSize = Deck.size();
         if(cardSize==0)
         {
             return null;
         }
         int key=randomGen.nextInt(cardSize); //(int)(Math.random()*size);
         Card temp= Deck.get(key);
         Deck.remove(key);
         return temp;
     }
     public ArrayList<Card> deal()
     {
         Random randomGen = new Random();
         int cardSize = Deck.size();
         ArrayList<Card> hand=new ArrayList<Card>();
         if(cardSize==0)
         {
             return null;
         }
         for(int i=0;i<5;i++)
         {
            int key=randomGen.nextInt(cardSize); //(int)(Math.random()*size);
            Card temp= Deck.get(key);
            Deck.remove(key);
            hand.add(temp);
            cardSize--;
            }
         return hand;
     }
}