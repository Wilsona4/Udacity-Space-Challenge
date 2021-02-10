import java.util.ArrayList;

public class Main {
    public static void main (String []args){
        Simulation simulation = new Simulation();
        String fileName1 = "phase-1.txt";
        String fileName2 = "phase-2.txt";

        ArrayList<Item> loadPhase1 = simulation.loadItems(fileName1);
        ArrayList<Item> loadPhase2 = simulation.loadItems(fileName2);

        ArrayList<Rocket> loadFleetU1Phase1 = simulation.loadU1(loadPhase1);
        ArrayList<Rocket> loadFleetU1Phase2 = simulation.loadU1(loadPhase2);

        ArrayList<Rocket> loadFleetU2Phase1 = simulation.loadU2(loadPhase1);
        ArrayList<Rocket> loadFleetU2Phase2 = simulation.loadU2(loadPhase2);

        int u1Phase1Budget = simulation.runSimulation(loadFleetU1Phase1);
        int u1Phase2Budget = simulation.runSimulation(loadFleetU1Phase2);

        int u2Phase1Budget = simulation.runSimulation(loadFleetU2Phase1);
        int u2Phase2Budget = simulation.runSimulation(loadFleetU2Phase2);

        System.out.println("The total Budget required for the U1 Phase-1 mission is $" + u1Phase1Budget + " Million");
        System.out.println("The total Budget required for the U1 Phase-2 mission is $" + u1Phase2Budget + " Million");
        System.out.println("The total Budget required for the U2 Phase-1 mission is $" + u2Phase1Budget + " Million");
        System.out.println("The total Budget required for the U2 Phase-2 mission is $" + u2Phase2Budget + " Million");
    }
}
