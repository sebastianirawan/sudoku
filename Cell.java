/*
 * Kelas Cell digunakan untuk merepresentasikan grid dari papan sudoku
 * yang nantinya akan diisi dengan Box angka
 * rasanya atribut posX dan posY tidak diperlukan di sini???
 */
package sudoku;

/**
 *
 * Cecilia E. Nugraheni - Luciana Abednego
 */
public class Cell {
  private Box box;
  private boolean fixed;
//  int posX;
//  int posY;
  private Position pos;
  
  Cell () {
      this.box = null;
  }
  
  Cell (int x, int y) {
      this.pos = new Position(x,y);
      this.box = null;
  }
  
  Cell (int x, int y, int v) {
      this.pos = new Position(x,y);
      this.box = new Box(v);
  }

  Cell(Position p){
    this.box = null;
    this.fixed = false;
    this.pos = p;
  }  
  
  
  Cell(Position p, Box b){
    this.box = b;
    this.fixed = false;
    this.pos = p;
  }  
  
  /*Cell(int x, int y){
    this.box = null;
    this.fixed = false;
    this.posX = x;
    this.posY = y;
    this.pos = new Position(x,y);
  }  
  
  Cell(Box b, int x, int y){
    this.box = b;
    this.fixed = false;
    this.posX = x;
    this.posY = y;
    this.pos = new Position(x,y);
  }
  */
  Box getBox () {
      return box;
  }
  
  Position getPosition(){
      return this.pos;
  }
 
  boolean isFixed(){
      return (this.fixed);
  }
  
  boolean isEmpty(){
      return (this.box == null);
  }
  
  void setBox(Box b){
      this.box = b;
  }
  
  void setEmpty(){
      this.box = null;
  }
  
  void setFixed(){
      this.fixed = true;
  }
  
  void setPosition(int x, int y){
      this.pos.setPosX(x); 
      this.pos.setPosY(y); 
  }  
  
  void printCell(){
      System.out.println("cell : "+this.pos.getPosX()+" "+this.pos.getPosY()+" "+this.box.getValue());
  }
}
