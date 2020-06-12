
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
    
    private static Direction direction; 
    private int chivato = 1;
    /*private List<Node> body = new List<Node>(); {
        @Override
        public int size() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isEmpty() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean contains(Object o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Iterator<Node> iterator() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <T> T[] toArray(T[] a) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean add(Node e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean addAll(Collection<? extends Node> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean addAll(int index, Collection<? extends Node> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Node get(int index) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Node set(int index, Node element) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void add(int index, Node element) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Node remove(int index) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int indexOf(Object o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int lastIndexOf(Object o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ListIterator<Node> listIterator() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ListIterator<Node> listIterator(int index) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<Node> subList(int fromIndex, int toIndex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };*/
    
    private List<Node> body;
    private int remainingNodesToCreate = 0;
    private Node node;
    
    /*private int widthBody = 10;
    private int heightBody = 10;*/
    
    //atributos que estaran en board
    //private int xCoor = 10, yCoor = 10;
    //private int size = 5;
    
    //private Board boardGame = new Board();
    private int xCoor, yCoor;
    private int initialNodes;
    private boolean coincideFoodAndBody = false;
    private Random r;
    
    
    public Snake(int row, int col, int size) { // Initial position of the head of the snake and number of inital nodes
        
        //La variable size esta de parametro que esta en el
        //constructor es el size que dice con los nodos
        //con los que empieza la serpiente
        r = new Random();
        initialNodes = size;
        body = new ArrayList<Node>();
        xCoor = row;
        yCoor = col;
        
        node = new Node(row, col, 10);
        
        direction = Direction.DOWN;
        // Finish this method
    }
    
    public int getSizeBody() {
        return body.size();
    }
    
    /*public Node getPositionBody(int numPosition) {
        return body.get(numPosition);
    }*/
    
    /*public void pintaNodos(Graphics g) {
        for(int i = 0; i < body.size(); i++) {
            body.get(i).paint();
        }
    }*/
    
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
    
    /*public boolean checkCoincideFoodAndBody(int xgenerateApple, int ygenerateApple) {
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
    
    public void addNodeFood(Node node) {
        body.add(node);
    }
    
    public void otherNode(int nuevoNodo ) {
        initialNodes = nuevoNodo;
    }
    
    public void eliminarFood(int i) {
        body.remove(i);
    }*/
    
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
