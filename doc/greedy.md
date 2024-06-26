# greedy
작성자 : 윤예은

### 정의 

최적의 값을 구해야 하는 상황에서 사용되는 근시안적인 방법론으로

‘각 단계에서 최적이라고 생각되는 것을 선택’ 해 나가는 방식으로 진행하여 최종적인 해답에 도달하는 알고리즘

### 조건 1. 탐욕 선택 속성

단계에서 '최선의 선택'을 했을 때 전체 문제에 대한 최적해를 구할 수 있는 경우
정리, 각 단계에서 최선의 선택 -> 전체의 이상적인 결과

### 조건 2. 최적 부분 구조 

전체 구조가 부분 문제들의 최적으로 구성


위의 조건 1,2 를 모두 만족하는 경우에 사용가능하다. 
조건을 만족하지 않는다면 그리디 알고리즘은 최적의 해를 보장하지 못한다. 

### 주의 사항
항상 최적의 값을 보장하는것이 아니라 최적의 값의 ‘근사한 값’을 목표로 한다.

### greedy step

1. 문제의 최적해 구조 결정
2. 선택 절차 정의
3. 2.번에 따라서 선택 수행
4. 선택된 해가 문제의 조건 만족하는지 적절성 검사
5. 4.에 해당안될 시 제외
6. 모든 선택 끝난 뒤 검사
   

### 6. 시간복잡도 O(n)

