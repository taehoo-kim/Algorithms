#include <iostream>
#include <string>
#include <unordered_map>
#include <stack>
#include <vector>
#include <algorithm>
#include <list>
using namespace std;

void solution() {
	
	int T;
	cin >> T;
	while (T--) {
		string input;
		cin >> input;
		
		list<char> password;
		auto cursor = password.begin(); 

		for (char c : input) {
			if (c == '<') {
				if (cursor != password.begin()) {
					cursor--;
				}
			}
			else if (c == '>') {
				if (cursor != password.end()) {
					cursor++;
				}
			}
			else if (c == '-') {
				if (cursor != password.begin()) {
					cursor = password.erase(--cursor);
				}
			}
			else {
				cursor = password.insert(cursor, c);
				cursor++;
			}
		}

		for (char c : password) {
			cout << c;
		}

		cout << "\n";
		
	}

}

int main() {
	
	solution();
	
	return 0;
}