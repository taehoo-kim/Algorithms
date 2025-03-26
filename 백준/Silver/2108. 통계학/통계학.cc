#include <iostream>
#include <algorithm>

using namespace std;

int arr[500001];
int cnt[8003];
int countArr[8003];

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N;
	double sum = 0;
	cin >> N;
	
	for(int i = 0; i < N; i++){
		cin >> arr[i];
		sum += arr[i];
		cnt[arr[i] + 4000]++;
	}
	
	double ten = 10;
	
	double avg = sum / N;
	if(avg >= 0){
		if((int)(avg * ten) % 10 >= 5){
			cout << (int)avg + 1 << '\n';
		} else {
			cout << (int)avg << '\n';
		}
	} else {
		
		if((int)(avg * ten) % 10 <= -5){
			cout << (int)avg - 1 << '\n';
		} else {
			cout << (int)avg << '\n';
		}
	}
	
	sort(arr, arr + N);
	cout << arr[N/2] << '\n';
	int max = -1;
	for(int i = 0; i < 8003; i++){
		if(cnt[i] > max) 
			max = cnt[i];
	}
	int idx = 0;
	for(int i = 0; i < 8003; i++){
		if(cnt[i] == max){
			countArr[idx++] = i;
		}
	}
	
	if(idx == 1){
		cout << countArr[0] - 4000 << '\n';
	} else {
		sort(countArr, countArr + idx);
		cout << countArr[1] - 4000 << '\n';
	
	}
	
	cout << arr[N - 1] - arr[0];
	
	return 0;
}