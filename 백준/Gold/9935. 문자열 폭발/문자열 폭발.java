import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String bomb = br.readLine();

        Stack<Character> s = new Stack<>();

        for(char c: input.toCharArray()) {
            s.push(c);

            if(s.size() >= bomb.length()) {
                boolean isBomb = true;

                for(int i = 0; i < bomb.length(); i++){
                    if(s.get(s.size() - bomb.length() + i) != bomb.charAt(i)){
                        isBomb = false;
                        break;
                    }
                }

                if(isBomb) {
                    for(int i = 0; i < bomb.length(); i++) {
                        s.pop();
                    }
                }
            }
        }

        if(s.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for(char c: s) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
