# Taking input 1 as integer, input 2 and 3 as list of integers
x1 = int(input())
x2 = list(map(int,input().split()))
x3 = list(map(int,input().split()))

# seeing how many times it takes to get to the same number when going to the right
def numright(x1,x2,x3):
    f = 0
    n = 0
    while x1 >= 1:
        if x2[n] != x3[0]:
            f += 1
            x1 -= 1
            n += 1
        else: 
            return f
    return f

# same as numright, but going to the left instead
def numleft(x1,x2,x3):
    f = 0
    n = 0
    while x1 >= 1:
        if x2[n] != x3[0]:
            f += 1
            x1 -= 1
            n -= 1
        else: 
            return f
    return f

# determining the smallest amount
a1 = numleft(x1,x2,x3)
a2 = numright(x1,x2,x3)
if a1 > a2:
    print(a2)
elif a1 < a2:
    print(a1)
        
    
        


