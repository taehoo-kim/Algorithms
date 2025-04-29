#include <iostream>
#include <string>
#include <set>

using namespace std;

int main() {
	
	int N;
	char mode;
	int res = 0;
	set<string> s;
	cin >> N >> mode;

	for (int i = 0; i < N; i++) {
		string input;
		cin >> input;
		s.insert(input);
	}


	if (mode == 'Y') {
		cout << s.size();
	}
	else if (mode == 'F') {
		cout << s.size() / 2;
	}
	else {
		cout << s.size() / 3;
	}


	return 0;
}
