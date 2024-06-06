import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Main
{
    public static void main(String[] args)
    {
        //starting needed variables
        Scanner scan = new Scanner(System.in);
        String response = "";
        Random random = new Random();

        //list of words that may appear
        String[] words = {"hashing", "array", "nested", "aliases", "static", "recursion", "boolean", "sorting"};
        System.out.println("Hello! Wanna play HangMan?");
        response = scan.nextLine();
        //gets response and continues on no matter what the user inputs
        if(response.equals("yes") || response.equals("ok"))
        {
            System.out.println("\nGreat! Let's get started!");
        }
        else if(response.equals("no"))
        {
            System.out.println("\nToo bad! Let's get started!");
        }
        else
        {
            System.out.println("\nI'll take that as a yes...");
        }
        //instructions
        System.out.println("\nA random term from the AP-CSA course is going to be chosen and you need to guess it using letters before the drawing is completed...\nWith each wrong answer, the drawing becomes more complete(5 tries)\nREADY?");
        response = scan.nextLine();
        //continues no matter what the user inputs
        if(response.equals("yes") || response.equals("ok"))
        {
            System.out.println("\nGreat!\n");
        }
        else if(response.equals("no"))
        {
            System.out.println("\nToo bad!\n");
        }
        else
        {
            System.out.println("\nI'll take that as a yes...\n");
        }

        //informational variables that will be outputed and changed overtime
        int wordIndex = random.nextInt(words.length);
        String word = words[wordIndex];
        // System.out.print(word); //PRINTS WORD!!!
        String guessWord = "";
        int lettersLeft = word.length();
        int triesLeft = 5;
        int rightGuesses = 0;
        boolean finishGame = false;

        //a series of 2D faces that show the user how much they are getting wrong
        String[][] faceOne = {{" ", " ", " O", " O ", "O ", " ", " "},
                {" ", "O", " ", " ", " ", "   O", " "},
                {"O", " ", " ", " ", " ", " ", "   O"},
                {"O", " ", " ", " ", " ", " ", "   O"},
                {"O", " ", " ", " ", " ", " ", "   O"},
                {" ", "O", " ", " ", " ", "   O", " "},
                {" ", " ", " O", " O ", "O ", " ", " "}};

        String[][] faceTwo = {{" ", " ", " O", " O ", "O ", " ", " "},
                {" ", "O", " ", " ", " ", "    O", " "},
                {"O", " ", "1 ", " ", " ", " ", "   O"},
                {"O", " ", " ", " ", " ", " ", "    O"},
                {"O", " ", " ", " ", " ", " ", "    O"},
                {" ", "O", " ", " ", " ", "    O", " "},
                {" ", " ", " O", " O ", "O ", " ", " "}};

        String [][] faceThree = {{" ", " ", "  O", " O ", "O ", " ", " "},
                {" ", "O", " ", " ", " ", "     O", " "},
                {"O", " ", " 1", " ", " ", " 2", "   O"},
                {"O", " ", " ", " ", " ", " ", "     O"},
                {"O", " ", " ", " ", " ", " ", "     O"},
                {" ", "O", " ", " ", " ", "     O", " "},
                {" ", " ", "  O", " O ", "O ", " ", " "}};

        String[][] faceFour = {{" ", " ", "   O", " O ", "O", " ", " "},
                {" ", "O", " ", "         ", " ", "O", " "},
                {"O", " ", " ", "1      ","2", " ", " ", "O"},
                {"O", " ", " ", "         ", " ", " ", "O"},
                {"O", " ", " ", "   4 4   ", " ", " ", "O"},
                {" ", "O", " ", "4       4", " ", "O", " "},
                {" ", " ", "   O", " O ", "O", " ", " "}};

        String[][] faceFive = {{"X", " ", " ", " ", " ", " ", " ", "X"},
                {" ", "X", " ", " ", " ", " ", "X", " "},
                {" ", " ", "X", " ", " ", "X", " ", " "},
                {" ", " ", " ", "X", "X", " ", " ", " "},
                {" ", " ", " ", "X", "X", " ", " ", " "},
                {" ", " ", "X", " ", " ", "X", " ", " "},
                {" ", "X", " ", " ", " ", " ", "X", " "},
                {"X", " ", " ", " ", " ", " ", " ", "X"}};

        //initially makes the word anominous
        for(int i = 0; i < word.length(); i++)
        {
            guessWord += "*";
        }
        //makes the user keep guessing until the game is finished
        while(!finishGame)
        {
            System.out.println("--------------------------------------------------");
            System.out.println("Guess a letter that might be in the word: " + guessWord);
            response = scan.nextLine();
            //if the user input is invalid...

            if(response.length() > 1)
            {
                //creates an invalid variable and outputs it so that it can inform the user of how to properly respond
                while(response.length() > 1)
                {
                    invalid invalid  = new invalid(lettersLeft, triesLeft, guessWord, response.charAt(0), response.substring(1));
                    System.out.println(invalid.toString());
                    response = scan.nextLine();
                }
            }
            else
            {
                //if the user's letter is correct...
                if(word.contains(response))
                {
                    //the # of right guesses incriments
                    rightGuesses++;
                    // a corect-type variable is created
                    correct correctAnswer = new correct(lettersLeft, triesLeft, guessWord, rightGuesses);

                    //the guessWprd is updated in the 'correct' class
                    guessWord = correctAnswer.updateGuessWord(response, word, guessWord);

                    //the lettersLeft variable is redefined
                    lettersLeft = 0;
                    for(int i = 0; i < guessWord.length(); i++)
                    {
                        if(guessWord.substring(i, i+1).equals("*"))
                        {
                            lettersLeft++;
                        }
                    }
                    //outputs the correct-type variable so that the game updates and continues
                    System.out.println(correctAnswer.toString(lettersLeft, triesLeft, guessWord, rightGuesses));
                    //checks if there are no more words to be found
                    if(!(guessWord.contains("*")))
                    {
                        //the user wins
                        finishGame = true;
                        System.out.println("\n\n\nYou Won!\n\nThe word was: " + guessWord + "!");
                    }
                }
                //if incorrect...
                else
                {
                    //if the user is incorrect...
                    wrong wrongAnswer;
                    //the number of tries they have left decrements
                    triesLeft--;

                    //checks how many tries are left and creates a' wrong' type variable and outputs it
                    if(triesLeft == 4)
                    {
                        wrongAnswer = new wrong(lettersLeft, triesLeft, guessWord, faceOne);
                        System.out.println(wrongAnswer.toString(triesLeft, faceOne));
                    }
                    else if(triesLeft == 3)
                    {
                        wrongAnswer = new wrong(lettersLeft, triesLeft, guessWord, faceTwo);
                        System.out.println(wrongAnswer.toString(triesLeft, faceTwo));
                    }
                    else if(triesLeft == 2)
                    {
                        wrongAnswer = new wrong(lettersLeft, triesLeft, guessWord, faceThree);
                        System.out.println(wrongAnswer.toString(triesLeft, faceThree));
                    }
                    else if(triesLeft == 1)
                    {
                        wrongAnswer = new wrong(lettersLeft, triesLeft, guessWord, faceFour);
                        System.out.println(wrongAnswer.toString(triesLeft, faceFour));
                    }
                    //if the user has 0 tries left...
                    else//tries == 0
                    {
                        wrongAnswer = new wrong(lettersLeft, triesLeft, guessWord, faceFive);
                        //the youLose method from the 'wrong' class outputs
                        System.out.println(wrongAnswer.toString(triesLeft, faceFive) + wrongAnswer.youLose(word));

                        //the game finishes and the user lost
                        finishGame = true;
                    }
                }
            }
        }//end of while loop
    }//end of main method
}//end of class