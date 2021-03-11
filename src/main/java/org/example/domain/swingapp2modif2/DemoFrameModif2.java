package org.example.domain.swingapp2modif2;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

@Component
public class DemoFrameModif2 extends JFrame {

    private JButton jButton1;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    /**
     * Creates new form DemoFrame
     */
    public DemoFrameModif2() {
     initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spring Boot with Swing application");
    }

    public void paint(Graphics gp) {
        super.paint(gp);
        Graphics2D graphics = (Graphics2D) gp;
        Line2D line = new Line2D.Float(200, 150, 150, 220);
        graphics.draw(line);
    }

    public void paintLines(Graphics gp) {
        super.paint(gp);
        Graphics2D graphics = (Graphics2D) gp;
        Line2D line = new Line2D.Float(200, 150, 200, 1220);
        graphics.draw(line);


    }

}