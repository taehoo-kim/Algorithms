import java.io.*;
import java.util.*;

import static java.lang.Math.max;

public class Main {
    static int res = 0;
    static int R, C;
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                board[i][j] = line.charAt(j);
            }
        }

        boolean[] visited = new boolean[26];
        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1, visited);

        System.out.println(res);
    }
    static void dfs(int x, int y, int count, boolean[] visited){
        res = Math.max(res, count);

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            int idx = board[nx][ny] - 'A';
            if(!visited[idx]){
                visited[idx] = true;
                dfs(nx, ny, count + 1, visited);
                visited[idx] = false;
            }
        }
    }
}
