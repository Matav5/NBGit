/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;
import Snake.Game;
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
        
        for (y = y ;y<2;y++){
           for(x =0; x<2;x++){
               pixels[x+y*width]= 0x00;
           } 
            
        }
        renderPoint();
        
    }
    public void renderPoint(){
        
       int x = Point.x;
       int y = Point.y;
       
        for (y = y ;y<2;y++){
           for(x = x; x<2;x++){
               pixels[x+y*width]=0x00;
           } 
            
        }
        
    }

    public void renderMap() {
        for(int y =0; y<height;y++){
            for(int x =0;x<width;x++)
                pixels[x+y*width]=0xffffff;
            
        }

    }
    
        
    
}
