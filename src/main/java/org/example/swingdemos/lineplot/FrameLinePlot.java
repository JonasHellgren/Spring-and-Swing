package org.example.swingdemos.lineplot;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class FrameLinePlot extends JFrame {

    /**    * Creates new  Frame     */
    public FrameLinePlot() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spring Boot with Swing application");
    }
}