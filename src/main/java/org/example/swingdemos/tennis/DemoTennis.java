package org.example.swingdemos.tennis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Set;


//https://kemitix.wordpress.com/2015/03/24/creating-an-awt-or-swing-gui-application-with-spring-boot/
//http://www.edu4java.com/en/game/game3.html

@SpringBootApplication
public class DemoTennis {

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
    GameModel gameModel;
    TennisPanel panel;

    @Bean
    //The runGame() method returns a CommandLineRunner bean that automatically runs the code when
    //the application launches
    public CommandLineRunner runGame() {
        return (args) -> {

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.setVisible(true);
                    frame.setSize(Settings.W, Settings.H+ Settings.MARGIN_Y);
                }
            });

            //add frame
            panel = new TennisPanel();
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //create small dots in panel
            final Random random = new Random();
            int x,y;

            for (int i = 0; i < Settings.NOF_DOTS; i++) {
                x=random.nextInt(Settings.W);  y=random.nextInt(Settings.H);
                panel.addDot(new Dot(x,y,Settings.DOT_RADIUS));
            }
            //create game model
            Racket racket = new Racket(Settings.W/2,Settings.racketHidth);
            TennisBall tennisBall  = new TennisBall(Settings.W/2,Settings.H/2,Settings.BALL_RADIUS,Color.red);
            gameModel=new GameModel(racket, tennisBall);


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

