/*
 * Kelas Environment         
 * atribut: 1. Board - papan sudoku
 *          2. FreeCellList - cell kosong yang belum terisi box
 *          3. numbers - tumpukan box yang akan diletakkan ke papan sudoku
 *             (direpresentasikan sebagai array of integer, masing-masing
 *             elemen menyatakan banyaknya box yang ada di tumpukan)
 */
package sudokumodel;
import java.util.*;
import java.io.*;
import javax.swing.JComboBox;
/**
 * Cecilia E. Nugraheni - Luciana Abednego
 * 2012
 */
public class Environment {
    public static final int SIZE = 9;  
    int [] numbers = {SIZE,SIZE,SIZE,SIZE,SIZE,SIZE,SIZE,SIZE,SIZE};
    List FreeCellList; //cell kosong yang belum terisi box
    
    // papan permainan
    Cell [][] Board;
    
    // tumpukan
    Box [][] bStack; // tumpukan box yang belum diletakkan di papan
    
    boolean backtrack;
               
    Environment(){
         Board = new Cell[SIZE][SIZE];
         bStack = new Box[SIZE][SIZE]; 
         FreeCellList = new List (SIZE * SIZE);
         backtrack = false;
    }
    
    public boolean isValidCell(int i, int j) {
// Cek apakah cell[i][j] valid pada baris i
      if (!Board[i][j].isEmpty()) {       
         for (int column=0; column<SIZE; column++){
            if (column != j && !Board[i][column].isEmpty() &&
                    Board[i][column].getBox().getValue() == 
                    Board[i][j].getBox().getValue()){
                return false;
            }
        }
// Cek apakah cell[i][j] valid pada kolom j
        for (int row=0; row<SIZE; row++){
            if (row != i && !Board[row][j].isEmpty() &&
                Board[row][j].getBox().getValue() == 
                    Board[i][j].getBox().getValue()){
                return false;
            }
        }
// Cek apakah cell[i][j] valid pada kotak 3x3
        for (int row=(i/3)*3; row<(i/3)*3+3; row++){
            for (int col=(j/3)*3; col<(j/3)*3+3; col++){
                if (row != i && col != j && !Board[row][col].isEmpty() &&
                    Board[row][col].getBox().getValue() == 
                        Board[i][j].getBox().getValue()){
                    return false;
                }
            }
        }
      }
      return true; // Nilai pada cell[i][j] valid
    } 
    
    // untuk menguji apakah puzzle valid, tidak ada yang melanggar constraint
    public boolean isValidPuzzle() {
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                if (!Board[i][j].isEmpty() && !isValidCell(i,j)){
                    return false;
                }
            }
        }
        return true; 
    }
    
    /** Baca Sudoku puzzle dari keyboard */
    public boolean createAPuzzle() {
        // bagaimana dengan penomoran box? sama dengan penomoran cell (board)
        // atau tidak 
        // apa gunanya box punya nomor lokasi?
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a Sudoku puzzle:");
        int x;
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                this.Board[i][j] = new Cell(i,j);
                x = input.nextInt();
                // jika x tidak sama dengan 0, cell diisi dengan kotak
                if (isValidNumber(x)) {
                // masih bingung dengan atribut box!
                    this.Board[i][j].setBox(new Box(x));
                    this.Board[i][j].setFixed();
                    numbers[x-1]--;
                }
                else {
                    if (x == 0) {
                        FreeCellList.InsertLast(new Cell(new Position(i,j)));
                    }
                    else {
                        System.out.println("Wrong input");
                        return false;
                    }
                }
            }
        }
        // cek ada angka yang kemunculannya lebih dari 9 tidak
        // karena setiap muncul number berkurang 1, maka akan lebih dari 9
        // jika number < 0
        for (int i=0;i<SIZE;i++){
            if (numbers[i] < 0) {
                return false;
            }
        }
        return true;
    }
    
    void SetupBoxStacks (){
        // siapkan tumpukan box yang akan diletakkan ke papan sudoku
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j < numbers[i];j++) {
                bStack[i][j] = new Box(i+1);
            }
        }       
    }
    
    boolean isValidNumber(int x){
        return (x <= SIZE && x >= 1);
    }
    
//    boolean isEmptyStack(int i){
//        return (this.numbers[i] == 0);
//    }
    
    public boolean emptyStacks(){
        for (int i=0; i<SIZE; i++){
            if (this.numbers[i] > 0) { return false; }
        }
        return true;
    }
      
    boolean isInRow (int x, int id){
    // menguji apakah sudah ada block dengan nomor id di baris tertentu    
        for (int column=0; column<SIZE; column++){
            if ((!Board[x][column].isEmpty()) && 
                Board[x][column].getBox().getValue() == id){
                return true;
            }
        }
        return false;
    }
    
    boolean isRowFull(int x, int y){
        return (!Board[x][y].isEmpty() && !Board[x][y+1].isEmpty() && !Board[x][y+2].isEmpty());
    }

    boolean isColumnFull(int x, int y){
        return (!Board[x][y].isEmpty() && !Board[x+1][y].isEmpty() && !Board[x+2][y].isEmpty());
    }
    boolean isInColumn (int y, int id){
    // menguji apakah sudah ada block dengan nomor id di baris tertentu    
        for (int row=0; row<SIZE; row++){
            if ((!Board[row][y].isEmpty()) && 
                Board[row][y].getBox().getValue() == id){
                return true;
            }
        }
        return false;
    }
    
    boolean isInSubblock (Position p, int id){
        // Cek apakah cell[i][j] valid pada kotak 3x3
        int sr = p.getPosX()/3*3;
        int sc = p.getPosY()/3*3;
        for (int row = sr; row < sr+3; row++){
            for (int col = sc; col < sc+3; col++){
                if (!Board[row][col].isEmpty() &&
                    Board[row][col].getBox().getValue() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    ListElement getFreeCell(int i){
        // menghapus freeCell ke-i
        return this.FreeCellList.getElement(i);
    }
    
    boolean isSolved(){
        // untuk menguji apakah semua kotak berhasil diletakkan di papan Sudoku
        for(int i=0; i<SIZE; i++){
            if (this.numbers[i] > 0) {
                return false;
            }
            return true;
        }
/*            for(int j=0; j<SIZE; j++){
                if (bStack[i][j] != null) { return false; }
            }
        }
*/        return true;
    }
    
    int getSize() {
        return SIZE;
    }
    
    boolean readAPuzzle(String fileName){
        try{
            FileInputStream fstream = new FileInputStream(fileName); //"soal11.txt");//sudoku1.txt");
        // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
        //Read File Line By Line
            int x;
            for (int i=0; i < SIZE; i++) {
                for (int j=0; j < SIZE; j++) {
                    strLine = br.readLine();
                    x = char2int(strLine.trim().charAt(0));
                    if (isValidNumber(x)){
                        this.Board[i][j] = new Cell(i,j,x);
                        this.Board[i][j].setFixed();
                        numbers[x-1]--;
                    }
                    else {
                        if (x == 0){
                            FreeCellList.InsertElement(new Cell(i,j));
                            this.Board[i][j] = new Cell(i,j);
                        } else {
                            System.out.println("wrong input");
                            return false;
                        }
                    }
                }
            }
            in.close();
        } catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        
        for (int i=0; i<SIZE;i++){
            if (numbers[i] < 0) { return false; }
        }
        return true;
    }

    boolean saveAPuzzle(String fileName, JComboBox[] CB){
        File f = new File(fileName);
        FileWriter fr = null;
        BufferedWriter br = null;
        String str;
        try{
            fr = new FileWriter(f);
            br = new BufferedWriter(fr);
            for(int i=0; i<81; i++){
               str = CB[i].getSelectedItem().toString()+System.getProperty("line.separator");
               br.write(str);
            }
            br.close();
            fr.close();
        //Read File Line By Line
        } catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }
   
    boolean editAPuzzle(String fileName, JComboBox[] CB){
        try{
            FileInputStream fstream = new FileInputStream(fileName); 
        // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
        //Read File Line By Line
            int x;
            for (int i=0; i < 81; i++) {
                    strLine = br.readLine();
                    x = char2int(strLine.trim().charAt(0));
                    // harus dikirim ke sudoku lagi!
                    CB[i].setSelectedIndex(x);
                    CB[i].revalidate(); CB[i].repaint();
            }
            in.close();
        } catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        return true;
    }    
    
    int char2int(char c){
        switch (c) {
            case '0': return 0; 
            case '1': return 1; 
            case '2': return 2; 
            case '3': return 3; 
            case '4': return 4; 
            case '5': return 5; 
            case '6': return 6; 
            case '7': return 7; 
            case '8': return 8; 
            case '9': return 9;
            default: return -1;
        } 
    }
    
    void setBacktrack (boolean b){
        this.backtrack = b;
    }
    
    boolean isBacktrack(){
        return this.backtrack;
    }
    
    void PrintBoard(){
 /*       for (int i=0;i<9;i++){
            for (int j=0; j<9; j++) {
                 if (Board[i][j].getBox() != null){
                     System.out.print(Board[i][j].getBox().getValue()+ " ");
                 } else {
                     System.out.print("  ");                 }
            }
            System.out.println("");
        }*/
    //    PF.drawBoard(Board);
    } 
    
    void showBoard(){
        for (int i=0;i<9;i++){
            for (int j=0; j<9; j++) {
                 if (Board[i][j].getBox() != null){
//                     System.out.print(Board[i][j].getBox().getValue()+ " ");
                 } else {
                     System.out.print("  ");                 }
            }
        }
    }
    
}
