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
- DFS는 모든 경로를 탐색한다. (완전 탐색)
- Back Trackting은 조건이 제시되기 때문에 모든 경로를 탐색하지 않고 경우의 수를 줄일 수 있다.




## 15651 : N과 M (3)
백트래킹 기본 문제로 DFS와 동일한 방식으로 해결한다.

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

## 9663 : N-Queen
DFS에 pro라는 함수를 설정하여 가지치기를 해준다.
#### 일차원 배열을 활용하여 열 위치를 파악하여 문제를 해결한다.

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
            if (pro(depth)==1) { // 가지치기
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


## 2580 : 스도쿠
아래와 같이 backtracking 함수를 정의하여 전체 배열을 확인하고 check 함수를 통해 조건을 입력한다.

```java
        backtracking(0,0);
	}
public static void backtracking(int row,int col) throws IOException  {
	//가로 끝까지 오면 다음 줄로 내려간다. 
	if(col == 9) {
        	backtracking(row+1,0);
		return;
	}
	//세로까지 다 오면 끝. 
	if(row == 9) {
		for(int i=0;i<9;i++) {			
			for(int j=0;j<9;j++) {
                                System.out.print(matrix[i][j]+" ");
                        }
                        System.out.println();
                }
        	System.exit(0);
                return;
        }
        //0 발견
        if(matrix[row][col] == 0) {
                for(int i=0;i<9;i++) { //1~9까지 맞는 숫자 넣는다. 
        		if(check(row,col,i+1)) {
                                matrix[row][col] = i+1; //값 대입
                        	backtracking(row,col+1); //다음칸 이동 			
                        }
                }
        matrix[row][col] =0; //다시 복구 
        return;
	}
        //아무일 없으면 다음으로 넘어감. 
        backtracking(row,col+1);
        return;
}
//num 이 가능한 숫자면 true로 반환하여 대입 , 
public static boolean check(int row,int col , int num) {
	for(int i=0;i<9;i++) {
                //가로 체크
                if(matrix[row][i] == num) return false;
                //세로 체크
                if(matrix[i][col] == num) return false;
        }
		
        //3*3 check
        int newRow = (row/3)*3; //0,3,6으로만 되도록 
        int newCol = (col/3)*3;
        for (int i = newRow; i < newRow + 3; i++) { //0,1,2 | 3,4,5 | 6,7,8
                for (int j = newCol; j < newCol + 3; j++) {//0,1,2 | 3,4,5 | 6,7,8
                        if(matrix[i][j] == num) return false;
                }
        }
        return true;	
}
}
```

##  13023 : ABCDE
그래프를 활용하여 문제 해결한다.

```java
 list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        status = false;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            DFS(i, 1);
            if (status) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
    static void DFS( int idx, int depth){
        if (depth == 5) {
            status = true;
            return;
        }
        visited[idx] = true;
        for (int nxt : list[idx]) {
            if (!visited[nxt]) {
                DFS(nxt, depth + 1);
            }
        }
        visited[idx] = false;
    }
}
```




