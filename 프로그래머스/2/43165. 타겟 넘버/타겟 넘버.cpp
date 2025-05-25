#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers, int target) {
    vector<int> result;
    result.push_back(0);

    for (int i = 0; i < numbers.size(); i++) {
        vector<int> temp;
        for (int j = 0; j < result.size(); j++) {
            temp.push_back(result[j] + numbers[i]);
            temp.push_back(result[j] - numbers[i]);
        }
        result = temp;
    }

    int answer = 0;
    for (int i = 0; i < result.size(); i++) {
        if (result[i] == target) answer++;
    }
    return answer;
}