#include <iostream>
#include <string>

using namespace std;

int sum[26][200001];

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	string S;
	int q, index = 0;
	
	cin >> S;
	cin >> q;
	
	
	for(int i = 0; i < S.length(); i++){
		sum[S[i] - 'a'][i]++;
	}
	
	for(int i = 0; i < 26; i++){
		for(int j = 1; j < S.length(); j++){
			sum[i][j] += sum[i][j - 1];
		}
	}
	
	
	for(int i = 0; i < q; i++){
		char a;
		int l, r;
		
		cin >> a >> l >> r;
		
		if (l == 0){
			cout << sum[a - 'a'][r] << '\n';	
		} else {
			cout << sum[a - 'a'][r] - sum[a - 'a'][l - 1] << '\n';
		}
		
	}
	
	
	
	
	return 0;
}