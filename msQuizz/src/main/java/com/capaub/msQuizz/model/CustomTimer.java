package com.capaub.msQuizz.model;

import java.util.TimerTask;

public class CustomTimer extends TimerTask {
    private int time = 20;
    @Override
    public void run() {
        System.out.println("time : " + time);

        if (time == 10){
            System.out.println("ATTENTION : plus que 10 secondes");
        }
        if (time == 5){
            System.out.println("ATTENTION : plus que 5 secondes");
        }
        if (time == 0){
            cancel();
        }
        time--;
    }
}
