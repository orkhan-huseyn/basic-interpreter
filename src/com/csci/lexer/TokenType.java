package com.csci.lexer;

public enum TokenType {

    // comment block
    COMMENTLINE("//(.*)\n"),
    COMMENTBLOCK("/\\*.*\n.*\\*\\/"),
    SCOPESTART("\\{"),
    SCOPEEND("\\}"),
    BRASTART("\\("),
    BRAEND("\\)"),
    ARRSTART("\\["),
    ARREND("\\]"),
    // type patterns
    FLOAT("-?[0-9]+\\.[0-9]+"),
    INT("-?[0-9]+"),
    STRING("\"(.*?)\""),
    CHAR("'(.*?)'"),
    BOOLEAN("true|false"),
    INCREMENT("\\+\\+"),
    DECREMENT("--"),
    PLUS("\\+"),
    MINUS("-"),
    PROD("\\*"),
    DIV("/"),
    GREATEROREQUALS(">="),
    LESSOREQUALS("<="),
    GREATER(">"),
    LESS("<"),
    EQUALS("=="),
    NOTEQUAL("!="),
    AND("\\&\\&"),
    OR("\\|\\|"),
    ASSIGNMENT("="),
    SEMICOLON(";"),
    WHITESPACE("[\t\f\n\r]+"),
    // type name patterns
    TYPEINT("int"),
    TYPEFLOAT("float"),
    TYPESTRING("string"),
    TYPECHAR("char"),
    TYPEBOOL("bool"),
    TYPEVOID("void"),
    TRUE("true"),
    FALSE("false"),
    // keywords
    FOR("for"),
    WHILE("while"),
    IF("if"),
    ELSE("else"),
    RETURN("return"),
    BREAK("break"),
    CONTINUE("continue"),
    // ident (varable or function name)
    IDENT("[a-zA-Z0-9_]+"),
    EOF("EOF");

    public final String pattern;

    private TokenType(String pattern) {
        this.pattern = pattern;
    }

}
