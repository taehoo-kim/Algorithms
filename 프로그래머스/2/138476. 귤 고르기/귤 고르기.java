import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        int cnt = 0;
        
        for(Map.Entry<Integer, Integer> entry : entryList) {
            cnt += entry.getValue();
            answer++;
            if(cnt >= k) {
                break;
            }
        }
        
        return answer;
    }
}