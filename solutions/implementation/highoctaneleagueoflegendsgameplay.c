#include <stdio.h>

int main()
{
    int a, b, c, n; //initializes variables used in program
    scanf("%d%d%d", &a, &b, &n); //gets input for variables, a, b, and n. a being the first number in the series, b being the second, and n being the index.
    for(int i = 2; i<n; i++) { //for loop that begins at 2 since the first 2 values of the series are already known and can be added
        c = a+b; //sum of a + b
		    a = b;   // a becomes b 
        b = c;   //b becomes c, or the sum of a and the previous b
    }
    printf("%d", c); //outputs the sum, c
    return 0;
}
