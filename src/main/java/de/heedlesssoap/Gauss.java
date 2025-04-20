package de.heedlesssoap;

public class Gauss {
    public static void solve(double[][] system, int numVars, String[] varNames) {
        reorderSystem(system, numVars);

        System.out.println("Reordered System:");
        IOHandler.printSystem(system, numVars, varNames);
        IOHandler.printSeparationLine();

        triangulateSystem(system, numVars, varNames);

        System.out.println("Triangulated System:");
        IOHandler.printSystem(system, numVars, varNames);
        IOHandler.printSeparationLine();
    }

    private static void reorderSystem(double[][] system, int numVars) {
        for (int row = 0; row < numVars; row++) {
            for (int col = 0; col < numVars; col++) {
                if (system[row][col] == 0) {
                    break;
                }
                double[] tempFirstRow = system[0];
                system[0] = system[row];
                system[row] = tempFirstRow;
                return;
            }
        }
    }

    private static void triangulateSystem(double[][] system, int numVars, String[] varNames) {
        for (int i = 1; i < numVars; i++) {
            eliminateVariableFromEachRow(system, i, i - 1,numVars);
            System.out.printf("System after eliminating Variable %s:%n",varNames[i - 1]);
            IOHandler.printSystem(system, numVars, varNames);
            IOHandler.printSeparationLine();
        }
    }

    private static void eliminateVariableFromEachRow(double[][] system, int startRow, int startCol, int numVars) {
        for (int row = startRow; row < numVars; row++) {
            double factor = system[row][startCol] / system[startRow - 1][startCol];
            if(system[row][startCol] == 0) {
                continue;
            }
            for (int col = startCol; col < numVars + 1; col++) {
                system[row][col] -= system[startRow - 1][col] * factor;
            }
        }
    }

    private static double[] backSubstitution(double[][] system, int numVars) {
        double[] solutions = new double[numVars];
        for(int i = numVars - 1; i >= 0; i--) {
            for (int varIdx = numVars - 1; varIdx > i; varIdx--) {
                system[i][numVars] -= system[i][varIdx] * solutions[varIdx];
            }
            solutions[i] = system[i][numVars] / system[i][i];
        }
        return solutions;
    }
}