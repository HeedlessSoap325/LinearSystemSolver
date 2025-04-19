package de.heedlesssoap;

public class Gauss {
    public static void solve(double[][] system, int numVars, String[] varNames) {
        system = reorderSystem(system, numVars);

        System.out.println("Reordered System:");
        IOHandler.printSystem(system, numVars, varNames);
    }

    private static double[][] reorderSystem(double[][] oldSystem, int numVars) {
        double[][] newSystem = oldSystem.clone();
        for (int row = 0; row < numVars; row++) {
            for (int col = 0; col < numVars; col++) {
                if (oldSystem[row][col] == 0) {
                    break;
                }
                double[] tempFirstRow = oldSystem[0];
                newSystem[0] = oldSystem[row];
                newSystem[row] = tempFirstRow;
                return newSystem;
            }
        }
        return newSystem;
    }
}
