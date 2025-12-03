package sudoku;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;

public class SchedulerAgent extends Agent {
    private Environment env;
    private PuzzleFrame gui;
    private int currentRobot = 1;
    private boolean changesInCycle = false;

    @Override
    protected void setup() {
        System.out.println("Scheduler Starting...");

        // 1. Setup Environment
        env = new Environment();
        // Ensure "soal11.txt" is in your project root!
        boolean loaded = env.readAPuzzle("sudoku_junior_1.txt");
        if(loaded) env.SetupBoxStacks();
        else System.out.println("Warning: Failed to load sudoku_junior_1.txt");

        // 2. Launch GUI
        java.awt.EventQueue.invokeLater(() -> {
            gui = new PuzzleFrame();
            gui.setVisible(true);
            gui.updateFromEnvironment(env, 1);
        });

        // 3. Wait for robots, then start
        doWait(2000); 
        addBehaviour(new GameLoop());
    }

    private class GameLoop extends Behaviour {
        int step = 0;
        boolean finished = false;

        @Override
        public void action() {
            switch (step) {
                case 0: // Send Request
                    ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                    msg.addReceiver(new AID("Agent" + currentRobot, AID.ISLOCALNAME));
                    try {
                        msg.setContentObject(env);
                        myAgent.send(msg);
                        step = 1;
                    } catch (IOException e) { e.printStackTrace(); }
                    break;

                case 1: // Wait Reply
                    ACLMessage reply = myAgent.receive();
                    if (reply != null) {
                        // --- SAFETY CHECK START ---
                        // Only try to read the object if the robot actually replied with INFORM
                        if (reply.getPerformative() == ACLMessage.INFORM) {
                            try {
                                env = (Environment) reply.getContentObject();
                                String success = reply.getUserDefinedParameter("success");
                                
                                if ("true".equals(success)) changesInCycle = true;

                                // Update GUI
                                if (gui != null) {
                                    final int rID = currentRobot;
                                    // Use SwingUtilities to be safe
                                    javax.swing.SwingUtilities.invokeLater(() -> gui.updateFromEnvironment(env, rID));
                                }

                                currentRobot++;
                                if (currentRobot > 9) step = 2; // End of Cycle
                                else {
                                    step = 0;
                                    doWait(100); 
                                }
                            } catch (Exception e) { 
                                System.out.println("Error reading robot reply: " + e.getMessage());
                                e.printStackTrace();
                            }
                        } 
                        else {
                            // If we received a FAILURE/REFUSE/NOT_UNDERSTOOD message
                            System.out.println("Robot " + currentRobot + " returned error: " + ACLMessage.getPerformative(reply.getPerformative()));
                            System.out.println("Content: " + reply.getContent());
                            // Skip this robot and move on to prevent freezing
                            currentRobot++;
                            if (currentRobot > 9) step = 2;
                            else step = 0;
                        }
                        // --- SAFETY CHECK END ---
                    } else {
                        block();
                    }
                    break;

                case 2: // Check Cycle Results
                    // ... (keep your existing case 2 logic) ...
                    System.out.println("--- Cycle Complete ---");
                    if (changesInCycle) {
                        currentRobot = 1;
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