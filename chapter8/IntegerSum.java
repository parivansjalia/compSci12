import java.util.Scanner;

public class IntegerSum {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a number that is a postive integer under 10");
        int number = myObj.nextInt();
        String print = intSum(number);
        System.out.println(print);
    }

    private static String intSum(int num) {
        int i = 2;
        int tempTotal = 1;
        String finalPrint = "1";
        if (num > 0) {
            while (i <= num) {
                finalPrint = finalPrint + " + " + i;
                tempTotal = tempTotal + i;
                i++;
            }
            finalPrint += " = " + tempTotal;
        }

        else {
            finalPrint = "0";
        }

        return finalPrint;
    }
}
