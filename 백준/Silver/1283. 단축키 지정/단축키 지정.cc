#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>

using namespace std;

void solution() {

	int N;
	vector<int> visited(26, 0);
	cin >> N;
	cin.ignore();
	for (int i = 0; i < N; i++) {
		string line;
		
		getline(cin, line);
		int selected_idx = -1, selected_idx2 = -1;
		istringstream ss(line);
		string token;
		vector<string> words;
		while (getline(ss, token, ' ')) {
			words.push_back(token);
		}


		for (int j = 0; j < words.size(); j++) {
			if (words[j][0] <= 'Z' && words[j][0] >= 'A') {
				if (!visited[words[j][0] - 'A']) {
					visited[words[j][0] - 'A'] = 1;
					selected_idx = j;
					break;
				}
			}
			else {
				if (!visited[words[j][0] - 'a']) {
					visited[words[j][0] - 'a'] = 1;
					selected_idx = j;
					break;
				}
			}
		}

		if (selected_idx != -1) {
			for (int j = 0; j < words.size(); j++) {
				if (selected_idx == j) {
					int len = words[j].length();

					for (int k = 0; k < len; k++) {
						if (k == 0) {
							cout << "[" << words[j][k] << "]";
						}
						else {
							cout << words[j][k];
						}
					}

					cout << ' ';
				}
				else {
					cout << words[j] << ' ';
				}
			}
		}
		else {
			for (int j = 0; j < words.size(); j++) {
				for (int k = 0; k < words[j].size(); k++) {
					if (words[j][k] <= 'Z' && words[j][k] >= 'A') {
						if (!visited[words[j][k] - 'A']) {
							visited[words[j][k] - 'A'] = 1;
							selected_idx = j;
							selected_idx2 = k;
							break;
						}
					}
					else {
						if (!visited[words[j][k] - 'a']) {
							visited[words[j][k] - 'a'] = 1;
							selected_idx = j;
							selected_idx2 = k;
							break;
						}
					}
					if (selected_idx != -1) break;
				}
			}

			if (selected_idx != -1) {
				for (int j = 0; j < words.size(); j++) {
					if (selected_idx == j) {
						int len = words[j].length();

						for (int k = 0; k < len; k++) {
							if (k == selected_idx2) {
								cout << "[" << words[j][k] << "]";
							}
							else {
								cout << words[j][k];
							}
						}

						cout << ' ';
					}
					else {
						cout << words[j] << ' ';
					}
				}
			}
			else {
				for (int j = 0; j < words.size(); j++) {
					cout << words[j] << ' ';
				}
			}
		}

		cout << "\n";
		
	}

}

int main() {

	solution();
}