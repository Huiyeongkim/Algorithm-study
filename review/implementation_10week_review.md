# 구현
---
주어진 문제의 요구사항에 맞게 프로그램을 직접 작성하고, 알고리즘을 설계하여 해결하는 문제 유형을 의미합니다. 구현 문제는 특정한 알고리즘을 요구하기보다는, 문제에서 설명한 규칙과 로직을 정확하게 코드로 옮겨 실행하는 것이 핵심이다.

# 구현의 특징
---
1. 문제 해결을 위한 명확한 알고리즘이 없는 경우가 많음:
구현 문제는 특별한 알고리즘 지식이 필요하지 않고, 주어진 문제의 설명을 바탕으로 직접 로직을 생각해내야 하는 경우가 많습니다. 예를 들어, 반복문, 조건문, 배열 등을 사용하여 해결할 수 있습니다.
2. 조건이나 제약 사항이 많음:
구현 문제는 종종 조건이나 제약 사항이 매우 세밀하게 설정되어 있어서 이를 모두 충족시키는 코드를 작성하는 것이 중요합니다. 작은 부분까지도 신경 써서 코드를 작성해야 합니다.
3. 시뮬레이션 문제:
많은 구현 문제는 특정 상황을 시뮬레이션하는 형태입니다. 예를 들어, 특정한 움직임에 따라 위치가 변하는 로봇의 경로를 추적하거나, 게임에서의 점수 계산을 시뮬레이션하는 등의 문제 유형입니다.
4. 문제에서 요구하는 대로 단계별로 처리:
문제에 나오는 요구사항을 차례대로 코드로 옮기는 것이 중요합니다. 문제의 단계나 흐름을 파악하고, 이를 코딩으로 직접 구현하는 것이 핵심입니다.

# 19238: 스타트 택시
---
구현, 시뮬레이션 문제로 승객들의 출발지와 도착지가 겹칠수 있다는 점을 주의하면서 BFS를 이용하여 해결할 수 있다

    while (true) {
            Node node = findPassenger();
            if (node == null){
                 flag = false;
                 break;
            }
            visited = new boolean[N][N];
            int destination = map.get(node.x * N + node.y);
            board[node.x][node.y] = 0;
            visited[node.x][node.y] = true;
            queue.add(new Taxi(node.x, node.y, node.remainFuel, 0));
            if (!findDestination(destination)) {
                flag = false;
                break;
            }

            visited = new boolean[N][N];

            if (tc()) break;
        }

        if (flag) System.out.println(answer);
        else System.out.println(-1);
    }

    private static boolean tc() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > 0) return false;
            }
        }
        return true;
    }

    private static Node findPassenger() {
        List<Node> list = new ArrayList<>(); // 택시에서 가장 가까운 승객들
        while (!queue.isEmpty()) {
            Taxi cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int fuel = cur.fuel;
            int distance = cur.distance;
            if (board[x][y] > 0) list.add(new Node(x, y, distance, fuel));
            if (fuel == 0) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || board[nx][ny] == wall) continue;
                visited[nx][ny] = true;
                queue.add(new Taxi(nx, ny, fuel - 1, distance + 1));
            }
        }

        if (list.isEmpty()) return null;

        list.sort((o1, o2) -> {
            if (o1.distance != o2.distance) return o1.distance - o2.distance;
            else if (o1.x != o2.x) return o1.x - o2.x;
            else return o1.y - o2.y;
        }); // 택시에서 승객까지 최단거리,행,열 순으로 정렬

        return list.get(0);
    }

    private static boolean findDestination(int destination) {
        int initialFUel = queue.peek().fuel;

        while (!queue.isEmpty()) {
            Taxi cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int fuel = cur.fuel;
            int distance = cur.distance;
            if (fuel == 0) continue;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || board[nx][ny] == wall) continue;
                visited[nx][ny] = true;
                if (nx * N + ny == destination) {
                    queue.clear();
                    int num = (initialFUel - (fuel - 1)) * 2 + fuel - 1;
                    queue.add(new Taxi(nx, ny, num, 0));
                    answer = num;
                    return true;
                }
                queue.add(new Taxi(nx, ny, fuel - 1, distance + 1));
            }
        }

        return false;
    }


# 20057: 마법사 상어와 토네이도
---
토네이도의 방향별로 다른위치에 모래가 날린다는 사실을 인지하면서 각 방향별로 모래가 날릴위치를 배열로 만들어주고 토네이도가 격자 밖으로 나갈떄까지 반복해주면 해결가능하다.

    public class bj20057_마법사상어와토네이도 {
        private static int N;
        private static int[][] board;
        private static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
        private static int[] ratio = {1, 1, 2, 7, 7, 2, 10, 10, 5};
        private static int[] d0x = {-1, 1, -2, -1, 1, 2, -1, 1, 0}, d0y = {1, 1, 0, 0, 0, 0, -1, -1, -2};
        private static int[] d1x = {-1, -1, 0, 0, 0, 0, 1, 1, 2}, d1y = {-1, 1, -2, -1, 1, 2, -1, 1, 0};
        private static int[] d2x = {1, -1, 2, 1, -1, -2, 1, -1, 0}, d2y = {-1, -1, 0, 0, 0, 0, 1, 1, 2};
        private static int[] d3x = {1, 1, 0, 0, 0, 0, -1, -1, -2}, d3y = {1, -1, 2, 1, -1, -2, 1, -1, 0};
        private static int tx, ty, direction;
        private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tx = N / 2; // 초기 토네이도 x위치
        ty = N / 2; // 초기 토에니도 y위치
        int moves = 1;
        direction = 0;

        while (true) {
            int num =(moves + 1) / 2;

            for (int i = 0; i < num; i++) {
                tx += dx[direction];
                ty += dy[direction];
                if (tc()) {
                    System.out.println(answer);
                    return;
                }
                tornadoMoving();
            }
            moves++;
            direction = (direction + 1) % 4;
        }

    }

    private static void tornadoMoving() {
        int[] ddx, ddy;
        if (direction == 0) {
            ddx = d0x;
            ddy = d0y;
        } else if (direction == 1) {
            ddx = d1x;
            ddy = d1y;
        } else if (direction == 2) {
            ddx = d2x;
            ddy = d2y;
        } else {
            ddx = d3x;
            ddy = d3y;
        }

        int sand = board[tx][ty];
        board[tx][ty] = 0;
        int totalSpread = 0;

        for (int i = 0; i < 9; i++) {
            int nx = tx + ddx[i];
            int ny = ty + ddy[i];
            int sandBlown = (sand * ratio[i]) / 100; // 바람에 날린 모래양

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) answer += sandBlown;
            else board[nx][ny] += sandBlown;

            totalSpread += sandBlown;
        }


        int ax = tx + dx[direction];
        int ay = ty + dy[direction];
        int alpha = sand - totalSpread;
        if (ax < 0 || ax >= N || ay < 0 || ay >= N) answer += alpha;
        else board[ax][ay] += alpha;

    }

    private static boolean tc() {
        return tx < 0 || tx >= N || ty < 0 || ty >= N;
    }
}

# 20058: 마법사상어와파이어스톰
---
Q값이 0이 될때까지 격자를 나누고 얼음을 녹이고 남아있는 얼음의 합을 출력하고 가장 큰 얼음 덩어리의 칸의 개수를 출력하면 된다
            
            while (Q-- > 0) {
                        int L = Integer.parseInt(st.nextToken());
                        int divide = (int) Math.pow(2, L);

            for (int i = 0; i < size; i += divide) {
                for (int j = 0; j < size; j += divide) {
                    rotate(i, j, divide);
                }
            }
            melting();
        }


        calIce();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] > 0 && !visited[i][j]) {
                    queue.add(new Node(i, j));
                    answer = Math.max(answer, bfs());
                }
            }
        }
---
            private static void calIce() {
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            sum += board[i][j];
                        }
                    }
                }
            private static void rotate(int row, int column, int size) {
                    int[][] temp = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp[j][size - 1 - i] = board[row + i][column + j];
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[row + i][column + j] = temp[i][j];
            }
        }

    }
