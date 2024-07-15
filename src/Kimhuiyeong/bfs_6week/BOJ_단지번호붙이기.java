import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static int dx[] = {0,0,-1,1};
    private static int dy[] = {-1,1,0,0};
    static int N;
    static int count;
    static boolean[][] visited;
    static int[][] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        home = new int[N][N];
        List<Integer> list = new LinkedList<>();
        count = 1;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                home[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (home[i][j] == 1 && !visited[i][j]) {
                    DFS(i, j);
                    list.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && home[nx][ny]==1) {
                count++;
                DFS(nx,ny);
            }
        }
    }
}
