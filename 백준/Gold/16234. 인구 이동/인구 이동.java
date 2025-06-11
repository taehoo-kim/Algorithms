import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while(true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        if(bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if(!moved) break;
            days++;
        }
        System.out.println(days);
    }

    // 연합을 형성하고 인구 이동이 있으면 true 반환
    private static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        q.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;
        int sum = map[x][y];

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;

                int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                if(L <= diff && diff <= R) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    sum += map[nx][ny];
                }
            }
        }

        if(union.size() == 1) return false; // 연합이 1개면 이동 없음

        int avg = sum / union.size();
        for(int[] pos : union) {
            map[pos[0]][pos[1]] = avg;
        }
        return true;
    }
}
