package org.example.swingdemos.tennis;

import org.springframework.stereotype.Component;

@Component
public class PlayerService {
    //Dummy AI for playing tennis.

    public int calcSpdRacketRef(GameModel gameModel)  {

        if (gameModel.getTennisBall().x<gameModel.getRacket().x)
            return -Settings.BALL_SPEED;   //go left is ball is left to racket
        else
            return Settings.BALL_SPEED;  //go right if ..
    }

}
