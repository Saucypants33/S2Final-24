public class invalid extends moveOn
{
    //private instance variables
    private char firstLetter;
    private String restOfWord;

    //constructor
    public invalid(int lettersLeft, int triesLeft, String guessWord, char firstLetter, String restOfWord)
    {
        super(lettersLeft, triesLeft, guessWord);
        this.firstLetter = firstLetter;
        this.restOfWord = restOfWord;
    }

    //toString - informs the user of how to properly respond
    public String toString()
    {
        return "Invalid response, answer using a singular letter\n\nFor example: (" + firstLetter + ") " + restOfWord + "\n" + super.toString(lettersLeft, triesLeft, guessWord) + " ENTER to continue";
    }
}