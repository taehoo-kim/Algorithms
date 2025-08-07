class Solution {
    public String solution(String s) {
        String answer = "";
        String lowerString = "";
        
        int len = s.length();
        
        for(int i = 0; i < len; i++){
            if(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
                char ch = (char)(s.charAt(i) + 'a' - 'A');
                lowerString += ch;
            } else {
                lowerString += s.charAt(i);
            }
        }
        
        for(int i = 0; i < len; i++){
            if(i == 0){
                if(lowerString.charAt(0) <= 'z' && lowerString.charAt(0) >= 'a') {
                    char ch = (char)(lowerString.charAt(0) + 'A' - 'a');
                    answer += ch;
                }
                else {
                    answer += lowerString.charAt(i);
                }
            }
            else {
                if(lowerString.charAt(i) == ' ') {
                    while(true) {
                        if(lowerString.charAt(i) != ' ' || i >= len - 1) break;
                        answer += lowerString.charAt(i);
                        i++;
                    }
                    if(lowerString.charAt(i) <= 'z' && lowerString.charAt(i) >= 'a') {
                        char ch = (char)(lowerString.charAt(i) + 'A' - 'a');
                        answer += ch;
                    }
                    else {
                        answer += lowerString.charAt(i);
                    }
                }

                else {
                    answer += lowerString.charAt(i);
                }
            }
            
            
        }
        
        
        return answer;
    }
}