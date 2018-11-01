
package Snake;

import static Snake.Game.height;
import static Snake.Game.s;
import static Snake.Game.vel;
import static Snake.Game.width;
import java.util.ArrayList;
import java.util.Arrays;

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
        
        
        
    }
    public void update(){
        if(eaten){
            parts.add(new Parts(getX(poc),getY(poc),(short)getSmer(poc)) );
           
        }
       int yy=0;
       int xx=0;
       if(input.up)yy++;
       if(input.down)yy--;
       if(input.right)xx++;
       if(input.left)xx--;
       
       if(xx>0)smer =1;
       if(xx<0)smer =3;
       if(yy>0)smer =2;
       if(yy<0)smer =0;
       xx+=xx*rych;
       yy+=yy*rych;
       if(!collision(xx,yy))
       {
           s.snake.x+=xx;
           s.snake.y+=yy;
           
       }
       parts.set(0 ,new Parts(x,y,smer));
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
