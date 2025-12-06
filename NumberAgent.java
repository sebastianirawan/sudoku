package sudoku;

import java.io.IOException;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class NumberAgent extends Agent{
    private int myNumber; 

    @Override
    protected void setup() {
        Object[] args = getArguments();
        if (args != null && args.length > 0) {
            myNumber = Integer.parseInt((String) args[0]);
        }
        System.out.println("Agent " + myNumber + " is online.");

        addBehaviour(new playingBehaviour(this));
    }

    class playingBehaviour extends CyclicBehaviour {
        public playingBehaviour (Agent a) {
            super(a);
        }

        public void action() {
            ACLMessage msg = receive();
            if (msg != null) {
                try {
                    Environment env = (Environment) msg.getContentObject();
                    boolean success = performLogic(env);
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
    }

    private boolean performLogic(Environment env) {
        for (int i = 0; i < 9; i++) {
            if (checkUnit(env, i, "ROW")) return true;
        }
        for (int j = 0; j < 9; j++) {
            if (checkUnit(env, j, "COL")) return true;
        }
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
            if (type.equals("ROW")) { r = unitIndex; c = k; }
            else if (type.equals("COL")) { r = k; c = unitIndex; }
            else {
                r = (unitIndex / 3) * 3 + (k / 3);
                c = (unitIndex % 3) * 3 + (k % 3);
            }

            if (env.Board[r][c].getBox() == null) {
                env.Board[r][c].setBox(new Box(myNumber));
                
                if (env.isValidPuzzle()) {
                    validCount++;
                    targetR = r;
                    targetC = c;
                }
                
                env.Board[r][c].setBox(null);
            } else if (env.Board[r][c].getBox().getValue() == myNumber) {
                return false; 
            }
        }

        if (validCount == 1) {
            env.Board[targetR][targetC].setBox(new Box(myNumber));
            env.numbers[myNumber-1]--;
            System.out.println("Agent " + myNumber + " placed at (" + targetR + "," + targetC + ")");
            return true;
        }
        return false;
    }
}