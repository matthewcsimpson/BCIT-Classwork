public class fibonacci {

    /**
     * Computes the n-th Fibonacci number using dynamic programming.
     * @param n the position in the Fibonacci sequence (0-indexed)
     * @return the n-th Fibonacci number
     */
    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

    public static void main(String[] args) {
        System.out.println("fibo(3) = " + fibo(3));
        System.out.println("fibo(7) = " + fibo(7));
        System.out.println("fibo(5) = " + fibo(5));
    }
}