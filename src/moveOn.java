public class moveOn
{

    //exclusive instance variables
    public int lettersLeft;
    public int triesLeft;
    public String guessWord;

    //constructor
    public moveOn(int lettersLeft, int triesLeft, String guessWord)
    {
        this.lettersLeft = lettersLeft;
        this.triesLeft = triesLeft;
        this.guessWord = guessWord;
    }

    //toString
    public String toString(int lettersLeft, int triesLeft, String guessWord)
    {
        //will be used to output informational variables and in child classes
        return "Letters left: " + lettersLeft + "\nTries left: " + triesLeft + "\nWord left: " + guessWord;
    }
    //overridden, //overloaded?, //polymorphism!(),

    //part of overriden method
    private void movesOn()
    {
        System.out.println("moveOn, right or wrong");
    }
}