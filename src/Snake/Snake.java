
package Snake;

import static Snake.Game.s;
import static Snake.Game.width;


public class Snake {
    public int x;
    public int y;
    public int smer;
    protected int poc =1;
    protected Parts[] parts;
    
    public Snake(int x, int y, long smer){
        
    parts = new Parts[poc];

        
        
        
    }
    public void update(){
        x++;
        y++;
          
        
        
        
    }
    public void render(Screen screen){
        
        
        s.screen.renderSnake(s.snake.x,s.snake.y);
        
    }
    public int eat(){
        
        return poc++;
    }   
}
