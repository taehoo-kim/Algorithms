#include <iostream>
#include <cstring>
#include <string>
#include <cstdlib>
#define MAX 101

using namespace std;

int gcd(int x, int y){
	
	if(y == 0) return x;
	else return gcd(y, x % y);
}

int main(){
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int t;
	int arr[MAX];
	
	cin >> t;
	
	cin.ignore();
	
	for(int i = 0; i < t; i++){
		int n;
		long long sum = 0;
		
		cin >> n;
		
		for(int j = 0; j < n; j++){
			cin >> arr[j];
		}
		
		for(int j = 0; j < n; j++){
			for(int k = j + 1; k < n ; k++){
				if(arr[j] > arr[k]){
					sum += gcd(arr[j], arr[k]);
				} else {
					sum += gcd(arr[k], arr[j]);
				}
				
			}
		}
		
		cout << sum << '\n';
	}
	
	return 0;
}