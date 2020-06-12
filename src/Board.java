

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
    
    private Thread thread;
    private boolean running = false;
    private int xCoor = 10, yCoor = 10;
    private int initialSizeNodes = 5;
    
    //variabel que nos ayudará a controlar 
    //la velocidad con la que se moverá la serpiente
    private int ticks = 0;
    
    private Key key;
    
    
    
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
        //el metodo start servirá para iniciar el Thread y dentro
        //de este método cambiará la variable running a true y también esta 
        //invocará al metodo run() ya que esta contiene un bucle while que
        //mientras running sea "true" llamará a un método importante porque 
        //se encargará del movimiento del snake y de la aparición de los nodos
        //y manzanas
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
    
    //Método que comprueba si la cabeza de la serpiente ha chocacdo o
    //ya esta encima de la posicion de una manzana
    //si ya ha alcanzado a una manzana retornará un true y  sino false
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
        //----PINTA LAS LINEAS DE CUADROS DEL TABLERO----------
        g.clearRect(0, 0, numRows, numCols);
        g.setColor(Color.BLACK);
        for(int i = 0; i < numRows / 10; i++) {
            g.drawLine(i*10, 0, i*10, numCols);
        }
        for(int i = 0; i < numCols / 10; i++) {
            g.drawLine(0, i*10, numRows , i*10);
        }
        //------------------------------------
        
        //PINTA SNAKE
        snake.paint(g, snake.getxPositionNode(), snake.getyPositionNode());
        
        //PINTA FOOD
        food.paint(g, 10, 10);
    
    }
    
    public void tick() {
        System.out.println("Running...");
        
        //Condicion que solo al principio añade el primer nodo al 
        //Arraylist body
        if(snake.getSizeBody()== 0) {
            snake.addNode();
        }
        //condicion que crea una manzana
        if(snake.getSizeApples()==0) {
            food = new Food(snake);
        }
        
        //si la condicion se cumple se incrementará el atributo de Snake 
        //llamado initialNodes y con el método eliminarFood() lo que hacemos
        //es eliminar la manzana porque la  cabeza de la serpiente ya ha
        //pasado por encima
        if(colideFood()) {
            snake.incrementinitialNodes();
            score++;
            snake.eliminarFood(0);
        }
        
        //Condicion que comprueba si la serpiente no se  ha chocado
        //con las paredes
        if(snake.getPositionBody(snake.getSizeBody()-1).getRow() <= 0 ||
                snake.getPositionBody(snake.getSizeBody()-1).getRow() >43 ||
                snake.getPositionBody(snake.getSizeBody()-1).getCol() <= 0 ||
                snake.getPositionBody(snake.getSizeBody()-1).getCol() > 43) {
            //Y si ha chocado llamará al método stop() que pondrá la variable
            //running a "false" y entonces el bucle while del método run() al ver
            //que ya no se cumple su condición dejará de utilizar el metodo tick()
            //y el metodo repaint()
            stop();
        }
        
        ticks++;
        //cuando la variable ticks sea mayor que 600 
        //llamará al método move() de Snake y dependiendo de la clase Key y el
        //metodo keyPressed, se moverá la serpiente dependiendo del  valor
        //que tenga el atributo direction de la clase Snake
        //cuanto mas pequeña sea el número con el que se tiene que comparar
        //la variable ticks más rápido irá la serpiente porque no demorará 
        //tanto la variable ticks en superar esa cifra
        if(ticks > 800) {
            snake.move();
            
            ticks = 0;
            
            //Metodo importante también ya que en cuanto la cabeza de la 
            //serpiente se haya comido una manzana como el atributo de Snake
            //initialNodes habrá incrementado en 1 su valor con la condición que
            //lleva este método la cuál es:
            /*if(body.size() > initialNodes) {
                body.remove(0);
              }*/
            //ya que ha incrementado initialNodes nos permitirá crear un nodo 
            //más y el método remove(0); nos servirá para eliminar la cola 
            //para que el tamaño de la serpiente al moverse sea fijo hasta que
            //coma una manzana
            snake.eliminaPosZero();
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
            //metodo que llama al metodo paintComponent()
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


