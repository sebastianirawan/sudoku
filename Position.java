/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.Serializable;

/**
 *
 * @author CEN
 */
public class Position implements Serializable{
    private int posX;
    private int posY;
    
    Position (int x, int y){
        this.posX = x;
        this.posY = y;
    }
    
    int getPosX () {
        return this.posX;
    }
    
    int getPosY(){
        return this.posY;
    }
    
    void setPosX(int x){
        this.posX = x;
    }
    
    void setPosY(int y){
        this.posY = y;
    }
}
