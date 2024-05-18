import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[][] arr = new String[N][4];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
            arr[i][3] = st.nextToken();
        }

        Arrays.sort(arr, ((o1, o2) -> {
            if (Integer.parseInt(o2[1]) < Integer.parseInt(o1[1])) return -1;
            else if (Integer.parseInt(o2[1]) == Integer.parseInt(o1[1])) {
                if (Integer.parseInt(o2[2]) > Integer.parseInt(o1[2])) return -1;
                else if (Integer.parseInt(o2[2]) == Integer.parseInt(o1[2])) {
                    if (Integer.parseInt(o2[3]) < Integer.parseInt(o1[3])) return -1;
                    else if (Integer.parseInt(o2[3]) == Integer.parseInt(o1[3])) return o1[0].compareTo(o2[0]);
                }
            }
            return 1;
        }));
        for (int i=0; i<N; i++) {
            System.out.println(arr[i][0]);
        }
    }
}
