import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] arr = new long[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        for (int i=0; i<m; i++) {
            long sum = arr[1] + arr[0];
            arr[0] = sum;
            arr[1] = sum;
            Arrays.sort(arr);
        }

        long result = 0;
        for (int i=0; i<n; i++) {
            result += arr[i];
        }
        System.out.println(result);
    }
}
