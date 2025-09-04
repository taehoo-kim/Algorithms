#include <iostream>
#include <string>
#include <unordered_map>
#include <stack>
#include <vector>
#include <algorithm>
#include <list>
#define MAX 101
using namespace std;

void solution() {
	
	int n;
	cin >> n;

	int graph[MAX][MAX];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> graph[i][j];
		}
	}

	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][k] == 1 && graph[k][j] == 1) {
					graph[i][j] = 1;
				}
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << graph[i][j] << " ";
		}
		cout << "\n";
	}



}

int main() {
	
	solution();
	
	return 0;
}