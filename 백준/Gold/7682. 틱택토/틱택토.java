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

            int xWin = win(board, 'X');
            int oWin = win(board, 'O');
            boolean isValid = false;

            // 1. X가 이긴 경우
            if (xCount == oCount + 1 && xWin > 0 && oWin == 0) {
                // X가 마지막에 두어서 승리한 뒤 바로 종료
                isValid = true;
            }
            // 2. O가 이긴 경우
            else if (xCount == oCount && oWin > 0 && xWin == 0) {
                // O가 마지막에 두어서 승리한 뒤 바로 종료
                isValid = true;
            }
            // 3. 무승부 (판이 가득 차고 승리자 없음)
            else if (xCount == 5 && oCount == 4 && xWin == 0 && oWin == 0) {
                isValid = true;
            }

            sb.append(isValid ? "valid\n" : "invalid\n");
        }

        System.out.print(sb);
    }

    // 승리 라인 개수 반환
    private static int win(char[][] board, char player) {
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
