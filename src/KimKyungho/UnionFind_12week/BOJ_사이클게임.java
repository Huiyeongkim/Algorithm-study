package UnionFind_12week;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [문제]
 * - 0부터 n-1 까지의 고유한 번호가 부여된 평면상의 점 n개가 주어지며, 이 중 어느 세 점도 일직선 위에 놓이지 않는다.
 * - 매 차례마다 이를 잇는 선분을 긋는다. -> 이전에 그은 선분을 다시 그을 수 없으며, 이미 그린 선분과 교차는 가능하다.
 * - 처음으로 사이클이 완성되는 순간 게임 종료
 * - 게임의 진행 상황이 주어지면 몇 번째 차례에서 사이클이 완성 되었는지를 판단하고, 혹은 게임이 진행 중인지를 판단하는 프로그램을 작성해라!
 * [접근]
 * 사이클이 발생하는 구간을 구하는 방법은?
 * union-find로 두 정점이 주어지면 해당 부모가 일치하는지 일단 확인하고, 만약 일치한다면 사이클이 생성된거임(사이클은 부모가 자기 자신이 되니까)
 * 그럼 union(x, y) 햇을 때, 서로 다른 부모를 갖고 있으면?
 * 그냥 두 정점을 연결하면 될듯...
 */

public class BOJ_사이클게임 {

    static int n, m;
    static int [] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (find(x) == find(y)) {  // 부모가 같아지므로, 사이클이 형성됨
                bw.write(i + 1 + "");
                bw.flush();
                bw.close();  // 출력하고 종료
                return;
            } else {
                union(x, y);
            }
        }
        bw.write("0");
        bw.flush();
        bw.close();
    }

    static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else
            parent[x] = y;
    }
}
