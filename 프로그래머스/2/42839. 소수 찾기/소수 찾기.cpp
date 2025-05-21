#include <string>
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

int isPrimeNumber(int N){
    if(N <= 1) return 0;
    
    int ret = 1;
    
    for(int i = 2; i*i <= N; i++){
        if(N % i == 0)
            ret = 0;
    }
    
    return ret;
}

int solution(string numbers) {
    int answer = 0;
    vector<int> v;
    unordered_set<int> res;
    for(int i = 0; i < numbers.size(); i++){
        v.push_back(numbers[i] - '0');
    }
    
    for(int i = 1; i <= v.size(); i++){
        
        sort(v.begin(), v.end());
        
        do {
            string numStr;
            for(int j = 0; j < i; j++){
                numStr += to_string(v[j]);
            }
            int num = stoi(numStr);
            if(numStr[0] != '0') res.insert(num);
        } while(next_permutation(v.begin(), v.end()));
    }
    
    for(int num : res){
        if(isPrimeNumber(num)) {
            answer++;
        }
    }
    
    
    return answer;
}