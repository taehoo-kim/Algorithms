#include <iostream>
#include <cstring>

using namespace std;

int main() {
	
	char password[21];

	while (1) {
		cin >> password;
		if (strcmp(password, "end") == 0) break;

		int flag = 0, len = strlen(password);


		for (int i = 0; i < len; i++) {
			if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u') {
				flag = 1;
			}
		}

		for (int i = 0; i < len - 2; i++) {

			if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u') {
				if (password[i + 1] == 'a' || password[i + 1] == 'e' || password[i + 1] == 'i' || password[i + 1] == 'o' || password[i + 1] == 'u') {
					if (password[i + 2] == 'a' || password[i + 2] == 'e' || password[i + 2] == 'i' || password[i + 2] == 'o' || password[i + 2] == 'u') {
						flag = 0;
					}
				}
			}
			else {
				if (password[i + 1] != 'a' && password[i + 1] != 'e' && password[i + 1] != 'i' && password[i + 1] != 'o' && password[i + 1] != 'u') {
					if (password[i + 2] != 'a' && password[i + 2] != 'e' && password[i + 2] != 'i' && password[i + 2] != 'o' && password[i + 2] != 'u') {
						flag = 0;
					}
				}
			}
		}

		for (int i = 0; i < len - 1; i++) {
			if (password[i] != 'e' && password[i] != 'o' && (password[i] == password[i + 1])) {
				flag = 0;
			}
		}

		if (flag) {
			cout << "<" << password << "> is acceptable.\n";
		}
		else {
			cout << "<" << password << "> is not acceptable.\n";
		}


	}

	return 0;
}
