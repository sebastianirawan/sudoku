/*
 * bagaimana akhirnya modelnya????
 * kalau mengikuti model TLA maka bentuknya parspec = ....
 * maka diperlukan sebuah kontroller untuk mengatur kapan agen dapat aktif
 * dibuat dengan mendefinisikan turn yang merupakan variabel global
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokumodel;
/**
 *
 * Cecilia E. Nugraheni - Luciana Abednego
 */
import javax.swing.SwingWorker;
import java.util.List;

class Sudoku extends SwingWorker<Void, State> {
//    public static final int SIZE = 9;     
    int model;    // model ke-
    int agentNum; // jumlah agen/robot
   // final long elapsedTimeMillis 
            
    Environment Puzzle; 
    Robot [] Agent; 
    Scheduler sch;
    PuzzleFrame PF;
    String fileName;    
    
    void toPublish(State s){
        System.out.println("publish "+s.toString());
        publish(s);
    }
        
    Scheduler getScheduler() {
        return sch;
    }
    
    Environment getEnvironment(){
        return Puzzle;
    }

    int getModel(){
        return this.model;
    }
    
    int getAgentNum(){
        return this.agentNum;
    }
    @Override
    public Void doInBackground() {       
        sch = new Scheduler(this);
        defineAgents();
        if (Puzzle.isValidPuzzle()){
            Puzzle.SetupBoxStacks();
            do {
            } while (sch.parAction());
            if (Puzzle.isSolved()) {
                System.out.println("ada solusi");//, ditemukan dalam waktu "+elapsedTimeMillis+ " ms");
            } else {
                System.out.println("tidak ada solusi");
            }
        } else {
            System.out.println("Not a valid puzzle");
        }      
        return null;
    }
    
    @Override
    public void done(){
        System.out.println(">> sudoku: done");
        PF.drawBoard(getEnvironment().Board);
        killAgents();
//        elapsedTimeMillis = System.currentTimeMillis() - startTime;
    }
    
    //@Override
    protected void process(List<State> chunks){
        for (State s : chunks) {
             this.PF.updateState(s);
         }
    }
    
    Sudoku (PuzzleFrame pf){
        this.model = pf.getModel();
        //setModel(pf.getModel()); //
        if (this.model > 1) agentNum = 9; else agentNum = 2;
        PF = pf;
        Puzzle = new Environment();
    }
    
    Sudoku (PuzzleFrame pf, String fN){
        this.model = pf.getModel();
        //setModel(pf.getModel());
        if (this.model > 1) agentNum = 9; else agentNum = 2;
        PF = pf;
        Puzzle = new Environment();
        this.fileName = fN;
        loadPuzzle(fN);
    }
  
    void setModel(int m){
        this.model = m;
        if (m > 1) agentNum = 9; else agentNum = 2;
    }
    // mendefinisikan jenis agen untuk masing-masing model
    void defineAgents() {
        Agent = new Robot [agentNum];        
        for (int i=0; i< agentNum; i++){
            Agent[i] = new Robot(this, i+1); //, Puzzle, model, this.sch);
            Agent[i].start();
        }
    }
    
    void killAgents(){
        for (int i=0; i< agentNum; i++){
            Agent[i].getThread().interrupt();
        }       
    }
    
    private void loadPuzzle(String fileName){
        Puzzle.readAPuzzle(fileName);
    }   
}