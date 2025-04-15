#include <iostream>
#define MAX 100
using namespace std;

int main() {
	int N, arr[MAX];
	cin >> N;
	
	for(int i = 0; i < N; i++)
		cin >> arr[i];
			
	int v, res = 0;
	
	cin >> v;
	
	for(int i = 0; i < N; i++){
		if(v == arr[i])
			res++;
	}
	
	cout << res;
	
	return 0;
}