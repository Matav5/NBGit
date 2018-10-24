/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;
import java.awt.Color;
import static java.lang.System.out;
import javax.swing.*;
/**
 *
 * @author Matav
 */
public class Snake {
      long lastTime;

        
        
    public static void main (String[] args){
    
    JFrame Okno = new JFrame();
    Okno.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    Okno.setUndecorated(false);
    Okno.getContentPane().setBackground(new Color(255, 247, 230));
    Okno.setVisible(true);
    long time = System.currentTimeMillis()+1000;
    out.println(time);
   
    }
    
    
}
