import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

// Finish the program GradeAvg. java, which reads integer scores 
// from a file called scores.dat and prints out their average.
// Hint: If input is a Scanner object associated with a file, 
// input.hasNextlnt () returns true if there is an integer value left 
// unread in the file; otherwise it returns false; input.nextInt () 
// returns the 'next integer read from the file.

public class GradeAvg {
    public static void main(String[] args) {
        Scanner input = null;
        // DecimalFormat df = new DecimalFormat("0.00";)
        try {
            input = new Scanner(new File("scores.dat"));
        } catch (FileNotFoundException e) {
            System.out.println("***  Can't open scores.dat ***");
            System.exit(1);
        }

        double total = 0;
        int numOfGrades = 0;

        while (input.hasNextInt()) {
            total += input.nextInt();
            numOfGrades++;
        }

        System.out.println("Avg:" + (int) ((total / numOfGrades) + 0.5));

    }
}