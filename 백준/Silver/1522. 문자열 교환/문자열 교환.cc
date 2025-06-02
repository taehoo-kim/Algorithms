#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int solution() {

	string s;

	cin >> s;

	int bCount = 0;
	int len = s.length();
	
	for (char c : s) {
		if (c == 'b') bCount++;
	}

	if (bCount == 0 || bCount == len) return 0;

	int left = 0, right = bCount - 1;
	int aCount = 0;

	for (int i = 0; i < bCount; i++) {
		if (s[i] == 'a') aCount++;
	}

	int ret = aCount;

	for (int i = 0; i < len; i++) {
		right = (right + 1) % len;
		if (s[right] == 'a') aCount++;

		if (s[left] == 'a') aCount--;
		left = (left + 1) % len;

		ret = min(ret, aCount);
	}

	return ret;
}

int main() {
	
	cout << solution();

	return 0;
}