package org.example.swingdemos.tennis;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class TennisFrame extends JFrame {

    /**    * Creates new  Frame     */
    public TennisFrame() {
     initComponents();
    }


    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spring Boot with Swing application");
    }



}