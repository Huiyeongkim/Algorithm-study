# 7주차: DFS (1012, 11725, 2668, 24480 ) Review

작성자 : 김희영

## DFS 문제
- 노드 간의 "하나 하나" 모든 관계를 알아야 할 때 사용한다.
- 재귀 또는 스택을 이용해 해결할 수 있다.
- 스택은 복잡하여 대부분 재귀를 이용해 해결한다.


## 1012 : 유기농 배추 
기초적인 이차 DFS 문제 (재귀를 이용해 해결)

```java
public static void DFS(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx>=0 && nx<M && ny>=0 && ny<N && !visited[nx][ny] && field[nx][ny]==1) {
                DFS(nx,ny);
            }
        }
    }
```

## 11725 : 트리의 부모 찾기
기초적인 DFS 문제  (재귀를 이용해 해결)

```java
public static void DFS(int node) {
        visited[node] = true;

        for (int a : tree[node]) {
            if (!visited[a]) {
                arr[a] = node;
                DFS(a);
            }
        }
    }
```

##  2668 : 숫자고르기 
 (재귀를 이용해 해결)
```java
public static void DFS(int start, int target) {
        if (!visited[arr[start]]) {
            visited[arr[start]] = true;
            DFS(arr[start], target);
        }
        if (arr[start] == target) list.add(target);
        visited[start] = false;
    }
```

##  24480 : 알고리즘 수업 - 깊이 우선 탐색 2
기초적인 DFS 연습문제 (재귀를 이용해 해결)

```java
public static void DFS(int R) {
        visited[R] = true;
        arr[R] = count++;

        for (int a : list[R]) {
            if (!visited[a]) {
                DFS(a);
            }
        }
    }
```
