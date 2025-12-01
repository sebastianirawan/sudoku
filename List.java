/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Apple's 1
 */
public class List {
    private int first; 
    private int last;
    private int length;
    private ListElement [] Content;
    
    List (int size){
        this.Content = new ListElement [size];
        this.first = -1;
        this.last = -1;
        this.length = 0;
    } 
    
    int getFirst() {
        return this.first;
    }
    
    void setFirst(int i){
        this.first = i;
    }

    int getLast(){
        return this.last;
    }
    
    void setLast(int i){
        this.last = i;
    }
    
    int getLength(){
        return this.length;
    }
    
    void decLength(){
        this.length--;
    }
    
    ListElement [] getContent(){
        return this.Content;
    }
    
    ListElement getFirstElement (){
        ListElement el;
        el = Content[first];
        this.first = el.getNext();
        this.length--;
        return el;
    } 
    
    ListElement getElement (int i){
        // menghapus elemen ke-i
        int j = this.first;
        if (j == i) {
            if (j == this.last) { // kasus list hanya berisi 1 elemen
                this.first = -1;
                this.last = -1;
                this.length = 0;
            }
            else {
                this.first = Content[j].getNext();
                this.length--;
            }
        }
        else {
            while (Content[j].getNext() != i){
                j = Content[j].getNext();
            } 
            if (this.last == i){
                Content[j].setNext(-1);
                this.last = j;
            }
            else {
                Content[j].setNext(Content[i].getNext());
            }
            this.length--;
        }
        return this.Content[i];
    }  
    
    void InsertLastElement (Cell c) {
        ListElement le = new ListElement(c, -1);
        this.Content[this.last].setNext(this.last+1); 
        this.last++;
        this.Content[this.last] = le;
    }
    
    void InsertFirstElement (Cell c){
//        if (this.first == -1) { // kosong
            this.first = 0;
            this.last = 0;
            this.Content[first] = new ListElement(c, -1);
  //      } 
    }
    
    // insert element ini hanya berlaku saat pengisian awal
    void InsertElement (Cell c){
        if (this.first == -1){
            InsertFirstElement(c);
        }
        else {
            InsertLastElement(c);
        }
        this.length++;
    }
    
    void InsertLast (Cell c){
        if (this.first == -1){ // kosong
            first = 0; 
            last = 0;
        } else { // sudah isi
            this.Content[last].setNext(last+1);
            this.last++;
        }
        this.Content[last] = new ListElement(c, -1);
        this.length++;
    }
    
    // untuk penyisipan sel pada saat proses backtrack
    boolean insertElement(ListElement le){
        int pos = findPosition(le);
        if (le.getNext() <= this.getFirst()) {
            // insertfirst
            le.setNext(this.getFirst());
            this.first = pos;
            this.length++;
            return true;
        }
        else {
            int cElmt = this.first;
            for (int i = 0; i < this.length; i++){
                if (pos > cElmt) {
                    le.setNext(this.Content[cElmt].getNext());
                    this.Content[cElmt].setNext(pos);
                    if (cElmt == this.last) {
                        this.last = pos;
                    }
                    this.length++;
                    return true;
                }
                cElmt = this.Content[cElmt].getNext();
            }
        }
        return false;
    }
    
    int findPosition(ListElement le){
        ListElement el; 
        for (int i=0; i < this.last; i++) {
            el = this.Content[i];
            if (el.getCell().getPosition().getPosX() ==
                    le.getCell().getPosition().getPosX() &&
                el.getCell().getPosition().getPosY() ==
                    le.getCell().getPosition().getPosY()) {
                return i;
            }
        }
        return -1;
    }
    
    void delFirst(){
        first = this.Content[first].getNext();
        this.length--;
    }
   
    void pushElement(Box b){
        this.first--;
        this.length++;
        this.Content[first].getCell().setBox(b);
    }
}
