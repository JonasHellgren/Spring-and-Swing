package org.example.domain.swingapp2modif;


import org.example.domain.swingapp2.DemoFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;


//https://kemitix.wordpress.com/2015/03/24/creating-an-awt-or-swing-gui-application-with-spring-boot/

@SpringBootApplication
public class DemoSwingApplicationModif {

    final int W=1000; final int H=600;

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoSwingApplicationModif.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Autowired
    private DemoFrameModif frame;

    @Bean
    //The runswing() method returns a CommandLineRunner bean that automatically runs the code when
    //the application launches
    public CommandLineRunner runswing() {
        return (args) -> {

            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.setVisible(true);
                    frame.setSize(W, H);
                }
            });

           // frame.
            JPanel panel = new JPanel();
            final LinesComponent linesComponent = new LinesComponent();
            final CirclesComponent circlesComponent = new CirclesComponent();
            final Random random = new Random();
            int x,y,xprev=0,yprev=0;

            xprev=0; yprev=0;
            for (int i = 0; i < 100; i++) {
                x=random.nextInt(W);  y=random.nextInt(H);
                linesComponent.addLine(xprev, yprev, x, y, new Color(1));
                xprev=x; yprev=y;
            }

            circlesComponent.addCircle(111,111,20);

            frame.add(linesComponent);
            frame.add(circlesComponent);  //strul, linjerna försvinner



        };
    }
}

