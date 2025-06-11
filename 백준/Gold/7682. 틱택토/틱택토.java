import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while (!(line = br.readLine()).equals("end")) {
            char[][] board = new char[3][3];
            int xCount = 0, oCount = 0;

            // 보드 초기화 및 X/O 개수 카운트
            for (int i = 0; i < 9; i++) {
                char c = line.charAt(i);
                board[i/3][i%3] = c;
                if (c == 'X') xCount++;
                else if (c == 'O') oCount++;
            }

            boolean isValid = false;

            // X가 이긴 경우
            if (xCount == oCount + 1) {
                int xWin = countWinLines(board, 'X');
                int oWin = countWinLines(board, 'O');

                // O가 승리하지 않았고 X가 최소 1줄 승리
                if (oWin == 0 && xWin > 0) {
                    isValid = true;
                }
            }
            // O가 이긴 경우
            if (xCount == oCount) {
                int xWin = countWinLines(board, 'X');
                int oWin = countWinLines(board, 'O');

                // X가 승리하지 않았고 O가 최소 1줄 승리
                if (xWin == 0 && oWin > 0) {
                    isValid = true;
                }
            }
            // 무승부 (판이 가득 찬 경우)
            if (xCount == 5 && oCount == 4) {
                int xWin = countWinLines(board, 'X');
                int oWin = countWinLines(board, 'O');

                // 둘 다 승리하지 않음
                if (xWin == 0 && oWin == 0) {
                    isValid = true;
                }
            }

            sb.append(isValid ? "valid\n" : "invalid\n");
        }

        System.out.print(sb);
    }

    // 승리 라인 수 계산 (가로, 세로, 대각선)
    private static int countWinLines(char[][] board, char player) {
        int cnt = 0;
        // 가로
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) cnt++;
        }
        // 세로
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) cnt++;
        }
        // 대각선
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) cnt++;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) cnt++;
        return cnt;
    }
}
