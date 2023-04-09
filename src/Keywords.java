public enum Keywords implements ReservedWords {
    PROGRAM, PROGRAM_BEGIN, PROGRAM_END, BEGIN, END, 
    WHILE, FOR, BREAK, IF, ELSEIF, SWITCH, INTEGER, FLOAT, DISPLAY;

    @Override
    public String getLexme() {
        return toString().toLowerCase();
    }

    @Override
    public String getTokenName() {
        return toString().toLowerCase();
    }

    @Override
    public Object getAttribute() {
        return null;
    }
}
