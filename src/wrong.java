public class wrong extends moveOn
{
    //exclusive instance variable
    private String[][] face;


    //constructor
    public wrong(int lettersLeft, int triesLeft, String guessWord, String[][] face)
    {
        super(lettersLeft, triesLeft, guessWord);
        this.face = face;
    }

    //toString
    public String toString(int triesLeft, String[][] face)
    {
        //prints out the face depending on how many tries the user has left
        for(int row = 0; row < face.length; row++)
        {
            for(int col = 0; col < face[row].length; col++)
            {
                System.out.print("\s" + face[row][col]);
            }
            System.out.println("\n");
        }
        //informs the user of their mistake
        return "You got it wrong!\n" + super.toString(lettersLeft, triesLeft, guessWord);
    }

    //brain method(you lose!);
    public String youLose(String word)
    {
        return "\n\n\nYou Lose!:(\n\nThe word was: " + word + "!";

    }
}
