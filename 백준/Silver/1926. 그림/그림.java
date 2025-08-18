import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int cnt = 0;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                bfs(i, j);
            }
        }

        System.out.println(cnt);
        System.out.print(res);
    }

    static void bfs(int x, int y) {
        if(visited[x][y] || arr[x][y] == 0) return;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int area = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(!visited[nx][ny] && arr[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        area++;
                    }
                }
            }
        }
        if(area > res) res = area;
        cnt++;
    }
}