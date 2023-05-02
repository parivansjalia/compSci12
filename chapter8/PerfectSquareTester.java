import java.util.Scanner;

public class PerfectSquareTester {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = myObj.nextInt();
        System.out.println(isPerfectSquare(number));
    }

    public static boolean isPerfectSquare(int n) {
        if (n == 0) {
            return true;
        }
        if (n < 0) {
            return false;
        }
        int temp = 0;
        for (int i = 1; temp < n; i += 2) {
            temp += i;
        }
        if (temp == n) {
            return true;
        }

        return false;
    }
}
