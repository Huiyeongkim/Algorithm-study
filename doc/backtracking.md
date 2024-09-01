# 백트래킹 (Backtracking)
작성자 : 김경호

<hr>

<center><img src="https://upload.wikimedia.org/wikipedia/commons/8/8c/Sudoku_solved_by_bactracking.gif" width="350"></center>

## 백트래킹이란??

재귀적으로 문제를 하나씩 풀어가면서 현재 재귀를 통해 확인 중의 노드가 <b><i>제한된 조건에 위배되는지 판단하고, 만약 해당 노드가 제한된 조건을 위배한다면 그 노드를 제외하고 다음 단계로 나아가는 방식</i></b>이다.



백트래킹은 현재 상태에서 다음 상태로 가는 모든 경우의 수를 찾아서 <u>이 모든 경우의 수가 더 이상 유망하지 않다고 판단되면</u> 이전의 상태로 돌아간다.<br>

> 더 이상 탐색할 필요가 없는 상태를 제외시키는 것(밑줄친 부분) → 가지치기(pruning)

<center><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbbeA4b%2FbtrVq3aIe0N%2F2KqqnpuHQKfrffN8N6qGP1%2Fimg.png" width="600"></center>

DFS 또한 백트래킹의 방법 중 하나로 DFS를 진행하면서 조건에 맞지 않는다면 하위 노드는 탐색하지 않고, 가지치기를 통해 부모 노드로 돌아가서 다음 노드의 탐색을 진행한다.

---

출처

https://cobi-98.tistory.com/22  
https://youngdroidstudy.tistory.com/entry/%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9-%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9%EC%9D%98-%EC%84%A4%EB%AA%85%EA%B3%BC-%EA%B0%84%EB%8B%A8%ED%95%9C-%EC%98%88%EC%A0%9C%ED%92%80%EC%9D%B4
https://commons.wikimedia.org/wiki/File:Sudoku_solved_by_bactracking.gif