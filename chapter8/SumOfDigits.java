import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a number that is a postive integer");
        int number = myObj.nextInt();
        int print = sumDigits(number);
        System.out.println(print);
    }

    public static int sumDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
