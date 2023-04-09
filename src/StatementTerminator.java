public enum StatementTerminator implements ReservedWords {
    SC(";");

    private String lexme;
    
    private StatementTerminator(String lexme) {
        this.lexme = lexme;
    } 

    @Override
    public String getLexme() {
        return lexme;
    }

    @Override
    public String getTokenName() {
        return "st";
    }

    @Override
    public Object getAttribute() {
        return this;
    }
}
