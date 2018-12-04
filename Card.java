public class Card
{
    private String suit;
    private String rank;
    private int value;
    private String color;
    public String getSuit()
    {
        return suit;
    }
    public String getRank()
    {
        return rank;
    }
    public int getValue()
    {
        return value;
    }
    public String getColor()
    {
        return color;
    }
    public Card(String r, String s, String co, int val)
    {
        this.rank=r;
        this.suit=s;
        this.color=co;
        this.value=val;
    }
    public Card()
    {}
    public void changeValue()
    {
        value+=6;
    }
    public void isLeft()
    {
        value+=10;
    }
    public void isRight()
    {
        value+=11;
    }
     public void resetValue()
    {
        value-=6;
    }
    public void resetBower()
    {
        value=3;
    }
    public String toString()
    {
        return rank+" of "+suit;
    }
}