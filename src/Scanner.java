import java.util.HashMap;

public class Scanner {
    private String program;
    private int lexmeBegin = 0;
    private int forward = -1;
    private int lineCount = 1;
    private DFA dfa;
    private HashMap<String, Object[]> symbolTable;

    /**
     * Initialize this instance with the given program, dfa, and symbol table.
     * The symbol table is initialized by reserved words.
     * The reserved words are keywords, operators, special characters, and statement terminator.
     * @param program the program
     * @param dfa the dfa
     * @param symbolTable the symobl table
     */
    public Scanner(String program, DFA dfa, 
                   HashMap<String, Object[]> symbolTable) {
        this.program = program + '\0';
        this.dfa = dfa;
        this.symbolTable = symbolTable;

        installReservedWords(Keywords.values());
        installReservedWords(Operators.values());
        installReservedWords(SpecialCharacters.values());
        installReservedWords(StatementTerminator.values());
    } 

    /**
     * Installs the given reserved words to the symbol table initially.
     * @param reservedWords the reserved words
     */
    private void installReservedWords(ReservedWords[] reservedWords) {
        for (ReservedWords reservedWord : reservedWords) {
            symbolTable.put(reservedWord.getLexme(), 
                            new Object[] { reservedWord.getTokenName(), 
                                           reservedWord.getAttribute() });
        }
    }

    /**
     * Gets next <code>Token</code> of the program of this instance.
     * @return the next token, <code>null</code> if error occured.
     */
    public Token getNextToken() {
        if (program.charAt(lexmeBegin) == '\0') {
            return new Token("EOF", null);
        }

        int state = 0;

        while (true) {
            state = dfa.move(state, program.charAt(++forward));
            
            if (dfa.isFinal(state)) {
                Token token;

                if (dfa.isRetract(state)) {
                    forward--;
                }

                token = accept(state);
                lexmeBegin = forward + 1;

                return token;
            } else if (state == dfa.ERROR_STATE 
                       || program.charAt(forward) == '\0') {
                return null;
            }

            if (program.charAt(forward) == '\n') {
                lineCount++;
            }
        }
    }

    /**
     * Gets token from the given final state.
     * @param state the final state
     * @return the token
     */
    private Token accept(int state) {
        String lexme = program.substring(lexmeBegin, forward + 1);
        
        if (lexme.isBlank()) {
            return new Token("ws", null);
        }
     
        Object attribute = install(lexme, state);
    
        return new Token(getTokenName(lexme), attribute);
    }

    /**
     * Makes token attributes with the given state and installs it to the symbol table with the given lexme.
     * Gets the token attribute after installing it.<p>
     * If there is registered lexme in the symbol table already, gets the attribute without installing it.
     * @param lexme the lexme
     * @param state the state
     * @return the token attribute
     */
    private Object install(String lexme, int state) {
        if (symbolTable.containsKey(lexme)) {
            return symbolTable.get(lexme)[1];
        }

        UnreservedSates unreservedState = UnreservedSates.getState(state);

        symbolTable.put(lexme, 
                new Object[] { unreservedState.TOKEN_NAME, 
                        new Object[] { lexme, unreservedState.TYPE, 
                                       lineCount } });
        
        return symbolTable.get(lexme)[1];
    }

    /**
     * Gets token name that corresponds to the given lexme from the symbol table.
     * This method is invoked after <code>install()</code>.
     * @param lexme the lexme 
     * @return the token name
     */
    private String getTokenName(String lexme) {
        return (String) symbolTable.get(lexme)[0];
    }
}
