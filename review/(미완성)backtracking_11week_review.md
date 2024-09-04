# 11주차: Back - Tracking (15651, 9663, 2580, 13023) Review

작성자 : 김희영

## Backtracking
: 탐색 알고리즘 중 하나로,
문제의 해답을 찾는 동안 모든 가능한 경로를 탐색하면서 해답에 도달하는 과정을 나타낸다.
어떤 경로가 해답이 될 가능성이 없다고 판단되면 되돌아가서 다른 경로를 탐색하는 방식으로 작동한다.

주로 재귀적 접근 방식으로 해결하며 가능한 모든 경우의 수를 탐색한다.



## DFS vs Back-Tracking
(공통점) 둘 다 재귀적으로 해결한다.

(차이점)
DFS는 모든 경로를 탐색한다. (완전 탐색)
Back Trackting은 조건이 제시되기 때문에 모든 경로를 탐색하지 않고 경우의 수를 줄일 수 있다.




## 15651 : N과 M (3)
```java
        arr = new int[M];
        DFS(N, M, 0);
        bw.flush();
    }
    public static void DFS(int N, int M, int depth) throws IOException {
        if (depth == M) {
            for (int val : arr) bw.write(val+" ");
            bw.write("\n");
            return;
        }
        for (int i=0; i<N; i++) {
            arr[depth] = i+1;
            DFS(N, M, depth+1);
        }
    }
}
```

## 
```java
    DFS(0);
        System.out.println(count);
    }
    public static void DFS(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        for (int i=0; i<N; i++) {
            arr[depth] = i;
            if (pro(depth)==1) {
                DFS(depth + 1);
            }
        }
    }
    public static int pro(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i] || depth - i == Math.abs(arr[depth] - arr[i])) {
                return 0;
            }
        }
        return 1;
    }
}
```


## 
```java

```

## 
```java
```




