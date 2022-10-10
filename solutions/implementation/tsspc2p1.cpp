#include <iostream>

using namespace std;

int main()
{
    int n, k, h, total = 0;
    cin >> n >> k; //number of birds and height requirement 
    
    for(int i = 0; i<n; i++) //get input of all the birds 
    {
        cin >> h;
        if(h >= k) //meets height requirement 
        {
            total++;
        }
    }
    
    cout<< total << endl;

    return 0;
}
