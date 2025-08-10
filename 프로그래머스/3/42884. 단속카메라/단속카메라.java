import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        
        int cnt = 0;
        int pos = Integer.MIN_VALUE;
        
        for(int[] route : routes) {
            if(route[0] > pos) {
                cnt++;
                pos = route[1];
            }
        }
        
        return cnt;
    }
}