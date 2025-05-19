#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    int max_length = -1;
    int max_length_sub;
    int idx;
    
    for(int i = 0; i < sizes.size(); i++){
        for(int j = 0; j < sizes[0].size(); j++){
            if(max_length < sizes[i][j]){
                max_length = sizes[i][j];
                idx = j;
                if(idx == 0){ // 제일 큰 길이가 가로면,
                    max_length_sub = sizes[i][1];
                } else { // 제일 큰 길이가 세로이면,
                    max_length_sub = sizes[i][0];
                }
            }
        }
    }
   
    for(int i = 0; i < sizes.size(); i++){
        for(int j = 0; j < sizes[0].size(); j++){
            if(idx == 0 && j == 1){
                if(max_length_sub < sizes[i][j]){
                    if(sizes[i][0] <= max_length_sub) continue;
                    else max_length_sub = min(sizes[i][0], sizes[i][1]);
                }
            }
            
            if(idx == 1 && j == 0){
                if(max_length_sub < sizes[i][j]){
                    if(sizes[i][1] <= max_length_sub) continue;
                    else max_length_sub = min(sizes[i][0], sizes[i][1]);
                }           
            }
        }
    }
    
    answer = max_length * max_length_sub;
    
    
    return answer;
}