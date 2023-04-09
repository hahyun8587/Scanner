import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DFA {
    public final int ERROR_STATE;

    private int[][] graph;
    private int[] fin;
    private int[] retract;

    /**
     * Initialize this instance from the given dfa file.
     * @param dfaFile the dfa file
     * @throws IOException
     */
    public DFA(String dfaFile) throws IOException {
        try (BufferedReader reader = 
                new BufferedReader(new FileReader(dfaFile))) {
            String line;
            ArrayList<int[]> integersList = new ArrayList<>();
            
            reader.readLine();

            while (!(line = reader.readLine()).isBlank()) {
                integersList.add(loadNumbers(line));
            }

            graph = integersList.toArray(new int[integersList.size()][]);

            reader.readLine();
            
            fin = loadNumbers(reader.readLine());

            reader.readLine();
            reader.readLine();

            retract = loadNumbers(reader.readLine());

            reader.readLine();
            reader.readLine();

            ERROR_STATE = Integer.parseInt(reader.readLine().strip());
        }
    }

    /**
     * Load numbers from the given string that consists of sequence of numbers.
     * @param str the string
     * @return array of numbers from the given string
     */
    private int[] loadNumbers(String str) {
        String[] numbers = str.strip().split(" ");
        int[] integers = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            integers[i] = Integer.parseInt(numbers[i]);
        }

        return integers;
    } 

    /**
     * Gets next state depending on the given state and character.
     * @param state the state
     * @param ch the character
     * @return integer that indicates the next state
     */
    public int move(int state, char ch) {
        return graph[state][getPath(ch)];
    }

    /**
     * Gets path from the given character.
     * @param ch the character
     * @return positive integer that indicates the path, -1 if error occured 
     */
    private int getPath(char ch) {
        Paths[] paths = Paths.values();

        for (int i = 0; i < paths.length; i++) {
            if (paths[i].check(ch)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Checks whether the given state is final or not.
     * @param state the state
     * @return <code>true</code> if the given state is final, <code>false</code> otherwise
     */
    public boolean isFinal(int state) {
        return fin[state] == 1;
    }

    /**
     * Checks whether the current character needs be retracted or not depending on the given state.
     * @param state the state
     * @return <code>true</code> if the current character needs to be retracted, <code>false</code> otherwise
     */
    public boolean isRetract(int state) {
        return retract[state] == 1;
    }
}
