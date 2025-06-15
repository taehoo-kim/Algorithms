import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            int[][] map = new int[N + 1][N + 1];
            int[][] value = new int[N + 1][N + 1];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    value[i][j] = -1;
                }
            }

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // Queue에 넣고
            Queue<int[]> q = new LinkedList<>();

            // 방문처리 하고
            value[0][0] = map[0][0];
            q.add(new int[]{0, 0});

            while(!q.isEmpty()){
                int[] cur = q.poll();
                int cur_x = cur[0], cur_y = cur[1];
                for(int i = 0; i < 4; i++){
                    int nx = cur_x + dx[i];
                    int ny = cur_y + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if(value[nx][ny] == -1 || value[nx][ny] > map[nx][ny] + value[cur_x][cur_y]){
                        value[nx][ny] = map[nx][ny] + value[cur_x][cur_y];
                        q.add(new int[]{nx, ny});
                    }
                }
            }


            sb.append(String.format("Problem %d: %d\n", idx, value[N - 1][N - 1]));
            idx++;
        }

        System.out.print(sb);
    }
}
