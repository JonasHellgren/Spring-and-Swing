package org.example.domain.swingapp3modif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * Created by Administrator on 2017/12/7.
 * https://www.programmersought.com/article/92784544291/
 */
@SpringBootApplication
public class CloudUtilsApplication {

    public static void main(String[] args){
        //The role of SwingUtilities.invokeLater can be Baidu in detail, I am a novice
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
        //spirng
        SpringApplication.run(CloudUtilsApplication.class,args);
    }
    private static void createAndShowGUI(){
        // Create JFrame instance
        JFrame frame = new JFrame("Login Example");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        /**
         * The following sentence, if written like this, the window is closed, the springboot project will be closed, use
         * dispose will not
         */
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.dispose(); //If you write this sentence to close the window, the springboot project is still running
        /* Create a panel, this HTML-like div tag
         * We can create multiple panels and specify the position in the JFrame
         * In the panel, we can add text fields, buttons and other components.
         */
        JPanel panel = new JPanel();
        // Add panel
        frame.add(panel);
        /*
         * Call user-defined methods and add components to the panel
         */
        placeComponents(panel);

        // The setting interface is visible
        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel) {

        /* We don’t introduce much in the layout part
         * Set the layout here to null
         */
        panel.setLayout(null);

        // Create JLabel
        JLabel userLabel = new JLabel("User:");
        /* This method defines the location of the component.
         * setBounds(x, y, width, height)
         * x and y specify the new position of the upper left corner, and the new size is specified by width and height.
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /*
         * Create text fields for user input
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // Enter the text field of the password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /*
         *This is similar to the text field used for input
         * However, the entered information will be replaced by dots for security including passwords
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // Create login button
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
    }
}