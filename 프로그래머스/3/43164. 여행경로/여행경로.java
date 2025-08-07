import java.util.*;

class Solution {
    static Map<String, List<String>> graph;
    static boolean[] visited;
    static int ticketCount;
    static String[] answer;
    
    public String[] solution(String[][] tickets) {
        ticketCount = tickets.length;
        graph = new HashMap<>();
        
        for(String[] t: tickets) {
            graph.computeIfAbsent(t[0], k -> new ArrayList<>()).add(t[1]);
        }
        for(List<String> destList: graph.values()) {
            Collections.sort(destList);
        }
        
        visited = new boolean[ticketCount];
        answer = new String[ticketCount + 1];
        
        dfs("ICN", 0, tickets);
        
        return answer;
    }
    
    static boolean dfs(String cur, int cnt, String[][] tickets){
        answer[cnt] = cur;
        if(cnt == ticketCount) return true;
        
        List<String> nextList = graph.get(cur);
        if(nextList == null) return false;
        
        for(int i = 0; i < nextList.size(); i++) {
            String next = nextList.get(i);
            
            for(int j = 0; j < ticketCount; j++) {
                if(!visited[j] && tickets[j][0].equals(cur) && tickets[j][1].equals(next)) {
                    visited[j] = true;
                    if(dfs(next, cnt + 1, tickets)) return true;
                    visited[j] = false;
                    break;
                }
            }
        }
        
        return false;
        
    }
}