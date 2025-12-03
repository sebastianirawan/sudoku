package sudoku;

import java.io.IOException;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class NumberAgent extends Agent{
    private int myNumber; 

    @Override
    protected void setup() {
        // 1. Determine which number I am (1-9)
        Object[] args = getArguments();
        if (args != null && args.length > 0) {
            myNumber = Integer.parseInt((String) args[0]);
        }
        System.out.println("Robot " + myNumber + " is online.");

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    try {
                        Environment env = (Environment) msg.getContentObject();
                        
                        // 2. Try to make a move using Fixed-Point Logic
                        boolean success = performLogic(env);

                        // 3. Send back the result
                        ACLMessage reply = msg.createReply();
                        reply.setPerformative(ACLMessage.INFORM);
                        reply.setContentObject(env);
                        reply.addUserDefinedParameter("success", String.valueOf(success));
                        send(reply);

                    } catch (UnreadableException | IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    block();
                }
            }
        });
    }

    private boolean performLogic(Environment env) {
        // We look for "Hidden Singles": Is there a unit (Row/Col/Block) 
        // where 'myNumber' has exactly ONE valid empty cell to go into?
        
        // Check Rows
        for (int i = 0; i < 9; i++) {
            if (checkUnit(env, i, "ROW")) return true;
        }
        // Check Columns
        for (int j = 0; j < 9; j++) {
            if (checkUnit(env, j, "COL")) return true;
        }
        // Check Sub-blocks
        for (int k = 0; k < 9; k++) {
            if (checkUnit(env, k, "BLOCK")) return true;
        }
        return false;
    }

    private boolean checkUnit(Environment env, int unitIndex, String type) {
        int validCount = 0;
        int targetR = -1; 
        int targetC = -1;

        for (int k = 0; k < 9; k++) {
            int r = 0, c = 0;
            // Map the 1D loop index 'k' to 2D coordinates based on unit type
            if (type.equals("ROW")) { r = unitIndex; c = k; }
            else if (type.equals("COL")) { r = k; c = unitIndex; }
            else { // BLOCK
                r = (unitIndex / 3) * 3 + (k / 3);
                c = (unitIndex % 3) * 3 + (k % 3);
            }

            // If cell is empty, test if myNumber fits here
            if (env.Board[r][c].getBox() == null) {
                // Temporarily place box
                env.Board[r][c].setBox(new Box(myNumber));
                
                // Use Environment's own validation
                if (env.isValidPuzzle()) {
                    validCount++;
                    targetR = r;
                    targetC = c;
                }
                
                // Remove box to continue testing
                env.Board[r][c].setBox(null);
            } else if (env.Board[r][c].getBox().getValue() == myNumber) {
                // My number is already present in this unit. I cannot place another.
                return false; 
            }
        }

        // FIXED POINT: If exactly ONE valid spot exists, take it!
        if (validCount == 1) {
            env.Board[targetR][targetC].setBox(new Box(myNumber));
            env.numbers[myNumber-1]--; // Decrement stack count
            System.out.println("Robot " + myNumber + " placed at (" + targetR + "," + targetC + ")");
            return true;
        }
        return false;
    }
}