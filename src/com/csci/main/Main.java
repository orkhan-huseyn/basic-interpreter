package com.csci.main;

import com.csci.gui.Editor;

import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                Editor window = new Editor();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

}
