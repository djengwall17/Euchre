public class Main
{
    public static void main (String []Args)
    {
        Game Euchre=new Game();
        Euchre.preGame();
        while(Euchre.getWinner()==0)
        {
            Euchre.determineTrump();
            Euchre.setTrump();
            for(int i=0; i<5; i++)
            {
                Euchre.trick();
            }
            Euchre.score();
            Euchre.resetHand();
        }
        System.out.println("The winner is team "+Euchre.getWinner());
    }
}