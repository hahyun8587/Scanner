public class Util {

    /**
     * Checks whether the given character is an alpahbet.
     * @param ch the character
     * @return <code>true</code> if the given character is an alphabet, <code>false</code> otherwise 
     */
    public static boolean isAlphabet(char ch) {
        return ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122 ? true : false;
    }

    /**
     * Checks whether the given character is a number.
     * @param ch the character
     * @return <code>true</code> if the given chararcter is a number, <code>false</code> otherwise
     */
    public static boolean isNumeric(char ch) {
        return ch >= 48 && ch <= 57 ? true : false;
    }

    /**
     * Checks whether the given character is blank.
     * @param ch the character
     * @return <code>true</code> if the given chararcter is blank, <code>false</code> otherwise
     */
    public static boolean isBlank(char ch) {
        return ch == '\t' || ch == '\n' || ch == '\r' || ch == ' ' 
                ? true 
                : false;
    }

    /**
     * Checks whether the given character is an operator.
     * @param ch the character
     * @return <code>true</code> if the given character is an operator, <code>false</code> otherwise
     */
    public static boolean isOperator(char ch) {
        String str = String.valueOf(ch);

        for (Operators operator : Operators.values()) {
            if (str.equals(operator.getLexme())) {
                return true;
            }
        } 

        return false;
    }

    /**
     * Checks whether the given character is a special character.
     * @param ch the character
     * @return <code>true</code> if the given character is a special character, <code>false</code> otherwise
     */
    public static boolean isSpecialCharacter(char ch) {
        String str = String.valueOf(ch);
        
        for (SpecialCharacters specialSymbol : SpecialCharacters.values()) {
            if (str.equals(specialSymbol.getLexme())) {
                return true;
            }
        } 

        return false;
    }
}
