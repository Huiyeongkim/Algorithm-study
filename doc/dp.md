# 동적 계획법 DP (Dynamic Programming)
작성자 : 김경호
<hr>

## 정의

<b>큰 문제를 작은 문제로 나눈 뒤, 기억하며 푸는 기법</b>으로 공간복잡도를 늘리는 대신, 시간복잡도는 줄이는 방식이다.

### 중복되는 부분 문제 - 피보나치 수열

피보나치 수열의 점화식은 `F(n) = F(n-1) + F(n-2)`로 단순 재귀 함수로 구현된다.
```java
public class fibonacci{
    static int fib(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static void main(String[] args){
        ~~
    }
}
```

![img_1](https://github.com/Huiyeongkim/Algorithm-study/assets/76249685/dbb1b104-44e2-4bd7-b2d9-4bc2c9847ef3)


피보나치 수열과 같은 중복되는 부분 문제 알고리즘은 n이 작은 함수로 갈수록 해당 함수의 호출 횟수가 증가한다.<br>
위 트리를 보면 fib(6) = fib(5) + fib(4)로 fib(5)과 fib(4)를 알아야하고, fib(5) = fib(4) + fib(3)이고, fib(4) = fib(3) + fib(2)으로 fib(3)과 fib(2)를 알아야 하며, fib(4)가 중복되는 것을 확인할 수 있다.<br>
이렇게 트리의 전체를 그리게 되면 부분 문제들이 기하급수적으로 늘어나게 되어 f(n)의 시간복잡도가 `O(2^n)`이 된다.

위 중복되는 부분 문제를 dp를 활용하여 풀면 `O(n)`의 시간복잡도로 효율적으로 풀 수 있다.

## DP 알고리즘 활용

DP의 구현 방법은 두 가지 방식, Top-down과 Bottom-up으로 구성된다.

### Memoization, Top-down(하향식) 방식

- 중복되는 계산은 한 번만 계산하는 재귀 방식으로 작은 값부터 캐시에 채워나가는 방식
- 위에서부터 아래로 계산하는 Top-down 방식으로 필요 없는 계산(중복되는 계산)은 하지 않는다.
- 단, 재귀 방식으로 너무 많이 사용하면 call stack이 쌓여 과부하로 오류 발생의 가능성이 있다.

#### Top-down 방식으로 피보나치 수열 계산

```java
public class Fibonacci {
    static int[] dp = new int[1000];
    static int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(dp[n] != 0) return dp[n];  // 계산한 적이 없으면 0
        dp[n] = fibonacci(n - 2) + fibonacci(n - 1);
        return dp[n];
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(fibonacci(N));
    }
}
```
![img_2](https://github.com/Huiyeongkim/Algorithm-study/assets/76249685/00be9f6c-bc13-47dc-8b94-375c65e73675)

재귀 방식을 사용하여 계산한적이 없다면 dp[n]으로 재귀함수를 계산하여 내려가며 작은 값을 구한다. 만약 계산한 적이 있는 dp[n]이 있다면 추가 재귀 호출 없이 그 값을 바로 리턴한다. <br>
이렇게 하면 위 그림의 빨간색 박스를 제외한 나머지 값들은 계산할 필요가 없다.

즉, 한 번 계산했던 값은 두 번 다시 계산할 필요가 없으므로 O(N)의 시간이 필요하다.

### Tabulation, Bottom-up(상향식) 방식

- 답을 구하기 위한 모든 계산을 Table 방식으로 저장하는 for문 방식으로 계산된 값을 캐시에서 꺼내는 방식
- 반복문으로 계산하는 Bottom-up 방식은 과부하로 인한 오류 발생의 가능성이 없다.
- 단, 필요 없는 것까지도 계산하게 된다.

#### Bottom-up 방식으로 피보나치 수열 계산

```java
public class Fibonacci{ 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for(int i = 2;i <= N;i++)
        	dp[i] = dp[i - 1] + dp[i - 2];
        System.out.println(dp[N]);
    }
}
```
| dp(1) | dp(2) | dp(3) | dp(4) | dp(5) | dp(6) |
|-------|-------|-------|-------|-------|-------|
| 1     | 1     | 2     | 3     | 5     | 8     |

n보다 작은 피보나치 항의 값들만 정확하게 알고 있다면, fib(n)을 구하는 데도 문제가 없다는 점을 이용하여 for문으로 fib(2)부터 f(n)까지의 값을 차례대로 구한다.
dp[] 배열에 각 과정의 결과들을 저장하며 마지막 값이 결과가 된다.
시간복잡도는 O(n)이 나온다.

## DP 활용에 적합한 문제

1. 최적 부분 구조(Optimal Substructure) : 상위 문제를 하위 문제로 나눌 수 있으며, 하위 문제의 답을 모아서 상위 문제를 해결할 수 있다.
2. 중복되는 부분 문제(Overlapping Subproblem) : 동일한 작은 문제를 반복적으로 해결해야 한다.

<br>
<br>

[출처]

https://cobi-98.tistory.com/42

https://www.baeldung.com/cs/fibonacci-top-down-vs-bottom-up-dynamic-programming