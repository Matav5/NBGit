package Snake;

import java.awt.Canvas;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
    public int width;
    public int height;
    private Thread thread;
    public boolean running;  
    public int LastTime = (int) System.currentTimeMillis();
    public static int secs =1000;
    public int target = 10;
    public JFrame Okno;
    public int now =100;
    public final int pixels[];
    public int fps;
    
    public static void main(String args[]){
       
       Game s = new Game();
       s.start();
       
    }
    public Game(){
       Okno f = new Okno();
       this.Okno = f.Okno;
       this.width =f.Okno.WIDTH;
       this.height = f.Okno.HEIGHT;
       pixels = new int[width*height];
       
    }
    public synchronized void start(){
        running = true;
        thread = new Thread(this,"Display");
        thread.start();
        
        
    }
      public synchronized void stop(){
        running =false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void update(){
        
        
    }
    
    public synchronized void render(){
     
        
    }
  

    @Override
    public void run() {
        
        while(running)
        {   now += now;
            System.out.println(fps);
            
            if(LastTime - now < secs/target){
              update();
              now =0;
              LastTime= (int) System.currentTimeMillis();
              fps++;
            }
            render();
        }
        stop();
    }
}