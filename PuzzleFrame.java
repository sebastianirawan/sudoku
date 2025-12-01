/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokumodel;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
/**
 *
 * @author Heni
 */
public class PuzzleFrame extends javax.swing.JFrame {

    /**
     * Creates new form PuzzleFrame
     */
    public PuzzleFrame() {
        initComponents();
        PP = new JButton [9][9];
        PP[0][0] = P11; PP[0][1] = P12; PP[0][2] = P13; PP[0][3] = P14; PP[0][4] = P15;
        PP[0][5] = P16; PP[0][6] = P17; PP[0][7] = P18; PP[0][8] = P19; 
        PP[1][0] = P21; PP[1][1] = P22; PP[1][2] = P23; PP[1][3] = P24; PP[1][4] = P25;
        PP[1][5] = P26; PP[1][6] = P27; PP[1][7] = P28; PP[1][8] = P29; 
        PP[2][0] = P31; PP[2][1] = P32; PP[2][2] = P33; PP[2][3] = P34; PP[2][4] = P35;
        PP[2][5] = P36; PP[2][6] = P37; PP[2][7] = P38; PP[2][8] = P39; 
        PP[3][0] = P41; PP[3][1] = P42; PP[3][2] = P43; PP[3][3] = P44; PP[3][4] = P45;
        PP[3][5] = P46; PP[3][6] = P47; PP[3][7] = P48; PP[3][8] = P49; 
        PP[4][0] = P51; PP[4][1] = P52; PP[4][2] = P53; PP[4][3] = P54; PP[4][4] = P55;
        PP[4][5] = P56; PP[4][6] = P57; PP[4][7] = P58; PP[4][8] = P59; 
        PP[5][0] = P61; PP[5][1] = P62; PP[5][2] = P63; PP[5][3] = P64; PP[5][4] = P65;
        PP[5][5] = P66; PP[5][6] = P67; PP[5][7] = P68; PP[5][8] = P69; 
        PP[6][0] = P71; PP[6][1] = P72; PP[6][2] = P73; PP[6][3] = P74; PP[6][4] = P75;
        PP[6][5] = P76; PP[6][6] = P77; PP[6][7] = P78; PP[6][8] = P79; 
        PP[7][0] = P81; PP[7][1] = P82; PP[7][2] = P83; PP[7][3] = P84; PP[7][4] = P85;
        PP[7][5] = P86; PP[7][6] = P87; PP[7][7] = P88; PP[7][8] = P89; 
        PP[8][0] = P91; PP[8][1] = P92; PP[8][2] = P93; PP[8][3] = P94; PP[8][4] = P95;
        PP[8][5] = P96; PP[8][6] = P97; PP[8][7] = P98; PP[8][8] = P99; 
        PuzzlePanel.setVisible(false);
        Model1Menu.setSelected(true);
        this.model = 1;
        
        AS = new JRadioButton[9];
        AS[0] = Agent1State; AS[1] = Agent2State; AS[2] = Agent3State;
        AS[3] = Agent4State; AS[4] = Agent5State; AS[5] = Agent6State;
        AS[6] = Agent7State; AS[7] = Agent8State; AS[8] = Agent9State;

        AB = new JTextField[9];
        AB[0] = Agent1Box; AB[1] = Agent2Box; AB[2] = Agent3Box; 
        AB[3] = Agent4Box; AB[4] = Agent5Box; AB[5] = Agent6Box; 
        AB[6] = Agent7Box; AB[7] = Agent8Box; AB[8] = Agent9Box; 
        
        CB = new JComboBox[81];
        AgentStatePanel.setVisible(false);
        CB[0] = C11; CB[1] = C12; CB[2] = C13; CB[3] = C14; CB[4] = C15; CB[5] = C16; CB[6] = C17; CB[7] = C18; CB[8] = C19;     
        CB[9] = C21; CB[10] = C22; CB[11] = C23; CB[12] = C24; CB[13] = C25; CB[14] = C26; CB[15] = C27; CB[16] = C28; CB[17] = C29;     
        CB[18] = C31; CB[19] = C32; CB[20] = C33; CB[21] = C34; CB[22] = C35; CB[23] = C36; CB[24] = C37; CB[25] = C38; CB[26] = C39;     
        CB[27] = C41; CB[28] = C42; CB[29] = C43; CB[30] = C44; CB[31] = C45; CB[32] = C46; CB[33] = C47; CB[34] = C48; CB[35] = C49;     
        CB[36] = C51; CB[37] = C52; CB[38] = C53; CB[39] = C54; CB[40] = C55; CB[41] = C56; CB[42] = C57; CB[43] = C58; CB[44] = C59;     
        CB[45] = C61; CB[46] = C62; CB[47] = C63; CB[48] = C64; CB[49] = C65; CB[50] = C66; CB[51] = C67; CB[52] = C68; CB[53] = C69;     
        CB[54] = C71; CB[55] = C72; CB[56] = C73; CB[57] = C74; CB[58] = C75; CB[59] = C76; CB[60] = C77; CB[61] = C78; CB[62] = C79;     
        CB[63] = C81; CB[64] = C82; CB[65] = C83; CB[66] = C84; CB[67] = C85; CB[68] = C86; CB[69] = C87; CB[70] = C88; CB[71] = C89;     
        CB[72] = C91; CB[73] = C92; CB[74] = C93; CB[75] = C94; CB[76] = C95; CB[77] = C96; CB[78] = C97; CB[79] = C98; CB[80] = C99;     
    }

/*    void updateBoardandStates(int x, int y, Box b){
        drawCell(x, y, b);
    //    showAgentStates(b.getAgentType());
    }
*/
    void drawBoard (Cell[][] box) {
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                drawCell(i,j, box[i][j].getBox(), box[i][j].isFixed());
            }
        }
        PuzzlePanel.revalidate();
        PuzzlePanel.repaint();
    }
    
    void drawCell (int x, int y, Box b, boolean fixed){
        if (b == null) PP[x][y].setText(" ");
        else {
            PP[x][y].setText(String.valueOf(b.getValue()));
            if (fixed) PP[x][y].setForeground(Color.red);
        }
        PP[x][y].validate();
        PP[x][y].repaint();
    }
    
    void drawCell (int x, int y, Box b){
        if (b == null) PP[x][y].setText(" ");
        else 
            PP[x][y].setText(String.valueOf(b.getValue()));
        PP[x][y].validate();
        PP[x][y].repaint();
    }
    
    void updateState(State s){
        for(int i=0;i<9;i++){
            for (int j=0;j<9;j++) {
                Box b = s.getBoard()[i][j].getBox();
                if (b != null) PP[i][j].setText(String.valueOf(s.getBoard()[i][j].getBox().getValue()));
                else PP[i][j].setText("");
                PP[i][j].revalidate();
                PP[i][j].repaint();
            }
        }
        this.PuzzlePanel.revalidate(); this.PuzzlePanel. repaint();
        
        for (int i=0;i<9;i++){
            AB[i].setText(String.valueOf(s.getNumbers()[i]));
            AB[i].revalidate(); AB[i].repaint();
        }
        
        for (int i=0;i<9;i++){
            AS[i].setSelected(false);
            AS[i].revalidate(); AS[i].repaint();            
        }
        AS[s.getAgentType()-1].setSelected(true);
        AS[s.getAgentType()-1].revalidate(); AS[s.getAgentType()-1].repaint();   
        
        this.AgentStatePanel.revalidate(); this.AgentStatePanel.repaint();
    } 
    
    void showAgentState(int i){
        AS[i].setSelected(true); 
        AS[i].revalidate(); AS[i].repaint();
        AB[i].setText(String.valueOf(S.getEnvironment().numbers[i]));
        AB[i].revalidate(); AB[i].repaint();       
    }
    
    void setAgentState(int i){
        AS[i].setSelected(true);
        AS[i].revalidate(); AS[i].repaint();
    }
    
    void setAgentBox(int i){
        AB[i].setText(String.valueOf(S.getEnvironment().numbers[i]));
        AB[i].revalidate(); AB[i].repaint();
    }
    
    void resetAgentBox(){
        for (int i=0; i<9;i++) {
            AB[i].setText("");
            AB[i].revalidate();
            AB[i].repaint();
        }
    }
    
    void resetBox(){
        for (int i=0; i<9; i++){
            for (int j=0;j<9;j++){
                PP[i][j].setForeground(Color.black);
            }
        }
    }
    
    void resetAgentState(){
        for (int i=0; i<9;i++) {
            AS[i].setSelected(false);
            AS[i].revalidate();
            AS[i].repaint();        
        }
    }
    
    void showInitialAgentStates(){
        resetAgentState();
        resetAgentBox();
        for (int i=0; i<9;i++) setAgentBox(i);
        this.AgentStatePanel.revalidate(); this.AgentStatePanel.repaint();
    }
    void showAgentStates(int aa){
        // menampilkan status agent yang terbaru
        System.out.println("show Agent State");
        
        resetAgentState();
        setAgentState(aa-1);
        setAgentBox(aa-1);
        
/*        switch (aa-1) {
            case 1: showAgentState(0); break;
            case 2: showAgentState(1); break;
            case 3: showAgentState(2); break;
            case 4: showAgentState(3); break;
            case 5: showAgentState(4); break;
            case 6: showAgentState(5); break;
            case 7: showAgentState(6); break;
            case 8: showAgentState(7); break;
            case 9: showAgentState(8); break;
        }
        
        for(int i = 0; i < 9; i++) {
            AS[i].revalidate(); AS[i].repaint();
        }*/
        this.AgentStatePanel.revalidate(); this.AgentStatePanel.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoadPuzzleFile = new javax.swing.JFileChooser();
        NotValidPuzzle = new javax.swing.JOptionPane();
        CreatePuzzleFrame = new javax.swing.JFrame();
        CreatePuzzlePanel = new javax.swing.JPanel();
        C11 = new javax.swing.JComboBox();
        C12 = new javax.swing.JComboBox();
        C13 = new javax.swing.JComboBox();
        C14 = new javax.swing.JComboBox();
        C15 = new javax.swing.JComboBox();
        C16 = new javax.swing.JComboBox();
        C17 = new javax.swing.JComboBox();
        C18 = new javax.swing.JComboBox();
        C19 = new javax.swing.JComboBox();
        C21 = new javax.swing.JComboBox();
        C22 = new javax.swing.JComboBox();
        C23 = new javax.swing.JComboBox();
        C24 = new javax.swing.JComboBox();
        C25 = new javax.swing.JComboBox();
        C26 = new javax.swing.JComboBox();
        C27 = new javax.swing.JComboBox();
        C28 = new javax.swing.JComboBox();
        C29 = new javax.swing.JComboBox();
        C31 = new javax.swing.JComboBox();
        C32 = new javax.swing.JComboBox();
        C33 = new javax.swing.JComboBox();
        C34 = new javax.swing.JComboBox();
        C35 = new javax.swing.JComboBox();
        C36 = new javax.swing.JComboBox();
        C38 = new javax.swing.JComboBox();
        C39 = new javax.swing.JComboBox();
        C37 = new javax.swing.JComboBox();
        C41 = new javax.swing.JComboBox();
        C42 = new javax.swing.JComboBox();
        C43 = new javax.swing.JComboBox();
        C44 = new javax.swing.JComboBox();
        C45 = new javax.swing.JComboBox();
        C46 = new javax.swing.JComboBox();
        C47 = new javax.swing.JComboBox();
        C48 = new javax.swing.JComboBox();
        C49 = new javax.swing.JComboBox();
        C51 = new javax.swing.JComboBox();
        C52 = new javax.swing.JComboBox();
        C53 = new javax.swing.JComboBox();
        C54 = new javax.swing.JComboBox();
        C55 = new javax.swing.JComboBox();
        C56 = new javax.swing.JComboBox();
        C57 = new javax.swing.JComboBox();
        C58 = new javax.swing.JComboBox();
        C59 = new javax.swing.JComboBox();
        C61 = new javax.swing.JComboBox();
        C62 = new javax.swing.JComboBox();
        C63 = new javax.swing.JComboBox();
        C64 = new javax.swing.JComboBox();
        C65 = new javax.swing.JComboBox();
        C66 = new javax.swing.JComboBox();
        C67 = new javax.swing.JComboBox();
        C68 = new javax.swing.JComboBox();
        C69 = new javax.swing.JComboBox();
        C71 = new javax.swing.JComboBox();
        C72 = new javax.swing.JComboBox();
        C73 = new javax.swing.JComboBox();
        C74 = new javax.swing.JComboBox();
        C75 = new javax.swing.JComboBox();
        C76 = new javax.swing.JComboBox();
        C77 = new javax.swing.JComboBox();
        C78 = new javax.swing.JComboBox();
        C79 = new javax.swing.JComboBox();
        C81 = new javax.swing.JComboBox();
        C82 = new javax.swing.JComboBox();
        C83 = new javax.swing.JComboBox();
        C84 = new javax.swing.JComboBox();
        C85 = new javax.swing.JComboBox();
        C86 = new javax.swing.JComboBox();
        C87 = new javax.swing.JComboBox();
        C88 = new javax.swing.JComboBox();
        C89 = new javax.swing.JComboBox();
        C94 = new javax.swing.JComboBox();
        C95 = new javax.swing.JComboBox();
        C96 = new javax.swing.JComboBox();
        C97 = new javax.swing.JComboBox();
        C91 = new javax.swing.JComboBox();
        C92 = new javax.swing.JComboBox();
        C93 = new javax.swing.JComboBox();
        C98 = new javax.swing.JComboBox();
        C99 = new javax.swing.JComboBox();
        ResetButton = new javax.swing.JButton();
        FinishButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        SavePuzzleFile = new javax.swing.JFileChooser();
        PuzzlePanel = new javax.swing.JPanel();
        P11 = new javax.swing.JButton();
        P12 = new javax.swing.JButton();
        P13 = new javax.swing.JButton();
        P14 = new javax.swing.JButton();
        P15 = new javax.swing.JButton();
        P16 = new javax.swing.JButton();
        P17 = new javax.swing.JButton();
        P18 = new javax.swing.JButton();
        P19 = new javax.swing.JButton();
        P21 = new javax.swing.JButton();
        P22 = new javax.swing.JButton();
        P23 = new javax.swing.JButton();
        P24 = new javax.swing.JButton();
        P25 = new javax.swing.JButton();
        P26 = new javax.swing.JButton();
        P27 = new javax.swing.JButton();
        P28 = new javax.swing.JButton();
        P29 = new javax.swing.JButton();
        P31 = new javax.swing.JButton();
        P32 = new javax.swing.JButton();
        P33 = new javax.swing.JButton();
        P34 = new javax.swing.JButton();
        P35 = new javax.swing.JButton();
        P36 = new javax.swing.JButton();
        P37 = new javax.swing.JButton();
        P38 = new javax.swing.JButton();
        P39 = new javax.swing.JButton();
        P41 = new javax.swing.JButton();
        P42 = new javax.swing.JButton();
        P43 = new javax.swing.JButton();
        P44 = new javax.swing.JButton();
        P45 = new javax.swing.JButton();
        P46 = new javax.swing.JButton();
        P47 = new javax.swing.JButton();
        P48 = new javax.swing.JButton();
        P49 = new javax.swing.JButton();
        P51 = new javax.swing.JButton();
        P52 = new javax.swing.JButton();
        P54 = new javax.swing.JButton();
        P53 = new javax.swing.JButton();
        P55 = new javax.swing.JButton();
        P56 = new javax.swing.JButton();
        P57 = new javax.swing.JButton();
        P58 = new javax.swing.JButton();
        P59 = new javax.swing.JButton();
        P61 = new javax.swing.JButton();
        P62 = new javax.swing.JButton();
        P63 = new javax.swing.JButton();
        P64 = new javax.swing.JButton();
        P65 = new javax.swing.JButton();
        P66 = new javax.swing.JButton();
        P67 = new javax.swing.JButton();
        P68 = new javax.swing.JButton();
        P69 = new javax.swing.JButton();
        P71 = new javax.swing.JButton();
        P72 = new javax.swing.JButton();
        P73 = new javax.swing.JButton();
        P74 = new javax.swing.JButton();
        P75 = new javax.swing.JButton();
        P76 = new javax.swing.JButton();
        P77 = new javax.swing.JButton();
        P78 = new javax.swing.JButton();
        P79 = new javax.swing.JButton();
        P81 = new javax.swing.JButton();
        P82 = new javax.swing.JButton();
        P83 = new javax.swing.JButton();
        P84 = new javax.swing.JButton();
        P85 = new javax.swing.JButton();
        P86 = new javax.swing.JButton();
        P87 = new javax.swing.JButton();
        P88 = new javax.swing.JButton();
        P89 = new javax.swing.JButton();
        P91 = new javax.swing.JButton();
        P92 = new javax.swing.JButton();
        P93 = new javax.swing.JButton();
        P94 = new javax.swing.JButton();
        P95 = new javax.swing.JButton();
        P96 = new javax.swing.JButton();
        P97 = new javax.swing.JButton();
        P98 = new javax.swing.JButton();
        P99 = new javax.swing.JButton();
        AgentStatePanel = new javax.swing.JPanel();
        Agent1State = new javax.swing.JRadioButton();
        Agent2State = new javax.swing.JRadioButton();
        Agent3State = new javax.swing.JRadioButton();
        Agent4State = new javax.swing.JRadioButton();
        Agent5State = new javax.swing.JRadioButton();
        Agent6State = new javax.swing.JRadioButton();
        Agent7State = new javax.swing.JRadioButton();
        Agent8State = new javax.swing.JRadioButton();
        Agent9State = new javax.swing.JRadioButton();
        Agent1Box = new javax.swing.JTextField();
        Agent2Box = new javax.swing.JTextField();
        Agent6Box = new javax.swing.JTextField();
        Agent7Box = new javax.swing.JTextField();
        Agent8Box = new javax.swing.JTextField();
        Agent9Box = new javax.swing.JTextField();
        Agent5Box = new javax.swing.JTextField();
        Agent3Box = new javax.swing.JTextField();
        Agent4Box = new javax.swing.JTextField();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        CreatePuzzleMenu = new javax.swing.JMenuItem();
        EditPuzzleMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        ExitMenu = new javax.swing.JMenuItem();
        PuzzleMenu = new javax.swing.JMenu();
        LoadPuzzleMenu = new javax.swing.JMenuItem();
        SolvePuzzleMenu = new javax.swing.JMenuItem();
        ClosePuzzleMenu = new javax.swing.JMenuItem();
        MASMenu = new javax.swing.JMenu();
        ModelMenu = new javax.swing.JMenu();
        Model1Menu = new javax.swing.JRadioButtonMenuItem();
        Model2Menu = new javax.swing.JRadioButtonMenuItem();
        Model3Menu = new javax.swing.JRadioButtonMenuItem();
        Model4Menu = new javax.swing.JRadioButtonMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        LoadPuzzleFile.setCurrentDirectory(new java.io.File("D:\\cheni\\Research\\Sudoku\\SudokuModel1\\Puzzles"));

        NotValidPuzzle.setMessage("Not a valid Sudoku puzzle!");

        CreatePuzzleFrame.setTitle("Create a puzzle");
        CreatePuzzleFrame.setMaximizedBounds(new java.awt.Rectangle(50, 50, 417, 440));
        CreatePuzzleFrame.setMinimumSize(new java.awt.Dimension(521, 395));
        CreatePuzzleFrame.setResizable(false);

        CreatePuzzlePanel.setBackground(new java.awt.Color(255, 255, 255));
        CreatePuzzlePanel.setForeground(new java.awt.Color(153, 153, 153));

        C11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C11.setMaximumSize(new java.awt.Dimension(50, 30));
        C11.setMinimumSize(new java.awt.Dimension(50, 30));
        C11.setPreferredSize(new java.awt.Dimension(50, 30));

        C12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C12.setMaximumSize(new java.awt.Dimension(50, 30));
        C12.setMinimumSize(new java.awt.Dimension(50, 30));
        C12.setPreferredSize(new java.awt.Dimension(50, 30));

        C13.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C13.setMaximumSize(new java.awt.Dimension(50, 30));
        C13.setMinimumSize(new java.awt.Dimension(50, 30));
        C13.setPreferredSize(new java.awt.Dimension(50, 30));

        C14.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C14.setMaximumSize(new java.awt.Dimension(50, 30));
        C14.setMinimumSize(new java.awt.Dimension(50, 30));
        C14.setPreferredSize(new java.awt.Dimension(50, 30));

        C15.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C15.setMaximumSize(new java.awt.Dimension(50, 30));
        C15.setMinimumSize(new java.awt.Dimension(50, 30));
        C15.setPreferredSize(new java.awt.Dimension(50, 30));
        C15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C15ActionPerformed(evt);
            }
        });

        C16.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C16.setMaximumSize(new java.awt.Dimension(50, 30));
        C16.setMinimumSize(new java.awt.Dimension(50, 30));
        C16.setPreferredSize(new java.awt.Dimension(50, 30));

        C17.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C17.setMaximumSize(new java.awt.Dimension(50, 30));
        C17.setMinimumSize(new java.awt.Dimension(50, 30));
        C17.setPreferredSize(new java.awt.Dimension(50, 30));

        C18.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C18.setMaximumSize(new java.awt.Dimension(50, 30));
        C18.setMinimumSize(new java.awt.Dimension(50, 30));
        C18.setPreferredSize(new java.awt.Dimension(50, 30));

        C19.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C19.setMaximumSize(new java.awt.Dimension(50, 30));
        C19.setMinimumSize(new java.awt.Dimension(50, 30));
        C19.setPreferredSize(new java.awt.Dimension(50, 30));

        C21.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C21.setMaximumSize(new java.awt.Dimension(50, 30));
        C21.setMinimumSize(new java.awt.Dimension(50, 30));
        C21.setPreferredSize(new java.awt.Dimension(50, 30));

        C22.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C22.setMaximumSize(new java.awt.Dimension(50, 30));
        C22.setMinimumSize(new java.awt.Dimension(50, 30));
        C22.setPreferredSize(new java.awt.Dimension(50, 30));

        C23.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C23.setMaximumSize(new java.awt.Dimension(50, 30));
        C23.setMinimumSize(new java.awt.Dimension(50, 30));
        C23.setPreferredSize(new java.awt.Dimension(50, 30));

        C24.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C24.setMaximumSize(new java.awt.Dimension(50, 30));
        C24.setMinimumSize(new java.awt.Dimension(50, 30));
        C24.setPreferredSize(new java.awt.Dimension(50, 30));

        C25.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C25.setMaximumSize(new java.awt.Dimension(50, 30));
        C25.setMinimumSize(new java.awt.Dimension(50, 30));
        C25.setPreferredSize(new java.awt.Dimension(50, 30));
        C25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C25ActionPerformed(evt);
            }
        });

        C26.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C26.setMaximumSize(new java.awt.Dimension(50, 30));
        C26.setMinimumSize(new java.awt.Dimension(50, 30));
        C26.setPreferredSize(new java.awt.Dimension(50, 30));

        C27.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C27.setMaximumSize(new java.awt.Dimension(50, 30));
        C27.setMinimumSize(new java.awt.Dimension(50, 30));
        C27.setPreferredSize(new java.awt.Dimension(50, 30));

        C28.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C28.setMaximumSize(new java.awt.Dimension(50, 30));
        C28.setMinimumSize(new java.awt.Dimension(50, 30));
        C28.setPreferredSize(new java.awt.Dimension(50, 30));

        C29.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C29.setMaximumSize(new java.awt.Dimension(50, 30));
        C29.setMinimumSize(new java.awt.Dimension(50, 30));
        C29.setPreferredSize(new java.awt.Dimension(50, 30));

        C31.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C31.setMaximumSize(new java.awt.Dimension(50, 30));
        C31.setMinimumSize(new java.awt.Dimension(50, 30));
        C31.setPreferredSize(new java.awt.Dimension(50, 30));

        C32.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C32.setMaximumSize(new java.awt.Dimension(50, 30));
        C32.setMinimumSize(new java.awt.Dimension(50, 30));
        C32.setPreferredSize(new java.awt.Dimension(50, 30));

        C33.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C33.setMaximumSize(new java.awt.Dimension(50, 30));
        C33.setMinimumSize(new java.awt.Dimension(50, 30));
        C33.setPreferredSize(new java.awt.Dimension(50, 30));

        C34.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C34.setMaximumSize(new java.awt.Dimension(50, 30));
        C34.setMinimumSize(new java.awt.Dimension(50, 30));
        C34.setPreferredSize(new java.awt.Dimension(50, 30));

        C35.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C35.setMaximumSize(new java.awt.Dimension(50, 30));
        C35.setMinimumSize(new java.awt.Dimension(50, 30));
        C35.setPreferredSize(new java.awt.Dimension(50, 30));
        C35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C35ActionPerformed(evt);
            }
        });

        C36.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C36.setMaximumSize(new java.awt.Dimension(50, 30));
        C36.setMinimumSize(new java.awt.Dimension(50, 30));
        C36.setPreferredSize(new java.awt.Dimension(50, 30));

        C38.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C38.setMaximumSize(new java.awt.Dimension(50, 30));
        C38.setMinimumSize(new java.awt.Dimension(50, 30));
        C38.setPreferredSize(new java.awt.Dimension(50, 30));

        C39.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C39.setMaximumSize(new java.awt.Dimension(50, 30));
        C39.setMinimumSize(new java.awt.Dimension(50, 30));
        C39.setPreferredSize(new java.awt.Dimension(50, 30));

        C37.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C37.setMaximumSize(new java.awt.Dimension(50, 30));
        C37.setMinimumSize(new java.awt.Dimension(50, 30));
        C37.setPreferredSize(new java.awt.Dimension(50, 30));

        C41.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C41.setMaximumSize(new java.awt.Dimension(50, 30));
        C41.setMinimumSize(new java.awt.Dimension(50, 30));
        C41.setPreferredSize(new java.awt.Dimension(50, 30));

        C42.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C42.setMaximumSize(new java.awt.Dimension(50, 30));
        C42.setMinimumSize(new java.awt.Dimension(50, 30));
        C42.setPreferredSize(new java.awt.Dimension(50, 30));

        C43.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C43.setMaximumSize(new java.awt.Dimension(50, 30));
        C43.setMinimumSize(new java.awt.Dimension(50, 30));
        C43.setPreferredSize(new java.awt.Dimension(50, 30));

        C44.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C44.setMaximumSize(new java.awt.Dimension(50, 30));
        C44.setMinimumSize(new java.awt.Dimension(50, 30));
        C44.setPreferredSize(new java.awt.Dimension(50, 30));

        C45.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C45.setMaximumSize(new java.awt.Dimension(50, 30));
        C45.setMinimumSize(new java.awt.Dimension(50, 30));
        C45.setPreferredSize(new java.awt.Dimension(50, 30));
        C45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C45ActionPerformed(evt);
            }
        });

        C46.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C46.setMaximumSize(new java.awt.Dimension(50, 30));
        C46.setMinimumSize(new java.awt.Dimension(50, 30));
        C46.setPreferredSize(new java.awt.Dimension(50, 30));

        C47.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C47.setMaximumSize(new java.awt.Dimension(50, 30));
        C47.setMinimumSize(new java.awt.Dimension(50, 30));
        C47.setPreferredSize(new java.awt.Dimension(50, 30));

        C48.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C48.setMaximumSize(new java.awt.Dimension(50, 30));
        C48.setMinimumSize(new java.awt.Dimension(50, 30));
        C48.setPreferredSize(new java.awt.Dimension(50, 30));

        C49.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C49.setMaximumSize(new java.awt.Dimension(50, 30));
        C49.setMinimumSize(new java.awt.Dimension(50, 30));
        C49.setPreferredSize(new java.awt.Dimension(50, 30));

        C51.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C51.setMaximumSize(new java.awt.Dimension(50, 30));
        C51.setMinimumSize(new java.awt.Dimension(50, 30));
        C51.setPreferredSize(new java.awt.Dimension(50, 30));

        C52.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C52.setMaximumSize(new java.awt.Dimension(50, 30));
        C52.setMinimumSize(new java.awt.Dimension(50, 30));
        C52.setPreferredSize(new java.awt.Dimension(50, 30));

        C53.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C53.setMaximumSize(new java.awt.Dimension(50, 30));
        C53.setMinimumSize(new java.awt.Dimension(50, 30));
        C53.setPreferredSize(new java.awt.Dimension(50, 30));

        C54.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C54.setMaximumSize(new java.awt.Dimension(50, 30));
        C54.setMinimumSize(new java.awt.Dimension(50, 30));
        C54.setPreferredSize(new java.awt.Dimension(50, 30));

        C55.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C55.setMaximumSize(new java.awt.Dimension(50, 30));
        C55.setMinimumSize(new java.awt.Dimension(50, 30));
        C55.setPreferredSize(new java.awt.Dimension(50, 30));
        C55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C55ActionPerformed(evt);
            }
        });

        C56.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C56.setMaximumSize(new java.awt.Dimension(50, 30));
        C56.setMinimumSize(new java.awt.Dimension(50, 30));
        C56.setPreferredSize(new java.awt.Dimension(50, 30));

        C57.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C57.setMaximumSize(new java.awt.Dimension(50, 30));
        C57.setMinimumSize(new java.awt.Dimension(50, 30));
        C57.setPreferredSize(new java.awt.Dimension(50, 30));

        C58.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C58.setMaximumSize(new java.awt.Dimension(50, 30));
        C58.setMinimumSize(new java.awt.Dimension(50, 30));
        C58.setPreferredSize(new java.awt.Dimension(50, 30));

        C59.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C59.setMaximumSize(new java.awt.Dimension(50, 30));
        C59.setMinimumSize(new java.awt.Dimension(50, 30));
        C59.setPreferredSize(new java.awt.Dimension(50, 30));

        C61.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C61.setMaximumSize(new java.awt.Dimension(50, 30));
        C61.setMinimumSize(new java.awt.Dimension(50, 30));
        C61.setPreferredSize(new java.awt.Dimension(50, 30));

        C62.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C62.setMaximumSize(new java.awt.Dimension(50, 30));
        C62.setMinimumSize(new java.awt.Dimension(50, 30));
        C62.setPreferredSize(new java.awt.Dimension(50, 30));

        C63.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C63.setMaximumSize(new java.awt.Dimension(50, 30));
        C63.setMinimumSize(new java.awt.Dimension(50, 30));
        C63.setPreferredSize(new java.awt.Dimension(50, 30));

        C64.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C64.setMaximumSize(new java.awt.Dimension(50, 30));
        C64.setMinimumSize(new java.awt.Dimension(50, 30));
        C64.setPreferredSize(new java.awt.Dimension(50, 30));

        C65.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C65.setMaximumSize(new java.awt.Dimension(50, 30));
        C65.setMinimumSize(new java.awt.Dimension(50, 30));
        C65.setPreferredSize(new java.awt.Dimension(50, 30));
        C65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C65ActionPerformed(evt);
            }
        });

        C66.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C66.setMaximumSize(new java.awt.Dimension(50, 30));
        C66.setMinimumSize(new java.awt.Dimension(50, 30));
        C66.setPreferredSize(new java.awt.Dimension(50, 30));

        C67.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C67.setMaximumSize(new java.awt.Dimension(50, 30));
        C67.setMinimumSize(new java.awt.Dimension(50, 30));
        C67.setPreferredSize(new java.awt.Dimension(50, 30));

        C68.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C68.setMaximumSize(new java.awt.Dimension(50, 30));
        C68.setMinimumSize(new java.awt.Dimension(50, 30));
        C68.setPreferredSize(new java.awt.Dimension(50, 30));

        C69.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C69.setMaximumSize(new java.awt.Dimension(50, 30));
        C69.setMinimumSize(new java.awt.Dimension(50, 30));
        C69.setPreferredSize(new java.awt.Dimension(50, 30));

        C71.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C71.setMaximumSize(new java.awt.Dimension(50, 30));
        C71.setMinimumSize(new java.awt.Dimension(50, 30));
        C71.setPreferredSize(new java.awt.Dimension(50, 30));

        C72.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C72.setMaximumSize(new java.awt.Dimension(50, 30));
        C72.setMinimumSize(new java.awt.Dimension(50, 30));
        C72.setPreferredSize(new java.awt.Dimension(50, 30));

        C73.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C73.setMaximumSize(new java.awt.Dimension(50, 30));
        C73.setMinimumSize(new java.awt.Dimension(50, 30));
        C73.setPreferredSize(new java.awt.Dimension(50, 30));

        C74.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C74.setMaximumSize(new java.awt.Dimension(50, 30));
        C74.setMinimumSize(new java.awt.Dimension(50, 30));
        C74.setPreferredSize(new java.awt.Dimension(50, 30));

        C75.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C75.setMaximumSize(new java.awt.Dimension(50, 30));
        C75.setMinimumSize(new java.awt.Dimension(50, 30));
        C75.setPreferredSize(new java.awt.Dimension(50, 30));
        C75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C75ActionPerformed(evt);
            }
        });

        C76.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C76.setMaximumSize(new java.awt.Dimension(50, 30));
        C76.setMinimumSize(new java.awt.Dimension(50, 30));
        C76.setPreferredSize(new java.awt.Dimension(50, 30));

        C77.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C77.setMaximumSize(new java.awt.Dimension(50, 30));
        C77.setMinimumSize(new java.awt.Dimension(50, 30));
        C77.setPreferredSize(new java.awt.Dimension(50, 30));

        C78.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C78.setMaximumSize(new java.awt.Dimension(50, 30));
        C78.setMinimumSize(new java.awt.Dimension(50, 30));
        C78.setPreferredSize(new java.awt.Dimension(50, 30));

        C79.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C79.setMaximumSize(new java.awt.Dimension(50, 30));
        C79.setMinimumSize(new java.awt.Dimension(50, 30));
        C79.setPreferredSize(new java.awt.Dimension(50, 30));

        C81.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C81.setMaximumSize(new java.awt.Dimension(50, 30));
        C81.setMinimumSize(new java.awt.Dimension(50, 30));
        C81.setPreferredSize(new java.awt.Dimension(50, 30));

        C82.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C82.setMaximumSize(new java.awt.Dimension(50, 30));
        C82.setMinimumSize(new java.awt.Dimension(50, 30));
        C82.setPreferredSize(new java.awt.Dimension(50, 30));

        C83.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C83.setMaximumSize(new java.awt.Dimension(50, 30));
        C83.setMinimumSize(new java.awt.Dimension(50, 30));
        C83.setPreferredSize(new java.awt.Dimension(50, 30));

        C84.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C84.setMaximumSize(new java.awt.Dimension(50, 30));
        C84.setMinimumSize(new java.awt.Dimension(50, 30));
        C84.setPreferredSize(new java.awt.Dimension(50, 30));

        C85.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C85.setMaximumSize(new java.awt.Dimension(50, 30));
        C85.setMinimumSize(new java.awt.Dimension(50, 30));
        C85.setPreferredSize(new java.awt.Dimension(50, 30));
        C85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C85ActionPerformed(evt);
            }
        });

        C86.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C86.setMaximumSize(new java.awt.Dimension(50, 30));
        C86.setMinimumSize(new java.awt.Dimension(50, 30));
        C86.setPreferredSize(new java.awt.Dimension(50, 30));

        C87.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C87.setMaximumSize(new java.awt.Dimension(50, 30));
        C87.setMinimumSize(new java.awt.Dimension(50, 30));
        C87.setPreferredSize(new java.awt.Dimension(50, 30));

        C88.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C88.setMaximumSize(new java.awt.Dimension(50, 30));
        C88.setMinimumSize(new java.awt.Dimension(50, 30));
        C88.setPreferredSize(new java.awt.Dimension(50, 30));

        C89.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C89.setMaximumSize(new java.awt.Dimension(50, 30));
        C89.setMinimumSize(new java.awt.Dimension(50, 30));
        C89.setPreferredSize(new java.awt.Dimension(50, 30));

        C94.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C94.setMaximumSize(new java.awt.Dimension(50, 30));
        C94.setMinimumSize(new java.awt.Dimension(50, 30));
        C94.setPreferredSize(new java.awt.Dimension(50, 30));

        C95.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C95.setMaximumSize(new java.awt.Dimension(50, 30));
        C95.setMinimumSize(new java.awt.Dimension(50, 30));
        C95.setPreferredSize(new java.awt.Dimension(50, 30));
        C95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C95ActionPerformed(evt);
            }
        });

        C96.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C96.setMaximumSize(new java.awt.Dimension(50, 30));
        C96.setMinimumSize(new java.awt.Dimension(50, 30));
        C96.setPreferredSize(new java.awt.Dimension(50, 30));

        C97.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C97.setMaximumSize(new java.awt.Dimension(50, 30));
        C97.setMinimumSize(new java.awt.Dimension(50, 30));
        C97.setPreferredSize(new java.awt.Dimension(50, 30));

        C91.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C91.setMaximumSize(new java.awt.Dimension(50, 30));
        C91.setMinimumSize(new java.awt.Dimension(50, 30));
        C91.setPreferredSize(new java.awt.Dimension(50, 30));

        C92.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C92.setMaximumSize(new java.awt.Dimension(50, 30));
        C92.setMinimumSize(new java.awt.Dimension(50, 30));
        C92.setPreferredSize(new java.awt.Dimension(50, 30));

        C93.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C93.setMaximumSize(new java.awt.Dimension(50, 30));
        C93.setMinimumSize(new java.awt.Dimension(50, 30));
        C93.setPreferredSize(new java.awt.Dimension(50, 30));

        C98.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C98.setMaximumSize(new java.awt.Dimension(50, 30));
        C98.setMinimumSize(new java.awt.Dimension(50, 30));
        C98.setPreferredSize(new java.awt.Dimension(50, 30));

        C99.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        C99.setMaximumSize(new java.awt.Dimension(50, 30));
        C99.setMinimumSize(new java.awt.Dimension(50, 30));
        C99.setPreferredSize(new java.awt.Dimension(50, 30));

        javax.swing.GroupLayout CreatePuzzlePanelLayout = new javax.swing.GroupLayout(CreatePuzzlePanel);
        CreatePuzzlePanel.setLayout(CreatePuzzlePanelLayout);
        CreatePuzzlePanelLayout.setHorizontalGroup(
            CreatePuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatePuzzlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CreatePuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreatePuzzlePanelLayout.createSequentialGroup()
                        .addComponent(C11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreatePuzzlePanelLayout.createSequentialGroup()
                        .addComponent(C21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreatePuzzlePanelLayout.createSequentialGroup()
                        .addComponent(C31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C35, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C37, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreatePuzzlePanelLayout.createSequentialGroup()
                        .addComponent(C41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C43, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C45, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C46, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C47, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C48, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C49, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreatePuzzlePanelLayout.createSequentialGroup()
                        .addComponent(C51, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C52, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C53, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C54, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C55, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C56, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C57, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C58, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C59, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreatePuzzlePanelLayout.createSequentialGroup()
                        .addComponent(C61, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C62, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C63, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C64, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C65, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C66, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C67, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C68, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C69, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreatePuzzlePanelLayout.createSequentialGroup()
                        .addComponent(C71, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C72, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C73, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C74, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C75, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C76, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C77, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C78, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C79, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreatePuzzlePanelLayout.createSequentialGroup()
                        .addComponent(C81, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C82, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C83, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C84, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C85, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C86, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C87, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C88, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C89, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreatePuzzlePanelLayout.createSequentialGroup()
                        .addComponent(C91, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C92, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C93, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C94, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C95, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C96, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C97, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C98, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(C99, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CreatePuzzlePanelLayout.setVerticalGroup(
            CreatePuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatePuzzlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CreatePuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(CreatePuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(CreatePuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CreatePuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C46, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(CreatePuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C55, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C56, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C58, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(CreatePuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C61, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C62, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C63, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C64, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C65, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C66, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C67, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C68, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C69, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CreatePuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C71, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C72, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C73, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C74, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C75, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C76, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C77, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C78, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C79, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(CreatePuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C81, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C82, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C83, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C84, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C85, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C86, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C87, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C88, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C89, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(CreatePuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C91, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C92, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C93, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C94, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C95, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C96, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C97, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C98, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C99, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        FinishButton.setText("Finish");
        FinishButton.setMaximumSize(new java.awt.Dimension(63, 23));
        FinishButton.setMinimumSize(new java.awt.Dimension(63, 23));
        FinishButton.setPreferredSize(new java.awt.Dimension(63, 23));
        FinishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishButtonActionPerformed(evt);
            }
        });

        SaveButton.setText("Save");
        SaveButton.setMaximumSize(new java.awt.Dimension(63, 23));
        SaveButton.setMinimumSize(new java.awt.Dimension(63, 23));
        SaveButton.setPreferredSize(new java.awt.Dimension(63, 23));
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CreatePuzzleFrameLayout = new javax.swing.GroupLayout(CreatePuzzleFrame.getContentPane());
        CreatePuzzleFrame.getContentPane().setLayout(CreatePuzzleFrameLayout);
        CreatePuzzleFrameLayout.setHorizontalGroup(
            CreatePuzzleFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatePuzzleFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CreatePuzzleFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreatePuzzleFrameLayout.createSequentialGroup()
                        .addComponent(CreatePuzzlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreatePuzzleFrameLayout.createSequentialGroup()
                        .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FinishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))))
        );
        CreatePuzzleFrameLayout.setVerticalGroup(
            CreatePuzzleFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatePuzzleFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CreatePuzzlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CreatePuzzleFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FinishButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        SavePuzzleFile.setCurrentDirectory(new java.io.File("D:\\CEN\\Research\\Sudoku\\SudokuModel1\\Puzzles"));
        SavePuzzleFile.setDialogTitle("Save As");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MAS based Sudoku Solver ");
        setName("FPuzzle"); // NOI18N
        setResizable(false);

        PuzzlePanel.setBackground(new java.awt.Color(153, 153, 153));

        P11.setBackground(new java.awt.Color(255, 255, 255));
        P11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P11.setText("1");
        P11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P11.setBorderPainted(false);
        P11.setFocusPainted(false);
        P11.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P11.setMaximumSize(new java.awt.Dimension(40, 40));
        P11.setMinimumSize(new java.awt.Dimension(40, 40));
        P11.setPreferredSize(new java.awt.Dimension(40, 40));

        P12.setBackground(new java.awt.Color(255, 255, 255));
        P12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P12.setText("2");
        P12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P12.setBorderPainted(false);
        P12.setFocusPainted(false);
        P12.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P12.setMaximumSize(new java.awt.Dimension(40, 40));
        P12.setMinimumSize(new java.awt.Dimension(40, 40));
        P12.setPreferredSize(new java.awt.Dimension(40, 40));

        P13.setBackground(new java.awt.Color(255, 255, 255));
        P13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P13.setText("3");
        P13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P13.setBorderPainted(false);
        P13.setFocusPainted(false);
        P13.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P13.setMaximumSize(new java.awt.Dimension(40, 40));
        P13.setMinimumSize(new java.awt.Dimension(40, 40));
        P13.setPreferredSize(new java.awt.Dimension(40, 40));

        P14.setBackground(new java.awt.Color(255, 255, 255));
        P14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P14.setText("4");
        P14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P14.setBorderPainted(false);
        P14.setFocusPainted(false);
        P14.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P14.setMaximumSize(new java.awt.Dimension(40, 40));
        P14.setMinimumSize(new java.awt.Dimension(40, 40));
        P14.setPreferredSize(new java.awt.Dimension(40, 40));

        P15.setBackground(new java.awt.Color(255, 255, 255));
        P15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P15.setText("5");
        P15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P15.setBorderPainted(false);
        P15.setFocusPainted(false);
        P15.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P15.setMaximumSize(new java.awt.Dimension(40, 40));
        P15.setMinimumSize(new java.awt.Dimension(40, 40));
        P15.setPreferredSize(new java.awt.Dimension(40, 40));

        P16.setBackground(new java.awt.Color(255, 255, 255));
        P16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P16.setText("6");
        P16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P16.setBorderPainted(false);
        P16.setFocusPainted(false);
        P16.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P16.setMaximumSize(new java.awt.Dimension(40, 40));
        P16.setMinimumSize(new java.awt.Dimension(40, 40));
        P16.setPreferredSize(new java.awt.Dimension(40, 40));

        P17.setBackground(new java.awt.Color(255, 255, 255));
        P17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P17.setText("7");
        P17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P17.setBorderPainted(false);
        P17.setFocusPainted(false);
        P17.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P17.setMaximumSize(new java.awt.Dimension(40, 40));
        P17.setMinimumSize(new java.awt.Dimension(40, 40));
        P17.setPreferredSize(new java.awt.Dimension(40, 40));

        P18.setBackground(new java.awt.Color(255, 255, 255));
        P18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P18.setText("8");
        P18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P18.setBorderPainted(false);
        P18.setFocusPainted(false);
        P18.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P18.setMaximumSize(new java.awt.Dimension(40, 40));
        P18.setMinimumSize(new java.awt.Dimension(40, 40));
        P18.setPreferredSize(new java.awt.Dimension(40, 40));

        P19.setBackground(new java.awt.Color(255, 255, 255));
        P19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P19.setText("9");
        P19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P19.setBorderPainted(false);
        P19.setFocusPainted(false);
        P19.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P19.setMaximumSize(new java.awt.Dimension(40, 40));
        P19.setMinimumSize(new java.awt.Dimension(40, 40));
        P19.setPreferredSize(new java.awt.Dimension(40, 40));

        P21.setBackground(new java.awt.Color(255, 255, 255));
        P21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P21.setText("1");
        P21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P21.setBorderPainted(false);
        P21.setFocusPainted(false);
        P21.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P21.setMaximumSize(new java.awt.Dimension(40, 40));
        P21.setMinimumSize(new java.awt.Dimension(40, 40));
        P21.setPreferredSize(new java.awt.Dimension(40, 40));

        P22.setBackground(new java.awt.Color(255, 255, 255));
        P22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P22.setText("2");
        P22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P22.setBorderPainted(false);
        P22.setFocusPainted(false);
        P22.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P22.setMaximumSize(new java.awt.Dimension(40, 40));
        P22.setMinimumSize(new java.awt.Dimension(40, 40));
        P22.setPreferredSize(new java.awt.Dimension(40, 40));

        P23.setBackground(new java.awt.Color(255, 255, 255));
        P23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P23.setText("3");
        P23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P23.setBorderPainted(false);
        P23.setFocusPainted(false);
        P23.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P23.setMaximumSize(new java.awt.Dimension(40, 40));
        P23.setMinimumSize(new java.awt.Dimension(40, 40));
        P23.setPreferredSize(new java.awt.Dimension(40, 40));

        P24.setBackground(new java.awt.Color(255, 255, 255));
        P24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P24.setText("4");
        P24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P24.setBorderPainted(false);
        P24.setFocusPainted(false);
        P24.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P24.setMaximumSize(new java.awt.Dimension(40, 40));
        P24.setMinimumSize(new java.awt.Dimension(40, 40));
        P24.setPreferredSize(new java.awt.Dimension(40, 40));

        P25.setBackground(new java.awt.Color(255, 255, 255));
        P25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P25.setText("5");
        P25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P25.setBorderPainted(false);
        P25.setFocusPainted(false);
        P25.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P25.setMaximumSize(new java.awt.Dimension(40, 40));
        P25.setMinimumSize(new java.awt.Dimension(40, 40));
        P25.setPreferredSize(new java.awt.Dimension(40, 40));

        P26.setBackground(new java.awt.Color(255, 255, 255));
        P26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P26.setText("6");
        P26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P26.setBorderPainted(false);
        P26.setFocusPainted(false);
        P26.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P26.setMaximumSize(new java.awt.Dimension(40, 40));
        P26.setMinimumSize(new java.awt.Dimension(40, 40));
        P26.setPreferredSize(new java.awt.Dimension(40, 40));

        P27.setBackground(new java.awt.Color(255, 255, 255));
        P27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P27.setText("7");
        P27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P27.setBorderPainted(false);
        P27.setFocusPainted(false);
        P27.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P27.setMaximumSize(new java.awt.Dimension(40, 40));
        P27.setMinimumSize(new java.awt.Dimension(40, 40));
        P27.setPreferredSize(new java.awt.Dimension(40, 40));

        P28.setBackground(new java.awt.Color(255, 255, 255));
        P28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P28.setText("8");
        P28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P28.setBorderPainted(false);
        P28.setFocusPainted(false);
        P28.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P28.setMaximumSize(new java.awt.Dimension(40, 40));
        P28.setMinimumSize(new java.awt.Dimension(40, 40));
        P28.setPreferredSize(new java.awt.Dimension(40, 40));

        P29.setBackground(new java.awt.Color(255, 255, 255));
        P29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P29.setText("9");
        P29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P29.setBorderPainted(false);
        P29.setFocusPainted(false);
        P29.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P29.setMaximumSize(new java.awt.Dimension(40, 40));
        P29.setMinimumSize(new java.awt.Dimension(40, 40));
        P29.setPreferredSize(new java.awt.Dimension(40, 40));

        P31.setBackground(new java.awt.Color(255, 255, 255));
        P31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P31.setText("1");
        P31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P31.setBorderPainted(false);
        P31.setFocusPainted(false);
        P31.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P31.setMaximumSize(new java.awt.Dimension(40, 40));
        P31.setMinimumSize(new java.awt.Dimension(40, 40));
        P31.setPreferredSize(new java.awt.Dimension(40, 40));

        P32.setBackground(new java.awt.Color(255, 255, 255));
        P32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P32.setText("2");
        P32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P32.setBorderPainted(false);
        P32.setFocusPainted(false);
        P32.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P32.setMaximumSize(new java.awt.Dimension(40, 40));
        P32.setMinimumSize(new java.awt.Dimension(40, 40));
        P32.setPreferredSize(new java.awt.Dimension(40, 40));

        P33.setBackground(new java.awt.Color(255, 255, 255));
        P33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P33.setText("3");
        P33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P33.setBorderPainted(false);
        P33.setFocusPainted(false);
        P33.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P33.setMaximumSize(new java.awt.Dimension(40, 40));
        P33.setMinimumSize(new java.awt.Dimension(40, 40));
        P33.setPreferredSize(new java.awt.Dimension(40, 40));

        P34.setBackground(new java.awt.Color(255, 255, 255));
        P34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P34.setText("4");
        P34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P34.setBorderPainted(false);
        P34.setFocusPainted(false);
        P34.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P34.setMaximumSize(new java.awt.Dimension(40, 40));
        P34.setMinimumSize(new java.awt.Dimension(40, 40));
        P34.setPreferredSize(new java.awt.Dimension(40, 40));

        P35.setBackground(new java.awt.Color(255, 255, 255));
        P35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P35.setText("5");
        P35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P35.setBorderPainted(false);
        P35.setFocusPainted(false);
        P35.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P35.setMaximumSize(new java.awt.Dimension(40, 40));
        P35.setMinimumSize(new java.awt.Dimension(40, 40));
        P35.setPreferredSize(new java.awt.Dimension(40, 40));

        P36.setBackground(new java.awt.Color(255, 255, 255));
        P36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P36.setText("6");
        P36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P36.setBorderPainted(false);
        P36.setFocusPainted(false);
        P36.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P36.setMaximumSize(new java.awt.Dimension(40, 40));
        P36.setMinimumSize(new java.awt.Dimension(40, 40));
        P36.setPreferredSize(new java.awt.Dimension(40, 40));

        P37.setBackground(new java.awt.Color(255, 255, 255));
        P37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P37.setText("7");
        P37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P37.setBorderPainted(false);
        P37.setFocusPainted(false);
        P37.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P37.setMaximumSize(new java.awt.Dimension(40, 40));
        P37.setMinimumSize(new java.awt.Dimension(40, 40));
        P37.setPreferredSize(new java.awt.Dimension(40, 40));

        P38.setBackground(new java.awt.Color(255, 255, 255));
        P38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P38.setText("8");
        P38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P38.setBorderPainted(false);
        P38.setFocusPainted(false);
        P38.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P38.setMaximumSize(new java.awt.Dimension(40, 40));
        P38.setMinimumSize(new java.awt.Dimension(40, 40));
        P38.setPreferredSize(new java.awt.Dimension(40, 40));

        P39.setBackground(new java.awt.Color(255, 255, 255));
        P39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P39.setText("9");
        P39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P39.setBorderPainted(false);
        P39.setFocusPainted(false);
        P39.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P39.setMaximumSize(new java.awt.Dimension(40, 40));
        P39.setMinimumSize(new java.awt.Dimension(40, 40));
        P39.setPreferredSize(new java.awt.Dimension(40, 40));

        P41.setBackground(new java.awt.Color(255, 255, 255));
        P41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P41.setText("1");
        P41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P41.setBorderPainted(false);
        P41.setFocusPainted(false);
        P41.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P41.setMaximumSize(new java.awt.Dimension(40, 40));
        P41.setMinimumSize(new java.awt.Dimension(40, 40));
        P41.setPreferredSize(new java.awt.Dimension(40, 40));

        P42.setBackground(new java.awt.Color(255, 255, 255));
        P42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P42.setText("2");
        P42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P42.setBorderPainted(false);
        P42.setFocusPainted(false);
        P42.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P42.setMaximumSize(new java.awt.Dimension(40, 40));
        P42.setMinimumSize(new java.awt.Dimension(40, 40));
        P42.setPreferredSize(new java.awt.Dimension(40, 40));

        P43.setBackground(new java.awt.Color(255, 255, 255));
        P43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P43.setText("3");
        P43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P43.setBorderPainted(false);
        P43.setFocusPainted(false);
        P43.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P43.setMaximumSize(new java.awt.Dimension(40, 40));
        P43.setMinimumSize(new java.awt.Dimension(40, 40));
        P43.setPreferredSize(new java.awt.Dimension(40, 40));

        P44.setBackground(new java.awt.Color(255, 255, 255));
        P44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P44.setText("4");
        P44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P44.setBorderPainted(false);
        P44.setFocusPainted(false);
        P44.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P44.setMaximumSize(new java.awt.Dimension(40, 40));
        P44.setMinimumSize(new java.awt.Dimension(40, 40));
        P44.setPreferredSize(new java.awt.Dimension(40, 40));

        P45.setBackground(new java.awt.Color(255, 255, 255));
        P45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P45.setText("5");
        P45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P45.setBorderPainted(false);
        P45.setFocusPainted(false);
        P45.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P45.setMaximumSize(new java.awt.Dimension(40, 40));
        P45.setMinimumSize(new java.awt.Dimension(40, 40));
        P45.setPreferredSize(new java.awt.Dimension(40, 40));

        P46.setBackground(new java.awt.Color(255, 255, 255));
        P46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P46.setText("6");
        P46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P46.setBorderPainted(false);
        P46.setFocusPainted(false);
        P46.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P46.setMaximumSize(new java.awt.Dimension(40, 40));
        P46.setMinimumSize(new java.awt.Dimension(40, 40));
        P46.setPreferredSize(new java.awt.Dimension(40, 40));

        P47.setBackground(new java.awt.Color(255, 255, 255));
        P47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P47.setText("7");
        P47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P47.setBorderPainted(false);
        P47.setFocusPainted(false);
        P47.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P47.setMaximumSize(new java.awt.Dimension(40, 40));
        P47.setMinimumSize(new java.awt.Dimension(40, 40));
        P47.setPreferredSize(new java.awt.Dimension(40, 40));

        P48.setBackground(new java.awt.Color(255, 255, 255));
        P48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P48.setText("8");
        P48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P48.setBorderPainted(false);
        P48.setFocusPainted(false);
        P48.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P48.setMaximumSize(new java.awt.Dimension(40, 40));
        P48.setMinimumSize(new java.awt.Dimension(40, 40));
        P48.setPreferredSize(new java.awt.Dimension(40, 40));

        P49.setBackground(new java.awt.Color(255, 255, 255));
        P49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P49.setText("9");
        P49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P49.setBorderPainted(false);
        P49.setFocusPainted(false);
        P49.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P49.setMaximumSize(new java.awt.Dimension(40, 40));
        P49.setMinimumSize(new java.awt.Dimension(40, 40));
        P49.setPreferredSize(new java.awt.Dimension(40, 40));

        P51.setBackground(new java.awt.Color(255, 255, 255));
        P51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P51.setText("1");
        P51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P51.setBorderPainted(false);
        P51.setFocusPainted(false);
        P51.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P51.setMaximumSize(new java.awt.Dimension(40, 40));
        P51.setMinimumSize(new java.awt.Dimension(40, 40));
        P51.setPreferredSize(new java.awt.Dimension(40, 40));

        P52.setBackground(new java.awt.Color(255, 255, 255));
        P52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P52.setText("2");
        P52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P52.setBorderPainted(false);
        P52.setFocusPainted(false);
        P52.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P52.setMaximumSize(new java.awt.Dimension(40, 40));
        P52.setMinimumSize(new java.awt.Dimension(40, 40));
        P52.setPreferredSize(new java.awt.Dimension(40, 40));

        P54.setBackground(new java.awt.Color(255, 255, 255));
        P54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P54.setText("4");
        P54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P54.setBorderPainted(false);
        P54.setFocusPainted(false);
        P54.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P54.setMaximumSize(new java.awt.Dimension(40, 40));
        P54.setMinimumSize(new java.awt.Dimension(40, 40));
        P54.setPreferredSize(new java.awt.Dimension(40, 40));

        P53.setBackground(new java.awt.Color(255, 255, 255));
        P53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P53.setText("3");
        P53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P53.setBorderPainted(false);
        P53.setFocusPainted(false);
        P53.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P53.setMaximumSize(new java.awt.Dimension(40, 40));
        P53.setMinimumSize(new java.awt.Dimension(40, 40));
        P53.setPreferredSize(new java.awt.Dimension(40, 40));

        P55.setBackground(new java.awt.Color(255, 255, 255));
        P55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P55.setText("5");
        P55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P55.setBorderPainted(false);
        P55.setFocusPainted(false);
        P55.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P55.setMaximumSize(new java.awt.Dimension(40, 40));
        P55.setMinimumSize(new java.awt.Dimension(40, 40));
        P55.setPreferredSize(new java.awt.Dimension(40, 40));

        P56.setBackground(new java.awt.Color(255, 255, 255));
        P56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P56.setText("6");
        P56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P56.setBorderPainted(false);
        P56.setFocusPainted(false);
        P56.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P56.setMaximumSize(new java.awt.Dimension(40, 40));
        P56.setMinimumSize(new java.awt.Dimension(40, 40));
        P56.setPreferredSize(new java.awt.Dimension(40, 40));

        P57.setBackground(new java.awt.Color(255, 255, 255));
        P57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P57.setText("7");
        P57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P57.setBorderPainted(false);
        P57.setFocusPainted(false);
        P57.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P57.setMaximumSize(new java.awt.Dimension(40, 40));
        P57.setMinimumSize(new java.awt.Dimension(40, 40));
        P57.setPreferredSize(new java.awt.Dimension(40, 40));

        P58.setBackground(new java.awt.Color(255, 255, 255));
        P58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P58.setText("8");
        P58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P58.setBorderPainted(false);
        P58.setFocusPainted(false);
        P58.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P58.setMaximumSize(new java.awt.Dimension(40, 40));
        P58.setMinimumSize(new java.awt.Dimension(40, 40));
        P58.setPreferredSize(new java.awt.Dimension(40, 40));

        P59.setBackground(new java.awt.Color(255, 255, 255));
        P59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P59.setText("9");
        P59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P59.setBorderPainted(false);
        P59.setFocusPainted(false);
        P59.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P59.setMaximumSize(new java.awt.Dimension(40, 40));
        P59.setMinimumSize(new java.awt.Dimension(40, 40));
        P59.setPreferredSize(new java.awt.Dimension(40, 40));

        P61.setBackground(new java.awt.Color(255, 255, 255));
        P61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P61.setText("1");
        P61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P61.setBorderPainted(false);
        P61.setFocusPainted(false);
        P61.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P61.setMaximumSize(new java.awt.Dimension(40, 40));
        P61.setMinimumSize(new java.awt.Dimension(40, 40));
        P61.setPreferredSize(new java.awt.Dimension(40, 40));

        P62.setBackground(new java.awt.Color(255, 255, 255));
        P62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P62.setText("2");
        P62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P62.setBorderPainted(false);
        P62.setFocusPainted(false);
        P62.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P62.setMaximumSize(new java.awt.Dimension(40, 40));
        P62.setMinimumSize(new java.awt.Dimension(40, 40));
        P62.setPreferredSize(new java.awt.Dimension(40, 40));

        P63.setBackground(new java.awt.Color(255, 255, 255));
        P63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P63.setText("3");
        P63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P63.setBorderPainted(false);
        P63.setFocusPainted(false);
        P63.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P63.setMaximumSize(new java.awt.Dimension(40, 40));
        P63.setMinimumSize(new java.awt.Dimension(40, 40));
        P63.setPreferredSize(new java.awt.Dimension(40, 40));

        P64.setBackground(new java.awt.Color(255, 255, 255));
        P64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P64.setText("4");
        P64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P64.setBorderPainted(false);
        P64.setFocusPainted(false);
        P64.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P64.setMaximumSize(new java.awt.Dimension(40, 40));
        P64.setMinimumSize(new java.awt.Dimension(40, 40));
        P64.setPreferredSize(new java.awt.Dimension(40, 40));

        P65.setBackground(new java.awt.Color(255, 255, 255));
        P65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P65.setText("5");
        P65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P65.setBorderPainted(false);
        P65.setFocusPainted(false);
        P65.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P65.setMaximumSize(new java.awt.Dimension(40, 40));
        P65.setMinimumSize(new java.awt.Dimension(40, 40));
        P65.setPreferredSize(new java.awt.Dimension(40, 40));

        P66.setBackground(new java.awt.Color(255, 255, 255));
        P66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P66.setText("6");
        P66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P66.setBorderPainted(false);
        P66.setFocusPainted(false);
        P66.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P66.setMaximumSize(new java.awt.Dimension(40, 40));
        P66.setMinimumSize(new java.awt.Dimension(40, 40));
        P66.setPreferredSize(new java.awt.Dimension(40, 40));

        P67.setBackground(new java.awt.Color(255, 255, 255));
        P67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P67.setText("7");
        P67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P67.setBorderPainted(false);
        P67.setFocusPainted(false);
        P67.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P67.setMaximumSize(new java.awt.Dimension(40, 40));
        P67.setMinimumSize(new java.awt.Dimension(40, 40));
        P67.setPreferredSize(new java.awt.Dimension(40, 40));

        P68.setBackground(new java.awt.Color(255, 255, 255));
        P68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P68.setText("8");
        P68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P68.setBorderPainted(false);
        P68.setFocusPainted(false);
        P68.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P68.setMaximumSize(new java.awt.Dimension(40, 40));
        P68.setMinimumSize(new java.awt.Dimension(40, 40));
        P68.setPreferredSize(new java.awt.Dimension(40, 40));

        P69.setBackground(new java.awt.Color(255, 255, 255));
        P69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P69.setText("9");
        P69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P69.setBorderPainted(false);
        P69.setFocusPainted(false);
        P69.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P69.setMaximumSize(new java.awt.Dimension(40, 40));
        P69.setMinimumSize(new java.awt.Dimension(40, 40));
        P69.setPreferredSize(new java.awt.Dimension(40, 40));

        P71.setBackground(new java.awt.Color(255, 255, 255));
        P71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P71.setText("1");
        P71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P71.setBorderPainted(false);
        P71.setFocusPainted(false);
        P71.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P71.setMaximumSize(new java.awt.Dimension(40, 40));
        P71.setMinimumSize(new java.awt.Dimension(40, 40));
        P71.setPreferredSize(new java.awt.Dimension(40, 40));

        P72.setBackground(new java.awt.Color(255, 255, 255));
        P72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P72.setText("2");
        P72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P72.setBorderPainted(false);
        P72.setFocusPainted(false);
        P72.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P72.setMaximumSize(new java.awt.Dimension(40, 40));
        P72.setMinimumSize(new java.awt.Dimension(40, 40));
        P72.setPreferredSize(new java.awt.Dimension(40, 40));

        P73.setBackground(new java.awt.Color(255, 255, 255));
        P73.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P73.setText("3");
        P73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P73.setBorderPainted(false);
        P73.setFocusPainted(false);
        P73.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P73.setMaximumSize(new java.awt.Dimension(40, 40));
        P73.setMinimumSize(new java.awt.Dimension(40, 40));
        P73.setPreferredSize(new java.awt.Dimension(40, 40));

        P74.setBackground(new java.awt.Color(255, 255, 255));
        P74.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P74.setText("4");
        P74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P74.setBorderPainted(false);
        P74.setFocusPainted(false);
        P74.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P74.setMaximumSize(new java.awt.Dimension(40, 40));
        P74.setMinimumSize(new java.awt.Dimension(40, 40));
        P74.setPreferredSize(new java.awt.Dimension(40, 40));

        P75.setBackground(new java.awt.Color(255, 255, 255));
        P75.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P75.setText("5");
        P75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P75.setBorderPainted(false);
        P75.setFocusPainted(false);
        P75.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P75.setMaximumSize(new java.awt.Dimension(40, 40));
        P75.setMinimumSize(new java.awt.Dimension(40, 40));
        P75.setPreferredSize(new java.awt.Dimension(40, 40));

        P76.setBackground(new java.awt.Color(255, 255, 255));
        P76.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P76.setText("6");
        P76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P76.setBorderPainted(false);
        P76.setFocusPainted(false);
        P76.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P76.setMaximumSize(new java.awt.Dimension(40, 40));
        P76.setMinimumSize(new java.awt.Dimension(40, 40));
        P76.setPreferredSize(new java.awt.Dimension(40, 40));

        P77.setBackground(new java.awt.Color(255, 255, 255));
        P77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P77.setText("7");
        P77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P77.setBorderPainted(false);
        P77.setFocusPainted(false);
        P77.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P77.setMaximumSize(new java.awt.Dimension(40, 40));
        P77.setMinimumSize(new java.awt.Dimension(40, 40));
        P77.setPreferredSize(new java.awt.Dimension(40, 40));

        P78.setBackground(new java.awt.Color(255, 255, 255));
        P78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P78.setText("8");
        P78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P78.setBorderPainted(false);
        P78.setFocusPainted(false);
        P78.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P78.setMaximumSize(new java.awt.Dimension(40, 40));
        P78.setMinimumSize(new java.awt.Dimension(40, 40));
        P78.setPreferredSize(new java.awt.Dimension(40, 40));

        P79.setBackground(new java.awt.Color(255, 255, 255));
        P79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P79.setText("9");
        P79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P79.setBorderPainted(false);
        P79.setFocusPainted(false);
        P79.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P79.setMaximumSize(new java.awt.Dimension(40, 40));
        P79.setMinimumSize(new java.awt.Dimension(40, 40));
        P79.setPreferredSize(new java.awt.Dimension(40, 40));

        P81.setBackground(new java.awt.Color(255, 255, 255));
        P81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P81.setText("1");
        P81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P81.setBorderPainted(false);
        P81.setFocusPainted(false);
        P81.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P81.setMaximumSize(new java.awt.Dimension(40, 40));
        P81.setMinimumSize(new java.awt.Dimension(40, 40));
        P81.setPreferredSize(new java.awt.Dimension(40, 40));

        P82.setBackground(new java.awt.Color(255, 255, 255));
        P82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P82.setText("2");
        P82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P82.setBorderPainted(false);
        P82.setFocusPainted(false);
        P82.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P82.setMaximumSize(new java.awt.Dimension(40, 40));
        P82.setMinimumSize(new java.awt.Dimension(40, 40));
        P82.setPreferredSize(new java.awt.Dimension(40, 40));

        P83.setBackground(new java.awt.Color(255, 255, 255));
        P83.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P83.setText("3");
        P83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P83.setBorderPainted(false);
        P83.setFocusPainted(false);
        P83.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P83.setMaximumSize(new java.awt.Dimension(40, 40));
        P83.setMinimumSize(new java.awt.Dimension(40, 40));
        P83.setPreferredSize(new java.awt.Dimension(40, 40));

        P84.setBackground(new java.awt.Color(255, 255, 255));
        P84.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P84.setText("4");
        P84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P84.setBorderPainted(false);
        P84.setFocusPainted(false);
        P84.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P84.setMaximumSize(new java.awt.Dimension(40, 40));
        P84.setMinimumSize(new java.awt.Dimension(40, 40));
        P84.setPreferredSize(new java.awt.Dimension(40, 40));

        P85.setBackground(new java.awt.Color(255, 255, 255));
        P85.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P85.setText("5");
        P85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P85.setBorderPainted(false);
        P85.setFocusPainted(false);
        P85.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P85.setMaximumSize(new java.awt.Dimension(40, 40));
        P85.setMinimumSize(new java.awt.Dimension(40, 40));
        P85.setPreferredSize(new java.awt.Dimension(40, 40));

        P86.setBackground(new java.awt.Color(255, 255, 255));
        P86.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P86.setText("6");
        P86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P86.setBorderPainted(false);
        P86.setFocusPainted(false);
        P86.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P86.setMaximumSize(new java.awt.Dimension(40, 40));
        P86.setMinimumSize(new java.awt.Dimension(40, 40));
        P86.setPreferredSize(new java.awt.Dimension(40, 40));

        P87.setBackground(new java.awt.Color(255, 255, 255));
        P87.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P87.setText("7");
        P87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P87.setBorderPainted(false);
        P87.setFocusPainted(false);
        P87.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P87.setMaximumSize(new java.awt.Dimension(40, 40));
        P87.setMinimumSize(new java.awt.Dimension(40, 40));
        P87.setPreferredSize(new java.awt.Dimension(40, 40));

        P88.setBackground(new java.awt.Color(255, 255, 255));
        P88.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P88.setText("8");
        P88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P88.setBorderPainted(false);
        P88.setFocusPainted(false);
        P88.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P88.setMaximumSize(new java.awt.Dimension(40, 40));
        P88.setMinimumSize(new java.awt.Dimension(40, 40));
        P88.setPreferredSize(new java.awt.Dimension(40, 40));

        P89.setBackground(new java.awt.Color(255, 255, 255));
        P89.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P89.setText("9");
        P89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P89.setBorderPainted(false);
        P89.setFocusPainted(false);
        P89.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P89.setMaximumSize(new java.awt.Dimension(40, 40));
        P89.setMinimumSize(new java.awt.Dimension(40, 40));
        P89.setPreferredSize(new java.awt.Dimension(40, 40));

        P91.setBackground(new java.awt.Color(255, 255, 255));
        P91.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P91.setText("1");
        P91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P91.setBorderPainted(false);
        P91.setFocusPainted(false);
        P91.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P91.setMaximumSize(new java.awt.Dimension(40, 40));
        P91.setMinimumSize(new java.awt.Dimension(40, 40));
        P91.setPreferredSize(new java.awt.Dimension(40, 40));

        P92.setBackground(new java.awt.Color(255, 255, 255));
        P92.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P92.setText("2");
        P92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P92.setBorderPainted(false);
        P92.setFocusPainted(false);
        P92.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P92.setMaximumSize(new java.awt.Dimension(40, 40));
        P92.setMinimumSize(new java.awt.Dimension(40, 40));
        P92.setPreferredSize(new java.awt.Dimension(40, 40));

        P93.setBackground(new java.awt.Color(255, 255, 255));
        P93.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P93.setText("3");
        P93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P93.setBorderPainted(false);
        P93.setFocusPainted(false);
        P93.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P93.setMaximumSize(new java.awt.Dimension(40, 40));
        P93.setMinimumSize(new java.awt.Dimension(40, 40));
        P93.setPreferredSize(new java.awt.Dimension(40, 40));

        P94.setBackground(new java.awt.Color(255, 255, 255));
        P94.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P94.setText("4");
        P94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P94.setBorderPainted(false);
        P94.setFocusPainted(false);
        P94.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P94.setMaximumSize(new java.awt.Dimension(40, 40));
        P94.setMinimumSize(new java.awt.Dimension(40, 40));
        P94.setPreferredSize(new java.awt.Dimension(40, 40));

        P95.setBackground(new java.awt.Color(255, 255, 255));
        P95.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P95.setText("5");
        P95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P95.setBorderPainted(false);
        P95.setFocusPainted(false);
        P95.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P95.setMaximumSize(new java.awt.Dimension(40, 40));
        P95.setMinimumSize(new java.awt.Dimension(40, 40));
        P95.setPreferredSize(new java.awt.Dimension(40, 40));

        P96.setBackground(new java.awt.Color(255, 255, 255));
        P96.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P96.setText("6");
        P96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P96.setBorderPainted(false);
        P96.setFocusPainted(false);
        P96.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P96.setMaximumSize(new java.awt.Dimension(40, 40));
        P96.setMinimumSize(new java.awt.Dimension(40, 40));
        P96.setPreferredSize(new java.awt.Dimension(40, 40));

        P97.setBackground(new java.awt.Color(255, 255, 255));
        P97.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P97.setText("7");
        P97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P97.setBorderPainted(false);
        P97.setFocusPainted(false);
        P97.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P97.setMaximumSize(new java.awt.Dimension(40, 40));
        P97.setMinimumSize(new java.awt.Dimension(40, 40));
        P97.setPreferredSize(new java.awt.Dimension(40, 40));

        P98.setBackground(new java.awt.Color(255, 255, 255));
        P98.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P98.setText("8");
        P98.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P98.setBorderPainted(false);
        P98.setFocusPainted(false);
        P98.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P98.setMaximumSize(new java.awt.Dimension(40, 40));
        P98.setMinimumSize(new java.awt.Dimension(40, 40));
        P98.setPreferredSize(new java.awt.Dimension(40, 40));

        P99.setBackground(new java.awt.Color(255, 255, 255));
        P99.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P99.setText("9");
        P99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P99.setBorderPainted(false);
        P99.setFocusPainted(false);
        P99.setMargin(new java.awt.Insets(2, 2, 2, 2));
        P99.setMaximumSize(new java.awt.Dimension(40, 40));
        P99.setMinimumSize(new java.awt.Dimension(40, 40));
        P99.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout PuzzlePanelLayout = new javax.swing.GroupLayout(PuzzlePanel);
        PuzzlePanel.setLayout(PuzzlePanelLayout);
        PuzzlePanelLayout.setHorizontalGroup(
            PuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PuzzlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PuzzlePanelLayout.createSequentialGroup()
                        .addComponent(P11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PuzzlePanelLayout.createSequentialGroup()
                        .addComponent(P81, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P82, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P83, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P84, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P85, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P86, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P87, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P88, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P89, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PuzzlePanelLayout.createSequentialGroup()
                        .addComponent(P91, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P92, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P93, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P94, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P95, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P96, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P97, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P98, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P99, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PuzzlePanelLayout.createSequentialGroup()
                        .addComponent(P71, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P72, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P73, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P74, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P75, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P76, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P77, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P78, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P79, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PuzzlePanelLayout.createSequentialGroup()
                        .addComponent(P51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P55, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P57, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P58, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P59, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PuzzlePanelLayout.createSequentialGroup()
                        .addComponent(P61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P62, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P63, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P64, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P65, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P66, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P67, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P68, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P69, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PuzzlePanelLayout.createSequentialGroup()
                        .addComponent(P41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P49, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PuzzlePanelLayout.createSequentialGroup()
                        .addComponent(P21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PuzzlePanelLayout.createSequentialGroup()
                        .addComponent(P31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(P37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(P39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PuzzlePanelLayout.setVerticalGroup(
            PuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PuzzlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(PuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(PuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(PuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P49, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(PuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P55, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P58, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P59, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P57, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(PuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P62, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P63, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P65, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P66, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P64, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P68, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P69, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P67, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(PuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P72, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P73, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P71, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P75, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P76, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P74, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P78, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P79, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P77, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(PuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P82, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P83, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P81, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P85, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P86, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P84, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P88, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P89, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P87, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(PuzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P92, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P91, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P95, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P96, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P94, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P98, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P99, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P97, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P93, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AgentStatePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Agent State"));

        Agent1State.setSelected(true);
        Agent1State.setText("1");
        Agent1State.setFocusable(false);

        Agent2State.setText("2");

        Agent3State.setText("3");

        Agent4State.setText("4");

        Agent5State.setText("5");

        Agent6State.setText("6");

        Agent7State.setText("7");

        Agent8State.setText("8");

        Agent9State.setText("9");

        Agent1Box.setEditable(false);
        Agent1Box.setFont(new java.awt.Font("Adobe Arabic", 0, 14)); // NOI18N
        Agent1Box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Agent1Box.setText("9");

        Agent2Box.setFont(new java.awt.Font("Adobe Arabic", 0, 14)); // NOI18N
        Agent2Box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Agent2Box.setText("9");

        Agent6Box.setFont(new java.awt.Font("Adobe Arabic", 0, 14)); // NOI18N
        Agent6Box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Agent6Box.setText("9");

        Agent7Box.setFont(new java.awt.Font("Adobe Arabic", 0, 14)); // NOI18N
        Agent7Box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Agent7Box.setText("9");

        Agent8Box.setFont(new java.awt.Font("Adobe Arabic", 0, 14)); // NOI18N
        Agent8Box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Agent8Box.setText("9");

        Agent9Box.setFont(new java.awt.Font("Adobe Arabic", 0, 14)); // NOI18N
        Agent9Box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Agent9Box.setText("9");

        Agent5Box.setFont(new java.awt.Font("Adobe Arabic", 0, 14)); // NOI18N
        Agent5Box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Agent5Box.setText("9");

        Agent3Box.setFont(new java.awt.Font("Adobe Arabic", 0, 14)); // NOI18N
        Agent3Box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Agent3Box.setText("9");

        Agent4Box.setFont(new java.awt.Font("Adobe Arabic", 0, 14)); // NOI18N
        Agent4Box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Agent4Box.setText("9");

        javax.swing.GroupLayout AgentStatePanelLayout = new javax.swing.GroupLayout(AgentStatePanel);
        AgentStatePanel.setLayout(AgentStatePanelLayout);
        AgentStatePanelLayout.setHorizontalGroup(
            AgentStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgentStatePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(AgentStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AgentStatePanelLayout.createSequentialGroup()
                        .addComponent(Agent1Box, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Agent2Box, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Agent3Box, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Agent4Box, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Agent5Box, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Agent6Box, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Agent7Box, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Agent8Box, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Agent9Box, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AgentStatePanelLayout.createSequentialGroup()
                        .addComponent(Agent1State)
                        .addGap(18, 18, 18)
                        .addComponent(Agent2State)
                        .addGap(18, 18, 18)
                        .addComponent(Agent3State)
                        .addGap(18, 18, 18)
                        .addComponent(Agent4State)
                        .addGap(18, 18, 18)
                        .addComponent(Agent5State)
                        .addGap(18, 18, 18)
                        .addComponent(Agent6State)
                        .addGap(18, 18, 18)
                        .addComponent(Agent7State)
                        .addGap(18, 18, 18)
                        .addComponent(Agent8State)
                        .addGap(18, 18, 18)
                        .addComponent(Agent9State)))
                .addGap(15, 15, 15))
        );
        AgentStatePanelLayout.setVerticalGroup(
            AgentStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgentStatePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(AgentStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Agent1Box, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agent2Box, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agent3Box, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agent4Box, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agent5Box, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agent6Box, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agent7Box, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agent8Box, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agent9Box, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AgentStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Agent1State)
                    .addComponent(Agent2State)
                    .addComponent(Agent3State)
                    .addComponent(Agent4State)
                    .addComponent(Agent5State)
                    .addComponent(Agent6State)
                    .addComponent(Agent7State)
                    .addComponent(Agent8State)
                    .addComponent(Agent9State))
                .addContainerGap())
        );

        MenuBar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        FileMenu.setText("File");

        CreatePuzzleMenu.setText("Create Puzzle");
        CreatePuzzleMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePuzzleMenuActionPerformed(evt);
            }
        });
        FileMenu.add(CreatePuzzleMenu);

        EditPuzzleMenu.setText("Edit Puzzle");
        EditPuzzleMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditPuzzleMenuActionPerformed(evt);
            }
        });
        FileMenu.add(EditPuzzleMenu);
        FileMenu.add(jSeparator1);

        ExitMenu.setText("Exit");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        FileMenu.add(ExitMenu);

        MenuBar.add(FileMenu);

        PuzzleMenu.setText("Puzzle");

        LoadPuzzleMenu.setText("Load Puzzle");
        LoadPuzzleMenu.setNextFocusableComponent(PuzzlePanel);
        LoadPuzzleMenu.setRequestFocusEnabled(false);
        LoadPuzzleMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadPuzzleMenuActionPerformed(evt);
            }
        });
        PuzzleMenu.add(LoadPuzzleMenu);

        SolvePuzzleMenu.setText("Solve Puzzle");
        SolvePuzzleMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolvePuzzleMenuActionPerformed(evt);
            }
        });
        PuzzleMenu.add(SolvePuzzleMenu);

        ClosePuzzleMenu.setText("Close Puzzle");
        ClosePuzzleMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClosePuzzleMenuActionPerformed(evt);
            }
        });
        PuzzleMenu.add(ClosePuzzleMenu);

        MenuBar.add(PuzzleMenu);

        MASMenu.setText("MAS");

        ModelMenu.setText("Model");

        Model1Menu.setSelected(true);
        Model1Menu.setText("Model 1");
        Model1Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Model1MenuActionPerformed(evt);
            }
        });
        ModelMenu.add(Model1Menu);

        Model2Menu.setText("Model 2");
        Model2Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Model2MenuActionPerformed(evt);
            }
        });
        ModelMenu.add(Model2Menu);

        Model3Menu.setText("Model 3");
        Model3Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Model3MenuActionPerformed(evt);
            }
        });
        ModelMenu.add(Model3Menu);

        Model4Menu.setText("Model 4");
        Model4Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Model4MenuActionPerformed(evt);
            }
        });
        ModelMenu.add(Model4Menu);

        MASMenu.add(ModelMenu);

        jMenu1.setText("Schedule");
        jMenu1.setName("SchedulingMenu"); // NOI18N

        jMenuItem1.setText("Normal");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Random");
        jMenu1.add(jMenuItem2);

        MASMenu.add(jMenu1);

        MenuBar.add(MASMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(PuzzlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(AgentStatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(PuzzlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AgentStatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_ExitMenuActionPerformed

    private void LoadPuzzleMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadPuzzleMenuActionPerformed
        int returnVal = LoadPuzzleFile.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String fileName = LoadPuzzleFile.getSelectedFile().getAbsolutePath();//
            System.out.println(fileName);
//try {
            // What to do with the file, e.g. display it in a TextArea
                S = new Sudoku(this); //, fileName);
                
                if (S.getEnvironment().readAPuzzle(fileName)) {
                //S.loadPuzzle(fileName);
                    resetBox();
                    drawBoard(S.Puzzle.Board);
                    this.showInitialAgentStates();
                    //for (int i=0; i < S.getAgentNum(); i++) this.showAgentStates(i);
                    PuzzlePanel.setVisible(true);
                    this.AgentStatePanel.setVisible(true);                   
                }
                else {
                    this.NotValidPuzzle.setVisible(true);
                }
            //} catch (IOException ex) {
            //System.out.println("problem accessing file"+file.getAbsolutePath());
            //}
        } else {
            System.out.println("File access cancelled by user.");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_LoadPuzzleMenuActionPerformed

    private void ClosePuzzleMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClosePuzzleMenuActionPerformed
        // TODO add your handling code here:
        PuzzlePanel.setVisible(false);
        this.AgentStatePanel.setVisible(false);
    }//GEN-LAST:event_ClosePuzzleMenuActionPerformed

    private void SolvePuzzleMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolvePuzzleMenuActionPerformed
        // TODO add your handling code here:
        System.out.println("model PF: "+this.model);
        S.execute(); //solvePuzzle();
        resetAgentState();
    }//GEN-LAST:event_SolvePuzzleMenuActionPerformed

    private void Model2MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Model2MenuActionPerformed
        // TODO add your handling code here:
        Model1Menu.setSelected(false);
        Model2Menu.setSelected(true);
        Model3Menu.setSelected(false);
        Model4Menu.setSelected(false);
        this.model = 2;
    }//GEN-LAST:event_Model2MenuActionPerformed

    private void Model3MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Model3MenuActionPerformed
        // TODO add your handling code here:
        Model1Menu.setSelected(false);
        Model2Menu.setSelected(false);
        Model3Menu.setSelected(true);
        Model4Menu.setSelected(false);
        this.model = 3;
    }//GEN-LAST:event_Model3MenuActionPerformed

    private void Model4MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Model4MenuActionPerformed
        // TODO add your handling code here:
        Model1Menu.setSelected(false);
        Model2Menu.setSelected(false);
        Model3Menu.setSelected(false);
        Model4Menu.setSelected(true);
        this.model = 4;
    }//GEN-LAST:event_Model4MenuActionPerformed

    private void Model1MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Model1MenuActionPerformed
        // TODO add your handling code here:
        Model1Menu.setSelected(true);
        Model2Menu.setSelected(false);
        Model3Menu.setSelected(false);
        Model4Menu.setSelected(false);
        this.model = 1;
    }//GEN-LAST:event_Model1MenuActionPerformed

    private void C15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C15ActionPerformed

    private void C25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C25ActionPerformed

    private void C35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C35ActionPerformed

    private void C45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C45ActionPerformed

    private void C55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C55ActionPerformed

    private void C65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C65ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C65ActionPerformed

    private void C75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C75ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C75ActionPerformed

    private void C85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C85ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C85ActionPerformed

    private void C95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C95ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C95ActionPerformed

    private void FinishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishButtonActionPerformed
        // TODO add your handling code here:
        this.CreatePuzzleFrame.setVisible(false);
    }//GEN-LAST:event_FinishButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
        for (int i=0; i<81; i++){
            CB[i].setSelectedIndex(0); CB[i].revalidate(); CB[i].repaint();
        }
        this.CreatePuzzleFrame.revalidate(); this.CreatePuzzleFrame.repaint(); 
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        int returnVal = LoadPuzzleFile.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String fileName = LoadPuzzleFile.getSelectedFile().getAbsolutePath();//
            // pengecekan apakah sudah ada file dengan nama tersebut?
            if (S == null) S = new Sudoku(this);
            S.getEnvironment().saveAPuzzle(fileName, CB);

        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void CreatePuzzleMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePuzzleMenuActionPerformed
        // TODO add your handling code here:
        this.CreatePuzzleFrame.setVisible(true);
    }//GEN-LAST:event_CreatePuzzleMenuActionPerformed

    private void EditPuzzleMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditPuzzleMenuActionPerformed
        // TODO add your handling code here:
        int returnVal = LoadPuzzleFile.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String fileName = LoadPuzzleFile.getSelectedFile().getAbsolutePath();//
            // pengecekan apakah sudah ada file dengan nama tersebut?
            if (S == null) S = new Sudoku(this);
            S.getEnvironment().editAPuzzle(fileName, CB);
            this.CreatePuzzlePanel.revalidate();
            this.CreatePuzzlePanel.repaint();
            this.CreatePuzzleFrame.setVisible(true);
        }
    }//GEN-LAST:event_EditPuzzleMenuActionPerformed
    
    int getModel(){
        return this.model;   //default
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PuzzleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuzzleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuzzleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuzzleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PuzzleFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Agent1Box;
    private javax.swing.JRadioButton Agent1State;
    private javax.swing.JTextField Agent2Box;
    private javax.swing.JRadioButton Agent2State;
    private javax.swing.JTextField Agent3Box;
    private javax.swing.JRadioButton Agent3State;
    private javax.swing.JTextField Agent4Box;
    private javax.swing.JRadioButton Agent4State;
    private javax.swing.JTextField Agent5Box;
    private javax.swing.JRadioButton Agent5State;
    private javax.swing.JTextField Agent6Box;
    private javax.swing.JRadioButton Agent6State;
    private javax.swing.JTextField Agent7Box;
    private javax.swing.JRadioButton Agent7State;
    private javax.swing.JTextField Agent8Box;
    private javax.swing.JRadioButton Agent8State;
    private javax.swing.JTextField Agent9Box;
    private javax.swing.JRadioButton Agent9State;
    private javax.swing.JPanel AgentStatePanel;
    private javax.swing.JComboBox C11;
    private javax.swing.JComboBox C12;
    private javax.swing.JComboBox C13;
    private javax.swing.JComboBox C14;
    private javax.swing.JComboBox C15;
    private javax.swing.JComboBox C16;
    private javax.swing.JComboBox C17;
    private javax.swing.JComboBox C18;
    private javax.swing.JComboBox C19;
    private javax.swing.JComboBox C21;
    private javax.swing.JComboBox C22;
    private javax.swing.JComboBox C23;
    private javax.swing.JComboBox C24;
    private javax.swing.JComboBox C25;
    private javax.swing.JComboBox C26;
    private javax.swing.JComboBox C27;
    private javax.swing.JComboBox C28;
    private javax.swing.JComboBox C29;
    private javax.swing.JComboBox C31;
    private javax.swing.JComboBox C32;
    private javax.swing.JComboBox C33;
    private javax.swing.JComboBox C34;
    private javax.swing.JComboBox C35;
    private javax.swing.JComboBox C36;
    private javax.swing.JComboBox C37;
    private javax.swing.JComboBox C38;
    private javax.swing.JComboBox C39;
    private javax.swing.JComboBox C41;
    private javax.swing.JComboBox C42;
    private javax.swing.JComboBox C43;
    private javax.swing.JComboBox C44;
    private javax.swing.JComboBox C45;
    private javax.swing.JComboBox C46;
    private javax.swing.JComboBox C47;
    private javax.swing.JComboBox C48;
    private javax.swing.JComboBox C49;
    private javax.swing.JComboBox C51;
    private javax.swing.JComboBox C52;
    private javax.swing.JComboBox C53;
    private javax.swing.JComboBox C54;
    private javax.swing.JComboBox C55;
    private javax.swing.JComboBox C56;
    private javax.swing.JComboBox C57;
    private javax.swing.JComboBox C58;
    private javax.swing.JComboBox C59;
    private javax.swing.JComboBox C61;
    private javax.swing.JComboBox C62;
    private javax.swing.JComboBox C63;
    private javax.swing.JComboBox C64;
    private javax.swing.JComboBox C65;
    private javax.swing.JComboBox C66;
    private javax.swing.JComboBox C67;
    private javax.swing.JComboBox C68;
    private javax.swing.JComboBox C69;
    private javax.swing.JComboBox C71;
    private javax.swing.JComboBox C72;
    private javax.swing.JComboBox C73;
    private javax.swing.JComboBox C74;
    private javax.swing.JComboBox C75;
    private javax.swing.JComboBox C76;
    private javax.swing.JComboBox C77;
    private javax.swing.JComboBox C78;
    private javax.swing.JComboBox C79;
    private javax.swing.JComboBox C81;
    private javax.swing.JComboBox C82;
    private javax.swing.JComboBox C83;
    private javax.swing.JComboBox C84;
    private javax.swing.JComboBox C85;
    private javax.swing.JComboBox C86;
    private javax.swing.JComboBox C87;
    private javax.swing.JComboBox C88;
    private javax.swing.JComboBox C89;
    private javax.swing.JComboBox C91;
    private javax.swing.JComboBox C92;
    private javax.swing.JComboBox C93;
    private javax.swing.JComboBox C94;
    private javax.swing.JComboBox C95;
    private javax.swing.JComboBox C96;
    private javax.swing.JComboBox C97;
    private javax.swing.JComboBox C98;
    private javax.swing.JComboBox C99;
    private javax.swing.JMenuItem ClosePuzzleMenu;
    private javax.swing.JFrame CreatePuzzleFrame;
    private javax.swing.JMenuItem CreatePuzzleMenu;
    private javax.swing.JPanel CreatePuzzlePanel;
    private javax.swing.JMenuItem EditPuzzleMenu;
    private javax.swing.JMenuItem ExitMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JButton FinishButton;
    private javax.swing.JFileChooser LoadPuzzleFile;
    private javax.swing.JMenuItem LoadPuzzleMenu;
    private javax.swing.JMenu MASMenu;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JRadioButtonMenuItem Model1Menu;
    private javax.swing.JRadioButtonMenuItem Model2Menu;
    private javax.swing.JRadioButtonMenuItem Model3Menu;
    private javax.swing.JRadioButtonMenuItem Model4Menu;
    private javax.swing.JMenu ModelMenu;
    private javax.swing.JOptionPane NotValidPuzzle;
    private javax.swing.JButton P11;
    private javax.swing.JButton P12;
    private javax.swing.JButton P13;
    private javax.swing.JButton P14;
    private javax.swing.JButton P15;
    private javax.swing.JButton P16;
    private javax.swing.JButton P17;
    private javax.swing.JButton P18;
    private javax.swing.JButton P19;
    private javax.swing.JButton P21;
    private javax.swing.JButton P22;
    private javax.swing.JButton P23;
    private javax.swing.JButton P24;
    private javax.swing.JButton P25;
    private javax.swing.JButton P26;
    private javax.swing.JButton P27;
    private javax.swing.JButton P28;
    private javax.swing.JButton P29;
    private javax.swing.JButton P31;
    private javax.swing.JButton P32;
    private javax.swing.JButton P33;
    private javax.swing.JButton P34;
    private javax.swing.JButton P35;
    private javax.swing.JButton P36;
    private javax.swing.JButton P37;
    private javax.swing.JButton P38;
    private javax.swing.JButton P39;
    private javax.swing.JButton P41;
    private javax.swing.JButton P42;
    private javax.swing.JButton P43;
    private javax.swing.JButton P44;
    private javax.swing.JButton P45;
    private javax.swing.JButton P46;
    private javax.swing.JButton P47;
    private javax.swing.JButton P48;
    private javax.swing.JButton P49;
    private javax.swing.JButton P51;
    private javax.swing.JButton P52;
    private javax.swing.JButton P53;
    private javax.swing.JButton P54;
    private javax.swing.JButton P55;
    private javax.swing.JButton P56;
    private javax.swing.JButton P57;
    private javax.swing.JButton P58;
    private javax.swing.JButton P59;
    private javax.swing.JButton P61;
    private javax.swing.JButton P62;
    private javax.swing.JButton P63;
    private javax.swing.JButton P64;
    private javax.swing.JButton P65;
    private javax.swing.JButton P66;
    private javax.swing.JButton P67;
    private javax.swing.JButton P68;
    private javax.swing.JButton P69;
    private javax.swing.JButton P71;
    private javax.swing.JButton P72;
    private javax.swing.JButton P73;
    private javax.swing.JButton P74;
    private javax.swing.JButton P75;
    private javax.swing.JButton P76;
    private javax.swing.JButton P77;
    private javax.swing.JButton P78;
    private javax.swing.JButton P79;
    private javax.swing.JButton P81;
    private javax.swing.JButton P82;
    private javax.swing.JButton P83;
    private javax.swing.JButton P84;
    private javax.swing.JButton P85;
    private javax.swing.JButton P86;
    private javax.swing.JButton P87;
    private javax.swing.JButton P88;
    private javax.swing.JButton P89;
    private javax.swing.JButton P91;
    private javax.swing.JButton P92;
    private javax.swing.JButton P93;
    private javax.swing.JButton P94;
    private javax.swing.JButton P95;
    private javax.swing.JButton P96;
    private javax.swing.JButton P97;
    private javax.swing.JButton P98;
    private javax.swing.JButton P99;
    private javax.swing.JMenu PuzzleMenu;
    private javax.swing.JPanel PuzzlePanel;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JFileChooser SavePuzzleFile;
    private javax.swing.JMenuItem SolvePuzzleMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
    //private PuzzlePanel PP;
    private JButton[][] PP;
    private JRadioButton[] AS;
    private JTextField[] AB;
    private JComboBox[] CB;
    private int model = 1;
    private Sudoku S;
}
