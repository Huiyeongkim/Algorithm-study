import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.*;



public class Main {
    static int N;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>(); //인접 리스트 그래프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        
        //노드 번호 1~N 이므로,  visited와 graph의 인덱스 설정
        visited=new boolean[N+1];
        graph.add(null);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        while(true){
            st=new StringTokenizer(br.readLine());
            int u=parseInt(st.nextToken());
            int v=parseInt(st.nextToken());

            if(u==-1 && v==-1) break;

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<Node> result = new ArrayList<>();

        //노드마다 BFS를 돌리며, BFS level 카운팅
        for(int i=1; i<=N; i++){
            Node node = new Node(i, bfs(i));
            result.add(node);
        }

        //level 오름차순 정렬
        Collections.sort(result, Comparator.comparingInt(n -> n.level));

        int minVal=result.get(0).level;

        //level 이 최소값인 것만 필터링
        result = result.stream().filter(n -> n.level == minVal).collect(Collectors.toList());

        //정답 출력
        System.out.println(minVal+" "+result.size());
        result.forEach(n-> System.out.print(n.number+" "));

        br.close();
    }

    static int bfs(int start){
        Arrays.fill(visited, false);

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, 0));
        visited[start]=true;

        int result=0;

        while(!queue.isEmpty()){
            Node current=queue.poll();

            for(Integer next:graph.get(current.number)){
                if(!visited[next]){
                    visited[next]=true;
                    queue.offer(new Node(next, current.level+1));
                }
            }

            result=current.level;
        }

        return result;
    }

    static class Node{
        int number, level;

        public Node(int number, int level) {
            this.number = number;
            this.level = level;
        }
    }
}
