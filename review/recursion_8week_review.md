# 8주차 : recursion (1629, 1074, 1780, 2447) Review

작성자 : 김경호

--- 

# Z
반복적 접근으로 연산 수행하며, 각 단계에서 size를 절반으로 줄이면서 현재 사분면을 선택.
```java
public static long Z(int N, int r, int c) {
        int size = (int) Math.pow(2, N);
        long answer = 0;
        while (size > 1) {
            size = size/2;
            if (r < size && c >= size) { // 왼쪽 아래칸
                answer += size * size;
                c -= size;
            } else if (r >= size && c < size) { // 오른쪽 위칸
                answer += 2 * size * size;
                r -= size;
            } else if (r>=size && c >= size) { // 오른쪽 아래칸
                answer += 3 * size * size;
                r -= size;
                c -= size;
            }
        }
        return answer;
    }
```
재귀적인 방법 사용. 크기를 반으로 줄여 나가면서ㅓ 사분면을 재귀적으로 탐색. 각 재귀 호출에서 n 값을 1씩 감소시키며 최종적으로 기저 조건에 도달하면 값을 반환
```java
public static int divide(int n, int r, int c) {
        if (n == 0) return 0;

        int mid = (int) Math.pow(2, n - 1); // 2^(n-1)
        int size = mid * mid;

        if (r < mid && c < mid) 
            return divide(n - 1, r, c);
        else if (r < mid) 
            return size + divide(n - 1, r, c - mid);
        else if (c < mid) 
            return 2 * size + divide(n - 1, r - mid, c);
        else 
            return 3 * size + divide(n - 1, r - mid, c - mid);

    }
```

# 종이의 개수

```java
// 왼쪽 위부터 오른쪽 아래로 cut()를 진행하며 분할을 진행
cut(x, y, newSize);  // 1
cut(x, y + newSize, newSize);  // 2
cut(x, y + newSize * 2, newSize);  // 3

cut(x + newSize, y, newSize);  // 4
cut(x + newSize, y + newSize, newSize);  // 5
cut(x + newSize, y + newSize * 2, newSize);  // 6

cut(x + newSize * 2, y, newSize);  // 7
cut(x + newSize * 2, y + newSize, newSize);  // 8
cut(x + newSize * 2, y + newSize * 2, newSize);  // 9
```
아래처럼 작성하면 더 간단하게 작성 가능
```java
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        divide(x + i * size, y + j * size, size);
    }
}
```

# 곱셈
분할 정복을 활용해야 하며, 지수 법칙과 모듈러 방식을 사용하여 진행해야 한다.
```java
public static long pow(long A, long exponent) {
    // 지수가 1일 경우 A^1 이므로 A % C를 리턴
    if (exponent == 1) return A % C;

    // 지수의 절반에 해당하는 A^(B/2)를 구한다.
    long temp = pow(A, exponent/2);

    // 지수가 짝수인 경우와 홀수인 경우로 리턴 값이 달라짐
    if (exponent % 2 == 1) {
        /**
         * 현재 지수가 홀수인 경우?
         * ex) exponent = 홀수 -> A^exponent = A^(exponent/2) * A^(exponent/2) * A
         * 가 되므로 A를 한 번 더 곱해줘야 한다.
         *
         * return temp * temp * A % C로 진행하면 long 형의 범위를 넘김
         * -> 모듈러 공식 사용 => (a * b) % C = (temp * temp % C) * a % C 가 됨.
         */
        //return temp * temp * A % C;
        return (temp * temp % C) * A % C;
    }
    // 지수가 짝수 인 경우
    return temp * temp % C;
}
```

# 별찍기 10

- 재귀로 큰 영역을 점점 더 작은 영역으로 나누어 처리한다.
- 중앙 공백 처리: 3x3 격자의 중앙 부분을 비우는 것이 별 모양을 만드는 데 중요한 역할을 함
- 기저 조건: N == 1일 때 재귀를 멈추고 별을 그리는 부분이 재귀의 종료 조건으로 설정

주석으로 추가 설명
```java
static void star(int x, int y, int N, boolean blank) {
    // 공백을 채우는 작업
    if (blank) {
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                arr[i][j] = ' ';
            }
        }
        return;
    }

    // 재귀의 기저 조건으로 N이 1일 때, 즉, 그릴 영역이 1x1일 때 실행됨. '*'을 그림
    if (N == 1) {
        arr[x][y] = '*';
        return;
    }

    // 별을 그릴 때, 현재 크기를 n/3한 값을 size로 설정한다. 이는 별 모양을 3x3의 작은 그리드로 나누기 위해 사용된다.
    // count 변수는 작은 격자의 순서를 추적할 때 사용. 
    int size = N / 3;
    int count = 0;
    for (int i = x; i < x + N; i+=size) {
        for (int j = y; j < y + N; j+=size) {
            count++;
            // count=5일 때, 중앙 공백 처리 
            if (count == 5) star(i, j, size, true);
            // 나머지 8개의 작은 격자에는 blank를 false로 설정하여 별을 그림
            else star(i, j, size, false);
        }
    }
}
```
