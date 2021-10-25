#include <stdio.h>

int main()
{
    long a, b, c, n;
	
    //input 
    scanf("%ld", &n);
  
    //to maximize, get a, b, and c as close to a third as n as possible
    if(n%3 == 0) //a, b, c all the same number in this case
    {
        a = n/3;
        b = n/3;
        c = n/3;
    }
    else 
    {
        a = n/3;
        b = a+1; //b is one more than a
        c = n-a-b; //c is one less than a (the remaining value left)
    }
    printf("%ld", (a*b*c + b*c + a*b + a*c));

    return 0;
}
