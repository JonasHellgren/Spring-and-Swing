package org.example.swingdemos.tennis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.util.Set;


//https://kemitix.wordpress.com/2015/03/24/creating-an-awt-or-swing-gui-application-with-spring-boot/
//http://www.edu4java.com/en/game/game3.html

@SpringBootApplication
public class DemoTennis {

    //final int W=1000; final int H=600;  //frame size

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoTennis.class)
                .headless(false)  //allow AWT classes to be instantiated
                .web(WebApplicationType.NONE)  //prevents the bundling of Tomcat or other Web components
                .run(args);
    }

    @Autowired
    private TennisFrame frame;

    @Autowired
    private PlayerService playerService;

    @Bean
    //The runswing() method returns a CommandLineRunner bean that automatically runs the code when
    //the application launches
    public CommandLineRunner runswing() {
        return (args) -> {

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.setVisible(true);
                    frame.setSize(Settings.W, Settings.H+ Settings.MARGIN_Y);
                }
            });

            //add frame
            TennisPanel panel = new TennisPanel();
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //create balls

            //create lines

            //create game model
            Racket racket = new Racket(Settings.W/2,Settings.H-Settings.racketHidth);
            TennisBall tennisBall  = new TennisBall(Settings.W/2,Settings.H/2,Settings.BALL_RADIUS,Color.red);
            GameModel gameModel=new GameModel(racket, tennisBall,panel);


            //"game" loop
            while (true) {
                if (gameModel.gameOver)
                    gameModel.resetGame();
                gameModel.moveBall();  //update of the physics of our world model
                gameModel.moveRacket(playerService.calcSpdRacketRef(gameModel));  //playerService(gameModel)
                panel.copyModelStates(gameModel);  //copy world model states to view/panel
                panel.repaint();  // tell the AWT engine to execute the paint method as soon as possible.
                Thread.sleep(Settings.DT);  // tells the processor that the thread which is being run must sleep
            }


        };
    }
}

