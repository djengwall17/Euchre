import java.util.*;
public class Game
{
    //maybe there us a problem in dealing
     private ArrayList<Player> players=new ArrayList<Player>();
     private ArrayList<Player> teamOne=new ArrayList<Player>();
     private ArrayList<Player> teamTwo=new ArrayList<Player>();
     private ArrayList<Player> teams=new ArrayList<Player>();
     private ArrayList<Player> playerOrder=new ArrayList<Player>();
     private int teamOnePlayers=0;
     private int teamTwoPlayers=0;
     private Deck deck=new Deck();
     private Player pOne=new Player();
     private Player pTwo=new Player();
     private Player pThree=new Player();
     private Player pFour=new Player();
     private String trumpSuit;
     public String trumpColor;
     private int teamOneTrick=0;
     private int teamTwoTrick=0;
     private int teamOneScore=0;
     private int teamTwoScore=0;
     private int winningTeamNum=0;
     public int getWinner()
     {
         return winningTeamNum;
        }
     public void preGame()
     {
         Scanner scn=new Scanner(System.in);
         int teamNum;
         String name;
         System.out.println("Enter Player Name: ");
         name=scn.nextLine();
         pOne.setName(name);
         try
         {
             pOne.setTeam();
            }
         catch(InputMismatchException e)
         {
             System.out.println("You must select 1 or 2");
             pOne.setTeam();
            }
         players.add(pOne);
        System.out.println("Enter Player Name: ");
        name=scn.nextLine();
         pTwo.setName(name);
         try
         {
             pTwo.setTeam();
            }
         catch(InputMismatchException e)
         {
             System.out.println("You must select 1 or 2");
             pTwo.setTeam();
            }
         players.add(pTwo);
             System.out.println("Enter Player Name: ");
             name=scn.nextLine();
         pThree.setName(name);
         try
         {
             pThree.setTeam();
            }
         catch(InputMismatchException e)
         {
             System.out.println("You must select 1 or 2");
             pThree.setTeam();
            }
         players.add(pThree);
             System.out.println("Enter Player Name: ");
             name=scn.nextLine();
         pFour.setName(name);
         try
         {
             pFour.setTeam();
            }
         catch(InputMismatchException e)
         {
             System.out.println("You must select 1 or 2");
             pFour.setTeam();
            }
         players.add(pFour);
         for(int i=0;i<4;i++)
         {
             Player chosen=players.get(i);
             if(chosen.getTeam()==1)
             {
                 teamOne.add(chosen);
                 teamOnePlayers++;
                 if(teamOnePlayers>2)
                 {
                     teamOne.remove(chosen);
                     teamTwo.add(chosen);
                    }
                }
             if(chosen.getTeam()==2)
             {
                 teamTwo.add(chosen);
                 teamTwoPlayers++;
                 if(teamTwoPlayers>2)
                 {
                     teamTwo.remove(chosen);
                     teamOne.add(chosen);
                    }
                }
            }
         for(int i=0;i<2;i++)
         {
             teams.add(teamOne.get(i));
             teams.add(teamTwo.get(i));
         }
         ArrayList<Card>hand=new ArrayList<Card>();
         for(Player p:teams)
         {
             hand=deck.deal();
             p.setHand(hand);
            }
            Random random=new Random();
            int playerSize=teams.size();
            int key=random.nextInt(playerSize);
            if(key==3)
            {
                key=0;
            }
            else
            {
                key++;
            }
            for(int i=0;i<4;i++)
            {
                playerOrder.add(teams.get(key));
                if(key==3)
                {
                    key=0;
                }
                else
                {
                    key++;
                }
            }
            System.out.println(playerOrder);
        }
        //test this
     public void determineTrump()
     {
        Scanner scn=new Scanner(System.in);
        Card top= deck.draw();
        Player dealer=playerOrder.get(3);
        ArrayList<Card> hand=dealer.getHand();
        for(int i=0;i<4;i++)
        {
            Player chosen=playerOrder.get(i);
            chosen.showCards();
            System.out.println("Up for grabs:");
            System.out.println(top);
            if(i<3)
            {
                System.out.println("Should the dealer pick it up? (y for yes, n for no)");
            }
            else
            {
                System.out.println("Do you want to pick it up? (y for yes, n for no)");
            }
            String choice=scn.nextLine();
            if(choice.equals("y"))
            {
                dealer.showCards();
                System.out.println("Up for grabs:");
                System.out.println(top);
                System.out.println("Which card should you substitute?");
                int cardNum=scn.nextInt();
                if(cardNum==1)
                {
                    hand.remove(0);
                    hand.add(0,top);
                    trumpSuit=top.getSuit();
                    trumpColor=top.getColor();
                    break;
                }
                else if(cardNum==2)
                {
                    hand.remove(1);
                    hand.add(1,top);
                    trumpSuit=top.getSuit();
                    trumpColor=top.getColor();
                    break;
                }
                else if(cardNum==3)
                {
                    hand.remove(2);
                    hand.add(2,top);
                    trumpSuit=top.getSuit();
                    trumpColor=top.getColor();
                    break;
                }
                else if(cardNum==4)
                {
                    hand.remove(3);
                    hand.add(3,top);
                    trumpSuit=top.getSuit();
                    trumpColor=top.getColor();
                    break;
                }
                else if(cardNum==5)
                {
                    hand.remove(4);
                    hand.add(4,top);
                    trumpSuit=top.getSuit();
                    trumpColor=top.getColor();
                    break;
                }
            }
            else if(i==3)
            {
                System.out.println("Which suit do you want? (s for spades, c for clubs, d for diamonds, h for hearts).");
                String suit=scn.nextLine();
                if(suit.equals("s"))
                {
                    trumpSuit="spades";
                    trumpColor="black";
                }
                else if(suit.equals("c"))
                {
                    trumpSuit="clubs";
                    trumpColor="black";
                }
                else if(suit.equals("d"))
                {
                    trumpSuit="diamonds";
                    trumpColor="red";
                }
                else if(suit.equals("h"))
                {
                    trumpSuit="hearts";
                    trumpColor="red";
                }
                else
                {
                    trumpSuit="spades";
                    trumpColor="black";
                }
            }
        }
     }
     //test
     public void setTrump()
     {
         for(Player p: playerOrder)
         {
             ArrayList<Card>hand=p.getHand();
             for(Card c: hand)
             {
                 String suit=c.getSuit();
                 String color=c.getColor();
                 if(color.equals(trumpColor))
                 {
                     if(c.getRank().equals("jack"))
                     {
                         if(suit.equals(trumpSuit))
                         {
                             c.isRight();
                            }
                            else
                            {
                                c.isLeft();
                            }
                        }
                        else if(suit.equals(trumpSuit))
                        {
                            c.changeValue();
                        }
                    }
                }
            }
     }
     public void trick()
     {
         Player winner=new Player();
         int highest=0;
         Card firstCard=new Card();
         for(int i=0;i<4;i++)
         {
             Player current=playerOrder.get(i);
             current.showCards();
             System.out.println("Trump is "+trumpSuit);
             if(i>0)
             {
                 System.out.println("The first card played was "+firstCard);
                }
             System.out.println("Which card will you play?");
             Card played=current.playCard(current.getHand());
             if(i==0)
             {
                 firstCard=played;
                }
             if(played.getValue()>highest)
             {
                 winner=current;
                 highest=played.getValue();
                }
            }
            if(winner.getTeam()==1)
            {
                teamOneTrick++;
            }
            else
            {
                teamTwoTrick++;
            }
            System.out.println(winner);
            ArrayList<Player> temp=new ArrayList<Player>();
            int index=playerOrder.indexOf(winner);
            for(int i=0;i<4;i++)
            {
                temp.add(playerOrder.get(index));
                if(index<3)
                {
                    index++;
                }
                else
                {
                    index=0;
                }
            }
            for(int i=0;i<4;i++)
            {
                playerOrder.set(i,temp.get(i));
            }
        }
        public void score()
        {
            if(teamOneTrick==3||teamOneTrick==4)
            {
                teamOneScore++;
                teamOneTrick=0;
            }
            else if(teamOneTrick==5)
            {
                teamOneScore+=2;
                teamOneTrick=0;
            }
            else if(teamTwoTrick==3||teamTwoTrick==4)
            {
                teamTwoScore++;
                teamTwoTrick=0;
            }
            else if(teamTwoTrick==5)
            {
                teamTwoScore+=2;
                teamTwoTrick=0;
            }
            if(teamOneScore>=10)
            {
                winningTeamNum=1;
            }
            else if(teamTwoScore>=10)
            {
                winningTeamNum=2;
            }
            System.out.println("Team one score: "+teamOneScore);
            System.out.println("Team two score: "+teamTwoScore);
        }
        public void resetHand()
        {
            ArrayList<Card>hand=new ArrayList<Card>();
            Deck next=new Deck();
            deck=next;
             for(Player p:teams)
             {
                 hand=next.deal();
                 p.setHand(hand);
             }
        }
}
