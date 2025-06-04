#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>
#include <stack>

using namespace std;
int arr[500001];

void solution() {
	
	int N;

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	stack<int> st;

	vector<int> answer(N, 0);

	for (int i = 0; i < N; i++) {
		while (!st.empty() && arr[st.top()] < arr[i]) st.pop();

		if (!st.empty()) answer[i] = st.top() + 1;

		st.push(i);
	}

	for (int num : answer) cout << num << " ";

}

int main() {

	solution();
	return 0;
}