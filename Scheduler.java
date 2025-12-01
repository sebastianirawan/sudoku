/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Heni
 */
public class Scheduler {
   private int turn;
   boolean [] hasTurn;
   boolean [] resAction;
   int [] boxes;
   Sudoku sudoku;
//   Cell c;
   
   Scheduler (Sudoku S) {
       turn = 1;
       hasTurn = new boolean [S.agentNum+1]; 
       resAction = new boolean [S.agentNum + 1];
       boxes = new int[S.agentNum+1];
       for (int i=1;i<= S.agentNum;i++) boxes[i] = S.Puzzle.numbers[i-1]; 
       sudoku = S;
   }
   
   public int getTurn(){
       return turn;
   }
   
   public void setTurn(int t) {
       turn = t;
   }
   
   public void nextTurn(){
       if (turn < sudoku.agentNum) {
           turn++;
       } else {turn = 1;}
   } 

   public void setHasTurn(int i) {
       hasTurn[i] = true;
   }
   
   public void setResAction(int i, boolean res) {
       resAction[i] = res;
   }
   
   boolean parAction() {
// main body of parSpecification
       boolean res =false;
       boolean resA;// = false;
       for (int i=1; i <= sudoku.agentNum; i++){
            hasTurn[i] = false;
    //       if ((sudoku.model == 1) || ((sudoku.model > 1) && (boxes[i] > 0))) {
           // apakah dia masih diperlukan, kalau tugas sudah selesai tidak perlu diaktifkan lagi
            this.setTurn(i);
            do {
            } while (!hasTurn[i]);
            resA = resAction[i];
            res = res || resA; // kalau true berarti agen masih bisa beraksi?   
        }
        return res; 
    }
}
