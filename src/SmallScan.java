import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class SmallScan {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.print("usage: java SmallScan "); 
            System.out.println("<program-file-to-scan> <dfa-file>");
            
            return;
        }
        
        try {
            Scanner scanner = new Scanner(
                Files.readString(Path.of(args[0])), 
                new DFA(args[1]), new HashMap<>());

            while (true) {
                Token token = scanner.getNextToken();

                if (token == null) {
                    System.out.println("Invalid string for scanner.");

                    break;
                } else if (token.getName().equals("EOF")) {
                    System.out.println(token);

                    break;
                } else if (!token.getName().equals("ws")) {
                    System.out.println(token);
                }
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
