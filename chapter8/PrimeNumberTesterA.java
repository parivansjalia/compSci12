public class PrimeNumberTesterA {
    // Modify one of the versions of the isPrime method on page
    // 200 so that if the argument is not 2 it tests only odd
    // numbers as potential factors of n.

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int m = 3; m * m <= n; m = m + 2) {
            if (n % m == 0) {
                return false;
            }
        }
        return true;
    }
}
