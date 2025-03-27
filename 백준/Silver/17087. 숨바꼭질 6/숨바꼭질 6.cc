#include <iostream>
#include <vector>

using namespace std;

int gcd(int x, int y){
	if(y == 0) return x;
	else return gcd(y, x%y);
}

int gcdArray(int dist[], int start, int n){
	
	if(n == 1) return dist[start];
	else if(n == 2) return gcd(dist[start], dist[start + 1]);
	else {
		return gcd(dist[start], gcdArray(dist, start + 1, n - 1));
	}
}

int main(){
	
	int N, S;
	
	cin >> N >> S;
	
	int arr[100001];
	int dist[100001];
	
	for(int i = 0; i < N; i++){
		cin >> arr[i];
	}
	
	int idx = 0;
	
	for(int i = 0; i < N; i++){
		if(arr[i] >= S){
			dist[idx++] = arr[i] - S;
		} else {
			dist[idx++] = S - arr[i];
		}
	}
	
	// 배열의 최대 공약수 
	cout << gcdArray(dist, 0, N);
	
	return 0;
}