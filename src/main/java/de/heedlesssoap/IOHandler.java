package de.heedlesssoap;

import java.text.DecimalFormat;
import java.util.Scanner;

public class IOHandler {
    public static void queryInput() {
        Scanner scanner = new Scanner(System.in);
        clearConsole();

        System.out.print("Enter the number of variables: ");
        int numVars = scanner.nextInt();
        clearConsole();

        double[][] system = new double[numVars][numVars + 1];
        String[] varNames = new String[numVars];

        for (int i = 0; i < numVars; i++) {
            System.out.printf("Please Enter the Name of Variable number %d: ", i + 1);
            varNames[i] = scanner.next();
            clearConsole();
        }

        for (int row = 0; row < numVars; row++) {
            for(int col = 0; col <= numVars; col++) {
                if(col == numVars) {
                    System.out.printf("Constant in Equation %d: ", row + 1);
                }else {
                    System.out.printf("Coefficient of Variable %s in Equation %s: ", varNames[col], row + 1);
                }
                system[row][col] = scanner.nextDouble();
                clearConsole();
            }
        }

        System.out.println("You have entered the following System:\n");
        printSystem(system, numVars, varNames);
        System.out.println();

        System.out.print("Solve this System? (y or n): ");

        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                clearConsole();
                Gauss.solve(system, numVars, varNames);
                break;
            }else if(input.equalsIgnoreCase("n")) {
                clearConsole();
                queryInput();
                break;
            }else {
                System.out.print("Invalide Input! Try again: ");
            }
        }

        scanner.close();
    }

    private static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }

    public static void printSystem(double[][] system, int numVars , String[] varNames) {
        for (int row = 0; row < numVars; row++) {
            StringBuilder formattedRow = new StringBuilder();

            for(int col = 0; col < numVars; col++) {
                String sign;
                if(col == 0){
                    sign = system[row][col] >= 0.0 ? "" : "- ";
                }else {
                    sign = system[row][col] >= 0.0 ? " + " : " - ";
                }

                double value = Math.abs(system[row][col]);
                if (value == 0.0) {
                    formattedRow.append(String.format("%s%s", sign, "0"));
                } else if (value == 1.0) {
                    formattedRow.append(String.format("%s%s", sign, varNames[col]));

                }else {
                    String num = new DecimalFormat("#.##########").format(value);

                    formattedRow.append(String.format("%s%s%s", sign, num, varNames[col]));
                }
            }
            String num = new DecimalFormat("#.##########").format(system[row][numVars]);

            formattedRow.append(String.format(" = %s", num));
            System.out.println(formattedRow);
        }
    }

    public static void printSeparationLine(){
        System.out.println("-".repeat(70));
    }
}
