import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(mod(A, B, C));
    }

    public static long mod(int A, int B, int C) {
        long answer = A % C;
        if (B == 0) return 1;
        else if (B == 1) return answer;
        else {
            answer = mod(A, B / 2, C);
            answer = (answer * answer) %C;
            if (B%2 != 0 ) answer = answer *A %C;
            return answer;
        }
    }
}
