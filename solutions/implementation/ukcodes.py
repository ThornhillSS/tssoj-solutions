# returns True if c is a digit and false otherwise
def isdig(c):
    if ord(c)>=48 and ord(c) <=57:
        return True
    else:
        return False

# returns a bitstring where digits are represented
# by 1 and otherwise by 0
# also counts number of spaces
def bin(s):
    i = 0
    k=0
    for j in s:
        i *=2
        if isdig(j):
            i+=1
        if ord(j) == 32:
            k+=1
        
    return i,k
        

from sys import stdin
input = stdin.readline

#print(bin("a1 1aa"))

s = input()
s = s.rstrip('\n')
#print(bin(s))



a,b = bin(s)


# returns whether postal code is valid by
# number of spaces, where the space is
# and the binary value of the code
if len(s)==6 and ord(s[2]) == 32 and b==1:
    if a == 20:
        print("code")
    else:
        print("not code")
elif len(s)==7 and ord(s[3]) == 32 and b==1:
    if a == 36:
        print("code")
    elif a == 52:
        print("code")
    elif a == 20:
        print("code")
    else:
        print("not code")
    
elif len(s)==8 and ord(s[4]) == 32 and b==1:
    if a == 36:
        print("code")
    elif a == 52:
        print("code")
    else:
        print("not code")
else:
    print("not code")
