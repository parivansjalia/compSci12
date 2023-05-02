package lab_perfect_numbers;

public class MyMath {
  /**
   * Returns the sum of all integers from 1 to n, if n >= 1,
   * and 0 otherwise.
   */
  public static int sumUpTo(int n) {
    int sum = 0;

    for (int i = 1; i <= n; i++)
      sum += i;

    return sum;
  }

  /**
   * Returns 1 * 2 * ... * n, if n >= 1; otherwise returns 1
   */
  public static long factorial(int n) {
    long f = 1;

    for (int k = 2; k <= n; k++)
      f *= k;

    return f;
  }

  /**
   * Returns true if n is a prime; otherwise returns false
   */
  public static boolean isPrime(int n) {

    if (n < 2) {
      return false;
    }
    for (int m = 2; m * m <= n; m++) {
      if (n % m == 0) {
        return false;
      }
    }
    return true;
  }
  // Fill in your solution here.
  // For added efficiency, try to only loop up to the sqrt of n.}

  /**
   * Returns true if n is a perfect number, false otherwise
   */

  public static boolean isPerfect(int n) {
    int divsors = 0;
    for (int i = 0; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        divsors += i;
      }
    }

    if (n == divsors) {
      return true;
    } else {
      return false;
    }

    // Do not use Euclid's method to generate perfect numbers here.
  }

  /**
   * Prints the first n perfect numbers
   */
  public static void printPerfectNums(int n) {
    System.out.println("Perfect numbers: ");
    int i = 0;
    while (i < n) {
      if (isPerfect(n)) {
        System.out.println(n);
        i++;
      }
    }
  }

  /**
   * Prints the first n Mersenne primes
   */
  public static void printMersennePrimes(int n) {
    System.out.println("Mersenne primes: ");

    for (int i = 0; i < n; i++) {

      System.out.println(Math.pow(2, i) - 1); // 2^i - 1
    }
  }

  /**
   * Prints the first n even perfect numbers
   */
  public static void printEvenPerfectNums(int n) {
    System.out.println("Even perfect numbers: ");
    int pow2 = 1;
    int count = 0;

    while (count < n) {
      if (isPrime((pow2 - 1))) {
        System.out.println((long) (pow2 - 1) * (pow2 / 2));
        count++;
      }
      pow2 *= 2;
    }
  }

  /*********************************************************************/

  public static void main(String[] args) {
    // /Scanner kb = new Scanner(System.in);
    // int n;

    // do {
    // System.out.print("Enter an integer from 4 to 20: ");
    // n = kb.nextInt();
    // } while (n < 4 || n > 20);

    // System.out.println();
    // System.out.println("1 + ... + " + n + " = " + sumUpTo(n));
    // System.out.println(n + "! = " + factorial(n));

  }
}
