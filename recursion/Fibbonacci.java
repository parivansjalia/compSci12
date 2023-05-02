public class Fibbonacci {
    public static void main(String[] args) {
        fibonacci(8);
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 0) {
            return n;
        } else {
            System.out.println(n);
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}