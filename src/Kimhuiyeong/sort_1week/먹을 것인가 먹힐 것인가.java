import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] Narr = new int[N];
            int[] Marr = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Narr[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Marr[j] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            Arrays.sort(Narr);
            Arrays.sort(Marr);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (Narr[j] > Marr[k]) count++;
                    else 
                        break;
                }
            }
            System.out.println(count);
        }
    }
}
