import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int len = works.length;
        long sum = 0;
        for(int i = 0; i < len; i++) {
            sum += works[i];           
        }
        if(n >= sum) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < len; i++) {
            pq.add(works[i]);
        }
        
        while(n > 0) {
            pq.add(pq.poll() - 1);
            n--;
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}