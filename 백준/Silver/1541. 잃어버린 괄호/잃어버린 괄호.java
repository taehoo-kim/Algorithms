import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        String number = "";
        int res = 0;
        boolean flag = false;
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '-'){
                if(flag) res -= Integer.parseInt(number);
                else res += Integer.parseInt(number);
                flag = true;
                number = "";
            }
            else if(expression.charAt(i) == '+'){
                if(flag) res -= Integer.parseInt(number);
                else res += Integer.parseInt(number);
                number = "";
            } else {
                number += expression.charAt(i);
            }
        }

        if(flag) res -= Integer.parseInt(number);
        else res += Integer.parseInt(number);

        System.out.print(res);

    }
}