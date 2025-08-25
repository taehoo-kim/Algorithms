#include <iostream>
#include <string>

using namespace std;

void solution() {

	int N;

	cin >> N;

	while (N--) {
		string A, B;

		cin >> A >> B;

		int len = A.length();
		int b_len = B.length();
		if (len != b_len) {
			cout << "Impossible\n";
			continue;
		}


		int cnt[26];
		bool possible = true;

		for (int i = 0; i < 26; i++) cnt[i] = 0;

		for (int i = 0; i < len; i++) {
			cnt[A[i] - 'a']++;
		}

		for (int i = 0; i < len; i++) {
			cnt[B[i] - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if (cnt[i] != 0) possible = false;
		}

		if (possible) cout << "Possible\n";
		else cout << "Impossible\n";

	}
}

int main() {
	
	solution();
	
	return 0;
}