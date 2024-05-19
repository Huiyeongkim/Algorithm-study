import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st ;
        long[][] arr = new long[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingLong(o -> o[0]));

        long answer = 0;
        long k = arr[0][0]-1;
        for (int i = 0; i < N; i++) {
            long start = arr[i][0];
            long end = arr[i][1];
            if (start > k) {
                answer += end - start;
                k = end;
            } else if (end > k) {
                answer += end - k;
                k = end;
            }
        }
        System.out.println(answer);
    }
}
