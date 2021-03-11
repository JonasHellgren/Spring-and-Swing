package org.example.domain.swingapp2modif;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

@Component
public class DemoFrameModif extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    /**
     * Creates new form DemoFrame
     */
    public DemoFrameModif() {
     initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spring Boot with Swing application");
    }

    public void paint(Graphics gp) {
        super.paint(gp);
        Graphics2D graphics = (Graphics2D) gp;
        //Line2D line = new Line2D.Float(200, 150, 150, 220);
        //graphics.draw(line);
    }
}