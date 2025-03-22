# 2주차: greedy (2170, 11000, 15903, 1931) Review

작성자 : 김희영

## greedy 알고리즘
: 현재 상태에서 볼 수 있는 선택지 중에 최선의 선택을 하는 알고리즘. 

장점 : 동적 계획법보다 구현하기 쉽고 시간 복잡도가 좋다. 

단점 : 항상 최적의 해를 보장하지 못한다.

<br>

## greedy 알고리즘 수행 과정
1. 해 선택 : 현재 상태에서의 최적의 해답을 선택한다.
2. 적절성 검사 : 선택된 해가 문제의 제약 조건을 만족하는지 검사한다.
3. 해답 검사 : 원래의 문제가 해결되었는지 검사하고, 해결되지 않았다면 1번으로 돌아가 위의 과정을 반복한다.

"가장 작은 순대로", "가장 큰 순서대로" 라는 말이 있으면 그리디 알고리즘일 가능성이 높다. 

대부분 문제 조건에 맞추어 정렬을 한 후 알고리즘 과정을 수행한다.

<br>

## 2170: 선 긋기
문제 조건에 맞추어 정렬을 한 후 그리디 알고리즘 과정을 수행한다.

```java
Arrays.sort(arr, new Comparator<int[]>() { 
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

int start = arr[0][0];
int end = arr[0][1];
int length = end - start;
for (int i = 1; i < N; i++) {
  if (start <= arr[i][0] && end >= arr[i][1]) {  // 선이 완전히 겹치는 경우(포함된 경우)
    continue;
  } else if (arr[i][0] < end) {  // 현재 선의 시작 부분이 이전 선에 포함된다면
    length += arr[i][1] - end;  // 길이에 증가된 길이만큼 추가
  } else {  // 현재 선 밖으로 나간 경우(겹치지 않는 경우)
    length += arr[i][1] - arr[i][0];
  }
  start = arr[i][0];  // 다음 루프에서 비교될 현재 선을 짖정
  end = arr[i][1];
}
```

## 11000 : 강의실 배정
문제 조건에 맞추어 정렬을 한 후 그리디 알고리즘 과정을 수행한다.

> <b> Priority Queue</b><br>
> : 우선순위 큐의 경우 들어가는 순서와는 상관없이 우선순위가 높은 데이터가 먼저 나가는 자료구조  

```java
Arrays.sort(arr, new Comparator<int[]>() {  // 시작 시간을 기준으로 오름차순으로 정렬하고, 만약 시작 시간이 같다면 종료 시간을 기준으로 오름차순 한다.
  public int compare(int [] o1, int [] o2) {
  if (o1[0] == o2[0]) {
    return o1[1] - o2[1];  // 시작 시간이 같으면 종료 시간을 기준으로 오름차순
  } else {
    return o1[0] - o2[0];  // 시작 시간을 기준으로 오름차순
  }
  }
});

Queue<Integer> queue = new PriorityQueue<>();
queue.offer(arr[0][1]);  // 우선순위 큐에 배열의 첫번째 강의의 종료 시간을 넣는다.
for (int i = 1; i < n; i++) {  // queue 안에 있는 가장 첫 수업의 종료 시간과 이 후 두번째 수업부터의 시작 시간을 비교.
  if (queue.peek() <= arr[i][0]) {  // 만약에 수업이 끝난 직후 도는 수업이 끝난 후에 다른 수입이 있다면 (즉, T_i ≤ S_j 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
    queue.poll();  // queue에서 이전 수업을 빼고 (queue 내부의 개수가 강의실 개수이므로 이전 수업 이후에 다른 수입 진행이 가능하다면 이전 수업을 제외하는게 효율적이다)
  }
  queue.offer(arr[i][1]); // 현재 수업의 종료 시간을 다시 넣는다.
}
System.out.println(queue.size());
```

## 15903 : 카드 합체 놀이
문제 조건에 맞추어 정렬을 한 후 그리디 알고리즘 과정을 수행한다.

```java
Arrays.sort(arr);
for (int i=0; i<m; i++) {
  long sum = arr[1] + arr[0];
  arr[0] = sum;
  arr[1] = sum;
  Arrays.sort(arr);
}
long result = 0;
for (int i=0; i<n; i++) {
  result += arr[i];
}
System.out.println(result);
```

## 1931 : 회의실 배정
문제 조건에 맞추어 정렬을 한 후 그리디 알고리즘 과정을 수행한다.

```java
Arrays.sort(arr, (o1, o2) -> {
  if (o1[1]==o2[1]) return o1[0]-o2[0];
    return o1[1]-o2[1];
  });

int end = 0;
int count = 0;
for (int i=0; i<N; i++) {
  if (end <= arr[i][0]) {
    end = arr[i][1];
    count++;
  }
}
System.out.println(count);
```
