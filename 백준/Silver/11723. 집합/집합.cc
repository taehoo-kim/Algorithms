#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int M;

	cin >> M;

	int S[21] = { 0, };

	for (int i = 0; i < M; i++) {
		string cmd;
		cin >> cmd;
		if (cmd == "add") {
			int x;
			cin >> x;
			S[x] = 1;
		}
		else if (cmd == "remove") {
			int x;
			cin >> x;
			S[x] = 0;
		}
		else if (cmd == "check") {
			int x;
			cin >> x;
			if (S[x]) cout << "1\n";
			else cout << "0\n";
		}
		else if (cmd == "toggle") {
			int x;
			cin >> x;
			if (S[x]) S[x] = 0;
			else S[x] = 1;
		}
		else if (cmd == "all") {
			for (int i = 1; i <= 20; i++) {
				S[i] = 1;
			}
		}
		else if (cmd == "empty") {
			for (int i = 1; i <= 20; i++) {
				S[i] = 0;
			}
		}

	}

	return 0;
}
