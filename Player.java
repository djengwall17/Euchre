import java.util.*;
public class Player
{
    private ArrayList<Card> hand=new ArrayList<Card>();
    private String name;
    private int teamNumber;
    private int score=0;
    private int subscore=0;
    private int teamOneOrderNum=0;
    private int teamTwoOrderNum=0;
    public void setTeam()
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Choose a team, 1 or 2");
        teamNumber=scan.nextInt();
    }
    public int getTeam()
    {
        return teamNumber;
    }
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    public void setHand(ArrayList<Card> cards)
    {
        hand=cards;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        name=n;
    }
    public void showCards()
    {
        int counter=1;
        System.out.println(name+"'s hand: [press Enter to view.]");
        Scanner scn=new Scanner(System.in);
        scn.nextLine();
        for(Card single:hand)
        {
            if(counter<5)
            {
                System.out.print(counter+") "+single+", ");
                counter++;
            }
            else
            {
                System.out.print(counter+") "+single);
            }
        }
        System.out.println();
        scn.nextLine();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public Card playCard (ArrayList<Card> hand)
    {
        Scanner scn=new Scanner(System.in);
        int num=scn.nextInt();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        //Round one=new Round();
        Card played=new Card();
        if(num==1)
        {
            played=hand.get(0);
            hand.remove(0);
            //return played;
        }
        if(num==2)
        {
            played=hand.get(1);
            hand.remove(1);
            //return played;
        }
        if(num==3)
        {
            played=hand.get(2);
            hand.remove(2);
            //return played;
        }
        if(num==4)
        {
            played=hand.get(3);
            hand.remove(3);
            //return played;
        }
        if(num==5)
        {
            played=hand.get(4);
            hand.remove(4);
            //return played;
        }
        return played;
    }
    public String toString()
    {
        return name;
    }
}