package org.example.domain.swingapp2modif2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


//https://kemitix.wordpress.com/2015/03/24/creating-an-awt-or-swing-gui-application-with-spring-boot/
//http://www.edu4java.com/en/game/game3.html

@SpringBootApplication
public class DemoSwingApplicationModif2 {

    final int W=1000; final int H=600;

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoSwingApplicationModif2.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Autowired
    private DemoFrameModif2 frame;

    @Bean
    //The runswing() method returns a CommandLineRunner bean that automatically runs the code when
    //the application launches
    public CommandLineRunner runswing() {
        return (args) -> {

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.setVisible(true);
                    frame.setSize(W, H);
                }
            });


            PanelComponent panel = new PanelComponent();
            frame.add(panel);
            frame.setSize(W, H);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel.addBall(10,10,11);
            panel.addBall(140,30,11,Color.blue);
            panel.addBall(333,333,11,Color.green);

            int x,y,xprev=0,yprev=0;
            final Random random = new Random();

            xprev=0; yprev=0;
            for (int i = 0; i < 100; i++) {
                x=random.nextInt(W);  y=random.nextInt(H);
                panel.addLine(xprev, yprev, x, y, new Color(1));
                xprev=x; yprev=y;
            }


            while (true) {
                panel.moveBalls();
                panel.repaint();
                Thread.sleep(10);
            }


        };
    }
}

