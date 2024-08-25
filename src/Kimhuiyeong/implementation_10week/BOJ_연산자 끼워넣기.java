import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] mat;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        mat = new int[4];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            mat[i] = Integer.parseInt(st.nextToken());
        }

        func(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static void func(int num, int idx) {
        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (mat[i] > 0) {
                mat[i]--;

                switch (i) {
                    case 0:	func(num + arr[idx], idx + 1);	break;
                    case 1:	func(num - arr[idx], idx + 1);	break;
                    case 2:	func(num * arr[idx], idx + 1);	break;
                    case 3:	func(num / arr[idx], idx + 1);	break;

                }
                mat[i]++;
            }
        }
    }
}
