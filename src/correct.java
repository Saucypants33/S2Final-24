public class correct extends moveOn
{
    //excluseive instance variable(s)
    private int rightGuesses = 0;

    //constructor
    public correct(int lettersLeft, int triesLeft, String guessWord, int rightGuesses)
    {
        super(lettersLeft, triesLeft, guessWord);
        this.rightGuesses = rightGuesses;
    }

    //toString
    public String toString(int lettersLeft, int triesLeft, String guessWord, int rightGuesses)
    {
        return "\nYou got it correct!\n\n" + super.toString(lettersLeft, triesLeft, guessWord) + "\nRight guesses: " + rightGuesses;
    }

    //brain method - updates variable guessWord
    public static String updateGuessWord(String response, String word, String guessWord)
    {
        String finalWord = guessWord;
        String firstOfGuessWord;
        String lastOfGuessWord;

        //iterates through each individual letter in word
        for(int i = 0; i < word.length(); i++)
        {
            //checks if letter is in the word
            if(word.substring(i, i+1).compareTo(response) == 0 && word.length() > 1)
            {
                //cuts the guessWord variable in two halves without the focused letter cut out
                firstOfGuessWord = finalWord.substring(0,i);
                lastOfGuessWord = finalWord.substring(i+1);


                finalWord = firstOfGuessWord;
                //concatinates the first half with the new letter, then the new first hald with the second half of the word
                finalWord = finalWord.concat(response);
                finalWord = finalWord.concat(lastOfGuessWord);
            }
        }
        //returns the new guessWord variable
        return finalWord;
    }

    //getter(useless)
    public int getLettersLeft()
    {
        return lettersLeft;
    }

    //setter(still useless)
    public void setLettersLeft(int left)
    {
        lettersLeft = left;
    }

    //part of overridden method
    void movesOn()
    {
        System.out.println("movesOn when only correct");
    }
}