# 너비 우선 탐색 BFS (Breadth-First Search)
작성자 : 김희영
<hr>

![image](https://github.com/user-attachments/assets/4a938ea9-07ba-48d5-8693-375eb1637181)


## 정의

<b>루트 노드(혹은 다른 임의의 노드)에서 시작해서 인접한 노드를 먼저 탐색한다.
-> 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 사용한다.

## BFS vs DFS 
(1) 깊이 우선 탐색 DFS
  - 노드 간의 "하나 하나" 모든 관계를 알아야 할 때 사용한다. 
  - 재귀적인 특성을 가진다.
(2) 너비 우선 탐색 BFS
  - 노드의 최단 경로를 찾을 때 사용한다.
  - 깊이 관련 특성을 가진다.


## 방식
대부분 큐(Queue)를 사용하여 해결한다.
처음 노드를 큐에 삽입한 후 노드와 관련된 노드로 이동할 경우 그 노드를 큐에서 삭제한다. 쭉 관련 노드를 넣고 나아간 노드는 삭제하는 방식으로 진행된다.


![image](https://github.com/user-attachments/assets/0ae0c37d-28a4-4691-95ea-7033292f7096)
출처 : https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html

