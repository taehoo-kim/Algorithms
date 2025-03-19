#include <iostream>
#include <algorithm>

using namespace std;

int arr[100001];
int sum[100001];

int main(){
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N, M;
	
	cin >> N >> M;
	
	for(int i = 0; i < N; i++){
		cin >> arr[i];
	}
	
	sum[0] = arr[0];
	
	for(int i = 1; i < N; i++){
		sum[i] = sum[i - 1] + arr[i];
	}
	
	
	for(int i = 0; i < M; i++){
		int a, b;
		cin >> a >> b;
		if(a >= 2){
			cout << sum[b - 1] - sum[a - 2] << '\n'; 
		} else {
			cout << sum[b - 1] << '\n';
		}
		
	}
	
	return 0;
}