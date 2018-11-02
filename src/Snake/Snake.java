
package Snake;

import static Snake.Game.height;
import static Snake.Game.s;
import static Snake.Game.vel;
import static Snake.Game.width;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Snake {
    public int x;
    public int y;
    public short smer;
    public boolean eaten;
    private Keyboard input;    
    protected ArrayList<Parts> parts;
    protected int poc;
    private int rych =vel;
    public Snake(int x, int y, int smer,Keyboard input){
        
     parts = new ArrayList<Parts>();
     parts.add(new Parts(x,y, (short) smer));
     poc = parts.size();
     this.input = input;
     this.x =x;
     this.y =y;
     this.smer = (short) smer;
        
        
        
    }
    public void update(){
        if(eaten){
            parts.add(new Parts(getX(poc),getY(poc),(short)getSmer(poc)) );
           
        }
       boolean pro = true;
       int xx=0;
       int yy=0;
      /* if(input.up)yy++;
       if(input.down)yy--;
       if(input.right)xx++;
       if(input.left)xx--;
       */
       if(input.up&&pro){
        smer = 0; pro=false; yy-=rych;
       }
       if(input.down&&pro){
        smer = 2; pro=false; yy+=rych;
       }
       if(input.right&&pro){
        smer = 1; pro=false; xx+=rych;
       }
       if(input.left&&pro){
        smer = 3; pro=false; xx-=rych;
       }
       
       /*if(xx>0)smer =1;
       if(xx<0)smer =3;
       if(yy>0)smer =2;
       if(yy<0)smer =0;*/
       x+=x;
       y+=yy;
       if(!collision(xx,yy))
       {
           s.snake.x+=xx;
           s.snake.y+=yy;
           
       }else{
           s.running=false;
       }
       parts.set(0 ,new Parts(s.snake.x,s.snake.y,s.snake.smer));
       for(int i =1;i<parts.size();i++){
           parts.set(i, new Parts(getX(i-1),getY(i-1),(short)getSmer(i-1)));
           
       } 
        
        
    }
    public boolean collision(int xx, int yy){
        if(x+xx<0||y+yy<0||y+yy>height ||x+xx>width) return true;
        if(s.pixels[(x+xx)+(y+yy)* width]!=0x000000)return true;
        
        return false;
          
    }
    public void render(Screen screen){
        
       int vel =8;
       int x = s.snake.x;
       int y = s.snake.y;
        for (Iterator<Parts> it = parts.iterator(); it.hasNext();) {
            Parts parts = it.next();
            // LEFT HERE
        }
        for (int j = x ;j<vel+x;j++){
                
           for(int i = x; i<vel+x;i++){
               
                    screen.pixels[i+j*width]=0x000000;
           } 
            
        }
               
    }
    public int getX(int i){
       int xa =parts.get(i-1).getX();
       return xa;
    }
    public int getY(int i){
     int ya =parts.get(i-1).getY();  
     return ya;
    }
    public int getSmer(int i){
     short smer =(short)parts.get(i-1).getSmer();  
     return smer;
    }
}
