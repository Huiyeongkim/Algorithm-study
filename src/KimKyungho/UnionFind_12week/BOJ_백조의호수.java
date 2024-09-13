package UnionFind_12week;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 호수는 차례대로 녹는데, 매일 물 공간과 접촉한 모든 빙판은 녹는다(가로 세로 인접)
 * 백조는 오직 물 공간에서 세로, 가로로만 움직일 수 있다.(백조는 물에서 시작함)
 *
 * 하루가 지날 때마다, bfs로 상대 백조와 만날 수 있는지 검증이 필요할 듯
 * 아니면 A백조가 위치한 집합과 B백조가 위치한 집합이 하나로 합쳐지는 시점을 확인 - union-find
 */

public class BOJ_백조의호수 {

    static int R, C;
    static char [][] map;
    static int answer = 0;

    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    static int [] parent;
    static boolean [][] visited;
    static Node firstSwan = null;
    static Node secondSwan = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());  // 행
        C = Integer.parseInt(st.nextToken());  // 열

        map = new char[R][C];
        parent = new int[R * C];  // R * N 개의 그룹이 있다.
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);

                parent[i * C + j] = i * C + j;  // parent를 자기 자신을 가리키도록 하여 초기화(각 노드에 인덱스 번호를 부여함)
                if (map[i][j] == 'L' && firstSwan == null) {  // 첫 번째 백조의 위치
                    firstSwan = new Node(i, j);  // 1번 백조의 위치를 기록하고,
                    map[i][j] = '.';  // 백조가 위치한 곳도 물이며, firstSwan에 백조의 위치를 저장했으므로 map[i][j]에는 물(.)을 저장하여 덮는다.
                } else if (map[i][j] == 'L' && secondSwan == null) {
                    secondSwan = new Node(i, j);  // 2번 백조의 위치 기록
                    map[i][j] = '.';
                }
            }
        }

        Queue<Node> waterQ = new LinkedList<>();
        // 처음 시작점에서 물의 위치를 저장하고, 각 그룹들을 나눠주기 위한 작업을 처리한다.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X')
                    continue;  // 빙판일 경우, 넘어간다.
                for (int dir = 0; dir < 4; dir++) {
                    int nextR = i + dx[dir];
                    int nextC = j + dy[dir];

                    if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C)
                        continue;
                    if (map[nextR][nextC] == '.' || map[nextR][nextC] == 'L') {
                        union(i * C + j, nextR * C + nextC);
                    } else if (map[nextR][nextC] == 'X' && !visited[nextR][nextC]) {
                        waterQ.add(new Node(nextR, nextC));
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }

        while (find(firstSwan.r * C + firstSwan.c) != find(secondSwan.r * C + secondSwan.c)) {

            visited = new boolean[R][C];
            Queue<Node> waterNextQ = new LinkedList<>();  // 다음에 녹을 빙판의 위치
            while(!waterQ.isEmpty()) {
                Node temp = waterQ.poll();
                int r = temp.r;
                int c = temp.c;

                map[r][c] = '.';  // waterQ는 다음에 녹을 빙판의 위치를 저장한 것이므로 바로 녹여준다.

                for (int dir = 0; dir < 4; dir++) {
                    int nextR = r + dx[dir];
                    int nextC = c + dy[dir];

                    if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C)
                        continue;
                    // 만약, 상하좌우에 물이 있을 경우, 해당 그룹을 맞춰준다.
                    if (map[nextR][nextC] == '.' || map[nextR][nextC] == 'L') {
                        union(r * C + c, nextR * C + nextC);
                    } else if (map[nextR][nextC] == 'X' && !visited[nextR][nextC]) {
                        waterNextQ.add(new Node(nextR, nextC));
                        visited[nextR][nextC] = true;
                    }
                }
            }
            waterQ = waterNextQ;
            answer += 1;
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    // 특정 원소가 속한 집합을 찾는다.
    static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    // 두 원소가 속한 집합을 합친다.
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}

class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}