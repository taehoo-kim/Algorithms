#include <iostream>
#include <string>
#include <unordered_map>
#include <stack>
#include <vector>
#include <algorithm>
#include <list>
#define INT_MAX 2147483647
using namespace std;

void solution() {
	
	int n;
	cin >> n;

	int score[21][21];
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> score[i][j];
		}
	}

	vector<int> team(n);

	for (int i = 0; i < n / 2; i++) {
		team[i] = 0;
	}
	
	for (int i = n / 2; i < n; i++) {
		team[i] = 1;
	}

	int answer = INT_MAX;

	do {
		int start_score = 0, link_score = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;

				if (team[i] == 0 && team[j] == 0) start_score += score[i][j];

				if (team[i] == 1 && team[j] == 1) link_score += score[i][j];
			}
		}

		answer = min(answer, abs(start_score - link_score));
	} while (next_permutation(team.begin(), team.end()));

	cout << answer;

}

int main() {
	
	solution();
	
	return 0;
}