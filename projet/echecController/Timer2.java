package echecController;

import java.util.*;

public class Timer2 extends Thread{
    private int totaltime = 300;
    Timer t = new Timer();
    TimerTask oui = new TimerTask() {
        public synchronized void run() {
            //synchronized (echequierListener.cle){
            if(totaltime == 280){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            totaltime--;
            System.out.println( (int)totaltime/60 + " Min "+ (totaltime%60));
            };
    };
    
    public synchronized void start (){
        t.schedule(oui,1000,1000);
        
    }
    
    
        
    }
    
//}

