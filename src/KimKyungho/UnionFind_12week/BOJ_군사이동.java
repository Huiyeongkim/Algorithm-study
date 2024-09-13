package UnionFind_12week;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 경로 상에 있는 길 중 너비가 가장 좁은 길의 너비를 최대화하는 경로를 선택
 * (경로를 병목 너비 기준으로 최적화하는 것으로 중복된 경로가 있더라도 그 경로의 병목 너비가 같으면 동일한 경로로 간주한다.)
 *
 * ex1) 3 -> 1 -> 2 -> 4 -> 5 (너비: 27, 16, 3, 5) => 병목 너비(가장 좁은 길의 너비) = 3
 * ex2) 3 -> 1 -> 0 -> 2 -> 4 -> 5 (너비: 27, 15, 23, 3, 50) => 병목 너비 = 3
 * ex3) 3 -> 4 -> 5 (너비: 14, 50) => 병목 너비 = 14
 * ex4) 3 -> 1 -> 2 -> 6 -> 5 (너비: 27, 16, 21, 42) => 병목 너비 = 16
 *
 *
 */
public class BOJ_군사이동 {

    static int p, w, c, v;
    static int [] parent, rank;
    static int max_value = Integer.MIN_VALUE;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());  // 지점
        w = Integer.parseInt(st.nextToken());  // 길

        parent = new int[p];
        rank = new int[p];

        // 부모 노드 초기화 (자기 자신을 가리킴)
        for (int i = 0; i < p; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());  // Baekjoon World의 수도
        v = Integer.parseInt(st.nextToken());  // Cube World의 수도

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            pq.add(new Edge(start, end, width));
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            union(edge.u, edge.v);
            // 모든 경로를 union하면서, c와 v가 서로 연결되어 있는지 확인한다.(같은 루트인지)
            if (find(c) == find(v)) {
                max_value = edge.cost;
                break;
            }
        }
        bw.write(max_value + "");
        bw.flush();
        bw.close();
    }

    // Edge로 값을 저장하면서 가중치를 기준으로 내림차순 정렬하면서 저장
    static class Edge implements Comparable<Edge> {
        int u, v, cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return o.cost - cost;
        }
    }

    static void union(int u, int v) {
        u = find(u);
        v = find(v);

        if (u != v) {
            if (rank[u] < rank[v]) {
                parent[u] = v;
            } else {
                parent[v] = u;
                if (rank[u] == rank[v]) {
                    rank[u]++;
                }
            }
        }
    }

    static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }
}
