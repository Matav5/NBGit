/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;

public class Okno extends JFrame{
    public JFrame Okno;
    
   public Okno(){
        JFrame Okno = new JFrame();
        Okno.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        Okno.setSize(400,400);
        Okno.setUndecorated(false);
        Okno.setResizable(false);
        Okno.getContentPane().setBackground(new Color(255, 247, 230));
        Okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Okno.setVisible(true);
       
    }
}
