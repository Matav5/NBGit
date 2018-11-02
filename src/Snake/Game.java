package Snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;
    public static int width = 400;
    public static int height = 400;
    public static int vel =8;
    private String title ="Snake";
    public Point point=new Point(width,height);
    public Snake snake;
    private Thread thread;
    public Screen screen=new Screen(width,height);
    public boolean running;
   
    public static int secs =1000;
    public double target = 5;
    public static Game s;
    public Keyboard key = new Keyboard();
    public JFrame Okno = new JFrame();
    BufferedImage image= new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    public static void main(String args[]){
       
        s = new Game();
        s.Okno.add(s);
        s.Okno.pack();
        s.Okno.setVisible(true);
        s.Okno.setSize(width,height);
        s.start();
    }
    public Game(){
        snake = new Snake(30,30,0,key);
        Okno.setExtendedState(JFrame.MAXIMIZED_BOTH); 
       
        Okno.setUndecorated(false);
        Okno.setResizable(false);
        Okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Okno.setTitle(title);
        Okno.addKeyListener(key);
       
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
    public void update(){
        key.update();
        snake.update();
        point.update();
        
        
    }
    
    public void render(){
     
        BufferStrategy bs = getBufferStrategy();
        if(bs == null)
        {
            createBufferStrategy(2);
            return;
        }
        screen.clear();
        screen.renderMap();
        snake.render(screen);
        for(int i =0;i<pixels.length;i++){
            this.pixels[i]=screen.pixels[i];
        }
        Graphics g = bs.getDrawGraphics();
        
        g.drawString(" X: "+snake.x+", Y: "+snake.y,450,400);
        g.drawImage(image,0,0, null);
        g.dispose();
        bs.show();
        
    }
  

   
    public void run() {
        final double ns = 1_000_000_000/target;
        double delta = 0;
        long LastTime = System.nanoTime();
        long time = System.currentTimeMillis();
        int frames=0;
        int updates=0;
        Okno.requestFocus();
        while(running)
        {   
                   long now = System.nanoTime();
             delta+=(now - LastTime) /ns;
             LastTime =now;
            while(delta >=1 ){
              update();
              updates++;
              delta--;
              
            }
            render();
            frames++;
            if (System.currentTimeMillis() - time>1000){
                time+=1000;
                System.out.println("Ups: " + updates +" Fps: " + frames);
                Okno.setTitle(title + " Ups" + updates +" || " +"Fps" +frames);
                updates=0;
                frames=0;
            }
        }
        stop();
    }
}