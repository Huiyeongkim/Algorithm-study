import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[] dc = {1,1,2,2};
    static int[][] dsx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    static int[][] dsy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},
            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
    static int[] rate ={1,1,2,7,7,2,10,10,5};
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = func(N/2, N/2);
        System.out.println(result);
    }

    static int func(int x, int y) {
        int total = 0;

        int currentX = x;
        int currentY = y;

        while (true) {
            for(int d = 0; d<4; d++){
                for(int moveCount = 0; moveCount<dc[d]; moveCount++){
  
                    int nx = currentX+dx[d];
                    int ny = currentY+dy[d];

                    if(nx<0 || ny<0 || nx>=N ||ny>=N){
                        return total;
                    }
                    
                    int sand = arr[nx][ny];
                    arr[nx][ny] = 0;
                    int spreadTotal = 0;


                    for(int spread = 0; spread<9; spread++){
                        int sandX = nx + dsx[d][spread];
                        int sandY = ny + dsy[d][spread];
                        int spreadAmount = (sand* rate[spread])/100;

                        if(sandX<0 || sandX>=N || sandY<0 || sandY>=N){
                            total += spreadAmount;
                        }
                        else{
                            arr[sandX][sandY]+=spreadAmount;
                        }
                        spreadTotal+= spreadAmount;
                    }

                    int alphaX = nx+dx[d];
                    int alphaY = ny+dy[d];
                    int alphaAmount = sand -spreadTotal;
                    if(alphaX<0 || alphaX>=N || alphaY<0|| alphaY>=N){
                        total +=alphaAmount;
                    }
                    else{
                        arr[alphaX][alphaY] +=alphaAmount;
                    }

                    currentX = nx;
                    currentY = ny;
                }
            }

            for(int index = 0; index<4; index++){
                dc[index] +=2;
            }
        }
    }
}
