import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int zeroGroupCnt = 0;
        int oneGroupCnt = 0;
        boolean zeroSwtich = false;
        boolean oneSwtich = false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0' && !zeroSwtich) {
                zeroGroupCnt++;
                zeroSwtich = true;
                oneSwtich = false;
            }
            if(str.charAt(i) == '1' && !oneSwtich) {
                oneGroupCnt++;
                zeroSwtich = false;
                oneSwtich = true;
            }
        }
        int res = zeroGroupCnt > oneGroupCnt ? oneGroupCnt : zeroGroupCnt;
        System.out.print(res);

    }
}