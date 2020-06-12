
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
public class Snake {
    
    private List<Node> body;
    private int remainingNodesToCreate = 0;
    private Node node;
    
    /*private int widthBody = 10;
    private int heightBody = 10;*/
    
    //atributos que estaran en board
    //private int xCoor = 10, yCoor = 10;
    //private int size = 5;
    
    //private Board boardGame = new Board();
    private static Direction direction; 
    private int xCoor, yCoor;
    private int initialNodes;
    private boolean coincideFoodAndBody = false;
    private Random r;
    private List<Node> apples;
    
    
    public Snake(int row, int col, int size) { // Initial position of the head of the snake and number of inital nodes
        
        r = new Random();
        
        //esta variable guarda el tamaño inicial de la serpiente
        initialNodes = size;
        
        body = new ArrayList<Node>();
        
        //estas dos variables guardan la posicion del primer nodo en principio
        xCoor = row;
        yCoor = col;
        
        //el 10 es al ancho y alto que tendra el nodo
        node = new Node(row, col, 10);
        
        direction = Direction.DOWN;
        apples = new ArrayList<Node>();
        // Finish this method
    }
    
    public int getSizeBody() {
        return body.size();
    }
    
    public Node getPositionBody(int numPosition) {
        return body.get(numPosition);
    }
    
    public void addNode() {
        body.add(node);
    }
    
    public int getxPositionNode() {
        
        return node.getRow();
    }
    
    public int getyPositionNode() {
        return node.getCol();
    }
    
    public void eliminaPosZero() {
        if(body.size() > initialNodes) {
            body.remove(0);
        }
    }
    
    public static void setDirection(Direction direction) {
        Snake.direction = direction;
    }
    
    public static Direction getDirection() {
        return direction;
    }
    
    public boolean checkCoincideFoodAndBody(int xgenerateApple, int ygenerateApple) {
        for(int i = 0; i < body.size(); i++) {
            if(body.get(i).getRow() == xgenerateApple &&
                    body.get(i).getCol() == ygenerateApple) {
                coincideFoodAndBody = true;
            }
        }
        
        if(coincideFoodAndBody) {
            return true;
        } else {
            return false;
        }
    }
    
    public Node getNodeFood(int numPosition) {
        return apples.get(numPosition);
    }
    
    public int getSizeApples() {
        return apples.size();
    }
    
    public void addNodeFood(Node node) {
        apples.add(node);
    }
    
    public void incrementinitialNodes() {
        initialNodes++;
    }
    
    public int getinitialNodes() {
        return initialNodes;
    }
    
    public void eliminarFood(int i) {
        apples.remove(i);
    }
    
    public boolean canMove(int row, int col) {
        
    // Finish this method
        return true;
    }
    
    public void paint(Graphics g, int positionX, int positionY) {
        
        for(int i = 0; i < body.size(); i++) {
            //System.out.println(i);
            g.setColor(Color.BLACK);
            g.fillRect(body.get(i).getRow()*10, body.get(i).getCol()*10, 10, 10);
            Util.drawSquare(g, body.get(i).getRow(), body.get(i).getCol(), 10, 10, Color.GREEN);
            Util.drawSquare(g, positionX, positionY, 10, 10, Color.GREEN);
            //SIN ESTA ULTIMA LINEA DE CODIGO EL PROGRAMA TAMBIEN FUNCIONARIA
            //XD
        }
        
        

        // Finish this method. Call Util.drawSquare()
    }
    
    public void move() {
        if(direction == Direction.RIGHT) node.setRow(node.getRow()+1); /*node.setRow(xCoor++);*/
        if(direction == Direction.LEFT) node.setRow(node.getRow()-1);
        if(direction == Direction.UP) node.setCol(node.getCol()-1);
        if(direction == Direction.DOWN) node.setCol(node.getCol()+1);
        
        //node = new Node(xCoor, yCoor, 10);
        node = new Node(node.getRow(), node.getCol(), 10);
        body.add(node);
        System.out.println("Posicion x: " + node.getRow() + "Posicion y; "
        + node.getCol());
        System.out.println("Posicion x: " + body.get(0).getRow() + "Posicion y:" 
                + body.get(0).getCol());
        /*switch(direction) {
            
            case UP:
            
                
            break;
            
            case DOWN:
            break;
            
            case LEFT:
            break;
            
            case RIGHT:
            break;
        }*/
        //int row = node.getRow();
        //int col = node.getCol();
        //if(right) node.setRow(node.getRow() + 1);
        //ACUERDATE DE ESTE headSnake.getRow() + 1
        //a lo mejor no es correcto y toca cambiarlo
        //por forma variable
        //if(left) node.setRow(row--);
        //if(up) node.setCol(col--);
        //if(down) node.setCol(col++);
        
        //aqui las direcciones
        // Finish this method

    }
    
    
    
}
