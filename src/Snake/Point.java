/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import java.util.Random;


public class Point {
  private Random rnd = new Random();
    public static int width,height,x,y;
  public Point(int width,int height){
      this.width =width;
      this.height =height;
      
  }
  
  public void update(){
     x = rnd.nextInt(width*height);
     y = rnd.nextInt(width*height);
     
  }
  
  
}
