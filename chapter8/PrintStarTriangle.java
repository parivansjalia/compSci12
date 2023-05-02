import java.util.Scanner;

public class PrintStarTriangle {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = myObj.nextInt();
        printStarTriangle(number);
    }

    public static void printStarTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int k = n - i; k > 0; k--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
