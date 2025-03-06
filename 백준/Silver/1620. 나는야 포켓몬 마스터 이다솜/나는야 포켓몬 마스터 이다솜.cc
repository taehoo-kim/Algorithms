#include <iostream>
#include <string>
#include <algorithm>
#include <map>
#include <vector>

using namespace std;

bool is_digit(string str) {
	return atoi(str.c_str()) || str.compare("0") == 0;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;

	cin >> N >> M;

	map<string, int> mapPokemon;

	vector<string> vecName;
	vector<string> vecRes;


	for (int i = 0; i < N; i++) {
		string temp;
		cin >> temp;
		vecName.push_back(temp);
		mapPokemon[temp] = i + 1;
	}

	for (int i = 0; i < M; i++) {
		string temp;
		cin >> temp;
		if (is_digit(temp)) {
			vecRes.push_back(vecName[stoi(temp) - 1]);
		}
		else {
			vecRes.push_back(to_string(mapPokemon[temp]));
		}
	}

	vector<string>::iterator it;

	for (it = vecRes.begin(); it != vecRes.end(); it++) {
		cout << *it << "\n";
	}

	return 0;
}