#include <iostream>
#include <string>

using namespace std;

int main() {
	int N;
	cin >> N;

	string s;
	cin >> s;

	// 양쪽 색이 다른 경우
	int R_cnt = 0;
	int B_cnt = 0;
	int answer;

	int check1 = 0, check2 = 0;

	for (int i = 0; i < N; i++) {
		if (s[i] == 'B') check1++;
		else check2++;
	}

	if (check1 == N || check2 == N) {
		cout << 0;
		return 0;
	}

	if (s[0] == 'B' && s[N - 1] == 'R') {
		// i) 빨간색을 선택했을 경우

		// 끝부터 뭉터기인 빨간색 개수
		int cnt1 = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (s[i] == 'B') break;
			cnt1++;
		}

		for (int i = 1; i < N - cnt1; i++) {
			if (s[i] == 'R')
				R_cnt++;
		}

		// ii) 파란색을 선택했을 경우
		
		// 앞부터 뭉터기인 파란색 개수
		int cnt2 = 0;
		for (int i = 0; i < N - 1; i++) {
			if (s[i] == 'R') break;
			cnt2++;
		}

		for (int i = N - 2; i >= cnt2; i--) {
			if (s[i] == 'B')
				B_cnt++;
		}
		

	}
	else if(s[0] == 'R' && s[N - 1] == 'B') {
		// i) 파란색을 선택했을 경우

		// 끝부터 뭉터기인 파란색 개수
		int cnt1 = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (s[i] == 'R') break;
			cnt1++;
		}

		for (int i = 1; i < N - cnt1; i++) {
			if (s[i] == 'B')
				R_cnt++;
		}

		// ii) 빨간색을 선택했을 경우

		// 앞부터 뭉터기인 빨간색 개수
		int cnt2 = 0;
		for (int i = 0; i < N - 1; i++) {
			if (s[i] == 'B') break;
			cnt2++;
		}

		for (int i = N - 2; i >= cnt2; i--) {
			if (s[i] == 'R')
				B_cnt++;
		}
	}
	answer = min(R_cnt, B_cnt);

	int same_case_cnt = 0;
	int same_case_cnt2 = 0;
	// 양 끝이 같은 색인 경우
	if (s[0] == s[N - 1]) {
		// i) 빨간색인 경우
		if (s[0] == 'R') {
			int cnt1 = 0;
			// 앞쪽 뭉티기 구함
			for (int i = 0; i < N; i++) {
				if (s[i] == 'B') break;
				cnt1++;
			}
			
			// 뒤쪽 뭉티기 구함
			int cnt2 = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (s[i] == 'B') break;
				cnt2++;
			}

			for (int i = cnt1; i < N - cnt2; i++) {
				if (s[i] == 'R') same_case_cnt++;
				if (s[i] == 'B') same_case_cnt2++;
			}

			same_case_cnt += min(cnt1, cnt2);
			same_case_cnt = min(same_case_cnt, same_case_cnt2);
		}
		else {
			int cnt1 = 0;
			// 앞쪽 뭉티기 구함
			for (int i = 0; i < N; i++) {
				if (s[i] == 'R') break;
				cnt1++;
			}

			// 뒤쪽 뭉티기 구함
			int cnt2 = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (s[i] == 'R') break;
				cnt2++;
			}

			for (int i = cnt1; i < N - cnt2; i++) {
				if (s[i] == 'B') same_case_cnt++;
				if (s[i] == 'R') same_case_cnt2++;
			}

			same_case_cnt += min(cnt1, cnt2);
			same_case_cnt = min(same_case_cnt, same_case_cnt2);
		}

		cout << same_case_cnt;
	}
	else {
		cout << answer;
	}

	return 0;
}