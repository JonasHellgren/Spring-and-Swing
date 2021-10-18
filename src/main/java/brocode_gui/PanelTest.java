package brocode_gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelTest {
    public static void main(String[] args) {

        ImageIcon image=new ImageIcon("src/main/resources/truck_top.png");
        JLabel label=new JLabel();
        label.setText("Hello");
        label.setIcon(image);
        //label.setHorizontalTextPosition(JLabel.CENTER);
        //label.setVerticalTextPosition(JLabel.TOP);
        label.setBounds(100,100,75,75);

        JPanel redPanel=new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0,0,250,250);

        JPanel bluePanel=new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(250,0,250,250);

        JPanel greenPanel=new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0,250,500,250);
        greenPanel.add(label);

        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);   //makes the label to not occupy all frame
        frame.setSize(750,750);
        frame.setVisible(true);
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);


    }
}
