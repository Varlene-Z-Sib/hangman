import javax.swing.JOptionPane;

// Class representing the Hangman game
public class HangmanGame 
{
    static String previousWord;
    static Word currentWord;
    static int triesLeft;

    // Constructor to initialize the game state
    public HangmanGame() 
    {
        this.currentWord = new Word("programming"); // Default word to be guessed
        this.triesLeft = 6;
        this.previousWord = null;
    }

    // Method to start the game
    public void startGame() 
    {
        while (true) 
        {
            String[] options = 
            {"Start Game", "Check Records", "Change Word", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                null,
                "Welcome to Hangman!\nChoose an option:",
                "Hangman Game Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
            );

            switch (choice) 
            {
                case 0:
                    playGame();
                    break;
                case 1:
                    showRecords();
                    break;
                case 2:
                    changeWord();
                    break;
                case 3:
                    exitGame();
                    return;
            }
        }
    }

    // Method to play the Hangman game
    private static void playGame() 
    {
        previousWord = currentWord.getActualWord();
        currentWord = new Word(previousWord); // Start with a new word

        while (triesLeft > 0) 
        {
            char guess = getCurrentPlayer().getGuess();

            if (guess == '\0') 
            {
                return;
            }

            boolean guessedCorrectly = currentWord.guessLetter(guess);

            if (guessedCorrectly) 
            
            {
                JOptionPane.showMessageDialog(null, "Correct guess!");
            }
            
            if (currentWord.isWordGuessed()) 
            {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the word: " + currentWord.getActualWord());
                recordResult(true);
                return;
            } 
            
            else if (!guessedCorrectly) 
            {
                triesLeft--;
                JOptionPane.showMessageDialog(null, "Incorrect guess. Tries left: " + triesLeft);
            }
        }

        JOptionPane.showMessageDialog(null, "Sorry, you've run out of tries. The word was: " + currentWord.getActualWord());
        recordResult(false);
    }

    // Method to show game records
    private void showRecords() 
    {
        StringBuilder records = new StringBuilder("Game Records:\n");
        if (previousWord != null) 
        {
            records.append("Previous Word: ").append(previousWord).append("\n");
        }
        JOptionPane.showMessageDialog(
            null,
            records.toString(),
            "Game Records",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Method to change the word to be guessed
    private void changeWord() 
    {
        String newWord = JOptionPane.showInputDialog("Enter a new word to be guessed:");
        if (newWord != null && !newWord.isEmpty()) 
        {
            previousWord = currentWord.getActualWord();
            currentWord = new Word(newWord.toLowerCase());
            triesLeft = 6;
            JOptionPane.showMessageDialog(null, "Word successfully changed!");
        } 
        
        else 
        {
            JOptionPane.showMessageDialog(null, "Invalid word. Word not changed.");
        }
    }

    // Method to record game results
    private void recordResult(boolean won) 
    {
        generateReport(won);
    }

    // Method to exit the game
    private void exitGame() 
    {
        JOptionPane.showMessageDialog(null, "Exiting the Hangman Game. Goodbye!");
        System.exit(0);
    }

    // Method to generate and display a game report in the console
    private void generateReport(boolean won) 
    {
        String result = won ? "Win" : "Loss";
        String word = currentWord.getActualWord();
        String tries = Integer.toString(triesLeft);

        String reportMessage = String.format(
            "Game Report:\nResult: %s\nWord: %s\nTries Left: %s\n",
            result, word, tries
        );

        System.out.println(reportMessage);
    }

    // Method to get the current player based on the turn
    private Player getCurrentPlayer() 
    {
        // Implement logic to switch between players (human and computer)
        // For now, return a human player
        return new HumanPlayer("Player1");
    }

    // Main method to start the game
    public static void main(String[] args)
    {
        HangmanGame game = new HangmanGame();
        game.startGame();
    }
}