package brocode_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCheckBoxFrame extends JFrame implements ActionListener {

    JButton button;
    JCheckBox checkBox;
    ImageIcon image;

    MyCheckBoxFrame() {
        //ImageIcon chargeImage=new ImageIcon("src/main/resources/charger.png");
        //ImageIcon notChargeImage=new ImageIcon("src/main/resources/notcharge.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());   //makes the label to not occupy all frame

        button = new JButton();
        button.setText("submit");
        button.addActionListener(this);

        checkBox = new JCheckBox();
        checkBox.setText("charge");
        checkBox.setFocusable(false);
        //checkBox.setFont
        //checkBox.setIcon(chargeImage);
        //checkBox.setSelectedIcon(notChargeImage);

        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            System.out.println(checkBox.isSelected());
        }

    }
}
