package org.example.swingdemos.swingmanylinessomeballs;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class FrameComponent extends JFrame {

    /**    * Creates new  Frame     */
    public FrameComponent() {
     initComponents();
    }


    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spring Boot with Swing application");
    }



}