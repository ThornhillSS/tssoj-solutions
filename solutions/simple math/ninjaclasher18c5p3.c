#include <stdio.h>
long toDec();
long toBase();
int main()
{
    int base;
    long sum, prod, x, y;
    scanf("%d %ld %ld", &base, &x, &y);
    //convert to base10 to do math nicely
    x = toDec(base, x);
    y = toDec(base, y);
    
    //the math part
    sum = x+y;
    prod = x*y;
    
    //convert back to base
    sum = toBase(base, sum);
    prod = toBase(base, prod);
    
    printf("%ld\n%ld", sum, prod);
    return 0;
}

long toDec(int bs, long num)
{
    long dec = 0;
    int power = 1;
    int curr = num%10; //last digit of num 
    int length = 0;
    int num2 = num;
    while(num2 > 0) //find length of number
    {
        length++;
        num2 /=10;
    }
    num /= 10;
    dec = curr;
    
    //conversion
    for(int i = 1; i<length; i++)
    {
        curr = num%10;
        num /= 10;
        power *= bs;
        
        dec += power*curr; //find how much the decimal is worth at that place and add it
    }
    return dec;
}

long toBase(int bs, long num)
{
    long base = 0;
    int power = 1;
    
    while(num > 0)
    {
        base += num%bs*power; //calculates value of each digit 
        power *= 10;
        num /= bs;
    }
    return base;
}
