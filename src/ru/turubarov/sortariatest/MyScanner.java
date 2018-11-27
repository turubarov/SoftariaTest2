package ru.turubarov.sortariatest;

public class MyScanner {
    private String input;
    private int index;
    private StringBuilder lexem;

    public MyScanner(String input) {
        this.input = input;
        this.index = 0;
        this.lexem = new StringBuilder();
    }

    public TypesOfSymbol Scan() {
        lexem.setLength(0);
        if (index >= input.length()) {
            return TypesOfSymbol.END;
        }
        switch (input.charAt(index)) {
            case '(':
                lexem.append(input.charAt(index++));
                return TypesOfSymbol.LEFT_BRACKET;
            case ')':
                lexem.append(input.charAt(index++));
                return TypesOfSymbol.RIGHT_BRACKET;
            case ',':
                lexem.append(input.charAt(index++));
                return TypesOfSymbol.COMMA;
            default:
                while (input.charAt(index) != '(' && input.charAt(index) != ')' && input.charAt(index) != ',' && index < input.length()) {
                    lexem.append(input.charAt(index++));
                }
                return TypesOfSymbol.TEXT;
        }
    }

    public StringBuilder getLexem() {
        return lexem;
    }
}
