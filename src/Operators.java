public enum Operators implements ReservedWords {
    ADD("+", "arithop"), SUB("-", "arithop"), MUL("*", "arithop"), 
    DIV("/", "arithop"), ASSIGN("=", "assignop"), NOT("!", "logicop"),
    INCR("++", "incrop"), DECR("--", "decrop"),
    LT("<", "relop"), GT(">", "relop"), EQ("==", "relop"), 
    LE("<=", "relop"), GE(">=", "relop"), NE("!=", "relop"); 

    private String lexme;
    private String tokenName;
   
    private Operators(String lexme, String tokenName) {
        this.lexme = lexme;
        this.tokenName = tokenName;
    }

    @Override
    public String getLexme() {
        return lexme;
    }

    @Override
    public String getTokenName() {
        return tokenName;
    }

    @Override
    public Object getAttribute() {
        return this;
    }
}
