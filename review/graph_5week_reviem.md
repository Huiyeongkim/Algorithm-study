# 5주차: graph (1043, 2660, 6118, 5567) Review

작성자 : 윤예은


## graph 종류
1. 방향 그래프 vs 무방향 그래프 
2. 가중치 유무

## 구현 

1. 인접 리스트
각 정점과 연결된 모든 정점의 리스트 저장 -> 인접한 정점 바로 알 수 있음.

2. 인접 행렬
정점의 개수인 v * v의 2차원 배열을 사용해 노드간의 연결 관계를 행렬 형태로 나타냄.

## 그래프 알고리즘
1. 그래프 탐색 알고리즘
2. BFS(너비 우선 탐색)와 
3. DFS(깊이 우선 탐색이 있음)
4. 최단 경로 알고리즘
5. 가중치가 있는 그래프에서 두 정점 간 최소 가중치의 합을 찾는 알고리즘 
  ex) 다익스트라 알고리즘, 벨만 포드 알고리즘, 플로이드 알고리즘
6. 그 외(위상 정렬, 최소 신장 트리 알고리즘 등)



# 회장뽑기.java 
: 인접리스트로 bfs 구현
~~~
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
~~~

# 결혼식 (무방향 -> 양방향그래프로 표헌, 인정 행렬로 구현)

~~~
while(!q.isEmpty()) {
				int now = q.poll(); //상근이 친구들, 예시 기준 : 2, 3
				
				for(int i=0;i<list[now].size();i++) { //예시 기준 list[2],list[3]안의 친구들까지만 카운트
					int friend = list[now].get(i);
					if(!visited[friend]) {
						countFriends++;
			      visited[friend] = true;
					}
				}
			}
			
			System.out.println(countFriends);
~~~

# 거짓말 : union/find 알고리즘 구현 
~~~
private static void union(int a,int b) {
		
		a = find(a);
		b = find(b);  //대표들
		
		if(a!=b) {
			int small; int large;
			if(knowTruth.contains(a)) {
			
				small = a;
				large = b;
			}else if(knowTruth.contains(b)){
				
				small =b ;
				large = a;
			}else {
				small = Math.min(a, b);
				large = Math.max(a, b);
			}
				
			for(int i=1;i<parents.length;i++) {
				if(i==large) continue;
				if(parents[i] == parents[large]) 
					parents[i] = parents[small];
			}
			
			parents[large] = parents[small];
			//System.out.println(parents[large]+","+large);
		}else {
			return;
		}
		
		
		
		
	
	}
	
	private static int find(int a) {
		if(knowTruth.contains(a)) {
			return parents[a] = a;

		}
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}
~~~


#숨바꼭질 (무방향 -> 양방향 그래프 구현, bfs로 구현)
~~~
 static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        visited[1] = true;

        while(!q.isEmpty()){
            Node a = q.poll();

            maxLen = Math.max(maxLen, a.len);
            lenArray[a.vertex] = a.len;

            for(int i = 0; i<l.get(a.vertex).size(); i++){
                int nextV = l.get(a.vertex).get(i);

                if(visited[nextV])
                    continue;

                q.offer(new Node(nextV, a.len+1));
                visited[nextV] = true;
            }
        }
    }
}
~~~
