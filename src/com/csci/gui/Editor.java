package com.csci.gui;

import java.awt.*;
import java.util.LinkedList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import com.csci.lexer.Lexer;
import com.csci.lexer.Token;
import com.csci.lexer.TokenType;
import com.csci.parser.Parser;
import com.csci.grammar.Program;

public class Editor {

    /**
     * Main frame
     */
    public JFrame frame;
    /**
     * editor pane
     */
    private JTextPane editor;
    /**
     * Console pane
     */
    private JTextPane console;
    /**
     * Lexer instance
     */
    private Lexer lexer;

    /**
     * Constructor
     */
    public Editor() {
        initialize();
        lexer = new Lexer();
    }

    /**
     * Initialize contents of frame
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 50, 900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JToolBar toolBar = new JToolBar();
        frame.getContentPane().add(toolBar, BorderLayout.NORTH);

        JButton btnParse = new JButton("Parse");

        btnParse.addActionListener(e -> {

            String input = editor.getText();

            LinkedList<Token> tokenList = lexer.lex(input);

            Parser parser = new Parser(tokenList);

            try {
                Program prog = parser.parseProgram();
                console.setText(prog.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        toolBar.add(btnParse);

        JButton btnRun = new JButton("Execute");
        toolBar.add(btnRun);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        frame.getContentPane().add(splitPane, BorderLayout.CENTER);

        editor = new JTextPane();

        editor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                highlight(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                highlight(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        editor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        editor.setFont(new Font("Consolas", Font.PLAIN, 22));
        editor.setMinimumSize(new Dimension(0, 500));
        splitPane.setLeftComponent(editor);

        console = new JTextPane();
        console.setEditable(false);
        console.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        splitPane.setRightComponent(console);
    }

    /**
     * Highlights tokens
     *
     * @param e event
     */
    private void highlight(DocumentEvent e) {

        Runnable doHighlight = () -> {

            try {

                Document doc = e.getDocument();
                String code = doc.getText(0, doc.getLength());

                LinkedList<Token> tokens = lexer.lex(code);

                HashMap<String, Color> tokenColors = new HashMap<>();
                tokenColors.put(TokenType.FLOAT.name(), Color.RED);
                tokenColors.put(TokenType.INT.name(), Color.RED);
                tokenColors.put(TokenType.STRING.name(), Color.GRAY);
                tokenColors.put(TokenType.CHAR.name(), Color.GRAY);
                tokenColors.put(TokenType.BOOLEAN.name(), Color.MAGENTA);
                tokenColors.put(TokenType.RETURN.name(), Color.BLUE);
                tokenColors.put(TokenType.TYPEINT.name(), Color.BLUE);
                tokenColors.put(TokenType.TYPEBOOL.name(), Color.BLUE);
                tokenColors.put(TokenType.TYPECHAR.name(), Color.BLUE);
                tokenColors.put(TokenType.TYPEFLOAT.name(), Color.BLUE);
                tokenColors.put(TokenType.TYPESTRING.name(), Color.BLUE);
                tokenColors.put(TokenType.TYPEVOID.name(), Color.BLUE);

                HashMap<String, Style> tokenStyles = new HashMap<>();

                for (String key : tokenColors.keySet()) {
                    Color color = tokenColors.get(key);
                    Style style = editor.addStyle(key, null);
                    StyleConstants.setForeground(style, color);
                    tokenStyles.put(key, style);
                }

                Style defaultStyle = editor.addStyle("default", null);
                StyleConstants.setForeground(defaultStyle, Color.BLACK);

                for (Token token : tokens) {
                    Style tokenStyle = tokenStyles.get(token.getType().name());
                    if (tokenStyle != null)
                        editor
                                .getStyledDocument()
                                .setCharacterAttributes(token.getPosition(), token.getData().length(), tokenStyle, true);
                    else
                        editor
                                .getStyledDocument()
                                .setCharacterAttributes(token.getPosition(), token.getData().length(), defaultStyle, true);
                }
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        };

        SwingUtilities.invokeLater(doHighlight);
    }

}
