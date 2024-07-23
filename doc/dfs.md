# 깊이 우선 탐색 DFS (depth-first search)
작성자 : 김경호

<hr>

<center><img src="https://blog.kakaocdn.net/dn/eNkmuf/btsARTyTItR/39XMv9JRa8auK6Z7xPNjBK/img.gif" width="350"></center>

## 정의

가장 깊은 노드까지 방문한 후에 더 이상 방문할 노드가 없으면 최근 방문한 노드로 돌아온 다음, 해당 노드에서 방문할 노드가 있는지 확인한다.

## 해결 방식

> 시작 노드를 정하고, 스택에 시작 노드를 push 한다. 스택에 있는 노드는 아직 방문하지 않았지만 방문할 예정인 노드이다. 이후에는 아래의 과정을 반복한다.

1. 스택이 비어있는지 확인하고, 스택이 비어있다면 탐색을 종료한다. (비어있는 경우는 모든 노드를 방문했음을 의미함)
2. 스택이 노드를 pop 한다. pop한 원소는 최근에 스택에 push한 노드이다.
3. pop한 노드의 방문 여부를 확인하다. 아직 방문하지 않은 노드라면 노드를 방문처리 한다.
4. 방문한 노드와 인접한 모든 노드를 확인하고 그중에서 아직 방문하지 않은 노드를 스택에 push 한다. 스택은 LIFO 구조이므로 방문 순서를 오름차순으로 고려한다면 역순으로 노드를 push해야 한다. 
(내림차순으로 큰 노드의 값 부터 push 해야 나중에 pop할 때, 작은 노드부터 꺼냄. ex. 0의 인접 노드가 1, 2면 2,1 순서대로 Push를 해야 스택에서 pop할 때, 1, 2 순서대로 꺼냄)

> 고려 사항 : 탐색할 노드가 없을 때까지 간선을 타고 내려갈 수 있어야 하고, 가장 최근에 방문한 노드를 알아야 하며, 이미 방문한 노드인지 확인할 수 있어야 한다.

### 스택을 이용한 방식

<img src="https://www.algotree.org/images/DFS_Example_Run.svg">


### 재귀를 이용한 방식 (문제 풀이한거 보면 대부분 재귀를 사용)

<img src="https://velog.velcdn.com/images/kimjihong9/post/e69981ee-d833-47c9-932b-f6b4ebe2b697/image.png">

## 시간 복잡도

- 인접 행렬로 구현 시, O(V^2)
- 인접 리스트로 구현 시, O(V + E)

## 결론

- 모든 가능한 해를 찾는 백트래킹 알고리즘을 구현할 때나 그래프의 사이클을 감지해야 하는 경우 활용
- 코테에서는 탐색을 해야할 때, 최단 경로를 찾는 문제가 아니라면 dfs를 우선 고려하는 것이 좋음

<br>
<br>

[출처]<br>

https://www.algotree.org/algorithms/tree_graph_traversal/depth_first_search/
https://velog.io/@kimjihong9/%EA%B9%8A%EC%9D%B4-%EC%9A%B0%EC%84%A0-%ED%83%90%EC%83%89DFS
https://www.algotree.org/algorithms/tree_graph_traversal/depth_first_search/
