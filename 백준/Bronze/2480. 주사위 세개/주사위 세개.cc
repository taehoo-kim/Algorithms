#include <iostream>
#include <algorithm>

using namespace std;

int main(){
	int arr[3];
	
	for(int i = 0; i < 3; i++){
		cin >> arr[i];
	}
	
	if(arr[0] == arr[1] && arr[1] == arr[2]){
		cout << 10000 + arr[0] * 1000;
	} else if(arr[0] == arr[1]){
		cout << 1000 + arr[0] * 100;
	} else if(arr[1] == arr[2]){
		cout << 1000 + arr[1] * 100;
	} else if(arr[2] == arr[0]){
		cout << 1000 + arr[2] * 100;
	} else {
		int m = *max_element(arr, arr + 3);
		cout << 100 * m;
	}
	
	return 0;
}