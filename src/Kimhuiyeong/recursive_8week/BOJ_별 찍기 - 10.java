import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i=0; i<N; i++) {
            Arrays.fill(arr[i],' ');
        }

        star(arr, 0, 0, N);

        for (int i=0; i<N; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void star(char[][] arr, int x, int y, int N) {
        if (N == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = N / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                star(arr, x + i * size, y + j * size, size);
            }
        }
    }
}
