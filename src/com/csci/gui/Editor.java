package com.csci.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import javax.swing.border.EtchedBorder;

import com.csci.lexer.Lexer;
import com.csci.lexer.Token;
import com.csci.lexer.TokenType;

public class Editor {

    public  JFrame frame;
    private JTextPane editorCode;
    private JTextPane editorConsole;
    private Lexer lexer;

    /**
     * Create the application.
     */
    public Editor() {
        initialize();
        lexer = new Lexer();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 50, 900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JToolBar toolBar = new JToolBar();
        frame.getContentPane().add(toolBar, BorderLayout.NORTH);

        JButton btnRun = new JButton("Execute");
        toolBar.add(btnRun);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        frame.getContentPane().add(splitPane, BorderLayout.CENTER);

        editorCode = new JTextPane();
        editorCode.getDocument().addDocumentListener(new DocumentListener() {
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
        editorCode.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        editorCode.setMinimumSize(new Dimension(0, 500));
        splitPane.setLeftComponent(editorCode);

        editorConsole = new JTextPane();
        editorConsole.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        splitPane.setRightComponent(editorConsole);
    }

    /**
     * Highlights tokens
     *
     * @param e
     */
    private void highlight(DocumentEvent e) {
        Runnable doHighlight = new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = e.getDocument();
                    String code = doc.getText(0, doc.getLength());

                    ArrayList<Token> tokens = lexer.lex(code);

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
                        Style style = editorCode.addStyle(key, null);
                        StyleConstants.setForeground(style, color);
                        tokenStyles.put(key, style);
                    }

                    Style defaultStyle = editorCode.addStyle("default", null);
                    StyleConstants.setForeground(defaultStyle, Color.BLACK);

                    // now iterate through tokens and try to highlight them
                    // see the example below

                    for (Token token : tokens) {
                        Style tokenStyle = tokenStyles.get(token.getType().name());
                        if (tokenStyle != null)
                            editorCode
                                    .getStyledDocument()
                                    .setCharacterAttributes(token.getPosition(), token.getData().length(), tokenStyle, true);
                        else
                            editorCode
                                    .getStyledDocument()
                                    .setCharacterAttributes(token.getPosition(), token.getData().length(), defaultStyle, true);
                    }
                } catch (BadLocationException e1) {
                    // exception
                }
            }
        };
        SwingUtilities.invokeLater(doHighlight);
    }

}
