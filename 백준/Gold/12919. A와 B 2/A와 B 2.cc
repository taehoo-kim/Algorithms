#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>

using namespace std;

string S, T;
bool found = false;

void dfs(string curr) {

    if (found) return;
    if (curr.length() < S.length()) return;
    if (curr == S) {
        found = true;
        return;
    }

    // 마지막 문자가 'A'인 경우
    if (curr.back() == 'A') {
        dfs(curr.substr(0, curr.length() - 1));
    }
    // 첫 번째 문자가 'B'인 경우
    if (curr.front() == 'B') {
        string temp = curr.substr(1);
        reverse(temp.begin(), temp.end());
        dfs(temp);
    }
}

int solution() {

	cin >> S;
	cin >> T;
    dfs(T);
	return found ? 1 : 0;

}

int main() {

	cout << solution();
	return 0;
}