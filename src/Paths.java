import java.util.function.Function;

public enum Paths {
    PLUS(x -> x == '+'), MINUS(x -> x == '-'), LESS_THEN(x -> x == '<'), 
    GREATER_THEN(x -> x == '>'), EQUAL(x -> x == '='), NOT(x -> x == '!'),
    DOT(x -> x == '.'), UNDER_BAR(x -> x == '_'), QUOTE(x -> x == '\"'), 
    SEMICOLON(x -> x == ';'), 
    LETTER(Util::isAlphabet), DIGIT(Util::isNumeric), 
    OPERATOR(Util::isOperator), WHITE_SPACE(Util::isBlank), 
    SPECIAL_CHARACTER(Util::isSpecialCharacter), OTHER(x -> true); 

    private Function<Character, Boolean> checkFunction;

    private Paths(Function<Character, Boolean> checkFunction) {
        this.checkFunction = checkFunction;
    }

    public boolean check(char ch) {
        return checkFunction.apply(ch);
    }
}
