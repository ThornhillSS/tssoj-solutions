#------------------------------------
#Author: Robloxian
#Description: Program that checks if two strings can replace eachother.
#
#------------------------------------
import sys
a = raw_input() #get inputs
b = raw_input()
for i in b:
    if i in a:
        a = a.replace(i,'',1)#replace all matches with empty char
if len(a) > 0:#if length of string is not all replaced print no
    print("NO")
    sys.exit(0)

print("YES")#means that the string is replaceable
