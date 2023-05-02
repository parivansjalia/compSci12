import java.util.Scanner;

public class testPrep {

    public static void main(String[] args) {
        int result = 0;
        while (result < 5)
            ;
        result++;
        System.out.print(result);
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = myObj.nextInt();
        System.out.println(isPerfectSquare(number));
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i * i;
        }
        System.out.println(sum);

        Scanner myObjj = new Scanner(System.in); // Read an integer
        int n = myObjj.nextInt();
        while (n > 0 && Math.sqrt(n) < 10)

            n++;

        System.out.println(n);
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