import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String currString = br.readLine();
        String finalString = br.readLine();

        int[] currStatus = new int[N + 1];
        int[] finalStatus = new int[N + 1];

        for(int i = 0; i < N; i++){
            if(currString.charAt(i) == '0') currStatus[i] = 0;
            else currStatus[i] = 1;
        }

        for(int i = 0; i < N; i++){
            if(finalString.charAt(i) == '0') finalStatus[i] = 0;
            else finalStatus[i] = 1;
        }

        // 1번 스위치를 누른 경우
        int cnt1 = 0;
        buttonClick(currStatus, 0);
        cnt1++;
        boolean failed = true;
        for(int i = 1; i < N; i++){
            if(currStatus[i - 1] != finalStatus[i - 1]){
                buttonClick(currStatus, i);
                cnt1++;
            }
        }

        boolean check1 = true;
        for(int i = 0; i < N; i++){
            if(currStatus[i] != finalStatus[i]){
                check1 = false;
            }
        }

        for(int i = 0; i < currString.length(); i++){
            if(currString.charAt(i) == '0') currStatus[i] = 0;
            else currStatus[i] = 1;
        }

        // 1번 스위치를 안 누른 경우
        int cnt2 = 0;
        for(int i = 1; i < N; i++){
            if(currStatus[i - 1] != finalStatus[i - 1]){
                buttonClick(currStatus, i);
                cnt2++;
            }
        }

        boolean check2 = true;
        for(int i = 0; i < N; i++){
            if(currStatus[i] != finalStatus[i]){
                check2 = false;
            }
        }

        if(!check1 && !check2) {
            System.out.print(-1);
            return;
        }

        if(check1 && !check2){
            System.out.print(cnt1);
            return;
        }
        if(!check1 && check2){
            System.out.print(cnt2);
            return;
        }

        if (cnt1 > cnt2) {
            System.out.print(cnt2);
        } else {
            System.out.print(cnt1);
        }

    }

    private static void buttonClick(int[] currStatus, int idx){

        if(currStatus[idx] == 0) currStatus[idx] = 1;
        else currStatus[idx] = 0;

        if(idx == 0) {
            if (currStatus[idx + 1] == 0) currStatus[idx + 1] = 1;
            else currStatus[idx + 1] = 0;
        } else if(idx == N - 1){
            if (currStatus[idx - 1] == 0) currStatus[idx - 1] = 1;
            else currStatus[idx - 1] = 0;
        } else {
            if (currStatus[idx + 1] == 0) currStatus[idx + 1] = 1;
            else currStatus[idx + 1] = 0;

            if (currStatus[idx - 1] == 0) currStatus[idx - 1] = 1;
            else currStatus[idx - 1] = 0;
        }


    }

}
