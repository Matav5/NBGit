/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

/**
 *
 * @author Matav
 */
public class Parts{
    
    public int x;
    public int y;
    public short smer;
    

 
   
    
    public Parts(int x, int y, short smer){
            
     this.x=x;
     this.y=y;
     this.smer=smer;
        
    }
    public int getX(){ 
        return x;
    }
    public int getY(){ 
        return y;
    }
    public int getSmer(){ 
        return smer;
    }
    
    
}
