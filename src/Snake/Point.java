/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import static Snake.Game.s;
import java.util.Random;


public class Point {
  private Random rnd = new Random();
  public int width,height,x,y;
  public int random =0;
  public Point(int width,int height){
      this.width =width;
      this.height =height;
      
  }
  
  public void update(){
      if( random == 0){
     random = rnd.nextInt(width*height);
     this.y= (int) Math.floor(random / width);
     System.out.println("y: "+y);
     this.x= random - y*width;
     System.out.println("x: "+x);
      }
      
           
      }
   public void render(){
       int vel =8;
       int x = s.point.x;
       int y = s.point.y;
      
        for (int j = x ;j<vel+x;j++){
                
           for(int i = x; i<vel+x;i++){
               
                    s.pixels[i+j*width]=0x000000;
           } 
            
        }
  
  }
}
