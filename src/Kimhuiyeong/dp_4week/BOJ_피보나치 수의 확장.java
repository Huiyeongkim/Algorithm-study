import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        // 음수 피보나치
        // n이 짝수이면 F(−n)=−F(n)
        // n이 홀수이면 F(−n)=F(n)
        long absN = Math.abs(n);
        long fib = Fibonacci(absN);

        if (n < 0 && absN % 2 == 0) {
            fib = -fib;
        }

        // 출력
        if (fib > 0) {
            System.out.println(1);
        } else if (fib == 0) {
            System.out.println(0);
        } else {
            System.out.println(-1);
        }

        System.out.println(Math.abs(fib));
    }

    static long Fibonacci(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0;
        long b = 1;

        for (long i = 2; i <= n; i++) {
            long sum = (a + b)% MOD;
            a = b;
            b = sum;
        }

        return b;
    }
}
