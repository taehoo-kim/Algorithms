#include <iostream>
#include <string>
#include <deque>
using namespace std;

void solution() {
	int N;
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> N;

	deque<int> q;

	for (int i = 0; i < N; i++) {
		string cmd;
		int number;

		cin >> cmd;

		if (cmd == "push") {
			cin >> number;
			q.push_back(number);
		}
		else if (cmd == "pop") {
			if (!q.empty()) {
				int k = q.front();
				cout << k << '\n';
				q.pop_front();
			}
			else {
				cout << -1 << "\n";
			}
		}
		else if (cmd == "size") {
			cout << q.size() << "\n";
		}
		else if (cmd == "empty") {
			if (q.empty()) cout << 1 << "\n";
			else cout << 0 << "\n";
		}
		else if (cmd == "front") {
			if (!q.empty()) {
				int k = q.front();
				cout << k << '\n';
			}
			else {
				cout << -1 << "\n";
			}
		}
		else if (cmd == "back") {
			if (!q.empty()) {
				int k = q.back();
				cout << k << '\n';
			}
			else {
				cout << -1 << "\n";
			}
		}
		else {
			continue;
		}

	}
}

int main() {
	
	solution();
	
	return 0;
}