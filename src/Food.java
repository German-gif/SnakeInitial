
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

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
    private Random r;
    private Snake snake;
    
    public Food(Snake snake) { 
        // We pass Snake to the constructor because if the randomnly generated food
        // falls on the Snake you have to create another position for the food
        this.snake = snake;
        r = new Random();
        
        int xCoor = r.nextInt(44);
        int yCoor = r.nextInt(44);
        
        while(snake.checkCoincideFoodAndBody(xCoor, yCoor)) {
            xCoor = r.nextInt(44);
            yCoor = r.nextInt(44);
        }
        
        position = new Node(xCoor, yCoor, 10);
        snake.addNodeFood(position);
        
    }
    
    public void tick() {
        
    }
    
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        //snake.paint(g, squareWidth, squareWidth);

        // Finish this method. Call Util.drawSquare()
    }
    
    public Snake getSnake() {
        return snake;
    }
    
    // Create all the methods you need here
}
