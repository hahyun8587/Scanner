public enum SpecialCharacters implements ReservedWords {
    LB("("), RB(")"), COMMA(",");

    private String lexme;

    private SpecialCharacters(String lexme) {
        this.lexme = lexme;
    }

    @Override
    public String getLexme() {
        return lexme;
    }

    @Override
    public String getTokenName() {
        return "sc";
    }

    @Override
    public Object getAttribute() {
        return this;
    }
}
