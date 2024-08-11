# 재귀함수 (recursion function)
작성자 : 윤예은
## 정의 
: 함수 내부에서 ‘자기 자신을 호출’하는 함수
(반복문 : Bottom-up vs 재귀 : Top-down)
![image](https://github.com/user-attachments/assets/ea69be7b-cb1d-44f1-98ff-f47e6dfe8863)

## 함수 구성
1. base case(필수) : 재귀 호출 멈추는 조건
2. recursive case : 재귀 호출 반복할 조건 
## 장점
1. 직관적 -> 코드의 가독성
2. 변수 사용량 감
## 단점
1. 스택 오버 플로우 
  - 아래 설명
2. 성능 저하.
### stack overflow
  ![image](https://github.com/user-attachments/assets/6e0615a2-eb94-4e4b-9ea5-d19f12de080b)
  - 재귀 함수 호출마다 스택(매개변수, 리턴값, 리턴되었을 때 돌아갈 위)에 쌓임 -> 메모리 초과 발생. 

#### 해결 방법
  1) Base case
  2) 꼬리 재귀(TCO; Tail-Call Optimization), 자바 지원 안함. 
     : 재귀 호출 이후 추가 연산 사용 ✖️ --> return문에 연산 ✖️(다른 return값을 재귀로 계산하지 않고 바로 종료가능)
     - 비교 예시 (피보나치)
~~~
     function factorial(n) {
    if (n === 1) {
        return 1;
    }
    return n * factorial(n-1);
}
~~~
![image](https://github.com/user-attachments/assets/2349530f-8d83-43fb-90c4-3f5bc56cfed7)


~~~
int factorialTail(int n, int acc){
	if(n == 1) return acc;
    return factorialTail(n - 1, acc * n);
}
int factorial(int n){
    return factorialTail(n, 1);
}
~~~

![image](https://github.com/user-attachments/assets/6e8b5500-3909-40c1-80ee-d282e77f11af)

    : 자바에선 직접 tail recursion 인터페이스/클래스 생성하여 직접 구현한다.
  참고 블로그 :  https://loosie.tistory.com/790
