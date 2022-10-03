#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define mod ((ll) 1e9 + 7)
#define loop(i,a,b) for(int i = int(a); i<=int(b); i++)
#define binpow(i) (1<<i)
#define andd(a,b) (a & b)

//store dp
ll arr[1001][1024][2] = {};
//store str[c]
int str[1001] = {};

int begin2, begin3;

void init(int v){
    int maxdig = str[v];
    if(v==1){
        //If first digit is from 1-maxdig-1
        loop(i,1,maxdig-1){
            if((binpow(i) & begin2) != 0){
                arr[v][begin2-binpow(i)][0]++;
            }
            else arr[v][begin2][0]++;
        }
        
        //If first digit is maxdig
        if(andd(binpow(maxdig),  begin3) != 0) begin3 -=binpow(maxdig);
        arr[v][begin3][1]++;
    }

    else{
        loop(i,0,maxdig-1){
            if(andd(binpow(i), begin3) != 0) arr[v][begin3-binpow(i)][0]++;
            else arr[v][begin3][0]++;
        }
        if( andd(binpow(maxdig), begin3) !=0) begin3 -=binpow(maxdig);
        arr[v][begin3][1]++;
    }
}

//v starts at 2
void dp(int v, int k){
    int val = arr[v-1][k][0];
    loop(i,0,9){
        if(andd(binpow(i), k) != 0) arr[v][k-binpow(i)][0] = (arr[v][k-binpow(i)][0] + val)%mod;
        else arr[v][k][0] = (arr[v][k][0] + val)%mod;
        
    }


    if(begin2 == k){
        loop(i,1,9){
            if(andd(binpow(i), k) != 0) arr[v][k-binpow(i)][0]++;
            else arr[v][k][0]++;

        }
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    //# digits
    int M; cin>>M;
    //digits
    vector<int> digits;
    loop(i,1,M){
        int k; cin>>k;
        digits.push_back(k);
    }
    sort(digits.begin(), digits.end());
    int temp=0;
    //powers (from digits)
    vector<int> powers;
    loop(i,0,9){
        if(digits[temp]==i){
            powers.push_back(pow(2.0,i));
            temp++;
        }
        else{
            powers.push_back(0);
        }
    }

    
    string s; cin>>s;
    int N = s.length();
    loop(i, 1, N) str[i] = s[i-1]-'0';

    begin2 = 0;
    loop(i,0,9) begin2+=powers[i];

    begin3 = begin2;

    init(1);
    loop(i,2,N){
        loop(j,0,1023){
            dp(i,j);
        }
        init(i);
    }

    if(begin2==1) arr[N][0][0]++;
    cout<<(arr[N][0][0] + arr[N][0][1])%mod;

    return 0;
}
