#include <string>
#include <vector>

using namespace std;

int solution(string name) {
    int answer = 0;
    
    // 제일 빨리 가는 법부터
    
    // A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
    // 
    int n = name.length();
    int min_move = n - 1;
    
    for(int i = 0; i < n; i++){
        
        if(name[i] - 'A' > 13) {
            // 이전 알파벳으로
            answer += 26 - (name[i] - 'A');
        } else {
            answer += name[i] - 'A';
        }
    }
    
    // 커서 이동 처리
    for(int i = 0; i < n; i++){
        int next = i + 1;
        while(next < n && name[next] == 'A') next++;
        min_move = min(min_move, i + (n - next) + min(i, n - next));
    }
    
    answer += min_move;
    
    return answer;
}