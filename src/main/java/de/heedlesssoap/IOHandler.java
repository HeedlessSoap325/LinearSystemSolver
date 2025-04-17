package de.heedlesssoap;

import java.text.DecimalFormat;
import java.util.Scanner;

public class IOHandler {
    public static void queryInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of variables: ");
        int numVars = scanner.nextInt();

        double[][] system = new double[numVars][numVars + 1];
        String[] varNames = new String[numVars];

        for (int i = 0; i < numVars; i++) {
            System.out.printf("Please Enter the Name of Variable number %d: ", i + 1);
            varNames[i] = scanner.next();
        }

        System.out.println("Please Enter the coefficients of each variable in each row:");
        for (int row = 0; row < numVars; row++) {
            for(int col = 0; col <= numVars; col++) {
                if(col == numVars) {
                    System.out.printf("Row %d Constant = ", row + 1);
                }else {
                    System.out.printf("Row %d Variable %s = ", row + 1, varNames[col]);
                }
                system[row][col] = scanner.nextDouble();
            }
        }

        printSystem(system, numVars, varNames);

        //TODO Gauss.solve(a, n);
        scanner.close();
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
}
