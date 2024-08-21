# 6주차: BFS (10026, 2667, 7562, 7576) Review

작성자 : 김희영

## BFS 문제
- 노드의 최단 경로를 찾을 때 사용한다.
- 깊이 관련 특성을 가진다.
- 재귀적인 특성을 가지고 있지 않다. (DFS와 차이)
- 선입선출(FIFO) 원칙으로 탐색 -> 큐 사용


## 10026 : 적록색약
DFS와 BFS 둘 다 가능한 문제

- DFS
```java
public static void DFS(int x, int y) {
        visited[x][y] = true;
        char ch = arr[x][y];

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx< N && ny>=0 && ny< N && !visited[nx][ny] && arr[nx][ny]==ch) {
                DFS(nx,ny);
            }
        }
    }
```

- BFS
```java
static void bfs(int x, int y, boolean colorBlind) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;  // 시작점 방문 처리
        char startColor = graph[x][y];  // 시작점의 색상

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 그래프 범위 내에 있고, 방문하지 않은 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (colorBlind) {  // 적록색약인 경우
                        // 현재 색상이 R 또는 G이고, 다음 색상도 R 또는 G인 경우
                        if ((startColor == 'R' || startColor == 'G') && (graph[nx][ny] == 'R' || graph[nx][ny] == 'G')) {
                            visited[nx][ny] = true;  // 방문 처리
                            queue.add(new int[]{nx, ny});
                        } else if (graph[nx][ny] == startColor) {  // 만약에 시작 색상(현재 색상)이 B인 경우에는 B만 탐색을 하기 때문에 해당 조건이 필요.
                            visited[nx][ny] = true;  // 방문 처리
                            queue.add(new int[]{nx, ny});
                        }
                    } else {  // 적록색약이 아닌 경우
                        if (graph[nx][ny] == startColor) {  // 현재 색상과 시작 색상이 같은 경우
                            visited[nx][ny] = true;  // 방문 처리
                            queue.add(new int[]{nx, ny});  // 큐에 새로운 좌표 추가
                        }
                    }
                }
            }
        }
```



## 2667 : 단지번호붙이기
DFS와 BFS 둘 다 가능한 문제

- DFS
```java
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
```

- BFS
```java
public static int BFS(int a,int b,int matrixSize) {
		int size = 0; //한번들어올때마다 단지의 크기는 리셋 
	  int[] position = {-1,0,1,0,0,-1,0,1}; //상(-1,0) 하(1,0) 좌(-1,0) 우(0,1)
		Queue<index> q = new LinkedList<>();
    
		q.add(new index(a,b)); //첫 인덱스 삽입
		visited[a][b] = true;
		
		while(!q.isEmpty()) {
			
			index i = q.poll();
			size++;
      
      for(int i=0;i<8;i+=2) { //position 2개 원소가 쌍이니까 두칸씩 이동한다. 
				//상하좌우 순서에 맞게 변화된 인덱스, matrix[A][B]
				int A = i.a+position[i];  
				int B = i.b+position[i+1];
				
				if(0<=A && A<= n-1 && 0<=B && B<=n-1) { //index 넘어가지 않게 , 
					if(!nowVisited[A][B] ) {
						q.add(new index(A,B));
						Visited[A][B] = true;
					}
				}
			}

		}
		return size;	
	}
```

## 7562 : 나이트의 이동
방향을 일차원 배열 두 개를 가지고 풀지 않고 이차원 배열 하나를 가지고도 풀 수 있다.

```java
static final int[][] directions = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

...

public static void BFS(int x, int y, int l) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 8; i++) {
                int ox = nx + directions[i][0];
                int oy = ny + directions[i][1];

                if (ox >= 0 && oy >= 0 && ox < l && oy < l && !visited[ox][oy]) {
                    queue.add(new int[]{ox, oy});
                    arr[ox][oy] = arr[nx][ny] + 1;
                    visited[ox][oy] = true;
                }
            }
        }
    }
```


## 7576 : 토마토
```java
public static int BFS() {
        int answer = 0;

        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();
            answer = tomato[2];

            for(int j=0; j<4; j++) {
                int ox = tomato[0] + dx[j];
                int oy = tomato[1] + dy[j];

                if (ox >= 0 && oy >= 0 && ox < N && oy < M && arr[ox][oy] == 0) {
                    arr[ox][oy] = 1;
                    queue.add(new int[]{ox, oy, answer+1});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    return -1;
                }
            }
        }
        return answer;
    }
```


