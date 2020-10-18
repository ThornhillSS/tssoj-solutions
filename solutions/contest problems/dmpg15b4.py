import sys
negative = []
positive = []
zero = 0
for i in range(int(input())):
    card = int(input())
    if card < 0:
        negative.append(card) 
    elif card > 0:
        positive.append(card)
    else:
        zero = 1
negative = sorted(negative)
positive = sorted(positive)
if len(positive) == 0:
    if zero == 1:
        print(0)
        sys.exit()
    else:
        print(min(negative))
        sys.exit()
total = 1
for i in positive:
    total = total*i
if len(negative)%2 == 0:
    for i in negative:
        total = total*i 
else:
    negative.pop()
    for i in negative:
        total = total*i
print(total)
