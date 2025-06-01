#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <string>

using namespace std;

int solution() {

	int N, d, k, c;

	cin >> N >> d >> k >> c;

	vector<int> v;

	for (int i = 0; i < N; i++) {
		int type;
		cin >> type;
		v.push_back(type);
	}

	vector<int> cnt(d + 1, 0);

	int left = 0, right = 0, ret = 0;
	int unique = 0;

	for (int i = 0; i < k; i++) {
		int curr = v[right];
		if (cnt[curr] == 0) unique++;
		cnt[curr]++;
		right = (right + 1) % N;
	}

	if (cnt[c] == 0) ret = unique + 1;
	else ret = unique;

	do {
		int out = v[left];
		cnt[out]--;
		if (cnt[out] == 0) unique--;
		left = (left + 1) % N;

		int in = v[right];
		if (cnt[in] == 0) unique++;
		cnt[in]++;
		right = (right + 1) % N;

		int case_res;

		if (cnt[c] == 0) case_res = unique + 1;
		else case_res = unique;

		ret = max(ret, case_res);

	} while (left != 0);


	return ret;

}

int main() {
	
	cout << solution();

	return 0;
}