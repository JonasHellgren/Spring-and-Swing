package brocode_gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MySliderFrame extends JFrame implements ChangeListener {


    JSlider slider;
    JPanel panel;
    JLabel label;

    public MySliderFrame() {

        slider = new JSlider(0, 100, 50);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.addChangeListener(this);

        label = new JLabel();
        // label.setIcon(image);
        label.setBounds(150,250,150,150);
        label.setVisible(true);
        label.setText("Speed = "+ slider.getValue());

        panel = new JPanel();

        panel.add(slider);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());   //makes the label to not occupy all frame
        this.add(panel);
        this.add(label);
        this.setSize(420, 420);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText("Speed = "+ slider.getValue());
    }
}
