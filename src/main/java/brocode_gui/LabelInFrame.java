package brocode_gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LabelInFrame {

    public static void main(String[] args) {

        ImageIcon image=new ImageIcon("src/main/resources/truck_top.png");
        Border border=BorderFactory.createLineBorder(Color.blue,3);
        int labelXpos=10;
        int labelYpos=10;

        JLabel label=new JLabel();
        label.setText("Hello");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(0X00FFFF));
        label.setFont(new Font("MV Boli", Font.PLAIN,20));
        label.setIconTextGap(1);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.TOP);  //set vertical pos of icon and text within label
        label.setHorizontalAlignment(JLabel.CENTER);  //set horizontal pos
        label.setBounds(labelXpos,labelYpos,100,200);

        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);   //makes the label to not occupy all frame
        frame.setVisible(true);
        frame.add(label);
        //frame.pack();    //size of frame will fit to components, comment label.setBounds, frame.setSize and frame.setLayout if used


    }
}
