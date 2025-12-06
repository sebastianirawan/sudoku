package sudoku;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SchedulerAgent extends Agent {
    private Environment env;
    private PuzzleFrame gui;
    private int currentRobot = 1;
    private boolean changesInCycle = false;

    private Integer[] agentOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int currentIndex = 0;

    @Override
    protected void setup() {
        System.out.println("Scheduler starting...");

        env = new Environment();
        boolean loaded = env.readAPuzzle("sudoku_5.txt");
        if(loaded) env.SetupBoxStacks();
        else System.out.println("WARNING: failed to load sudoku puzzle, check the puzzle path in SchedulerAgent.java line:26");

        java.awt.EventQueue.invokeLater(() -> {
            gui = new PuzzleFrame();
            gui.setVisible(true);
            gui.updateFromEnvironment(env, 1);
        });

        shuffleAgents();

        doWait(2000); 
        addBehaviour(new GameLoop());
    }

    private void shuffleAgents() {
        List<Integer> list = Arrays.asList(agentOrder);
        Collections.shuffle(list);
        list.toArray(agentOrder);
        System.out.print("New Agent Order: " + Arrays.toString(agentOrder));
        System.out.println();
    }

    private class GameLoop extends Behaviour {
        int step = 0;
        boolean finished = false;

        @Override
        public void action() {
            switch (step) {
                case 0:
                    int actualAgentID = agentOrder[currentIndex];

                    ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                    msg.addReceiver(new AID("Agent" + actualAgentID, AID.ISLOCALNAME));
                    try {
                        msg.setContentObject(env);
                        myAgent.send(msg);
                        step = 1;
                    } catch (IOException e) { e.printStackTrace(); }
                    break;

                case 1:
                    ACLMessage reply = myAgent.receive();
                    if (reply != null) {
                        if (reply.getPerformative() == ACLMessage.INFORM) {
                            try {
                                env = (Environment) reply.getContentObject();
                                String success = reply.getUserDefinedParameter("success");
                                
                                if ("true".equals(success)) changesInCycle = true;

                                if (gui != null) {
                                    final int rID = agentOrder[currentIndex];
                                    javax.swing.SwingUtilities.invokeLater(() -> gui.updateFromEnvironment(env, rID));
                                }

                                // currentRobot++;
                                currentIndex++;
                                if (currentIndex > 8) step = 2;
                                else {
                                    step = 0;
                                    doWait(100); 
                                }
                            } catch (Exception e) { 
                                System.out.println("Error reading agent reply: " + e.getMessage());
                                e.printStackTrace();
                            }
                        } 
                        else {
                            System.out.println("Agent " + currentRobot + " returned error: " + ACLMessage.getPerformative(reply.getPerformative()));
                            System.out.println("Content: " + reply.getContent());
                            // currentRobot++;
                            currentIndex++;
                            if (currentIndex > 8) step = 2;
                            else step = 0;
                        }
                    } else {
                        block();
                    }
                    break;

                case 2:
                    System.out.println("--- Cycle Complete ---");
                    if (changesInCycle) {
                        shuffleAgents();
                        currentIndex = 0;
                        changesInCycle = false;
                        step = 0; 
                    } else {
                        System.out.println("STOPPING: Fixed Point Reached.");
                        finished = true;
                        if(gui != null) {
                            javax.swing.SwingUtilities.invokeLater(() -> {
                                gui.updateFromEnvironment(env, 0);
                                javax.swing.JOptionPane.showMessageDialog(gui, "Process Finished!");
                            });
                        }
                    }
                    break;
            }
        }

        @Override
        public boolean done() { return finished; }
    }
}