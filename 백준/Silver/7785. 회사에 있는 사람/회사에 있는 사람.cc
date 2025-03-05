#include <iostream>
#include <string>
#include <algorithm>
#include <map>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;

	cin >> n;

	map<string, string, greater<string>> m;

	for (int i = 0; i < n; i++) {
		string name, check;

		cin >> name >> check;

		m[name] = check;
	}

	map<string, string>::iterator i;

	for (i = m.begin(); i != m.end(); i++) {
		if (i->second == "enter")
			cout << i->first << '\n';
	}


	return 0;
}