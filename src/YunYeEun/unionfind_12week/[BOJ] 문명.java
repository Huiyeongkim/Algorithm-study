public class Main {

    public static int N, K, count;
    public static int[][] map;
    public static int[] parents;
    public static Queue<Loc> q = new LinkedList<>();
    public static int[][] dt = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = K; // 지금 문명 수 , 1이 되면 끝낸다. 
        map = new int[N][N];
        parents = new int[K + 1];
      
        for (int i = 1; i <= K; i++) { 
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = N - Integer.parseInt(st.nextToken());
            map[x][y] = i; // 2*2 matrix
            parents[i] = i;
            q.offer(new Loc(x, y, i)); 
        }

        System.out.println(bfs());
        br.close();
    }

    public static void start() {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            Loc loc = q.poll();
            int myNum = find(loc.num);
            findCivil(loc.x, loc.y, myNum);
            q.offer(new Loc(loc.x, loc.y, myNum));
        }
    }

    public static int bfs() {

        start();

        int year = 0;
        while (count != 1) { //문명이 하나로 합쳐지면 종료 한다. 
            year++;  //깊이 
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                int myNum = find(loc.num); //합친 후 최종 자기 번호 == 부모 
                for (int d = 0; d < 4; d++) { //상하좌우 확장하기 
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];
                    if (checkRange(dx, dy)) { //범위 맞으면 
                        if (map[dx][dy] == 0) { //확장 안된곳이면 
                            map[dx][dy] = myNum; // 확장하기 
                            q.offer(new Loc(dx, dy, myNum)); 
                            findCivil(dx, dy, myNum); //근처 문명 확인하기 
                        }
                    }
                }
            }
        }

        return year;
    }

    public static void findCivil(int x, int y, int num) {
        for (int d = 0; d < 4; d++) {
            int dx = x + dt[d][0];
            int dy = y + dt[d][1];
            if (checkRange(dx, dy) && map[dx][dy] != 0 && !checkParent(num, map[dx][dy])) { 
                union(num, map[dx][dy]); //근처에 조건이 맞는 문명있으면 통합한다. 
                count--;
            }
        }
    }

    public static boolean checkRange(int x, int y) { //범위 확인 
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static int find(int num) { //찾아서 반환 
        if (parents[num] == num) return num;
        return parents[num] = find(parents[num]);
    }

    public static boolean checkParent(int a, int b) { // 같은 그래프인지 확인
        int aParent = find(a);
        int bParent = find(b);
        return aParent == bParent;
    }

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent == bParent) return;

        parents[aParent] = bParent;
    }

    public static class Loc { 
        int x, y, num;

        public Loc(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
