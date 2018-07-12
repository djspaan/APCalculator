interface CalculatorInterface {
    /**
     * @pre -
     * @post the list of arithmetic tokens from the String input has been returned.
     */
    TokenList readTokens(String input) throws IncorrectTokenInput;

    /**
     * @pre -
     * @post The result of the RPN expression has been returned.
     */
    Double rpn(TokenList tokens);

    /**
     * @pre -
     * @post The arithmetic expression tokens converted into Reverse-Polish-Notation have been returned.
     */
    TokenList shuntingYard(TokenList tokens);
}
