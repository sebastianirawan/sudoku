/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokumodel;

/**
 *
 * @author Apple's 1
 */
public class ListElement {
    Cell cell;
//    Position pos;
    int next;
        
/*    ListElement (Position p, int n){
        this.pos = p;
        this.next = n;
    }
*/    
    ListElement (Cell c, int n){
        this.cell = c;
        this.next = n;
    }
    
    Cell getCell(){
        return this.cell;
    }
    
  /*  Position getPosition(){
        return this.pos;
    }
    */
    void setCell(Cell c){
        this.cell = c;
    }
    
    int getNext (){
        return this.next;
    }   
    
    /*void setPosition (Position p){
        this.pos = p;
    }*/
    
    void setNext (int i){
        this.next = i;
    }
}
