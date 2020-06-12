
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victoralonso
 */
public class Util {
    
    public static void drawSquare(Graphics g, int row, int colo, int squareWidt, int squareHeight, Color color) {
        /*g.setColor(color);
        g.fillRect(row, colo, squareWidt, squareHeight);*/
        /*g.setColor(Color.BLACK);
        g.fillRect(row*squareWidt, colo*squareHeight, squareWidt, squareHeight);*/
        g.setColor(color);
        g.fillRect(row *squareWidt+2, colo*squareHeight+2, squareWidt-4, squareHeight-4);
    }
    
}
