package brocode_gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;

    MyFrame() {

        button=new JButton();
        button.setBounds(200,100,100,50);
        button.addActionListener(this);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);   //makes the label to not occupy all frame
        frame.setVisible(true);
        frame.add(button);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            System.out.println("pressed");
        }
    }
}
