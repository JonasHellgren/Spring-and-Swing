package brocode_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class MyFrameForButton extends JFrame implements ActionListener {

    JButton button;
    JLabel label;


    MyFrameForButton() {

        ImageIcon image=new ImageIcon("src/main/resources/charger.png");
        label = new JLabel();
        label.setIcon(image);
        label.setBounds(150,250,150,150);
        label.setVisible(false);

        button=new JButton();
        button.setBounds(200,100,200,50);
        button.addActionListener(this);
        button.setText("I'm a button");
        button.setFocusable(false);  //remove box around text
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans",Font.BOLD,25));
        button.setIconTextGap(-15);
        button.setForeground(Color.red);
        button.setBackground(Color.LIGHT_GRAY);
        button.setBorder(BorderFactory.createEtchedBorder());

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);   //makes the label to not occupy all frame
        frame.setVisible(true);
        frame.add(button);
        frame.add(label);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            System.out.println("pressed");
            label.setVisible(true);
            JOptionPane.showMessageDialog(null,"Hello","Title",JOptionPane.PLAIN_MESSAGE);
       /*     OptionPane.showMessageDialog(null,"Hello","Title",JOptionPane.INFORMATION_MESSAGE);
            OptionPane.showMessageDialog(null,"Hello","Title",JOptionPane.QUESTION_MESSAGE);
            OptionPane.showMessageDialog(null,"Hello","Title",JOptionPane.WARNING_MESSAGE);
            OptionPane.showMessageDialog(null,"Hello","Title",JOptionPane.ERROR_MESSAGE); */


            JOptionPane.showOptionDialog(null,"Bla bla", "sdfsd",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,0);

        }
    }
}
