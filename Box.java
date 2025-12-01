/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Apple's 1
 */
public class Box {
  private int Value;
  private int agentType;
//  private int posX;
//  private int posY;
  
  Box (int v){
      this.Value = v;
  }

  Box(int v, int x, int y){
    this.Value = v;
  //  this.posX = x;
  //  this.posY = y;
  }
  
  Box(int v, int a){
      this.Value = v;
      this.agentType = a;
  }

  void printBox(){
//    System.out.println ("("+this.posX+","+this.posY+","+this.Value+")");
    System.out.println ("("+this.Value+")");
  }

  void printValue (){
    System.out.println (this.Value);
  }

/*  void printPosition(){
    System.out.println ("("+this.posX+","+this.posY+")");
  }*/
  int getValue(){
      return this.Value;
  }
  
  void setValue(int x){
      this.Value = x;
  }

  int getAgentType(){
      return this.agentType;
  }
  void setAgentType (int i){
      this.agentType = i;
  }
}
