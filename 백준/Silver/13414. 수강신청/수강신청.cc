#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp_value(const pair<string, int>& a, const pair<string, int>& b) {
	return a.second < b.second;
}

void solution() {
	
	int K, L;

	cin >> K >> L;

	unordered_map<string, int> apply;

	for (int i = 0; i < L; i++) {
		string curr;
		cin >> curr;
		apply[curr] = i;
	}

	vector<pair<string, int>> v(apply.begin(), apply.end());

	sort(v.begin(), v.end(), cmp_value);

	K = min(K, (int)v.size());

	for (int i = 0; i < K; i++) {
		cout << v[i].first << '\n';
	}
}

int main() {
	
	solution();
	
	return 0;
}