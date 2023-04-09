public class Token {
    protected String name;
    protected Object attribute;

    public Token(String name, Object attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        if (name.equals("EOF")) {
            return "EOF : ";
        } else if (name.equals("id")) {
            return "IDENTIFIER : " + ((Object[]) attribute)[0];
        } else if (name.endsWith("op")) {
            return "OPERATOR : " + ((Operators) attribute).getLexme(); 
        } else if (attribute == null) {
            return "KEYWORD : " + name;
        } else if (name.equals("number")) {
            return "NUMBER : " + ((Object[]) attribute)[0];
        } else if (name.equals("sl")) {
            return "STRING_LITERAL : " + ((Object[]) attribute)[0]; 
        } else if (name.equals("sc")) {
            return "SPECIAL_CHAR : " 
                   + ((SpecialCharacters) attribute).getLexme();
        } else {
            return "STATEMENT_TERMINATOR : " 
                   + ((StatementTerminator) attribute).getLexme();
        }
    }

    public String getName() {
        return name;
    }
}
