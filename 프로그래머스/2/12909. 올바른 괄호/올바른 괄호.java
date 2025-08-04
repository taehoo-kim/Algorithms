import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        
        if(s.charAt(0) == ')') return false;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(') dq.push(ch);
            else if(ch == ')') {
                if(dq.isEmpty()) {
                    return false;
                }
                dq.pop();
            }
        }
        
        return dq.isEmpty();
    }
}