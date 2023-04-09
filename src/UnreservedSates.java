public enum UnreservedSates {
    IDENTIFIER(2, "id", null), NATURAL_NUMBER(12, "number", "int"), 
    REAL_NUMBER(14, "number", "float"), STRING_LITERAL(16, "sl", "string");
    
    private final int NUM;
    public final String TOKEN_NAME;
    public final String TYPE;

    private UnreservedSates(int num, String tokenName, String type) {
        NUM = num;
        TOKEN_NAME = tokenName;
        TYPE = type;
    }

    /**
     * Gets <code>UnreservedStates</code> of the given unreserved state. 
     * @param state the unreserved state
     * @return the <code>UnreservedStates</code>
     */
    public static UnreservedSates getState(int state) {
        for (UnreservedSates unreservedState : UnreservedSates.values()) {
            if (state == unreservedState.NUM) {
                return unreservedState;
            }
        }

        return null;
    }
}
