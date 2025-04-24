#include <iostream>

using namespace std;

int check_triangle(int a, int b, int c) {
	int max_length = -1;

	if (max_length < a) max_length = a;
	if (max_length < b) max_length = b;
	if (max_length < c) max_length = c;

	if (max_length == a) {
		if (a < b + c) return 1;
		else return 0;
	}
	else if (max_length == b) {
		if (b < a + c) return 1;
		else return 0;
	}
	else {
		if (c < a + b) return 1;
		else return 0;
	}

}

int main() {

	int a = 0, b = 0, c = 0;

	while (1) {

		cin >> a >> b >> c;

		if (a == 0 && b == 0 && c == 0) break;

		if (!check_triangle(a, b, c)) cout << "Invalid\n";
		else if (a == b && b == c) cout << "Equilateral\n";
		else if (a == b || b == c || c == a) cout << "Isosceles\n";
		else cout << "Scalene\n";

	}

	return 0;
}
