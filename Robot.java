/*
 * robot adalah agen
 * kecerdasan (aksi) dari agen mestinya disimpan di kelas ini
 */
package sudoku;
/**
 *
 * Cecilia E. Nugraheni - Luciana Abednego
 */
public class Robot implements Runnable {
    private Thread t;
    String threadName;
    int type;
    Sudoku S;
    private Cell resCell;
  
  Robot (Sudoku S, int t) { //, Environment P, int model, Scheduler sch) {
      this.S = S;
      this.type = t;
      this.threadName = String.valueOf(t);
//      System.out.println("robot ke-"+t+" model: "+S.model);
  }
          
  public void start(){
     System.out.println("Starting " + threadName);
     if (t == null)
     {
        t = new Thread (this, threadName);
        t.start ();
     }     
  }
  
  Thread getThread() {
      return this.t;
  }
  
@Override
  public void run(){
      boolean res;
//      System.out.println("Running " +  this.type + " model "+S.getModel());
      try {
          while(true){
            if (S.getScheduler().getTurn() == this.type) {
//                System.out.println("run robot ke-"+this.type);
                res = this.Action();
                S.getScheduler().setHasTurn(type); // memberi tahu Scheduler kalau sudah selesai
                S.getScheduler().setResAction(type, res);
//                if (res) {
//                    S.toPublish(S.getEnvironment().Board);
//                    S.getScheduler().setFilledCell(resCell);
//                }
            }
            t.sleep(300); //200); //500);  
          }
      } 
      catch (InterruptedException e) {
         System.out.println("Thread " +  this.type + " interrupted.");
      }
  }
  
  // aksi dasar robot adalah putOn dan takeBack box dari/ke tumpukan
  // ke/dari papan sudoku
  boolean putOn (){
      Environment P = S.getEnvironment();
      
      if (S.getModel() == 1) {
          if (this.type != 1) {
//              System.out.println("agent "+this.type+" put on false");
              return false; 
          } else {
              if (P.FreeCellList.getLength() == 0) {
//                    System.out.println("free cell habis");
                    // mengapa backtrack dipaksa true?
                    // freecell habis bukannya tanda semua cell sudah berhasil diisi?
                    P.setBacktrack(false); //true); // force to backtrack
                    return false;
              } else {
               // sel kosong pertama
                    ListElement le = P.FreeCellList.getContent()[P.FreeCellList.getFirst()];
                    // cari box yang bisa diletakkan di sel tersebut
                    // range num: 1 - 9
                    int num = getValidNumber(le); // getValidNumber hanya untuk model 1
                    if (num == -1){ // tidak ditemukan angka yang tepat
//                        System.out.println("tidak ada angka yang tepat");
                        if (P.isBacktrack()){
//                            System.out.println("agent 1 meminta backtrack");
                      // jika backtrack sdh true, berarti harus mundur lagi
                      // box yang sudah ditempatkan di sell tersebut di-null-kan
                            le.getCell().setBox(null);
                        }
                        else {
//                            System.out.println("agent 1 meminta backtrack - belum backtract - set backtrack");
                            P.setBacktrack(true);
                        }
                        return false;
                    } else {
                  // kalau ada box yang bisa ditempatkan di sel tersebut
  //                      System.out.println("ada angka yang dapat diletakkan");
                        le.getCell().setBox(new Box(num));
                        P.FreeCellList.setFirst(P.FreeCellList.getFirst()+1);
                        P.FreeCellList.decLength();
                        int px = le.getCell().getPosition().getPosX();
                        int py = le.getCell().getPosition().getPosY();
                        P.Board[px][py].setBox(new Box(num, 1)); // angka 1 adalah jenis robotnya
                        resCell = P.Board[px][py];
                        resCell.printCell();
                        // test index-nya num
                        // tujuan baris ini apa? mengurangi banyaknya tumpukan box 
                        P.bStack[num-1][P.numbers[num-1]-1]=null;//-1] = null;
                        P.numbers[num-1]--;
                        S.toPublish(new State(P.Board, this.type, P.numbers));
                        if (P.isBacktrack()) {
                            P.setBacktrack(false);
                        }
                        return true;
                    }
                }
            }
        } else {
//            System.out.println("Ambil posisi kosong, agen "+this.type);
            ListElement le = getValidFreeCell(); // sekaligus dihapus dari freecelllist
            if (le == null) { return false; }
            else {
//                System.out.print("agen "+this.type+" dapat posisi valid "); 
//                System.out.println("["+le.getCell().getPosition().getPosX()+","+le.getCell().getPosition().getPosY()+"]");
                // box dipindah ke cell, di tumpukan kota dikosongkan
                P.Board[le.getCell().getPosition().getPosX()][le.getCell().getPosition().getPosY()].
                  setBox(new Box(this.type, this.type));
                resCell = P.Board[le.getCell().getPosition().getPosX()][le.getCell().getPosition().getPosY()];              
                P.bStack[this.type-1][P.numbers[this.type-1]] = null;
                // cek lagi untuk model 1, bagaimana setting type-nya
                P.numbers[this.type-1]--;
// ----------------------------------------
                S.toPublish(new State(P.Board, this.type, P.numbers));
//---------------------------------------------                
                return true;
          }
      }
  }
  
  boolean takeBack (){
      Environment P = S.getEnvironment();
      // aksi ini aktif jika terjadi gagal peletakan box
      // robot dua akan mengambil box terakhir yang diletakkan
      // mengembalikannya ke tumpukan yang sesuai
      // harus ada indikasi terjadi backtrack atau tidak 
      // karena robot 1 harus tahu bahwa sel yang menjadi kosong, tidak sesuai lagi untuk
      // box yang dikembalikan
//      System.out.println("takeback");
      if (S.getModel() == 1 && this.type == 2 && P.isBacktrack()) {
//          System.out.println("proses backtrack");
          int s = P.FreeCellList.getFirst();
          if (s == 0) { // kalau sudah 0 maka tdk bisa backtrack lagi
              P.setBacktrack(false);
              return false;
          } else {
          // apa yang harus dilakukan untuk persiapan backtrack?
          // kembalikan box terakhir yang diletakkan, sebelum first
          // kosongkan kotak di papan
          // kembalikan kotak ke tumpukan
//              System.out.println("terjadi backtrack");
              ListElement le = P.FreeCellList.getContent()[s-1];
              int px = le.getCell().getPosition().getPosX();
              int py = le.getCell().getPosition().getPosY();
              Box b = P.Board[px][py].getBox();
              P.FreeCellList.pushElement(b);
              P.Board[px][py].setBox(null);
              P.numbers[b.getValue()-1]++;
              P.bStack[b.getValue()-1][P.numbers[b.getValue()-1]] = new Box(b.getValue());
          //P.setBacktrack(true); //false); // jangan dulu dimatikan lampu backtrack
              S.toPublish(new State(P.Board, this.type, P.numbers));
              return true;
          }
      } else return false;
  }
  
  boolean Action(){
      return putOn () || takeBack ();
  }
  
  int getValidNumber(ListElement le){
      int s;
      Environment P = S.getEnvironment();
      
      if (le.getCell().isEmpty()) { 
          s = 0; 
      } else {
          s = le.getCell().getBox().getValue();              
      }
      
      for (int i = s+1; i<=P.getSize(); i++){
          if (!P.isInRow(le.getCell().getPosition().getPosX(), i) &&
              !P.isInColumn(le.getCell().getPosition().getPosY(), i) &&
              !P.isInSubblock(le.getCell().getPosition(), i)) { // jika bisa diletakkan di sell ini
              return i;
          }
      }
      return -1;
  }
  
  ListElement getValidFreeCell(){
// hanya untuk model 2 dan 3      
      Environment P = S.getEnvironment();
      if (P.numbers[this.type-1] > 0){
        ListElement [] freeCells = P.FreeCellList.getContent();
        int pointer = P.FreeCellList.getFirst(); // indeks elemen pertama list
        for (int counter = 0; counter < P.FreeCellList.getLength(); counter++) {
          ListElement le = freeCells[pointer];
//          System.out.println("posisi: ["+(le.getCell().getPosition().getPosX()+1)+","+(le.getCell().getPosition().getPosY()+1)+"]");  
          if (isValidPosition(le.getCell().getPosition())) {
              // jika ditemukan, hapus dari freeCell
              // kapan jumlah box-nya dikurangi atau numbers berubah?
              P.FreeCellList.getElement(pointer);
              return le;
          }
          pointer = le.getNext();
        } 
      }
      return null;
   }
  
   boolean isValidPosition(Position pos){
      Environment P = S.getEnvironment();
      switch(S.getModel()){
          case 1: return isValidPosition1(pos, this.type); 
          case 2: return isValidPosition2(pos); 
          case 3: return isValidPosition3(pos); 
          case 4: return isValidPosition4(pos); 
      }
      return false;
   }
  //  
  boolean isValidPosition1(Position p, int num){   
      Environment P = S.getEnvironment();
      return (P.Board[p.getPosX()][p.getPosY()].isEmpty() && // kosong
             !P.isInRow(p.getPosX(), num) && // tdk muncul di baris);
             !P.isInColumn(p.getPosY(), num) && // tdk muncul di kolom
             !P.isInSubblock(p, num)); // tidak muncul di subblock
  }
   // mencari posisi yang tepat untuk model 2
   boolean isValidPosition2 (Position p){
      // sebuah posisi disebut valid untuk model 2 jika 
      // angka tsb blm muncul pada baris dan kolom p
      // dan sudah muncul di dua baris dan dua kolom lain dalam satu block
      // perlu dijamin bukan block-nya? 
      // apakah sel kosong
      Environment P = S.getEnvironment(); 
      if (!P.Board[p.getPosX()][p.getPosY()].isEmpty()) { return false; }
      // cek apa baris belum ada angka type robot
      if (P.isInRow(p.getPosX(), this.type)) { return false; } 
      // cek apa kolom belum ada angka type robot
      if (P.isInColumn(p.getPosY(), this.type)) { return false; } 
      // cek sudah muncul di subblok belum
      if (P.isInSubblock(p, this.type)) {return false;}

      // cek apa di dua baris lain dlm subblok yang sama sudah ada type robot
      int s = p.getPosX()/3*3; //s adalah rown pertama dalam subblock
      for (int x = s; x < s+3; x++){
      // jika x tdk sama dengan barisnya maka
          if (x != p.getPosX() && !P.isInRow(x, this.type)) { return false; }
      }
      
      // cek apa di dua kolom lain dlm subblok yang sama sudah ada num
      s = p.getPosY()/3 * 3; // s adalah kolom pertama dalam subblok
      for (int x = s; x < s+3; x++){
      // jika x tdk sama dengan kolomnya maka
          if (x != p.getPosY() && !P.isInColumn(x, this.type)) { return false; }
      }
      
      return true;
   }
   
   boolean isValidPosition3 (Position p){
       // versi di makalah waset
       // sebuah posisi [x,y] disebut valid untuk angka n jika
       // [x,y] masih kosong,
       // n belum muncul di subblock dimana [x,y] berada
       // di dua baris lain di subblock yang sama: r1 dan r2 berlaku
       //      n sudah muncul di r1 atau [r1,y] sudah terisi angka lain dan
       //      n sudah muncul di r2 atau [r2,y] sudah terisi angka lain atau tidak kosong
     
       // di dua kolom lain di subblock yang sama: c1 dan c2 berlaku
       //      n sudah muncul di c1 atau [x, c1] sudah terisi angka lain dan
       //      n sudah muncul di c2 atau [x, c2] sudah terisi angka lain atau tidak kosong

       
       Environment P = S.getEnvironment(); 
      if (!P.Board[p.getPosX()][p.getPosY()].isEmpty()) {
          return false;
      }
      
      if (P.isInRow(p.getPosX(), type)) {
          return false;
      }
      
      if (P.isInColumn(p.getPosY(), type)) {
          return false;
      }
      
      if (P.isInSubblock(p, this.type)) { 
          return false; 
      }
      	  
     // cek apa di dua baris lain dlm subblok yang sama sudah ada type robot
      int x = p.getPosX()/3*3; //s adalah row pertama dalam subblock
      int r1, r2;
      
      int y = p.getPosY()/3*3; //s adalah row pertama dalam subblock
      int c1, c2;
    
      if (p.getPosX() == x) {r1 = x+1; r2=x+2;}
      else if (p.getPosX() == x+1) {r1 = x; r2=x+2;}
      else {r1 = x; r2=x+1;}

      if (p.getPosY() == y) {c1 = y+1; c2=y+2;}
      else if (p.getPosY() == y+1) {c1 = y; c2=y+2;}
      else {c1 = y; c2=y+1;}
      
//      System.out.println("posisi "+p.getPosX()+","+p.getPosY()+","+r1+","+r2+","+c1+","+c2);
      
      if (P.isInRow(r1, this.type) && P.isInRow(r2, this.type)) {
          // jika muncul di kedua baris lainnya, tinggal cek apakah muncul juga di dua kolom lainnya
//  System.out.println("dua baris");
          if ((P.isInColumn(c1, this.type) && P.isInColumn(c2, this.type)) ||
              (P.isInColumn(c1, this.type) && !P.Board[p.getPosX()][c2].isEmpty()) ||
              (P.isInColumn(c2, this.type) && !P.Board[p.getPosX()][c1].isEmpty()) ||
              (!P.Board[p.getPosX()][c1].isEmpty() && !P.Board[p.getPosX()][c2].isEmpty())) { return true; }
      }
      
      if (P.isInColumn(c1, this.type) && P.isInColumn(c2, this.type)) {
          // jika muncul di kedua kolom lainnya, tinggal cek apakah muncul juga di dua baris lainnya
//  System.out.println("dua kolom");
//  System.out.println(P.isInRow(r1, this.type)+" "+P.isInRow(r2, this.type)+" "+P.Board[r2][p.getPosY()].isEmpty()+" "+P.Board[r1][p.getPosY()].isEmpty());
          if ((P.isInRow(r1, this.type) && P.isInRow(r2, this.type)) ||
              (P.isInRow(r1, this.type) && !P.Board[r2][p.getPosY()].isEmpty()) ||
              (P.isInRow(r2, this.type) && !P.Board[r1][p.getPosY()].isEmpty()) ||
              (!P.Board[r1][p.getPosY()].isEmpty() &&!P.Board[r2][p.getPosY()].isEmpty())){ return true; }
      }
      // untuk model 5
      // pengujian terakhir untuk menjamin bahwa sel tersebut
      // tidak mungkin terisi oleh angka num, dilakukan dengan cara
      // melihat apakah angka tersebut sudah muncul di baris/kolom
      // pada subblok lain

      return false;
   }
   
   boolean isValidPosition4 (Position p){
      // sebuah posisi valid untuk model 4 jika
      // masih kosong, semua tetangga dalam satu subblok sudah terisi
      // angka yang lain atau dijamin akan terisi angka yang lain
     
      // mengapa masih diuji kosong atau tidak, kan sudah dicatat di free-cell??
      Environment P = S.getEnvironment(); 
      if (!P.Board[p.getPosX()][p.getPosY()].isEmpty()) {
          return false;
      }
      
      if (P.isInRow(p.getPosX(), type)) {
          return false;
      }
      
      if (P.isInColumn(p.getPosY(), type)) {
          return false;
      }
      
      if (P.isInSubblock(p, this.type)) { 
          return false; 
      }
      
      // pengujian terakhir untuk menjamin bahwa sel tersebut
      // tidak mungkin terisi oleh angka num, dilakukan dengan cara
      // melihat apakah angka tersebut sudah muncul di baris/kolom
      // pada subblok lain
	  
     // cek apa di dua baris lain dlm subblok yang sama sudah ada type robot
      int x = p.getPosX()/3*3; //s adalah row pertama dalam subblock
      int r1, r2;
      
      int y = p.getPosY()/3*3; //s adalah row pertama dalam subblock
      int c1, c2;
    
      if (p.getPosX() == x) {r1 = x+1; r2=x+2;}
      else if (p.getPosX() == x+1) {r1 = x; r2=x+2;}
      else {r1 = x; r2=x+1;}

      if (p.getPosY() == y) {c1 = y+1; c2=y+2;}
      else if (p.getPosY() == y+1) {c1 = y; c2=y+2;}
      else {c1 = y; c2=y+1;}
      
//      System.out.println("posisi "+p.getPosX()+","+p.getPosY()+","+r1+","+r2+","+c1+","+c2);
      
      if ((P.isInRow(r1, this.type)|| P.isRowFull(r1, y)) && (P.isInRow(r2, this.type)||P.isRowFull(r2, y))) {
          // jika muncul di kedua baris lainnya, tinggal cek apakah muncul juga di dua kolom lainnya
//  System.out.println("dua baris");
          if (((P.isInColumn(c1, this.type)|| P.isColumnFull(x, c1)) && (P.isInColumn(c2, this.type)||P.isColumnFull(x, c2))) ||
              ((P.isInColumn(c1, this.type)|| P.isColumnFull(x, c1)) && !P.Board[p.getPosX()][c2].isEmpty()) ||
              ((P.isInColumn(c2, this.type)|| P.isColumnFull(x, c2)) && !P.Board[p.getPosX()][c1].isEmpty()) ||
              (!P.Board[p.getPosX()][c1].isEmpty() && !P.Board[p.getPosX()][c2].isEmpty())) { return true; }
      }
      
      if ((P.isInColumn(c1, this.type)|| P.isColumnFull(x, c1)) && (P.isInColumn(c2, this.type)|| P.isColumnFull(x, c2))) {
          // jika muncul di kedua kolom lainnya, tinggal cek apakah muncul juga di dua baris lainnya
//  System.out.println("dua kolom");
//  System.out.println(P.isInRow(r1, this.type)+" "+P.isInRow(r2, this.type)+" "+P.Board[r2][p.getPosY()].isEmpty()+" "+P.Board[r1][p.getPosY()].isEmpty());
          if (((P.isInRow(r1, this.type)|| P.isRowFull(r1, y)) && (P.isInRow(r2, this.type)||P.isRowFull(r2, y))) ||
              ((P.isInRow(r1, this.type)|| P.isRowFull(r1, y)) && !P.Board[r2][p.getPosY()].isEmpty()) ||
              ((P.isInRow(r2, this.type)|| P.isRowFull(r2, y)) && !P.Board[r1][p.getPosY()].isEmpty()) ||
              (!P.Board[r1][p.getPosY()].isEmpty() &&!P.Board[r2][p.getPosY()].isEmpty())){ return true; }
      }
      return false;
   }
}
