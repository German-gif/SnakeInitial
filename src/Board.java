

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victoralonso
 */
public class Board extends javax.swing.JPanel implements Runnable{
    
    private int numRows = 450;
    private int numCols = 450;
    private Snake snake;
    private Food food;
    private Food specialFood;
    private Timer snakeTimer;
    private Timer specialFoodTimer;
    private int DeltaTime;
    Direction keepDirection = Direction.LEFT;
    private Thread thread;
    private boolean running = false;
    private int xCoor = 10, yCoor = 10;
    private int initialSizeNodes = 5;
    
    private int ticks = 0;
    
    private Key key;
    
    private boolean haColisionado = false;
    
    //private useScoreBoard marcador;
    private int score=1;
    /**
     * Creates new form Board
     */
    public Board() {
        
        setFocusable(true);
        key = new Key();
        addKeyListener(key);
        snake = new Snake(xCoor, yCoor, initialSizeNodes);
        //marcador = new useScoreBoard();
        //food = new Food(snake);
        start();
        initComponents();
        myInit();
    }
    
    private void myInit() {
        
        /*Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.numRows = dim.width;
        this.numCols = dim.height;
        setSize(this.numRows, this.numCols);
        addKeyListener(this);*/
        
        

        // Finish this method
    }
    
    public Board(int numRows, int numCols) {
        
        // Finish this method
    }
    
    public boolean colideFood() {
        // Finish this method
        for(int i = 0; i < snake.getSizeApples(); i++) {
            if(snake.getPositionBody(snake.getSizeBody()-1).getRow() == snake.getNodeFood(i).getRow() &&
                    snake.getPositionBody(snake.getSizeBody()-1).getCol() == snake.getNodeFood(i).getCol()) {
                return true;
            }
        }
        return false;
        
    }
    
    public void gameOver() {
        // Finish this method
    }
    
    @Override 
    protected void paintComponent(Graphics g)  {
        super.paintComponent(g);
        
        g.clearRect(0, 0, numRows, numCols);
        g.setColor(Color.BLACK);
        for(int i = 0; i < numRows / 10; i++) {
            g.drawLine(i*10, 0, i*10, numCols);
        }
        for(int i = 0; i < numCols / 10; i++) {
            g.drawLine(0, i*10, numRows , i*10);
        }
        
        snake.paint(g, snake.getxPositionNode(), snake.getyPositionNode());
        food.paint(g, 10, 10);
        //Y SI LO AÑADES YA PINTADO??
        
        //snake.paint(g, this.numRows/2, this.numCols/2);
        // Finish this method
        // Paint the Snake and the food here
    }
    
    public void tick() {
        System.out.println("Running...");
        
        if(snake.getSizeBody()== 0) {
            snake.addNode();
        }
        
        if(snake.getSizeApples()==0) {
            food = new Food(snake);
        }
        
        /*for(int i = 0; i < snake.getSizeApples(); i++) {
            if(snake.getPositionBody(snake.getSizeBody()-1).getRow() == snake.getNodeFood(i).getRow() &&
                    snake.getPositionBody(snake.getSizeBody()-1).getCol() == snake.getNodeFood(i).getCol()) {
                snake.incrementinitialNodes();
            snake.eliminarFood(0);
            }
        }*/
        if(colideFood()) {
            snake.incrementinitialNodes();
            //marcador.incrementScore(score);
            score++;
            snake.eliminarFood(0);
        }
        
        /*System.out.println("Posicion x: " + snake.getPositionBody(snake.getSizeBody()-1).getRow() 
                + "Posicion y; " + snake.getPositionBody(snake.getSizeBody()-1).getCol());
        System.out.println("Posicion x: " + snake.getPositionBody(0).getRow() 
                + "Posicion y; " + snake.getPositionBody(0).getCol());*/
        
        
        
        if(snake.getPositionBody(snake.getSizeBody()-1).getRow() <= 0 ||
                snake.getPositionBody(snake.getSizeBody()-1).getRow() >43 ||
                snake.getPositionBody(snake.getSizeBody()-1).getCol() <= 0 ||
                snake.getPositionBody(snake.getSizeBody()-1).getCol() > 43) {
            stop();
        }
        
        
        
        /*for(int i = 0; i < snake.getSizeBody(); i++) {
            if(snake.getPositionBody(snake.getSizeBody()-1).getRow() == snake.getPositionBody(i).getRow() &&
                    snake.getPositionBody(snake.getSizeBody()-1).getCol() == snake.getPositionBody(i).getCol()) {
                if(i != snake.getSizeBody()-1) {
                    stop();
                }
            }
        }*/
        
            
        
        /*for(int i = 0; i < food.getSnake().getSizeBody(); i++) {
            if(snake.getxPositionNode() == food.getSnake()) {
                snake.otherNode(initialSizeNodes+1);
                food.getSnake().eliminarFood(i);
                i--;
            }
        }*/
        
        ticks++;
        
        if(ticks > 600) {
            snake.move();
            
            ticks = 0;
            
            //snake.addNode();
            snake.eliminaPosZero();
            
            /*if(snake.getSizeBody() > 5) {
            for(int i = 0; i < snake.getSizeBody(); i++) {
                if(snake.getPositionBody(snake.getSizeBody()-1).getRow() == snake.getPositionBody(i).getRow()
                        && snake.getPositionBody(snake.getSizeBody()-1).getCol() == snake.getPositionBody(i).getCol()) {
                    if(i != snake.getSizeBody()-1) {
                    System.out.println("COINCIDEEEEE");
                    stop();
                    }
                }
            }
        }*/
        }
    }
    
    public void start() {
        running = true;
        thread = new Thread(this,"Game Loop");
        thread.start();
    }
    
    public void stop() {
        running = false;
        try {
            System.out.println("Game Over");
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        while(running) {
            tick();
            repaint();
        }
    }
    
    private class Key extends KeyAdapter {
        
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
            if(key == KeyEvent.VK_RIGHT && 
                    Snake.getDirection() != Direction.LEFT) {
                Snake.setDirection(Direction.RIGHT);
            }
            if(key == KeyEvent.VK_LEFT && 
                    Snake.getDirection() != Direction.RIGHT) {
                Snake.setDirection(Direction.LEFT);
            }
            if(key == KeyEvent.VK_UP && 
                    Snake.getDirection() != Direction.DOWN) {
                Snake.setDirection(Direction.UP);
            }
            if(key == KeyEvent.VK_DOWN && 
                    Snake.getDirection() != Direction.UP) {
                Snake.setDirection(Direction.DOWN);
            }
        }
    }

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}


