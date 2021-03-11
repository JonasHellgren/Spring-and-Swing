package org.example.config;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BasicEx extends JFrame {

    public BasicEx() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Simple Java 2D example");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                BasicEx ex = new BasicEx();
                ex.setVisible(true);
            }
        });
    }
}