/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;
import Snake.Game;
import static Snake.Game.s;
public class Screen {
    
    public int width, height;
    public int[] pixels;
    
    public Screen(int width, int height){
        
        this.width=width;
        this.height=height;
        pixels = new int[width*height];

    }
    
    
    public void clear(){
        
        for (int i = 0; i<pixels.length;i++){
            pixels[i]=0;
        }
    }
    public void renderSnake(int x, int y){
        
           
         
               
    }
    
    public void renderPoint(){
       int vel =8;
       int x = s.point.x;
       int y = s.point.y;
      
        for (int j = x ;j<vel+x;j++){
                
           for(int i = x; i<vel+x;i++){
               
                    pixels[i+j*width]=0x000000;
           } 
            
        }
        
    }

    public void renderMap() {
        for(int y =0; y<height;y++){
            for(int x =0;x<width;x++)
                pixels[x+y*width]=0xFFFFFF;
            
        }

        renderPoint();
    }
    
        
    
}
