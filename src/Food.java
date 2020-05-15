
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victoralonso
 */
public class Food {
    private Node position;
    private static boolean isSpecial;
    
    public Food(Snake snake) { 
        // We pass Snake to the constructor because if the randomnly generated food
        // falls on the Snake you have to create another position for the food
        
    }
    
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        Util.drawSquare(g, position.getRow(), position.getCol(), squareWidth, squareHeight, Color.RED);

        // Finish this method. Call Util.drawSquare()
    }
    
    // Create all the methods you need here
}
