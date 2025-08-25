#include <iostream>
#include <string>

using namespace std;

void solution() {

	int N;

	string A, B;

	cin >> A;
	cin >> B;

	int a_len = A.length();
	int b_len = B.length();

	int a_cnt[26];
	int b_cnt[26];
	int res = 0;

	for (int i = 0; i < 26; i++) {
		a_cnt[i] = 0;
		b_cnt[i] = 0;
	}

	for (int i = 0; i < a_len; i++) {
		a_cnt[A[i] - 'a']++;
	}

	for (int i = 0; i < b_len; i++) {
		b_cnt[B[i] - 'a']++;
	}

	for (int i = 0; i < 26; i++) {
		if (a_cnt[i] != b_cnt[i]) {
			if (a_cnt[i] > b_cnt[i]) {
				res += (a_cnt[i] - b_cnt[i]);
			}
			else {
				res += (b_cnt[i] - a_cnt[i]);
			}
		}
	}

	cout << res;
}

int main() {
	
	solution();
	
	return 0;
}