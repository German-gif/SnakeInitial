
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
public class Node {
    private int row;
    
    private int col;
    
    private int width;
    
    private int height;
    
    /*private int rowPosition;
    private int colPosition;
    
    private Direction direccion;*/
    
    public Node(int row, int col, int tileSize) {
        this.row = row;
        this.col = col;
        width = tileSize;
        height = tileSize;
    }
    
    public void draw(Graphics g) {
         Util.drawSquare(g, row, col, width, height, Color.GREEN);
         //ESTA ESTA INCOMPLETO NOS FALTA RETOCAR ESTA EN EL SENTIDO DE
         //QUE ESTA TIENE UNOS BORDES NEGROS ALREDEDOR DE LA SERPIENTE
         //DEL NODO
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public void setCol(int col) {
        this.col = col;
    }
    
    
    
    // Create the constructor and all the methods you need here
}
