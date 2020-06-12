
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
    //clase que nos servirá para generar aleatoriamente posiciones sobretodo para
    //la posicion donde aparecerá una manzana
    private Random r;
    private Snake snake;
    
    public Food(Snake snake) { 
        // We pass Snake to the constructor because if the randomnly generated food
        // falls on the Snake you have to create another position for the food
        this.snake = snake;
        r = new Random();
        //44 en ambos lados porque es como que la posicion de la última columna 
        //entre comillas tiene la posición 44 y lo mismo con la última fila 
        //y creará la posición de la manzana hasta ese límite
        int xCoor = r.nextInt(44);
        int yCoor = r.nextInt(44);
        
        //bucle que tiene un metodo que este acepta las dos nuevas posiciones 
        //generadas para la manzana ydentro de este método comprueba que las
        //dos posiciones no coincidan con ninguna de las posiciones de los nodos
        // de la serpiente. Que coincide entonces devuelve true y otra  vez 
        //ha generar nuevas posiciones y otra vez a la condición del bucle.
        //Y si no coincide retorna false y 
        while(snake.checkCoincideFoodAndBody(xCoor, yCoor)) {
            xCoor = r.nextInt(44);
            yCoor = r.nextInt(44);
        }
        //se le asignará al nodo que tiene por atributo la  clase manzana
        //sus nueva posiciones y el tamaño de la manzana
        position = new Node(xCoor, yCoor, 10);
        //y se agregarña el nodo al Arraylist que tiene como atributo la clase 
        //Snake que guarda manzanas
        snake.addNodeFood(position);
        
    }
    
    
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        for(int i = 0; i < snake.getSizeApples(); i++) {
            g.setColor(Color.BLACK);
            g.fillRect(snake.getNodeFood(i).getRow()*10, snake.getNodeFood(i).getCol()*10, 10, 10);
            Util.drawSquare(g, snake.getNodeFood(i).getRow(), snake.getNodeFood(i).getCol(), 10, 10, Color.RED);
        }

        // Finish this method. Call Util.drawSquare()
    }
    
    /*public Snake getSnake() {
        return snake;
    }*/
    
    // Create all the methods you need here
}
