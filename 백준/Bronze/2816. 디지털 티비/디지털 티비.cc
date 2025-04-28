#include <iostream>
#include <string>
using namespace std;

int main() {

	int N;

	string channel;

	cin >> N;

	int idx1, idx2;

	for (int i = 0; i < N; i++) {
		cin >> channel;

		if (channel == "KBS1")
			idx1 = i;
		if (channel == "KBS2")
			idx2 = i;
	}

	if (idx1 > idx2) {

		for (int i = 0; i < idx1; i++)
			cout << "1";
		for (int i = 0; i < idx1; i++)
			cout << "4";

		for (int i = 0; i < idx2 + 1; i++)
			cout << "1";
		for (int i = 0; i < idx2; i++)
			cout << "4";

	}
	else {
		for (int i = 0; i < idx1; i++)
			cout << "1";
		for (int i = 0; i < idx1; i++)
			cout << "4";

		for (int i = 0; i < idx2; i++)
			cout << "1";
		for (int i = 0; i < idx2 - 1; i++)
			cout << "4";
	}

	return 0;
}
