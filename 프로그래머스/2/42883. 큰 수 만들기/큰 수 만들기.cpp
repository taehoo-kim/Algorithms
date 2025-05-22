#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer;
    vector<char> stack;
    for (char num : number) {
        while (!stack.empty() && k > 0 && stack.back() < num) {
            stack.pop_back();
            k--;
        }
        stack.push_back(num);
    }
    
    while(k--) stack.pop_back();
    
    for(char element: stack){
        answer += element;
    }
    
    return answer;
}