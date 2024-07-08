package graph_5week;

import java.io.*;
import java.util.*;

public class BOJ_회장뽑기 {

    static ArrayList<Integer>[] graph;
    static int[] distance;
    static Map<Integer, Integer> resultDis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) break;
            graph[a].add(b);
            graph[b].add(a);
        }

        resultDis = new HashMap<>();  // 각 사람 별 점수 저장
        int minScore = Integer.MAX_VALUE;

        // 각 회원에 대해 BFS를 적용하여 점수 계산
        for (int i = 1; i <= N; i++) {
            int score = bfs(i);
            resultDis.put(i, score);  // <회원 번호, 점수>의 형태로 해시맵에 저장
            if (score < minScore) {
                minScore = score;  // 최소 점수 갱신
            }
        }

        // 최소 점수(minScore)를 가진 사람들을 찾아서 리스트에 추가
        List<Integer> keySet = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : resultDis.entrySet()) {
            if (entry.getValue() == minScore) {  // value 값이 최소 점수와 같은 사람들을 리스트에 추가
                keySet.add(entry.getKey());
            }
        }

        Collections.sort(keySet);  // 오름차순 정렬

        bw.write(minScore + " " + keySet.size() + "\n");
        for (int i : keySet) {
            bw.write(i + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();

    }

    private static int bfs(int start) {
        distance = new int[graph.length + 1];  // 시작하는 사람이 바뀔 때마다 distance 배열 초기화해야됨
        Arrays.fill(distance, -1);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (distance[next] != -1) continue;
                queue.add(next);
                distance[next] = distance[now] + 1;
            }
        }

        int maxDistance = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
            }
        }
        return maxDistance;
    }
}
