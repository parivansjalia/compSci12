public class MakeChange {
    // Write and test a method that takes an amount
    // in cents and prints out all possible representations of that amount
    // as a sum of several quarters, dimes,nickels, and pennies. For example:
    // 30 cents = 0 quarters + 2 dimes + 1 nickels + 5 pennies
    // (There are 18 different representations for 30 cents and 242 for $1.00.

    public static void main(String[] args) {
        possibleChange(30);
    }

    public static void possibleChange(int cents) {
        System.out.println("Q  D  N  P");

        for (int quarters = 0; quarters * 25 <= cents; quarters++) {
            for (int dimes = 0; dimes * 10 <= cents - quarters * 25; dimes++) {
                for (int nickels = 0; nickels * 5 <= cents - quarters * 25 - dimes * 10; nickels++) {
                    int pennies = cents - quarters * 25 - dimes * 10 - nickels * 5;
                    System.out.println(quarters + "  " + dimes + "  " + nickels + "  " + pennies);
                }
            }
        }
    }
}
