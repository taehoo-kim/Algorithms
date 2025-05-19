#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    int flag = 0;
    
    for(int i = 1; i <= brown; i++){
        for(int j = 1; j <= i; j++){
            if(2 * i + 2 * j - 4 == brown){
                if(i * j - brown == yellow){
                    answer.push_back(i);
                    answer.push_back(j);
                    flag = 1;
                }
            }
        }
        if(flag) break;
    }

    return answer;
}