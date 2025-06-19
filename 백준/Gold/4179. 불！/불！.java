import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        int[][] dist1 = new int[R][C];
        int[][] dist2 = new int[R][C];
        int jx = 0, jy = 0;

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'J') {
                    jx = i;
                    jy = j;
                }

                if(map[i][j] == 'F') {
                    q1.add(new int[]{i, j});
                    dist1[i][j] = 1;
                }
            }
        }

        // 불 번지는거 찾기
        while(!q1.isEmpty()){
            int cur[] = q1.poll();
            int cur_x = cur[0], cur_y = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if(map[nx][ny] == '#') continue;
                if(dist1[nx][ny] == 0){
                    q1.add(new int[]{nx, ny});
                    dist1[nx][ny] = dist1[cur_x][cur_y] + 1;
                }
            }
        }

        q2.add(new int[]{jx, jy});
        dist2[jx][jy] = 1;

        while(!q2.isEmpty()) {
            int cur[] = q2.poll();
            int cur_x = cur[0], cur_y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    System.out.println(dist2[cur_x][cur_y]);
                    return;
                }
                if (map[nx][ny] != '.') continue;
                if (dist1[nx][ny] != 0 && dist1[nx][ny] <= dist2[cur_x][cur_y] + 1) continue;
                if (dist2[nx][ny] == 0) {
                    q2.add(new int[]{nx, ny});
                    dist2[nx][ny] = dist2[cur_x][cur_y] + 1;
                }
            }
        }

        System.out.println("IMPOSSIBLE");

    }
}
