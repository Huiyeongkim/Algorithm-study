import java.util.*;

세로 두 줄, 가로로 N개의 칸으로 이루어진 표가 있다.
  첫째 줄의 각 칸에는 정수 1, 2, …, N이 차례대로 들어 있고 둘째 줄의 각 칸에는 1이상 N이하인 정수가 들어 있다.
  첫째 줄에서 숫자를 적절히 뽑으면,
  그 뽑힌 정수들이 이루는 집합과, 뽑힌 정수들의 바로 밑의 둘째 줄에 들어있는 정수들이 이루는 집합이 일치한다.
  이러한 조건을 만족시키도록 정수들을 뽑되, 최대로 많이 뽑는 방법을 찾는 프로그램을 작성하시오.
  예를 들어, N=7인 경우 아래와 같이 표가 주어졌다고 하자.




public class Main {    
    
    static ArrayList<Integer> list;
    static boolean[] visited;
    static int[] num;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //n개의 정수를 입력받는다.
        int n = scan.nextInt();
        num = new int[n + 1];
        for(int i = 1; i <= n; i++)  num[i] = scan.nextInt();
        
        
        //순서대로 사이클이 발생하는지 dfs로 확인한다.
        list = new ArrayList<>();
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        
        Collections.sort(list); //작은 수 부터 출력하므로 정렬한다.
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }    
    
    public static void dfs(int start, int index) {
        if(visited[num[start]] == false) { //내부 배열
            visited[num[start]] = true;
            dfs(num[start], index);
            visited[num[start]] = false;
        }
        if(num[start] == index) list.add(index); //사이클 발생시 해당 숫자를 list에 담아준다.
    }
}
