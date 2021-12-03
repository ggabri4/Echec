package echecController;

import java.util.*;
import echecVue.plateau;

public class Timer2 extends Thread{
    plateau myplateau;
    private int totaltime = 10;
    Timer t = new Timer();
    public Timer2(plateau myplateau){
        this.myplateau = myplateau;
    }
    TimerTask echecTimer = new TimerTask() {
        public void run() {
            
            totaltime--;
            if(totaltime%10==0)
                System.out.println( (int)totaltime/60 + " Min "+ (totaltime%60));//affichage dans le terminale toutes les minutes
            if(totaltime<0)
                try {
                    myplateau.Perdu("B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        };
    };
    
    public synchronized void start (){
        t.schedule(echecTimer,1000,1000);
    }
}