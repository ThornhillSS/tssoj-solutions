l = input() #store length of string (not really needed)
s = input() #store string in variable 's'
n = 0 #counter for how many open/close brackets needed

#first cycle backwards and keep track of how many close brackets ->')' there are using variable closebracket
#if there's an open bracket ->'(' and there aren't enough close brackets behind it, then add one to the counter n 
#if there is enough, then reduce the count of closebracket by one
closebracket = 0 
for i in range(len(s)-1, -1, -1):
    if s[i] == ')':
        closebracket += 1 
    if s[i] == '(':
        if closebracket <= 0:
            n += 1 
        else:
            closebracket -= 1 
s += ')'*(n) #add the amount of close brackets needed to the string
#do the same thing as before but now cycle the string and keep track of the number of openbrackets
#everything there aren't enough openbrackets in front of a closed one, add one to the counter n
openbracket = 0
n = 0
for i in range(len(s)):
    if s[i] == '(':
        openbracket += 1 
    if s[i] == ')':
        if openbracket <= 0:
            n += 1 
        else:
            openbracket -= 1
s = '('*(n) + s #add the amount of open brackets need to the string
print(s) #print the string
