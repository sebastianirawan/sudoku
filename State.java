/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokumodel;

/**
 *
 * @author Heni
 */
public class State {
    Cell[][] board;
    int agentType;
    int [] numbers = new int [9];
    
    State (Cell[][] C, int aT, int[] nbrs){
        this.board = copyBoard(C);
        agentType = aT;
        System.arraycopy(nbrs, 0, numbers, 0, 9);
    }

    private Cell[][] copyBoard(Cell[][] C){
        Cell[][] temp = new Cell[9][9];
        
        for (int i=0; i<9;i++){
            for (int j=0; j<9; j++){
                temp[i][j] = new Cell(C[i][j].getPosition(), C[i][j].getBox()); 
            }
        }
        return temp;
    }
    
    Cell[][] getBoard(){
        return board;
    }
    
    int getAgentType(){
        return agentType;
    }
    
    int[] getNumbers(){
        return numbers;
    }
}
